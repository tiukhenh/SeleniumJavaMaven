package Cindy;

import PageObject.GolfCoursesPage;
import PageObject.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
}
