Feature: As a user, I should be able to update the address information by clicking the Address Book tab under the My Account module.


  Background:Login and navigate Adress Book page
    Given The user can logın successfully
    When The user navigates to "My Account" module "Login" tab
    And The user enters the personal username and password
    And The user navigates to "My Account" module and click My Account button
   # And The user should be navigate to the My Account page and able to see the "My Account" as title
    And The user goes and clicks on "Address Book" button


  Scenario Outline: Verify that the user can add a NEW address
    Then The user should be navigate to the Address Book page and able to see the "Address Book" as title
    When The user clicks on New Address button
    And The user enters NEW "<First Name>" "<Last Name>" "<Company>" "<Address 1>" "<Address 2>" "<City>" "<Post Code>" "<Country>" "<Region / State>" credentials
    And The user clicks the Continue button
    Then The user verify "<message>"
    Examples:
      | First Name | Last Name | Company   | Address 1    | Address 2                  | City      | Post Code | Country | Region / State | message                                  |
      | Zeynep     | Elif      | Hayırlısı | Susam Sokağı | Barış Manço, Moda, Kadıköy | Amsterdam | 1020      | Finland | Oulun lääni    | Your address has been successfully added |


  Scenario Outline: Verify that the user can EDIT address
    Then The user should be navigate to the Address Book page and able to see the "Address Book" as title
    When The user clicks on Edit button
    And The user UPDATES credentials "<First Name>" "<Last Name>" "<Company>" "<Address 1>" "<Address 2>" "<City>" "<Post Code>" "<Country>" "<Region / State>"
    And The user clicks the Continue button
    Then The user verify Edit "<message>"
    Examples:
      | First Name | Last Name | Company            | Address 1           | Address 2 | City   | Post Code | Country | Region / State | message                                    |
      | Betül      | Melike    | Hayırlısı İnşallah | Perihan Abla Sokağı |           | Viyana | 1010      | Denmark | Copenhagen     | Your address has been successfully updated |

  @wip1
  Scenario Outline: Negative scenario- User should NOT be able to login with invalid credentials
    Then The user should be navigate to the Address Book page and able to see the "Address Book" as title
    When The user clicks on New Address button
    And The user enters "<FirstName>" "<Last Name>" "<Address 1>" "<City>" "<Post Code>" "<Country>" "<Region / State>" credentials
    And The user clicks the Continue button
    Then The dander message contains "<message>"
    Examples:
      | FirstName                         | Last Name                         | Address 1                                                                                                                         | City                                                                                                                              | Post Code   | Country               | Region / State        | message                                         |
#      |                                   | Melike                            | Perihan Abla Sokağı                                                                                                               | Aberdeen                                                                                                                          | AB10        | United Kingdom        | Aberdeen              | First Name must be between 1 and 32 characters! |
#      | Elif1234567890Elif1234567890Elif1 | Melike                            | Perihan Abla Sokağı                                                                                                               | Aberdeen                                                                                                                          | AB10        | United Kingdom        | Aberdeen              | First Name must be between 1 and 32 characters! |
#      | Seda                              |                                   | Perihan Abla Sokağı                                                                                                               | Aberdeen                                                                                                                          | AB10        | United Kingdom        | Aberdeen              | Last Name must be between 1 and 32 characters!  |
#      | Seda                              | Elif1234567890Elif1234567890Elif1 | Perihan Abla Sokağı                                                                                                               | Aberdeen                                                                                                                          | AB10        | United Kingdom        | Aberdeen              | Last Name must be between 1 and 32 characters!  |
#      | Seda                              | Melike                            |                                                                                                                                   | Aberdeen                                                                                                                          | AB10        | United Kingdom        | Aberdeen              | Address must be between 3 and 128 characters!   |
#      | Seda                              | Melike                            | QA                                                                                                                                | Aberdeen                                                                                                                          | AB10        | United Kingdom        | Aberdeen              | Address must be between 3 and 128 characters!   |
#      | Seda                              | Melike                            | 1234567890+1234567890+1234567890+1234567890+1234567890+1234567890+1234567890+1234567890+1234567890+1234567890+1234567890+12345678 | Aberdeen                                                                                                                          | AB10        | United Kingdom        | Aberdeen              | Address must be between 3 and 128 characters!   |
#      | Seda                              | Melike                            | Perihan Abla Sokağı                                                                                                               |                                                                                                                                   | AB10        | United Kingdom        | Aberdeen              | City must be between 2 and 128 characters!      |
#      | Seda                              | Melike                            | Perihan Abla Sokağı                                                                                                               | A                                                                                                                                 | AB10        | United Kingdom        | Aberdeen              | City must be between 2 and 128 characters!      |
#      | Seda                              | Melike                            | Perihan Abla Sokağı                                                                                                               | 1234567890+1234567890+1234567890+1234567890+1234567890+1234567890+1234567890+1234567890+1234567890+1234567890+1234567890+12345678 | AB10        | United Kingdom        | Aberdeen              | City must be between 2 and 128 characters!      |
#      | Seda                              | Melike                            | Perihan Abla Sokağı                                                                                                               | Aberdeen                                                                                                                          |             | United Kingdom        | Aberdeen              | Postcode must be between 2 and 10 characters!   |
#      | Seda                              | Melike                            | Perihan Abla Sokağı                                                                                                               | Aberdeen                                                                                                                          | 1           | United Kingdom        | Aberdeen              | Postcode must be between 2 and 10 characters!   |
#      | Seda                              | Melike                            | Perihan Abla Sokağı                                                                                                               | Aberdeen                                                                                                                          | 12345678901 | United Kingdom        | Aberdeen              | Postcode must be between 2 and 10 characters!   |
      | Seda                              | Melike                            | Perihan Abla Sokağı                                                                                                               | Aberdeen                                                                                                                          | AB10        | --- Please Select --- |     --- None ---                    | Please select a country!                        |
      | Seda                              | Melike                            | Perihan Abla Sokağı                                                                                                               | Aberdeen                                                                                                                          | AB10        | United Kingdom        | --- Please Select --- | Please select a region / state!                 |

  Scenario Outline: Negative scenario for BUG- User should NOT be able to login with invalid credentials
    Then The user should be navigate to the Address Book page and able to see the "Address Book" as title
    When The user clicks on New Address button
    When The user enters "<FirstName>" "<Last Name>" "<Address 1>" "<City>" "<Post Code>" "<Country>" "<Region / State>" credentials
    And The user clicks the Continue button
    Then The warning message contains "<message>"
    Examples:
      | FirstName | Last Name | Address 1           | City     | Post Code   | Country | Region / State | message                                    |
      | &&%%&&    | Melike    | Perihan Abla Sokağı | Helsinki | 1010        | Denmark | Copenhagen     | Your address has been successfully added |
      | 123456    | Melike    | Perihan Abla Sokağı | Helsinki | 1010        | Denmark | Copenhagen     | Your address has been successfully added |
      | Seda      | &&%%&&    | Perihan Abla Sokağı | Helsinki | 1010        | Denmark | Copenhagen     | Your address has been successfully added |
      | Seda      | 123456    | Perihan Abla Sokağı | Helsinki | 1010        | Denmark | Copenhagen     | Your address has been successfully added |
      | Seda      | Melike    | Perihan Abla Sokağı | &?%      | 1010        | Denmark | Copenhagen     | Your address has been successfully added |
      | Seda      | Melike    | Perihan Abla Sokağı | 123456   | 1010        | Denmark | Copenhagen     | Your address has been successfully added |
      | Seda      | Melike    | Perihan Abla Sokağı | Helsinki |             | Denmark | Copenhagen     | Your address has been successfully added |
      | Seda      | Melike    | Perihan Abla Sokağı | Helsinki | 1           | Denmark | Copenhagen     | Your address has been successfully added |
      | Seda      | Melike    | Perihan Abla Sokağı | Helsinki | 12345678901 | Denmark | Copenhagen     | Your address has been successfully added |
      | Seda      | Melike    | Perihan Abla Sokağı | Helsinki | &&&&&&&&&   | Denmark | Copenhagen     | Your address has been successfully added |
      | Seda      | Melike    | Perihan Abla Sokağı | Helsinki | aAaAaAa     | Denmark | Copenhagen     | Your address has been successfully added |

  Scenario Outline: Negative scenario for BUG- Verify that the user can NOT change default address button Yes to No
    Then The user should be navigate to the Address Book page and able to see the "Address Book" as title
    When The user clicks on New Address button
    When The user enters NEW "<First Name>" "<Last Name>" "<Company>" "<Address 1>" "<Address 2>" "<City>" "<Post Code>" "<Country>" "<Region / State>" credentials
    And The user switch Default Address from Yes to No
    And The user clicks the Continue button
    Then The user verify "<message>"
    When The user clicks on Edit button again
    Then The user verify Default Address is on the "No"
    Examples:
      | First Name | Last Name | Company   | Address 1    | Address 2                  | City      | Post Code | Country | Region / State | message                                  |
      | Zeynep     | Elif      | Hayırlısı | Susam Sokağı | Barış Manço, Moda, Kadıköy | Amsterdam | 1020      | Finland | Oulun lääni    | Your address has been successfully added |
