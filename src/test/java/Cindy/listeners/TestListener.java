package Cindy.listeners;

import Cindy.common.BaseSetup;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class TestListener implements ITestListener {

    @Override
    public void onFinish(ITestContext result) {
        System.out.println("Ket thuc auto test");
    }

    @Override
    public void onStart(ITestContext result) {
        System.out.println("Day la khoi dong auto test");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Đây là test case bị fail: " + result.getName());
        //chup man hinh khi testcase fail
        try {
            TakesScreenshot scrShot = ((TakesScreenshot) BaseSetup.getDriver());

            // Chụp ảnh và lưu vào File
            File screenshotFile = scrShot.getScreenshotAs(OutputType.FILE);

            // Sao chép file ảnh vào thư mục mong muốn
            FileUtils.copyFile(screenshotFile, new File("./screenshots/" + result.getName() + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Đây là test case bị bỏ qua: " + result.getName());

    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Đây là test case chạy thành công: " + result.getName());

    }
}