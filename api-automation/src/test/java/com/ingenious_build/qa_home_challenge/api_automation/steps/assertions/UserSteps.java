package com.ingenious_build.qa_home_challenge.api_automation.steps.assertions;

import com.ingenious_build.qa_home_challenge.api_automation.core.model.GetUsersResponse;
import com.ingenious_build.qa_home_challenge.api_automation.core.model.UserDto;
import com.ingenious_build.qa_home_challenge.api_automation.enums.ApiStorageKey;
import com.ingenious_build.qa_home_challenge.api_automation.model.User;
import com.ingenious_build.qa_home_challenge.api_automation.storage.ApiScenarioContext;
import com.ingenious_build.qa_home_challenge.testing_components.core.storage.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.SoftAssertions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static com.ingenious_build.qa_home_challenge.api_automation.enums.ApiStorageKey.GET_USERS_DATA;
import static com.ingenious_build.qa_home_challenge.api_automation.enums.ApiStorageKey.GET_USERS_RESPONSE;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class UserSteps {

    ApiScenarioContext scenarioContext;
    SoftAssertions softAssertions;
    ModelMapper modelMapper;

    @Then("I should receive response code {int}")
    public void iShouldReceiveResponseCode(int expectedStatusCode) {
        softAssertions.assertThat(scenarioContext.getValue(GET_USERS_RESPONSE, ResponseEntity.class))
                .extracting(ResponseEntity::getStatusCode)
                .extracting(HttpStatusCode::value)
                .describedAs("Expecting <%d> response code", expectedStatusCode)
                .isEqualTo(expectedStatusCode);
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

}
