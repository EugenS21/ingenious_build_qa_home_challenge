package com.ingenious_build.qa_home_challenge.api_automation.steps.assertions;

import com.ingenious_build.qa_home_challenge.api_automation.core.model.*;
import com.ingenious_build.qa_home_challenge.api_automation.enums.ApiStorageKey;
import com.ingenious_build.qa_home_challenge.api_automation.storage.ApiScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.SoftAssertions;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Signal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.ingenious_build.qa_home_challenge.api_automation.enums.ApiStorageKey.*;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class UserSteps {

    ApiScenarioContext scenarioContext;
    SoftAssertions softAssertions;

    @Then("I should receive response code {int}")
    public void iShouldReceiveResponseCode(int expectedStatusCode) {
        softAssertions.assertThat(scenarioContext.getValue(GET_USERS_RESPONSE, ResponseEntity.class))
                .extracting(ResponseEntity::getStatusCode)
                .extracting(HttpStatusCode::value)
                .describedAs("Expecting <%d> response code", expectedStatusCode)
                .isEqualTo(expectedStatusCode);
    }

    @Then("I should receive response codes {int}")
    public void iShouldReceiveResponseCodes(int expectedStatusCode) {
        var responses = ((Flux<ResponseEntity<GetUserResponse>>) scenarioContext.getValue(GET_USER_BY_ID_REQUESTS, Flux.class))
                .collectList()
                .block();
        softAssertions.assertThat(responses)
                .extracting(ResponseEntity::getStatusCode)
                .extracting(HttpStatusCode::value)
                .describedAs("Expecting <%d> response code", expectedStatusCode)
                .containsOnly(expectedStatusCode);

    }

    @Then("the response body should contain a list of users")
    public void theResponseBodyShouldContainAListOfUsers() {
        softAssertions.assertThat(scenarioContext.getValue(GET_USERS_DATA, GetUsersResponse.class).getData())
                .describedAs("Expecting a non null collection of users")
                .isNotNull();
    }

    @Then("the list should not be empty")
    public void theListShouldNotBeEmpty() {
        softAssertions.assertThat(scenarioContext.getValue(GET_USERS_DATA, GetUsersResponse.class).getData())
                .describedAs("Expecting a non empty collection of users")
                .isNotEmpty();
    }

    @Then("new user creation date is today")
    public void newUserCreationDateIsToday() {
        CreateUserResponse responseData = scenarioContext.getValue(GET_USERS_DATA, CreateUserResponse.class);
        softAssertions.assertThat(responseData)
                .extracting(CreateUserResponse::getCreatedAt)
                .describedAs("Expecting created at to be today")
                .isEqualTo(LocalDate.now());
    }

    @Then("user details were updated")
    public void userWasUpdated() {
        UpdateUserResponse response = scenarioContext.getValue(UPDATE_USER_DATA, UpdateUserResponse.class);
        UpdateUserRequest request = scenarioContext.getValue(UPDATE_USER_REQUEST, UpdateUserRequest.class);
        softAssertions.assertThat(response)
                .usingRecursiveComparison()
                .isEqualTo(request);
    }

    @Then("the response time is no longer than '{}' second(s)")
    public void theResponseTimeIsNoLongerThanResponseTimeSecondS(Integer expectedResponseTime) {
        ((Mono<ResponseEntity<GetUsersResponse>>) scenarioContext.getValue(GET_USERS_RESPONSE, Mono.class)).elapsed()
                .map(tuple -> {
                    softAssertions.assertThat(tuple.getT1() / 1000).isLessThanOrEqualTo(expectedResponseTime);
                    return tuple.getT2();
                })
                .block();
    }

}
