Feature: User Management API
  As a user of the User Management API
  I want to be able to create, get, update an user

  Scenario: Validation 1 - get users
    Given I send a request to get the total number of users
    Given I send a request to get all the users
    Then I should receive response code 200
    And the response body should contain a list of users
    Then the list should not be empty
    When print users with odd id numbers



