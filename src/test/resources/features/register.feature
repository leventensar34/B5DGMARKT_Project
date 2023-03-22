@wip2
Feature: Register Functionality

  Background:
    Given The user can first login successfully

  #Users Story : As a user I should be able to register on the website
  #Acceptance Criteria :
  #1-Verify that the user can register by entering all the required fields – firstname, lastname, email, telephone,password, confirm password

  #US03_TC01
  Scenario Outline: Positive scenario As a user I should be able to register on the website
    Then The user should be on the main page and can see the "Your Store" text as title
    When The user navigates to "My Account" module "Register" tab
    Then The user verify that the Register Account page message "Register Account"
    And The user enters all the personal credential '<firstname>' '<lastname>' '<email>' '<telephone>' '<password>' '<passwordConfirm>'
    And The user click the Privacy Policy and Continue box button
    Then The user verify that the succesfully message "Your Account Has Been Created!"
    And The user click the Continue button
    Then The user verify that on the main Account page and see the "My Account" text as title
    Examples:
      | firstname | lastname | email        | telephone | password | passwordConfirm |
      | Ali       | Ata      | aa@gmail.com | 0123456   | 12345    | 12345           |

  #Users Story : As a user I should be able to register on the website
  #Acceptance Criteria :
  #2-Verify that the error message is displayed when the user incorrectly fills in or does not fill in the required field.

  #US03_TC02
  Scenario Outline:Negative scenario As a user I should be able to see the error message when I does NOT fill in the required field
    Then The user should be on the main page and can see the "Your Store" text as title
    When The user navigates to "My Account" module "Register" tab
    Then The user verify that the Register Account page message "Register Account"
    And The user enters all the personal credential '<firstname>' '<lastname>' '<email>' '<telephone>' '<password>' '<passwordConfirm>'
    And The user click the Privacy Policy and Continue box button
    Then The user verify that the error message '<message>'

    Examples:
      | firstname | lastname | email | telephone | password | passwordConfirm | message |
      |           | Yilmaz | yilmaz@gmail.com | 123456789 | 12345 | 12345 | message |
      | firstname | lastname | email | telephone | password | passwordConfirm | message |
      | firstname | lastname | email | telephone | password | passwordConfirm | message |
      | firstname | lastname | email | telephone | password | passwordConfirm | message |
      | firstname | lastname | email | telephone | password | passwordConfirm | message |
      | firstname | lastname | email | telephone | password | passwordConfirm | message |
      | firstname | lastname | email | telephone | password | passwordConfirm | message |