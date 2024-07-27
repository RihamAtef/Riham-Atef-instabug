@regression
Feature: testing login functionality

  @smoke

  Scenario: user could login with invalid credentials
    Given user go to login page

    And  user enter invalid email"name" and  invalid password in login page"pasword"
    And user click on loginBtn
    Then error message appears

  Scenario: user could login with valid credentials
    Given user go to login page

    And  user enter valid email"standard_user" and password in login page"secret_sauce"
    And user click on loginBtn
    Then welcome message appears