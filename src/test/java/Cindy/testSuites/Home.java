package Cindy.testSuites;

import PageObject.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Home {
    WebDriver driver;
    HomePage homePage;
    @BeforeSuite
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        //Khởi tạo đối tượng HomePage
        homePage = new HomePage(driver);
    }
    @Test
    public void testHomePage() {
        homePage.navigateToHomePage("https://www.admlucid.com");
        assert(homePage.getTitleText().contains("Home Page - Admlucid"));

    }
    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
