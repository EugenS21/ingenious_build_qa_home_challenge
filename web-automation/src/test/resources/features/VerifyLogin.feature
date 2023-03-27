Feature: UI Validation 4 - User Authentication
  As a registered user
  I want to be able to log in to the system
  So that I can access inventory

  Background:
    Given I am on the login page

  Scenario: Verify successful login
    When I enter the following login credentials:
      | username      | password     |
      | standard_user | secret_sauce |
    And click on login button
    Then I should be redirected to products page

  Scenario: Verify login with locked_out_user user
    When I enter the following login credentials:
      | username      | password     |
      | locked_out_user | secret_sauce |
    And click on login button
    Then I should see 'Epic sadface: Sorry, this user has been locked out.' error
