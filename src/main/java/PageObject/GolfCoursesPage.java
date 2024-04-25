package PageObject;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GolfCoursesPage {
    WebDriver driver;

    private By tiltePage = By.tagName("h1");
    private By golfCoursesloca = By.xpath("//a[@href='/Golf']");

    private By inputGCName = By.name("SearchString");
    private By searchButton = By.xpath("//form[@method='post']//button");

    //table
    private By tableLocator =By.xpath("//table[@class='table']");
    private By trLocator = By.xpath("//table[@class='table']//tbody//tr");
    private By tdLocator = By.xpath("//table[@class='table']//tbody//tr//td");

    private By selectCountry = By.tagName("select");
    private By filterButton = By.xpath("//form[@action='/Golf' and@method='get']//button");
    private By clearFilter = By.xpath("//form[@action='/Golf/Index2' and@method='get']//button");

    private By paginationLocator = By.xpath("//ul[@class='pagination']");

    private By detailOFGolfCoursesName(String name) {
        return By.xpath("//table[@class='table']//tbody//tr//td[contains(text(),'"+name+"')]/ancestor::tr//td[6]");
    }
    private By tilteDetailPage = By.tagName("h1");

    private By nextPaginationButton = By.xpath("//a[@rel='next']");


    public GolfCoursesPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnGolfCourses() {
        driver.findElement(golfCoursesloca).click();
    }

    public String getTitlePage(){
        return driver.findElement(tiltePage).getText();
    }
    public void inputGolfCoursesName(String name) {
        driver.findElement(inputGCName).sendKeys(name);
    }
    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public String[] handleTableResultName() {
        List<String> resultList = new ArrayList<>();

        WebElement table = driver.findElement(tableLocator);
        List<WebElement> cells = table.findElements(tdLocator);
        for (int i = 0; i < cells.size(); i += 6) {
            WebElement cell = cells.get(i);
            String cellText = cell.getText();
//            System.out.println(i+ " "+cellText);
            resultList.add(cellText);
        }
        return resultList.toArray(new String[0]);
    }
    public boolean arrayContainsString(String[] array, String searchString) {
        for (String str : array) {
            if (str.contains(searchString)) {
                return true;
            }
        }
        return false;
    }
    public void selectCountry(String country) {
        Select select = new Select(driver.findElement(selectCountry));
        select.selectByValue(country);
    }
    public void clickFilterButton() {
        driver.findElement(filterButton).click();
    }
    public String[] handleTableResultCountry() {
        List<String> resultList = new ArrayList<>();

        WebElement table = driver.findElement(tableLocator);
        List<WebElement> cells = table.findElements(tdLocator);
        for (int i = 1; i < cells.size(); i += 6) {
            WebElement cell = cells.get(i);
            String cellText = cell.getText();
//            System.out.println(i+ " "+cellText);
            resultList.add(cellText);
        }
        return resultList.toArray(new String[0]);
    }
    public void clickClearFilter() {
        driver.findElement(clearFilter).click();
    }
    public int numberPagination() {
        WebElement ulElement = driver.findElement(paginationLocator);
        int number = ulElement.findElements(By.tagName("li")).size();
        if (number==1){
            return 1;
        }else {
            return number-1;
        }
    }
    public void clickDetailGolfCourses(String name) {
        driver.findElement(detailOFGolfCoursesName(name)).click();
    }
    public String getTitleDetailPage(){
        return driver.findElement(tilteDetailPage).getText();
    }
    public  void clickNextPagination() {
        driver.findElement(nextPaginationButton).click();
    }
    public String[] concatArray(String[] arr1, String[] arr2) {
        String[] result = new String[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
        return result;
    }
    //take Screen short
    public void takeScreenshot(WebDriver driver, String screenshotName) {
        try {
            // Chuyển driver thành TakesScreenshot
            TakesScreenshot scrShot = ((TakesScreenshot) driver);

            // Chụp ảnh và lưu vào File
            File screenshotFile = scrShot.getScreenshotAs(OutputType.FILE);

            // Sao chép file ảnh vào thư mục mong muốn
            FileUtils.copyFile(screenshotFile, new File("./screenshots/" + screenshotName + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
