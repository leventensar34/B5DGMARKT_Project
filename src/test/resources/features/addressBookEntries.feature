Feature: As a user, I should be able to update the address information by clicking the Address Book tab under the My Account module.

  Background: The User should be able to login with valid credentials
    Then The user should be on the main page and can see the "Your Store" text as title
    When The user navigates to "My Account" module "Login" tab
    And The user enters the personal username and password
    Then The user should be on the dashboard page and can see the "×" success message
    When The user navigates to "My Account" module and click "My Account" button
    Then The user should be navigate to the My Account page and able to see the "My Account" as title
    When The user goes and clicks on "Address Book" button
    Then The user should be navigate to the Address Book page and able to see the "Address Book" as title

  Scenario Outline: Verify that the user can add a NEW address.
    When The user clicks on "New Address" button
    When The user enters NEW "<First Name>","<Last Name>","<Company>","<Address 1>","<Address 2>","<City>","<Post Code>","<Country>","<Region / State>" credentials
    And The user clicks the "Continue" button
    Then verify "<message>"
    Examples:
      | First Name | Last Name | Company   | Address 1    | Address 2                  | City      | Post Code | Country | Region / State | message                                  |
      | Zeynep     | Elif      | Hayırlısı | Susam Sokağı | Barış Manço, Moda, Kadıköy | Amsterdam | 1020      | Finland | Oulun lääni    | Your address has been successfully added |

  Scenario Outline: Verify that the user can add a NEW address.
    When The user clicks on "Edit" button
    When The user UPDATES his/her credentials "<First Name>","<Last Name>","<Company>","<Address 1>","<Address 2>","<City>","<Post Code>","<Country>","<Region / State>"
    And The user clicks the "Continue" button
    Then verify "<message>"
    Examples:
      | First Name | Last Name | Company            | Address 1           | Address 2 | City   | Post Code | Country | Region / State | message                                    |
      | Betül      | Melike    | Hayırlısı İnşallah | Perihan Abla Sokağı |           | Viyana | 1010      | Denmark | Copenhagen     | Your address has been successfully updated |


  Scenario Outline:First Name Negative scenario 1- User should NOT be able to login with invalid First Name credentials
    When The user clicks on "New Address" button
    When The user enters with "<invalidFirstName>" and valid "<Last Name>","<Company>","<Address 1>","<City>","<Post Code>","<Country>","<Region / State>" credentials
    Then The warning message contains "<message>"
    Examples:
      | invalidFirstName                  | Last Name | Company   | Address 1           | City   | Post Code | Country | Region / State | message                                         |
      |                                   | Melike    | Hayırlısı | Perihan Abla Sokağı | Viyana | 1010      | Denmark | Copenhagen     | First Name must be between 1 and 32 characters! |
      | Elif1234567890Elif1234567890Elif1 | Melike    | Hayırlısı | Perihan Abla Sokağı | Viyana | 1010      | Denmark | Copenhagen     | First Name must be between 1 and 32 characters! |
      | &&%%&&                            | Melike    | Hayırlısı | Perihan Abla Sokağı | Viyana | 1010      | Denmark | Copenhagen     | First Name must be between 1 and 32 characters! |
      | 123456                            | Melike    | Hayırlısı | Perihan Abla Sokağı | Viyana | 1010      | Denmark | Copenhagen     | First Name must be between 1 and 32 characters! |

  Scenario Outline:Last Name Negative scenario 2- User should NOT be able to login with invalid Last Name credentials
    When The user clicks on "New Address" button
    When The user enters with "<invalidLastName>" and valid "<FirstName>","<Company>","<Address 1>","<City>","<Post Code>","<Country>","<Region / State>" credentials
    Then The warning message contains "<message>"
    Examples:
      | FirstName | invalidLastName                   | Company   | Address 1           | City   | Post Code | Country | Region / State | message                                         |
      | Seda      |                                   | Hayırlısı | Perihan Abla Sokağı | Viyana | 1010      | Denmark | Copenhagen     | Last Name must be between 1 and 32 characters! |
      | Seda      | Elif1234567890Elif1234567890Elif1 | Hayırlısı | Perihan Abla Sokağı | Viyana | 1010      | Denmark | Copenhagen     | Last Name must be between 1 and 32 characters! |
      | Seda      | &&%%&&                            | Hayırlısı | Perihan Abla Sokağı | Viyana | 1010      | Denmark | Copenhagen     | Last Name must be between 1 and 32 characters! |
      | Seda      | 123456                            | Hayırlısı | Perihan Abla Sokağı | Viyana | 1010      | Denmark | Copenhagen     | Last Name must be between 1 and 32 characters! |
