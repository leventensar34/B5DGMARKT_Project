Feature: My Account-User can Edit account Information

  Background: The User should be able to login with valid credentials
    Given The user should be on the main page and can see the "Your Store" text as title
    And   The user navigates to "My Account" module "Login" tab
    And   The user enters the personal "test1@test.com" and "Test123"
    And   The user navigates to My Account module My Account button
    And   The user clicks "Edit Account" button

@B5DGMAUT-28
  Scenario Outline: Positive scenario Verify that you as a user can update account Information on the website
    Given  The user updates "<FirstName>" "<LastName>" "<E-Mail>" "<Telephone>"
    And    The user clicks the Continue button
    Then   The user verify "<Message>"
    Examples:
      | FirstName | LastName | E-Mail         | Telephone  | Message                                              |
      | Hansel    | Gratel   | test1@test.com | 1234567254 | Success: Your account has been successfully updated. |

@B5DGMAUT-29
  Scenario Outline: Negative scenario Verify that you as a user can update account Information on the website
    Given  The user updates "<FirstName>" "<LastName>" "<E-Mail>" "<Telephone>"
    And    The user clicks the Continue button
    Then   The user verify dangers "<Message>"
    Examples:
      | FirstName                           | LastName                            | E-Mail         | Telephone                           | Message                                         |
      |                                     | Gratel                              | test1@test.com | 1234567254                          | First Name must be between 1 and 32 characters! |
      | 12345678901234567890123456789022asa | Gratel                              | test1@test.com | 1234567254                          | First Name must be between 1 and 32 characters! |
      | Hansel                              |                                     | test1@test.com | 1234567254                          | Last Name must be between 1 and 32 characters!  |
      | Hansel                              | 12345678901234567890123456789022asa | test1@test.com | 1234567254                          | Last Name must be between 1 and 32 characters!  |
      | Hansel                              | Gratel                              |                | 1234567254                          | E-Mail Address does not appear to be valid!     |
      | Hansel                              | Gratel                              | test1@test.com |                                     | Telephone must be between 3 and 32 characters!  |
      | Hansel                              | Gratel                              | test1@test.com | 12                                  | Telephone must be between 3 and 32 characters!  |
      | Hansel                              | Gratel                              | test1@test.com | 12345678901234567890123456789022asa | Telephone must be between 3 and 32 characters!  |

@B5DGMAUT-58
  Scenario Outline: Negative BUQ scenario Verify that you as a user can update account Information on the website
    Given  The user updates "<FirstName>" "<LastName>" "<E-Mail>" "<Telephone>"
    And    The user clicks on the Continue button
    Then   The user verify this "<Message>"
    Examples:
      | FirstName | LastName | E-Mail         | Telephone  | Message                                              |
      | 12345     | Gratel   | test1@test.com | 1234567254 | Success: Your account has been successfully updated. |
      | $$$$$$    | Gratel   | test1@test.com | 1234567254 | Success: Your account has been successfully updated. |
      | Hansel    | 12345    | test1@test.com | 1234567254 | Success: Your account has been successfully updated. |
      | Hansel    | $$$$$$   | test1@test.com | 1234567254 | Success: Your account has been successfully updated. |
      | Hansel    | Gratel   | test1@test.com | abcdef     | Success: Your account has been successfully updated. |
      | Hansel    | Gratel   | test1@test.com | $$$$$$     | Success: Your account has been successfully updated. |

@B5DGMAUT-59
  Scenario Outline: Negative email "@" sign scenario
    Given  The user updates "<FirstName>" "<LastName>" "<E-Mail>" "<Telephone>"
    And    The user clicks the Continue button
    Then  The user verify that a danger error "<Message>"
    Examples:
      | FirstName | LastName | E-Mail        | Telephone  | Message                                                                                     |
      | Hansel    | Gratel   | emailtest.com | 1234567254 | Lütfen e-posta adresine bir \"@\" işareti ekleyin. \"emailtest.com\" adresinde \"@\" eksik. |
