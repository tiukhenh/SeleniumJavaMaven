Feature: WebElementPage
  Background: Navigate to HomePage
    Given Navigate to HomePage
    Then Verify navigate to Homepage successful
    When Click on Test button
    And Click on WebElement
    Then Verify navigate to WebElementPage successful
  Scenario: Check button
    When Click on button
    And Confirm accept
    Then Verify button status disable
    When Screenshot "button status disable"
  Scenario: Check input text
    When User input "hello"
    And Screenshot "input text"
