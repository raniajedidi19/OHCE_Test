Feature: Smoke tests

  The following tests verifies that the user is able to log in, that his library opens and that he is able to log out

  Background:
    Given user goes to the base url
    When Login page opens successfully
    Then user accept cookies

  @functional
  Scenario: Test success login with valid credentials
    Given user enters his credentials and login
    Then user is logged in successfully to his library


  @functional
  Scenario: Test success logout
    Given user enters his credentials and login
    Then user is logged in successfully to his library
    When user log out
    Then Login page opens again

 @functional
  Scenario: Test failed login
    When user enters his credentials and try login
    Then user gets an error message