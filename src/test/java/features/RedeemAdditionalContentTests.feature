Feature: Redeem Additional Content functionality test - amazon kindle flow

  #This flow is corresponding to users purchasing AC licenses of books from amazon kindle
  #Only Additional content licenses should be given to those users
  Background:
    Given user is on homepage

  @functional
  @NRT
  Scenario: Test success access to the Redeem Additional Content page
    When user clicks on the link 'No Access Code?'
    Then user is redirected to Redeem Additional Content page successfully

  @functional
  @NRT
  Scenario: Test success amazon redemption
    Given user is on Redeem Additional Content page
    When user enters a valid order number
    And user enters a valid ISBN
    Then the redeem button is enabled
    When user click on the redeem button
    Then user will be redirected to the product page
    And the book should be added successfully to the top of the list


  @functional
  @NRT
  Scenario: Test entering invalid order number
    Given user is on Redeem Additional Content page
    When user Fills in order number input with invalid data
    Then Check that order number validation message is displayed

  @functional
  @NRT
  Scenario: Test entering invalid ISBN
    Given user is on Redeem Additional Content page
    When user Fills in ISBN input with invalid data
    Then Check that ISBN validation message is displayed 2


