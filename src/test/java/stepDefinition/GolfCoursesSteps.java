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

    @When("Input GolfCourses name")
    public void inputGolfCoursesName() {
        golfCoursesPage.inputGolfCoursesName(searchedGolfCourseName );
        golfCoursesPage.clickSearchButton();

    }
}
