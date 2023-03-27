package com.ingenious_build.qa_home_challenge.api_automation.core.client;

import com.ingenious_build.qa_home_challenge.api_automation.core.properties.web_client.WebClientProperties;
import io.netty.channel.ChannelOption;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import static org.springframework.web.reactive.function.client.ExchangeStrategies.builder;

@Configuration
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ClientConfiguration {

    WebClientProperties webClientProperties;

    @Bean
    @SneakyThrows(SSLException.class)
    public WebClient webClient() {
        Integer timeout = webClientProperties.getTimeout();
        var sslContext = SslContextBuilder.forClient().trustManager((X509Certificate[]) null).build();
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, timeout)
                .doOnConnected(conn -> conn.addHandlerLast(new ReadTimeoutHandler(timeout, TimeUnit.MILLISECONDS))
                        .addHandlerLast(new WriteTimeoutHandler(timeout, TimeUnit.MILLISECONDS)))
                .secure(sslSpec -> sslSpec.sslContext(sslContext));
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .baseUrl(webClientProperties.getBaseUrl())
                .filter(logRequest())
                .filter(logResponse())
                .exchangeStrategies(builder().codecs(configure -> configure.defaultCodecs().maxInMemorySize(webClientProperties.getMaxInMemorySize())).build())
                .build();
    }

    private ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(request -> {
            log.info("Request: " + request.method() + " to " + request.url() + " with " + request.body());
            return Mono.just(request);
        });
    }

    private ExchangeFilterFunction logResponse() {
        return ExchangeFilterFunction.ofResponseProcessor(response -> {
            log.info("Response: " + response.statusCode() + " body " + response.body(BodyExtractors.toMono(String.class)));
            return Mono.just(response);
        });
    }

}
