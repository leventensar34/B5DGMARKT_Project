Feature: Register Functionality

  Background:
    Given The user can first login successfully
    And The user should be on the main page and can see the "Your Store" text as title
    And The user navigates to "My Account" module "Register" tab
    And The user verify that the Register Account page message "Register Account"


  @B5DGMAUT-30
  Scenario Outline: Positive scenario As a user I should be able to register on the website
    When The user enters all the personal credential '<firstname>' '<lastname>' '<email>' '<telephone>' '<password>' '<passwordConfirm>'
    And The user click the Privacy Policy and Continue box button
    Then The user verify that the succesfully message "Your Account Has Been Created!"
    And The user click the Continue button
    Then The user verify that on the main Account page and see the "My Account" text as title
    Examples:
      | firstname | lastname | email          | telephone | password | passwordConfirm |
      | Ali       | Ata      | abc3@gmail.com | 0123456   | 12345    | 12345           |


  @B5DGMAUT-31
  Scenario Outline:Negative scenario-1 As a user I should be able to see the error message when I fill with invalid credential in the required field
    When The user enters all the personal credential '<firstname>' '<lastname>' '<email>' '<telephone>' '<password>' '<passwordConfirm>'
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



  @B5DGMAUT-32
  Scenario Outline: Negative scenario-2 As a user I can NOT create a Register Account when I entered with invalid credential in the required field
    When The user enters all the personal credential '<firstname>' '<lastname>' '<email>' '<telephone>' '<password>' '<passwordConfirm>'
    And The user click the Privacy Policy and Continue box button
    Then The user verify that the succesfully message '<message>'
    Examples:
      | firstname | lastname | email                     | telephone  | password               | passwordConfirm        | message                        |
      | 1111      | Kara     | alvahtapot@hotmail.com.com | 0123456789 | 12345                  | 12345                  | Your Account Has Been Created! |
      | &%        | Kara     | alsahtapot@hotmail.com.com | 0123456789 | 12345                  | 12345                  | Your Account Has Been Created! |
      | Mert      | 1111     | alkahtapot@hotmail.com.com | 0123456789 | 12345                  | 12345                  | Your Account Has Been Created! |
      | Mert      | $&       | altapot@hotmail.com.com    | 0123456789 | 12345                  | 12345                  | Your Account Has Been Created! |
      | Mert      | $&       | alspot@hotmail.com.com     | 0123456789 | 12345                  | 12345                  | Your Account Has Been Created! |
      | Mert      | $&       | alkot@hotmail.com.com      | 0123456789 | 12345                  | 12345                  | Your Account Has Been Created! |
      | 1111      | 1111     | alst@hotmail.com.com       | 0123456789 | 12345                  | 12345                  | Your Account Has Been Created! |
      | $&        | %&       | algramazan@hotmail.com.com | 0123456789 | 12345                  | 12345                  | Your Account Has Been Created! |
      | Mert      | Kara     | algamazan@hotmail.com.com  | 1234       | 12345                  | 12345                  | Your Account Has Been Created! |
      | Mert      | Kara     | algmazan@hotmail.com.com   | kerem      | 12345                  | 12345                  | Your Account Has Been Created! |
      | Mert      | Kara     | algazan@hotmail.com.com    | $%&        | 12345                  | 12345                  | Your Account Has Been Created! |
      | Ahmet     | Onur     | alyilmazs@gmail.co         | 123456789  | 12345                  | 12345                  | Your Account Has Been Created! |
      | Ahmet     | Onur     | alyildiz@gmail.com         | 123456789  | 1234567890123456789012 | 1234567890123456789012 | Your Account Has Been Created! |

