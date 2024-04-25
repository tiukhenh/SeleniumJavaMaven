Feature: GolfCoursesPage
  Background: Navigate to HomePage
    Given Navigate to HomePage
    Then Verify navigate to Homepage successful
    When Click on Test button
    And Click on GolfCourse
    Then Verify navigate to GolfCoursePage successful

  Scenario Outline: Check navigate to Golf courses page
    When Input GolfCourses name "<name>"
    And Click on search button
    Then Verify result list contain "<name>"
    Examples:
      | name  |
      | Tiger |
      | Tiger a|