Feature: Access code help functionality test

  #The self-service Access Code Help is a user journey that let’s a user request help for an access code that is not working. Typical use cases for an access code not working are ; code is not legible after scratch off (in the book), code has already redeemed, code was missed during migration, code was not imported, or code is missing from the product.
  # ACH feature is not working as expected temporary
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
    Then    check the message displayed

  @functional
  Scenario: Test Recovering with valid ISBN code
    When    user is on access code help page
    And     user enters a valid Book ISBN
    Then    check the message displayed
    When    user clicks the submit button
    Then    check the message displayed