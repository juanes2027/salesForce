Feature: As a Qa automator, I want to create a automation to test https://www.salesforce.com/

  Scenario: Create an Account ,verify it was created, update and verify the update
    Given  The user Login in the website
    When The user goes to the account and creates a new one
    Then The user validate the new account
    And  Edit account that the user just created
    Then The user validate the update

