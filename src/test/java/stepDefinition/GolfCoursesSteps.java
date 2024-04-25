package stepDefinition;

import Cindy.common.BaseSetup;
import PageObject.GolfCoursesPage;
import PageObject.HomePage;
import PageObject.WebElementPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class GolfCoursesSteps {
    WebDriver driver;
    GolfCoursesPage golfCoursesPage;
    String searchedGolfCourseName  = "Tiger";

    public GolfCoursesSteps() {
        driver = commonStepDefinition.driver; // Sử dụng đối tượng WebDriver từ commonStepDefinition
        golfCoursesPage = new GolfCoursesPage(driver);
    }

    @And("Click on GolfCourse")
    public void clickOnGolfCourse() {
        golfCoursesPage.clickOnGolfCourses();
    }

    @Then("Verify navigate to GolfCoursePage successful")
    public void verifyNavigateToGolfCoursePageSuccessful() {
        assert(golfCoursesPage.getTitlePage().contains("Golf Courses"));
    }

    @When("Input GolfCourses name {string}")
    public void inputGolfCoursesName(String name) {
        golfCoursesPage.inputGolfCoursesName(name);
    }

    @And("Click on search button")
    public void clickOnSearchButton() {
        golfCoursesPage.clickSearchButton();
    }

    @Then("Verify result list contain {string}")
    public void verifyResultListContain(String name) {
        String[] result = golfCoursesPage.handleTableResultName();

        for (int i = 0; i < result.length; i++) {
//            Assert.assertEquals(expectedResult[i], result[i]);
            System.out.println(result[i]);
            Assert.assertTrue(golfCoursesPage.arrayContainsString(result, searchedGolfCourseName ));
        }
    }
}
