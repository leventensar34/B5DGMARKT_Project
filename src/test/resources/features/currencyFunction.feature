@B5DGMAUT-4
Feature: Currency Function

  Background:
    Then The user should be on the main page and can see the "Your Store" text as title
    When The user navigates to "My Account" module "Login" tab
    And The user enters the personal username and password
    Then The user should be on the dashboard page and can see the "×" success message


  @B5DGMAUT-27
  Scenario Outline: The currency selected by the user should be the same as the currency in the products.
    Given The user selects  "<currency>"
    When The user goes to "<category>" page from Category
    Then The user sees that the currency on the products has changed to "<currencyOfProduct>"
    Examples:
      | category       | currency         | currencyOfProduct |
      | Televisions    | £ Pound Sterling | £121.89           |
      | Networking     | € Euro           | 252.64€           |
      | TV Accessories | $ US Dollar      | $189.00           |


  @B5DGMAUT-35
  Scenario Outline: The user should be able to complete the purchase with the currency of their choise.
    Given The user selects  "<currency1>"
    When The user goes to "<category>" page from Category
    And The user select a product and adds the selected product to the cart
    And The user goes to cart
    And The user goes to checkout page
    And The user selects the I want to use a new address and goes to the Delivery Details
    And The user enters "<FirsName>","<LastName>", "<Adress1>", "<City>", "<PostCode>", "<Country>", "<RegionState>"
    And The user selects the I want to use an existing address
    When The user confirms Term&Condition
    Then The user sees that the product currency is "<currency2>"
    When The user confirms your their order
    Then The user verifies that the order was completed successfully

    Examples:
      | currency1        | category    | FirsName | LastName | Adress1  | City | PostCode | Country | RegionState | currency2 |
      | £ Pound Sterling | Televisions | John     | Wick     | Mainstr. | Can  | 12345    | Germany | Bayern      | £         |
      | $ US Dollar      | Televisions | John     | Wick     | Mainstr. | Can  | 12345    | Germany | Bayern      | $         |
      | € Euro           | Televisions | John     | Wick     | Mainstr. | Can  | 12345    | Germany | Bayern      | €         |
