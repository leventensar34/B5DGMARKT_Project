
Feature: Cart Icon function

  Background:The user should be login and the product should be added to the cart.
    Then The user should be on the main page and can see the "Your Store" text as title
    When The user navigates to "My Account" module "Login" tab
    And The user enters the personal username and password
    Then The user should be on the dashboard page and can see the "×" success message


  @B5DGMAUT-63
  Scenario: As a user, I should be able to manage the cart by clicking the cart icon.
    When The user navigates to Home Page Cart icon and click
    Then The user should be see "Nicky Clarke NMS201 Multi Styler" in popup window
    When The user navigates to View Cart button and click
    Then The user should be see the chosen product "Nicky Clarke NMS201 Multi Styler" message in Wish List
    When The user navigates to Cart Icon and go Checkout button and click
    Then The user should be able to see Checkout Page
    When The user should be enters valid Checkout credentials
    Then The user should be able to see "Your Order Has Been Placed!" message