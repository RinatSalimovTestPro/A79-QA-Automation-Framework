Feature: Login

  Scenario: Login with valid credentials
    Given User opens login page
    When User enters valid credentials
    And User clicks login button
    Then User should see avatar