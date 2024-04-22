package Cindy.testSuites;

import Cindy.common.BaseSetup;
import Cindy.listeners.TestListener;
import PageObject.GolfCoursesPage;
import PageObject.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class GolfCourses {
    WebDriver driver;
    GolfCoursesPage golfCoursesPage;
    HomePage homePage;

    //Variable
    String searchedGolfCourseName  = "Tiger";
    String country = "Canada";
    String golfCourseName = "Tiger Golf";

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        golfCoursesPage = new GolfCoursesPage(driver);
        homePage = new HomePage(driver);


        homePage.navigateToHomePage("https://www.admlucid.com/Golf");
        assert(golfCoursesPage.getTitlePage().contains("Golf Courses"));

    }
    @Test
    public void searchGolfCoursesName(){
        golfCoursesPage.inputGolfCoursesName(searchedGolfCourseName );
        golfCoursesPage.clickSearchButton();

        String[] result = golfCoursesPage.handleTableResultName();

        for (int i = 0; i < result.length; i++) {
//            Assert.assertEquals(expectedResult[i], result[i]);
            System.out.println(result[i]);
            Assert.assertTrue(golfCoursesPage.arrayContainsString(result, searchedGolfCourseName ));
        }
    }
    @Test
    public void searchCountry() {
        golfCoursesPage.selectCountry(country);
        golfCoursesPage.clickFilterButton();

        String[] result = golfCoursesPage.handleTableResultCountry();

        for (int i = 0; i < result.length; i++) {
//            Assert.assertEquals(expectedResult[i], result[i]);
            System.out.println(result[i]);
            Assert.assertTrue(golfCoursesPage.arrayContainsString(result, country));
        }
    }
    @Test
    public void clearFilter() {
        golfCoursesPage.inputGolfCoursesName(searchedGolfCourseName);
        golfCoursesPage.clickSearchButton();

        int numberPaginationBefore = golfCoursesPage.numberPagination();
        System.out.println("Number pagination before clear filter "+numberPaginationBefore);

        golfCoursesPage.clickClearFilter();

        int numberPaginationAfter = golfCoursesPage.numberPagination();
        System.out.println("Number pagination after clear filter "+numberPaginationAfter);

        //số lượng phân trang tăng lên
        Assert.assertTrue(numberPaginationAfter>numberPaginationBefore);

    }
    @Test
    public void viewDetailGolfCourses() {
        golfCoursesPage.inputGolfCoursesName(golfCourseName);
        golfCoursesPage.clickSearchButton();

        golfCoursesPage.clickDetailGolfCourses(golfCourseName);

        assert(golfCoursesPage.getTitleDetailPage().contains(golfCourseName));
        // take screen short
        golfCoursesPage.takeScreenshot(driver,"detail");
    }
    @Test
    public void getNameGolfCourses() {
        int numberPagination = golfCoursesPage.numberPagination();
        String[] result = golfCoursesPage.handleTableResultName();
        if(numberPagination > 1) {
            for (int i = 1;i < numberPagination;i++) {
                System.out.println("lan click "+i);
                golfCoursesPage.clickNextPagination();
                String[] namesOnCurrentPage = golfCoursesPage.handleTableResultName();
                result = golfCoursesPage.concatArray(result, namesOnCurrentPage);
            }
        }
        for (String name : result) {
            System.out.println(name);
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Listeners(TestListener.class)
    public static class ListenerTC {

        WebDriver driver;

        @BeforeClass
        public void setupDriver() {
            driver = new BaseSetup().setupDriver("chrome");
        }

        @Test(priority = 1) //Success Test
        public void gotoPage() {
            driver.get("https://anhtester.com");
        }

        @Test(priority = 2) //Failed Test
        public void checkTitle() {
            String expectedTitle = "Anh Tester";
            String originalTitle = driver.getTitle();
            Assert.assertEquals(originalTitle, expectedTitle, "Title of the website do not match");
        }

        @Test(priority = 3)  //Skip Test
        public void skipTest() {
            throw new SkipException("Skipping The Test Method ");
        }

        @AfterClass
        public void closeDriver() {
            driver.quit();
        }
    }
}
