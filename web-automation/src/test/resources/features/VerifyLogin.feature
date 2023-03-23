Feature: Validation 4 - User Authentication
  As a registered user
  I want to be able to log in to the system
  So that I can access my account information

  Background:
    Given I am on the login page

  Scenario: Verify successful login
    When I enter the following login credentials:
      | username      | password     |
      | standard_user | secret_sauce |
    And click on login button
    Then I should be redirected to products page
