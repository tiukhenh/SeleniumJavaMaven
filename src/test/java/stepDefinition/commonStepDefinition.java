package stepDefinition;

import Cindy.common.BaseSetup;
import PageObject.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class commonStepDefinition {
    public static WebDriver driver;;
    HomePage homePage;


    @Given("Navigate to HomePage")
    public void navigate_to_home_page() {
        driver = new BaseSetup().setupDriver("chrome");
        homePage = new HomePage(driver);

        homePage.navigateToHomePage("https://www.admlucid.com");
    }
    @Then("Verify navigate to Homepage successful")
    public void verify_navigate_to_homepage_successful() {
        assert(homePage.getTitleText().contains("Home Page - Admlucid"));
    }
    @When("Click on Test button")
    public void click_on_test_button() {
        homePage.clickOnTestsButton();
    }

}
