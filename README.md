**Overview**
Create Test framework based
- Java8;
- Maven;
- Junit - version - 5.8.0-M1;
- Selenium Webdriver - version - 4.0.0-beta-3;
- Cucumber - version 6.10.4;

**Test Cases**
1. `Description`: As a customer I want to have ability to buy product
   immediately
   
   `Scenario:` Add to basket via “Buy now” button
   
   GIVEN I login as non registered user on haircarepanda
   
   AND I select category “gummies”
   
   AND I put cursor on product
   
   WHEN I tap on “Buy now” button
   
   THEN the basket page is displayed with selected previously
   product
2. `Description:` As a customer I want to have ability to delete product
   from my basket
   
   `Scenario:` Remove product from basket
   
   GIVEN I login as non registered user on haircarepanda
   
   AND I add product to basket
   
   AND I navigate to basket
   
   WHEN I tap on “delete” icon near product name
   
   THEN the message “Your shopping cart is empty
   
   An empty basket is a sad basket” is displayed
   
3. `Description:` As a customer I want to have ability to increase
   quantity of products in my basket
   
   `Scenario:` increase quantity of product in basket
   
   GIVEN I login as non registered user on haircarepanda
   
   AND I add product to basket
   
   AND I navigate to basket
   
   WHEN I tap on “+” icon near product name
   
   THEN the quantity of products is increased
   
   AND the price is calculated correctly
