package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    private By testButon = By.xpath("//button[@class='dropbtn' and contains(text(), 'Tests')]");
    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getTitleText() {
        return driver.getTitle();
    }
    // Method to navigate to the home page (if needed)
    public void navigateToHomePage(String url) {
        driver.get(url);
    }
    public void clickOnTestsButton() {
        driver.findElement(testButon).click();
    }

}
