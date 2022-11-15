@regression

Feature: Login function
   Scenario: Enter Valid Data
    Given open login page
    When enter email "shimaa@asem.com" and password "shimaa89"
    And user press login
    Then user go to home page
