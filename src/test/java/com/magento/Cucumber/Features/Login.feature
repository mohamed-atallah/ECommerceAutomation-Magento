Feature: Login functionality
  As a user, I want to be able to log in to my application using my Email and Password.

  Scenario: Successful login with valid credentials
    Given I navigate to the login page
    When I enter email and password
    And I click the login button
    Then I should see the home page
