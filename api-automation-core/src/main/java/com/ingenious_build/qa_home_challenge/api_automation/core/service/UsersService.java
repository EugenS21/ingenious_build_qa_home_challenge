package com.ingenious_build.qa_home_challenge.api_automation.core.service;

import com.ingenious_build.qa_home_challenge.api_automation.core.model.GetUsersResponse;
import com.ingenious_build.qa_home_challenge.api_automation.core.properties.endpoints.users.UserEndpointProperties;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Service
public class UsersService {

    UserEndpointProperties userEndpointProperties;
    WebClient webClient;

    public UsersService(UserEndpointProperties userEndpointProperties, WebClient webClient) {
        this.userEndpointProperties = userEndpointProperties;
        this.webClient = webClient.mutate()
                .baseUrl(userEndpointProperties.getPath())
                .build();
    }

    public Mono<ResponseEntity<GetUsersResponse>> getUsers(Integer usersPerPage, Integer page) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.queryParam("page", page)
                        .queryParam("per_page", usersPerPage)
                        .build())
                .retrieve()
                .toEntity(GetUsersResponse.class);
    }


}
