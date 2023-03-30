Feature: Login Functionality


  Scenario:The User should be able to login with valid credentials
    Then The user should be on the main page and can see the "Your Store" text as title
    When The user navigates to "My Account" module "Login" tab
    And The user enters the personal username and password
    #Then The user should be on the dashboard page and can see the "x" success message
    Then The user should be on the dashboard page and can see the "Congratulation! Login Successfully" success message