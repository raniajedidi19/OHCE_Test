Feature: Access code help functionality test


  Background:
    Given user is on homepage

  @functional
  Scenario: Test success access to the access code help page
    When user redeems invalid code
    Then user access the access code help page successfully using the link

  @functional
  Scenario: Test Recovering with invalid ISBN code
    When    user is on access code help page
    And     user enters an invalid Book ISBN
    Then    check the message displayed with an invalid ISBN
