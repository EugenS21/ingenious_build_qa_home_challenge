Feature: User Management API
  As a user of the User Management API
  I want to be able to create, get, update an user

  Scenario: Validation 1 - get users
    Given I send a request to get the total number of users
    When I send a request to get all the users
    Then I should receive response code 200
    And the response body should contain a list of users
    Then the list should not be empty
    When print users with odd id numbers

  Scenario: Validation 2 - create user
    When I send a request to create a new user with details:
      | name     | job     |
      | RND_NAME | RND_JOB |
    Then I should receive response code 201
    And new user creation date is today

  Scenario: Validation 3 - update user
    Given I send a request to get the total number of users
    When I send a request to get all the users
    And I pick a random user to be updated
    When I send a request to update the user with details:
      | name     | job     |
      | RND_NAME | RND_JOB |
    Then I should receive response code 200
    And user details were updated

#    I decided to change the request from the Tasks
#    I used a parametrized step to pass the delay
#    and then I asserted that response time wont exceed the delay we passed
  Scenario Outline: Validation 4 - get users with delay
    Given I send a request to get the total number of users
    When I send a request to get all the users with '<delay>' seconds delay
    Then the response time is no longer than '<responseTime>' seconds

    Examples:
      | delay | responseTime |
      | 0     | 1            |
      | 3     | 4            |

  Scenario: Validation 5 - get users asynchronously
    Given I send a request to get the total number of users
    When I send a request to get all the users
    And I send '10' asynchronous requests to get user by id
    Then I should receive response codes 200