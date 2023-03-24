Feature: Register Functionality

  Background:
    Given The user can first login successfully
    Then The user should be on the main page and can see the "Your Store" text as title
    When The user navigates to "My Account" module "Register" tab
    Then The user verify that the Register Account page message "Register Account"

  #Users Story : As a user I should be able to register on the website
  #Acceptance Criteria :
  #1-Verify that the user can register by entering all the required fields – firstname, lastname, email, telephone,password, confirm password

  #US03_TC01

  Scenario Outline: Positive scenario As a user I should be able to register on the website
    And The user enters all the personal credential '<firstname>' '<lastname>' '<email>' '<telephone>' '<password>' '<passwordConfirm>'
    And The user click the Privacy Policy and Continue box button
    Then The user verify that the succesfully message "Your Account Has Been Created!"
    And The user click the Continue button
    Then The user verify that on the main Account page and see the "My Account" text as title
    Examples:
      | firstname | lastname | email         | telephone | password | passwordConfirm |
      | Ali       | Ata      | abc@gmail.com | 0123456   | 12345    | 12345           |

  #Users Story : As a user I should be able to register on the website
  #Acceptance Criteria :
  #2-Verify that the error message is displayed when the user incorrectly fills in or does not fill in the required field.

  #US03_TC02

  Scenario Outline:Negative scenario As a user I should be able to see the error message when I fill with invalid credential in the required field
    And The user enters all the personal credential '<firstname>' '<lastname>' '<email>' '<telephone>' '<password>' '<passwordConfirm>'
    And The user click the Privacy Policy and Continue box button
    Then The user verify that the error message '<message>'

    Examples:
      | firstname                         | lastname                          | email            | telephone                         | password | passwordConfirm | message                                         |
      |                                   | Onur                              | yilmaz@gmail.com | 123456789                         | 12345    | 12345           | First Name must be between 1 and 32 characters! |
      | Ifyoualreadyhaveanaccountwithuspl | Onur                              | yilmaz@gmail.com | 123456789                         | 12345    | 12345           | First Name must be between 1 and 32 characters! |
      | Ahmet                             |                                   | yilmaz@gmail.com | 123456789                         | 12345    | 12345           | Last Name must be between 1 and 32 characters!  |
      | Ahmet                             | Ifyoualreadyhaveanaccountwithuspl | yilmaz@gmail.com | 123456789                         | 12345    | 12345           | Last Name must be between 1 and 32 characters!  |
      | Ahmet                             | Onur                              |                  | 123456789                         | 12345    | 12345           | E-Mail Address does not appear to be valid!     |
      | Ahmet                             | Onur                              | yilmazgmail.com  | 123456789                         | 12345    | 12345           | E-Mail Address does not appear to be valid!     |
      | Ahmet                             | Onur                              | yilmaz@gmail     | 123456789                         | 12345    | 12345           | E-Mail Address does not appear to be valid!     |
      | Ahmet                             | Onur                              | yilmaz@gmail.    | 123456789                         | 12345    | 12345           | E-Mail Address does not appear to be valid!     |
      | Ahmet                             | Onur                              | yilmaz@.com      | 123456789                         | 12345    | 12345           | E-Mail Address does not appear to be valid!     |
      | Ahmet                             | Onur                              | yilmaz@gmail.com |                                   | 12345    | 12345           | Telephone must be between 3 and 32 characters!  |
      | Ahmet                             | Onur                              | yilmaz@gmail.com | 12                                | 12345    | 12345           | Telephone must be between 3 and 32 characters!  |
      | Ahmet                             | Onur                              | yilmaz@gmail.com | 123456789012345678901234567890123 | 12345    | 12345           | Telephone must be between 3 and 32 characters!  |
      | Ahmet                             | Onur                              | yilmaz@gmail.com | 123456789                         |          | 12345           | Password must be between 4 and 20 characters!   |
      | Ahmet                             | Onur                              | yilmaz@gmail.com | 123456789                         | 123      | 123             | Password must be between 4 and 20 characters!   |
      | Ahmet                             | Onur                              | yilmaz@gmail.com | 123456789                         |          | 12345           | Password must be between 4 and 20 characters!   |
      | Ahmet                             | Onur                              | yilmaz@gmail.com | 123456789                         | 12345    |                 | Password confirmation does not match password!  |
      | Ahmet                             | Onur                              | yilmaz@gmail.com | 123456789                         | 12345    | 123             | Password confirmation does not match password!  |


  #Users Story : As a user I should be able to register on the website
  #Acceptance Criteria :
  #2-Verify that the error message is displayed when the user incorrectly fills in or does not fill in the required field.

   #US03_TC03 bug
  @wip2
  Scenario Outline: Negative scenario As a user I can NOT create a Register Account when I entered with invalid credential in the required field
    And The user enters all the personal credential '<firstname>' '<lastname>' '<email>' '<telephone>' '<password>' '<passwordConfirm>'
    And The user click the Privacy Policy and Continue box button
    Then The user verify that the succesfully message '<message>'
    Examples:
      | firstname | lastname | email                    | telephone  | password               | passwordConfirm        | message                        |
      | 1111      | Kara     | vahtapot@hotmail.com.com | 0123456789 | 12345                  | 12345                  | Your Account Has Been Created! |
      | &%        | Kara     | sahtapot@hotmail.com.com | 0123456789 | 12345                  | 12345                  | Your Account Has Been Created! |
      | Mert      | 1111     | kahtapot@hotmail.com.com | 0123456789 | 12345                  | 12345                  | Your Account Has Been Created! |
      | Mert      | $&       | tapot@hotmail.com.com    | 0123456789 | 12345                  | 12345                  | Your Account Has Been Created! |
      | Mert      | $&       | spot@hotmail.com.com     | 0123456789 | 12345                  | 12345                  | Your Account Has Been Created! |
      | Mert      | $&       | kot@hotmail.com.com      | 0123456789 | 12345                  | 12345                  | Your Account Has Been Created! |
      | 1111      | 1111     | st@hotmail.com.com       | 0123456789 | 12345                  | 12345                  | Your Account Has Been Created! |
      | $&        | %&       | gramazan@hotmail.com.com | 0123456789 | 12345                  | 12345                  | Your Account Has Been Created! |
      | Mert      | Kara     | gamazan@hotmail.com.com  | 1234       | 12345                  | 12345                  | Your Account Has Been Created! |
      | Mert      | Kara     | gmazan@hotmail.com.com   | kerem      | 12345                  | 12345                  | Your Account Has Been Created! |
      | Mert      | Kara     | gazan@hotmail.com.com    | $%&        | 12345                  | 12345                  | Your Account Has Been Created! |
      | Ahmet     | Onur     | yilmazs@gmail.co         | 123456789  | 12345                  | 12345                  | Your Account Has Been Created! |
      | Ahmet     | Onur     | yildiz@gmail.com         | 123456789  | 1234567890123456789012 | 1234567890123456789012 | Your Account Has Been Created! |

