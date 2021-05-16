Feature: As a customer I want to have ability to buy product immediately
  Scenario: Add to basket via “Buy now” button
    Given I login as non registered user on haircarepanda
    And I select category “gummies”
    And I put cursor on product
    When I tap on “Buy now” button
    Then the basket page is displayed with selected previously product

  Scenario: As a customer I want to have ability to delete product from my basket
    Given I login as non registered user on haircarepanda
    And I add product to basket
    And I navigate to basket
    When I tap on “delete” icon near product name
    Then the message “Your shopping cart is empty An empty basket is a sad basket” is displayed

  Scenario: As a customer I want to have ability to increase quantity of products in my basket
    Given I login as non registered user on haircarepanda
    And I add product to basket
    And I navigate to basket
    When I tap on “+” icon near product name
    Then the quantity of products is increased
    And the price is calculated correctly
