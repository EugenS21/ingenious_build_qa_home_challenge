package com.ingenious_build.qa_home_challenge.api_automation.steps.actions;

import com.github.javafaker.Faker;
import com.ingenious_build.qa_home_challenge.api_automation.core.model.*;
import com.ingenious_build.qa_home_challenge.api_automation.core.service.UsersService;
import com.ingenious_build.qa_home_challenge.api_automation.enums.ApiStorageKey;
import com.ingenious_build.qa_home_challenge.api_automation.model.CreateUserDetails;
import com.ingenious_build.qa_home_challenge.api_automation.model.UpdateUserDetails;
import com.ingenious_build.qa_home_challenge.api_automation.storage.ApiScenarioContext;
import com.ingenious_build.qa_home_challenge.testing_components.core.storage.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Assertions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.ingenious_build.qa_home_challenge.api_automation.enums.ApiStorageKey.*;
import static java.util.stream.Collectors.toList;
import static reactor.core.publisher.Flux.fromIterable;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class UserSteps {

    ModelMapper modelMapper;
    UsersService usersService;
    ApiScenarioContext scenarioContext;

    @When("I send a request to get the total number of users")
    public void iSendARequestToGetAllPages() {
        ResponseEntity<GetUsersResponse> response = usersService.getUsers(1, 1).block();
        scenarioContext.addValue(GET_USERS_DATA, response.getBody().getTotal());
    }

    @When("I send a request to get all the users")
    public void iSendARequestToGetAllTheUsers() {
        Integer totalNumberOfUsers = scenarioContext.getValue(GET_USERS_DATA, Integer.class);
        ResponseEntity<GetUsersResponse> response = usersService.getUsers(totalNumberOfUsers, 1).block();
        scenarioContext.addValue(GET_USERS_RESPONSE, response);
        scenarioContext.addValue(GET_USERS_DATA, response.getBody());
    }

    @When("print users with odd id numbers")
    public void printUsersWithOddIdNumbers() {
        scenarioContext.getValue(GET_USERS_DATA, GetUsersResponse.class).getData()
                .stream()
                .filter(el -> el.getId() % 2 != 0)
                .forEach(System.out::println);
    }

    @When("I send a request to create a new user with details:")
    public void iSendARequestToCreateANewUser(CreateUserDetails userDetails) {
        var response = usersService.createUser(modelMapper.map(userDetails, CreateUserRequest.class)).block();
        scenarioContext.addValue(GET_USERS_RESPONSE, response);
        scenarioContext.addValue(GET_USERS_DATA, response.getBody());
    }

    @When("I pick a random user to be updated")
    public void iPickARandomUserToBeUpdated() {
        scenarioContext.getValue(GET_USERS_DATA, GetUsersResponse.class).getData().stream()
                .findAny()
                .ifPresent(user -> scenarioContext.addValue(ApiStorageKey.USER_DATA, user));
    }

    @When("I send a request to update the user with details:")
    public void iSendARequestToUpdateTheUserWithDetails(UpdateUserDetails newUserDetails) {
        UserDto userToBeUpdated = scenarioContext.getValue(ApiStorageKey.USER_DATA, UserDto.class);
        UpdateUserRequest updatedUserDetails = modelMapper.map(newUserDetails, UpdateUserRequest.class);
        scenarioContext.addValue(UPDATE_USER_REQUEST, updatedUserDetails);
        ResponseEntity<UpdateUserResponse> response = usersService.updateUser(userToBeUpdated.getId(), updatedUserDetails).block();
        scenarioContext.addValue(UPDATE_USER_RESPONSE, response);
        scenarioContext.addValue(UPDATE_USER_DATA, response.getBody());
    }

    @When("I send a request to get all the users with '{}' seconds delay")
    public void iSendARequestToGetAllTheUsersWithDelaySecondsDelay(Integer delay) {
        Integer totalNumberOfUsers = scenarioContext.getValue(GET_USERS_DATA, Integer.class);
        Mono<ResponseEntity<GetUsersResponse>> usersWithDelay = usersService.getUsersWithDelay(totalNumberOfUsers, 1, delay);
        scenarioContext.addValue(GET_USERS_RESPONSE, usersWithDelay);
    }

    @When("I send '{}' asynchronous requests to get user by id")
    public void iSendAsynchronousRequestsToGetUserById(int numberOfRequestsToSend) {
        List<UserDto> usersDetails = scenarioContext.getValue(GET_USERS_DATA, GetUsersResponse.class).getData();
        Collections.shuffle(usersDetails, new Random());
        List<Long> longs = usersDetails.stream()
                .limit(numberOfRequestsToSend)
                .map(UserDto::getId)
                .toList();
        scenarioContext.addValue(GET_USER_BY_ID_REQUESTS, fromIterable(longs).flatMap(usersService::getUser));
    }
}
