package com.ingenious_build.qa_home_challenge.api_automation.core.service;

import com.ingenious_build.qa_home_challenge.api_automation.core.model.*;
import com.ingenious_build.qa_home_challenge.api_automation.core.properties.endpoints.users.UserEndpointProperties;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
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

    public Mono<ResponseEntity<GetUserResponse>> getUser(Long id) {
        return webClient.get()
                .uri(userEndpointProperties.getById(), id)
                .retrieve()
                .toEntity(GetUserResponse.class);
    }

    public Mono<ResponseEntity<CreateUserResponse>> createUser(CreateUserRequest userDetails) {
        return webClient.post()
                .body(BodyInserters.fromValue(userDetails))
                .retrieve()
                .toEntity(CreateUserResponse.class);
    }

    public Mono<ResponseEntity<UpdateUserResponse>> updateUser(Long id, UpdateUserRequest userDetails) {
        return webClient.put()
                .uri(userEndpointProperties.getById(), id)
                .body(Mono.just(userDetails), UpdateUserRequest.class)
                .retrieve()
                .toEntity(UpdateUserResponse.class);
    }

    public Mono<ResponseEntity<GetUsersResponse>> getUsersWithDelay(Integer usersPerPage, Integer page, Integer delay) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.queryParam("page", page)
                        .queryParam("per_page", usersPerPage)
                        .queryParam("delay", delay)
                        .build())
                .retrieve()
                .toEntity(GetUsersResponse.class);
    }
}
