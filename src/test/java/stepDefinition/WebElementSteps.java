package stepDefinition;


import Cindy.common.BaseSetup;
import PageObject.HomePage;
import PageObject.WebElementPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

public class WebElementSteps {
    WebDriver driver;
    WebElementPage webElementPage;

    public WebElementSteps() {
        driver = commonStepDefinition.driver; // Sử dụng đối tượng WebDriver từ commonStepDefinition
        webElementPage = new WebElementPage(driver);
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

    @And("Click on button")
    public void clickOnButton() {
        webElementPage.clickOnButton1();
    }

    @And("Confirm accept")
    public void confirmAccept() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // Chờ cho alert xuất hiện
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        alert.accept();
        // Chờ cho trang web được cập nhật sau khi chấp nhận alert
        try {
            Thread.sleep(2000); // Thời gian chờ 2 giây
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("Verify button status disable")
    public void verifyButtonStatusDisable() {
        //verify status Button is disEnabled
        Boolean statusAfter = webElementPage.statusButton1();
        Assert.assertFalse(statusAfter);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @When("Screenshot {string}")
    public void screenshot(String name) {
        BaseSetup.takeScreenShot(name);
//        String screenshotPath =BaseSetup.captureScreenshot(driver, name);
//        scenario.attach(screenshotPath, "image/png", "Screenshot");
    }
    @AfterTest
    public void tearDownScenario() {
        driver.quit();
    }

}
