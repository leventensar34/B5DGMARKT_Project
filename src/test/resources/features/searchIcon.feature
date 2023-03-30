Feature: Search Icon functionality

  Background:
    Given The user should be login in homepage

  @B5DGMAUT-25
  Scenario Outline: Positive scenario The user verify that the product when user search the item on the website
    When  The user clicks search icon button
    Then  The user should be able to see search line
    And   The user types '<item>' in search field and click search button
    Then  The user verify that title of searched product "<title>"
    Examples:
      | item       | title               |
      | Television | Search - Television |
      | cable      | Search - cable      |
      | asus       | Search - asus       |

  @B5DGMAUT-26
  Scenario Outline: Negative scenario The user verify that the message
    Given The user should be login in homepage
    When  The user clicks search icon button
    Then  The user should be able to see search line
    And   The user types '<item>' in search field and click search button
    Then  The user verify that NOT found message "There is no product that matches the search criteria."
    Examples:
      | item      |
      | Radio     |
      | Telephone |
      | Mouse     |



