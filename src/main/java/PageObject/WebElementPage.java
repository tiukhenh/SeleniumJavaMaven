package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementPage {
    WebDriver driver;
    //Locators
    private By tiltemessa = By.xpath("//h1");
    private By testButon = By.xpath("//button[@class='dropbtn' and contains(text(), 'Tests')]");
    //    private By webElemntloca = By.xpath("//a[@href='/Home/WebElements']");
    private By webElemntloca = By.linkText("Web_Elements");
    private By text1 = By.id("Text1");

    private By button1 = By.id("Button1");

    private By chooseFile1 = By.id("File1");

    private By checkBox1 = By.id("Checkbox1");
    private By radio1 = By.id("Radio1");

    private By parentName = By.xpath("//*[@name='Name']");
    private By parentEmail = By.xpath("//*[@name='EMail']");
    private By parentPhone = By.xpath("//*[@name='Telephone']");
    private By genderLoca(String gender) {
        return By.xpath("//*[@name='Gender' and @value ='"+gender+"']");
    }
    private By ageLocator = By.name("age");
    private By serviceLocator = By.name("Service");
    private By sendButton = By.name("Submit");
    private By resetButton = By.name("Reset");
    public By disable15sButton = By.id("Wait45");
    public By footerLocator = By.tagName("footer");

    // Constructor
    public WebElementPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getTitleText() {
        return driver.findElement(tiltemessa).getText();
    }

    public void clickOnTestsButton() {
        driver.findElement(testButon).click();
    }
    public void clickOnWebElement() {
        driver.findElement(webElemntloca).click();
    }
    public  void inputText1 (String text) {
        driver.findElement(text1).sendKeys(text);
    }
    public Boolean statusButton1() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(button1));
        return driver.findElement(button1).isEnabled();
    }
    public void clickOnButton1() {
        driver.findElement(button1).click();
    }
    public  void chooseFile1(String path) {
        driver.findElement(chooseFile1).sendKeys(path);
    }
    public void clickOnCheckBox1() {
        driver.findElement(checkBox1).click();
    }
    public Boolean statusCheckBox() {
        return driver.findElement(checkBox1).isSelected();
    }
    public void clickOnRadio1(){
        driver.findElement(radio1).click();
    }
    public void inputParentName(String name) {
        driver.findElement(parentName).sendKeys(name);
    }
    public void inputParentEmail(String email) {
        driver.findElement(parentEmail).sendKeys(email);
    }
    public void inputParentPhone(String phone) {
        driver.findElement(parentPhone).sendKeys(phone);
    }
    public void selectGender(String gender) {
        // Tìm phần tử cần cuộn đến
        WebElement element = driver.findElement(footerLocator);
        // Cuộn trang đến phần tử
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        // wait element vísible
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(genderLoca(gender)));
        driver.findElement(genderLoca(gender)).click();
    }
    public void selectAge(String age) {
        WebElement ageDropdown = driver.findElement(ageLocator);

        Select select = new Select(ageDropdown);
        select.selectByVisibleText(age);
    }
    public void selectService(String service) {
        WebElement serviceDropdown = driver.findElement(serviceLocator);

        Select select = new Select(serviceDropdown);
        select.selectByVisibleText(service);
    }
    public void submitRegistration() {
        // wait element vísible
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(sendButton));
        driver.findElement(sendButton).click();
    }
    public void resetRegistration() {
        // Tìm phần tử cần cuộn đến, cuộn phàn từ sau nó
        WebElement element = driver.findElement(footerLocator);
        // Cuộn trang đến phần tử
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        // wait element vísible
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(resetButton));
        driver.findElement(resetButton).click();
    }
    public void clickOnDisable15sButton() {
        // Tìm phần tử cần cuộn đến, cuộn phàn từ sau nó
        WebElement element = driver.findElement(footerLocator);
        // Cuộn trang đến phần tử
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        // wait element vísible
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(disable15sButton));

        driver.findElement(disable15sButton).click();

    }
    public void checkElementWait15s() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(disable15sButton));
        // Chờ đợi phần tử trở lại được kích hoạt trong vòng 15 giây
        wait.until(ExpectedConditions.elementToBeClickable(disable15sButton));


    }
}

