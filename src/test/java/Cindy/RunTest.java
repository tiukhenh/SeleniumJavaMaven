package Cindy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class RunTest {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup(); //gọi phiên bản browser

        driver= new ChromeDriver(); // khởi tạo giá tri cho browser
        driver.get("https://anhtester.com/");

    }
}
