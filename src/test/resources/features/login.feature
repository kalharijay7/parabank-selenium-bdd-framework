@login
Feature: User Login

  Scenario: Verify a registered user can log in successfully
  As a registered Parabank user
  I want to log in using valid credentials
  So that I can access my account overview page

    Given the user is on the home page
    When the user enters valid credentials
    And clicks on the login button
    Then the user should be redirected to accounts overview page
