package PageObject;

import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

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

}
