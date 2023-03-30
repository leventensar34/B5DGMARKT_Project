
Feature: Like Icon Functionality

  Background:The user should be login
    Then The user should be on the main page and can see the "Your Store" text as title
    When The user navigates to "My Account" module "Login" tab
    And The user enters the personal username and password
    Then The user should be on the dashboard page and can see the "×" success message


@B5DGMAUT-60
  Scenario Outline: As a user I should be able to see products in the wish list
    When The user navigates Category dropdown than choose "<Category>" and click
    And The user navigates "<chosen product>" and click Like Icon
    Then The user should be see Success: You have added "<success>" mesage
    When The user navigates Wish List Icon and click
    Then The user should be see the chosen product "<success>" mesage in Wish List

    Examples:
    |Category|chosen product|success|
    |TV Accessories|BELKIN VIDEO / AUDIO CABLE|Belkin video / audio cable|
    |Networking|ASUS USB-BT400 | ASUS USB-BT400 |
    |Health & Beauty|NICKY CLARKE NMS201 MULTI STYLER|Nicky Clarke NMS201 Multi Styler|

  @B5DGMAUT-61
  Scenario: As a user I should be able to add to cart or products from wish list
    Given The user is on the Wish List page
    When The user navigates chosen "Nicky Clarke NMS201 Multi Styler" Add to Cart icon and click
   Then The user should be see "Nicky Clarke NMS201 Multi Styler" mesage
  @B5DGMAUT-62
  Scenario: As a user I should be able to delete products from wish list
    Given The user is on the Wish List page
    When The user navigates chosen "ASUS USB-BT400 - network adapter" Remove icon and click
    Then The user should be see "Success: You have modified your wish list!" message




