Feature: WebElementPage
  Background: Navigate to HomePage
    Given Navigate to HomePage
    Then Verify navigate to Homepage successful
  Scenario: Navigate to WebElementPage
    When Click on Test button
    And Click on WebElement
    Then Verify navigate to WebElementPage successful

