Feature: GolfCoursesPage
  Background: Navigate to HomePage
    Given Navigate to HomePage
    Then Verify navigate to Homepage successful
    When Click on Test button
    And Click on GolfCourse
    Then Verify navigate to GolfCoursePage successful
  Scenario: Check navigate to Golf courses page
    When Input GolfCourses name