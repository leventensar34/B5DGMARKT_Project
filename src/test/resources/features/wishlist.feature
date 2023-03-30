@B5DGMAUT-11
Feature:US011 Wish List Modify Functionality

  Background: User Login
    Then The user should be on the main page and can see the "Your Store" text as title
    When The user navigates to "My Account" module "Login" tab
    And The user enters the personal username and password
    Then The user should be on the dashboard page and can see the "Congratulation! Login Successfully" success message

  @B5DGMAUT-45 @B5DGMAUT-46 @B5DGMAUT-51
  Scenario Outline: TC001, TC002, TC003 Verify that the user should be able to reach wish list on My wish list page
    And The user hover overs to "Category" menu headers and clicks "<moduleName>" sub menu headers
    And User adds "<productName>" item in his her wish list
    Then User validates the success message adding to wish list "<productNamesInSuccessMessages>"
    And User clicks "Wish List"
    Then User verifies that the user can see the product "<productNamesInSuccessMessages>" in the wish list
    Examples: Product names & Module Names
      | productName              | productNamesInSuccessMessages | moduleName      |
      | CELLO C3220G 32          | Cello C3220G 32               | Televisions     |
      | CAPSULE PLATE 6PCS       | Capsule Plate 6pcs            | Health & Beauty |
      | ASUS ROG STRIX GS-AX3000 | ASUS ROG STRIX GS-AX3000      | Networking      |


  @B5DGMAUT-47 @B5DGMAUT-48 @us011
  Scenario Outline: TC004, TC005 Verify that the user should be able to add the products from wish list to cart
    And The user hover overs to "Category" menu headers and clicks "<moduleName>" sub menu headers
    And User adds "<productName>" item in his her wish list
    And User clicks "Wish List"
    And User adds product "<productNamesInSuccessMessages>" from wish list to cart
    Then User validates the success message adding to cart "<productNamesInSuccessMessages>"
    And User clicks to cart button
    Then User validates that the item is in cart "<cartProductName>"
    Examples: Product names & Module Names
      | productName              | productNamesInSuccessMessages | moduleName      | cartProductName          |
      | CAPSULE PLATE 6PCS       | Capsule Plate 6pcs            | Health & Beauty | Capsule Plate 6pcs       |
      | ASUS ROG STRIX GS-AX3000 | ASUS ROG STRIX GS-AX3000      | Networking      | ASUS ROG STRIX GS-AX3000 |
   #  | BELKIN ADAPTER CABLE     | Belkin adapter cable          | TV Accessories  | Belkin adapter cable     |


  @B5DGMAUT-49 @B5DGMAUT-50 @us011
  Scenario Outline: TC006, TC007 Verify that the User should be able to delete the products from wish list
    And The user hover overs to "Category" menu headers and clicks "<moduleName>" sub menu headers
    And User adds "<productName>" item in his her wish list
    Then User validates the success message adding to wish list "<productNamesInSuccessMessages>"
    And User clicks "Wish List"
    And User clicks remove button "<productNamesInSuccessMessages>"
    Then User validates that the item is not on the wish list anymore "<productNamesInSuccessMessages>"
    Examples: Product names & Module Names
      | productName              | productNamesInSuccessMessages | moduleName      |
      | CAPSULE PLATE 6PCS       | Capsule Plate 6pcs            | Health & Beauty |
      | ASUS ROG STRIX GS-AX3000 | ASUS ROG STRIX GS-AX3000      | Networking      |
   #  | BELKIN ADAPTER CABLE     | Belkin adapter cable          | TV Accessories  |









