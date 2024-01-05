package utills.Listeners;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import runner.BaseTest;

import java.io.File;
import java.io.IOException;

public class TestListener extends BaseTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        System.out.println("****************************************************************");
        System.out.println("---Test Execution Started for Test Case: "+result.getMethod().getMethodName()+"---");
        System.out.println("****************************************************************");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        System.out.println("Test Execution Status for Test Case: "+result.getMethod().getMethodName() +": PASSED");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        System.out.println("Test Execution Status for Test Case: "+result.getMethod().getMethodName() +": SKIPPED");
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        System.out.println("****************************************************************");
        System.out.println("------------------------Test Execution Starts-------------------");
        System.out.println("****************************************************************");
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        System.out.println("****************************************************************");
        System.out.println("------------------------Test Execution Ends---------------------");
        System.out.println("****************************************************************");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        System.out.println("Test Case Failed");
        takesScreenShot(result.getName());
    }

    @Attachment(value = "Page Screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }
}
