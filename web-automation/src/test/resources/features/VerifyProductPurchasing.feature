@dev
Feature: Validation 1 - Checkout Process
  As a registered user
  I want to be able to purchase inventory

  Background:
    Given I am on the login page

  Scenario: Verify the Purchase Process
    When I login with the following credentials:
      | username      | password     |
      | standard_user | secret_sauce |
    Then I should be redirected to products page
    And I should see the following items on the page:
      | name                              | description                                                                                                                                                            | price  |
      | Sauce Labs Backpack               | carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.                                 | $29.99 |
      | Sauce Labs Bike Light             | A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.        | $9.99  |
      | Sauce Labs Bolt T-Shirt           | Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.                        | $15.99 |
      | Sauce Labs Fleece Jacket          | It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office. | $49.99 |
      | Sauce Labs Onesie                 | Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.        | $7.99  |
      | Test.allTheThings() T-Shirt (Red) | This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.              | $15.99 |
    When I add the following items to the cart:
      | Sauce Labs Bike Light |
      | Sauce Labs Onesie     |
    Then I should see '2' items added to cart
    And I go to the cart
    Then I should be redirected to checkout page
    And I should see the items I added earlier
    When I remove the following items from the cart:
      | A |
      | B |
    Then I should validate that the items have been removed
    When I proceed to checkout
    Then I should see the order confirmation