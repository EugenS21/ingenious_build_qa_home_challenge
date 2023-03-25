@dev
Feature: Validation 2 and 3- Sorting Items
  As a registered user
  I want to be able to sort items

  Background:
    Given I am on the login page

  Scenario Outline: Verify the Sorting Process
    When I login with the following credentials:
      | username      | password     |
      | standard_user | secret_sauce |
    Then I should be redirected to products page
    When I sort the items by <FIELD> <STRATEGY>
    And I check the products grid
    Then I should see the items ordered <STRATEGY> by <FIELD>

    Examples:
      | FIELD | STRATEGY |
      | name  | asc      |
      | name  | desc     |
      | price | desc     |
      | price | asc      |