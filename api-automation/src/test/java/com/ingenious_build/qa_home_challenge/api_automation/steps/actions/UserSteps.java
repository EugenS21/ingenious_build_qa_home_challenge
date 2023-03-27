package com.ingenious_build.qa_home_challenge.api_automation.steps.actions;

import com.ingenious_build.qa_home_challenge.api_automation.core.model.GetUsersResponse;
import com.ingenious_build.qa_home_challenge.api_automation.core.model.UserDto;
import com.ingenious_build.qa_home_challenge.api_automation.core.service.UsersService;
import com.ingenious_build.qa_home_challenge.api_automation.enums.ApiStorageKey;
import com.ingenious_build.qa_home_challenge.api_automation.storage.ApiScenarioContext;
import com.ingenious_build.qa_home_challenge.testing_components.core.storage.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static com.ingenious_build.qa_home_challenge.api_automation.enums.ApiStorageKey.GET_USERS_DATA;
import static com.ingenious_build.qa_home_challenge.api_automation.enums.ApiStorageKey.GET_USERS_RESPONSE;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class UserSteps {

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
}
