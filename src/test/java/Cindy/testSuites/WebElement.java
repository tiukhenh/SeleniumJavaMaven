package Cindy.testSuites;

import PageObject.HomePage;
import PageObject.WebElementPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebElement {
    WebDriver driver;
    WebElementPage webElementPage;
    HomePage homePage;

    @BeforeSuite
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        // Thiết lập kích thước màn hình
        Dimension screenSize = new Dimension(1920,1080); // Thay đổi kích thước tùy ý
        driver.manage().window().setSize(screenSize);
        //Khởi tạo đối tượng WebElementPage
        webElementPage = new WebElementPage(driver);
        homePage = new HomePage(driver);

        homePage.navigateToHomePage("https://www.admlucid.com");
        assert(homePage.getTitleText().contains("Home Page - Admlucid"));

        webElementPage.clickOnTestsButton();
        webElementPage.clickOnWebElement();
        assert(webElementPage.getTitleText().contains("Web Elements and Locators"));
    }
    @Test
    public  void  testButton(){
        //verify status Button is Enabled
        Boolean status = webElementPage.statusButton1();
        Assert.assertTrue(status);
        System.out.println("Button 1 is Enable: "+status);
        // click the button and handle the alert
        webElementPage.clickOnButton1();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        //verify status Button is disEnabled
        Boolean statusAfter = webElementPage.statusButton1();
        Assert.assertFalse(statusAfter);
        System.out.println("Button 1 is Enable: "+statusAfter);

    }
    @Test(enabled = false)
    public void testInputText() {
        webElementPage.inputText1("hello");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test(enabled = false)
    public void testUploadDoc(){
        webElementPage.chooseFile1("E:/dataTest.xlsx");
    }
    @Test(enabled = false)
    public void testCheckBox() {
        Assert.assertFalse(webElementPage.statusCheckBox());
        System.out.println("CheckBox 1 is Selected "+webElementPage.statusCheckBox());

        webElementPage.clickOnCheckBox1();

        Assert.assertTrue(webElementPage.statusCheckBox());
        System.out.println("CheckBox1 is Selected after click: "+webElementPage.statusCheckBox());
    }
    @Test(enabled = false)
    public void testSubmitChildCareRegistration() {
        webElementPage.inputParentName("cindy");
        webElementPage.inputParentEmail("aaaaa");
        webElementPage.inputParentPhone("0968");
        // Tạo đối tượng JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Thực hiện cuộn xuống dưới cùng của trang
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        webElementPage.selectGender("boy");

        webElementPage.selectAge("2");
        webElementPage.selectService("After School");

        webElementPage.submitRegistration();

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    @Test(enabled = false)
    public void testCancelSubmitChildCareRegistration() {
        webElementPage.inputParentName("cindy");
        webElementPage.inputParentEmail("aaaaa");
        webElementPage.inputParentPhone("0968");
        // Tạo đối tượng JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Thực hiện cuộn xuống dưới cùng của trang
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        webElementPage.selectGender("boy");

        webElementPage.selectAge("2");
        webElementPage.selectService("After School");

        webElementPage.submitRegistration();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    @Test(enabled = false)
    public void testResetChildCareRegistration() {
        webElementPage.inputParentName("cindy");
        webElementPage.inputParentEmail("aaaaa");
        webElementPage.inputParentPhone("0968");
//        // Tạo đối tượng JavascriptExecutor
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        // Thực hiện cuộn xuống dưới cùng của trang
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        webElementPage.selectGender("boy");

        webElementPage.selectAge("2");
        webElementPage.selectService("After School");

        webElementPage.resetRegistration();
    }
    @Test(enabled = false)
    public void waitForElement15s() {
        // Issue can't click element bc it not on the screen

        webElementPage.clickOnDisable15sButton();
        webElementPage.checkElementWait15s();
    }
    @AfterSuite(enabled = false)
    public void tearDown() {
        driver.quit();
    }
}
