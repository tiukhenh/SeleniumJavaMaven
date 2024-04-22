package stepDefinition;

import Cindy.common.BaseSetup;
import PageObject.HomePage;
import PageObject.WebElementPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WebElementSteps {
    WebDriver driver;
    HomePage homePage;
    WebElementPage webElementPage;

    @Given("Navigate to HomePage")
    public void navigate_to_home_page() {
        driver = new BaseSetup().setupDriver("chrome");
        homePage = new HomePage(driver);
        webElementPage = new WebElementPage(driver);

        homePage.navigateToHomePage("https://www.admlucid.com");
    }
    @Then("Verify navigate to Homepage successful")
    public void verify_navigate_to_homepage_successful() {
        assert(homePage.getTitleText().contains("Home Page - Admlucid"));
    }
    @When("Click on Test button")
    public void click_on_test_button() {
        webElementPage.clickOnTestsButton();
    }
    @And("Click on WebElement")
    public void click_on_web_element() {
        webElementPage.clickOnWebElement();
    }

    @Then("Verify navigate to WebElementPage successful")
    public void verify_navigate_to_web_element_page_successful() {
        assert(webElementPage.getTitleText().contains("Web Elements and Locators"));

    }
    @When("User input {string}")
    public void user_input(String string) {
        webElementPage.inputText1(string);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

}
