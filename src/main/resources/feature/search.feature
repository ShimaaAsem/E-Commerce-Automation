@regression
Feature: test search
  Background:
    Given initialize Search feature
  Scenario Outline: search products with name
    Given initialize Search feature
    When user types "<productName>"
    And clicks on search
    Then user should find the "<productName>"
    Examples:
      |productName|
      |Apple|


