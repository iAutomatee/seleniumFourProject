package tests.alertFrames;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.alertFrame.AlertPage;
import pageObjects.alertFrame.WindowsHandlePage;
import runner.BaseTest;

import java.io.IOException;

public class AlertTest extends BaseTest {
    public WebDriver driver;
    AlertPage alertPage;


    @BeforeMethod
    public void routeToAlerts(){

    }

//    public AlertTest() throws IOException {
//        this.driver = getDriver();
//        alertPage = new AlertPage(driver);
//    }

    @Test(enabled = false)
    public void verifyAlert() {
        alertPage.clickAlerts();
        Assert.assertTrue(alertPage.verifyAlert());
    }

    @Test(enabled = false)
    public void verifyTimerAlert() {
        alertPage.clickAlerts();
        Assert.assertTrue(alertPage.verifyTimerAlert());
    }

    @Test(enabled = false)
    public void verifyTextBoxAlert() {
        alertPage.clickAlerts();
        Assert.assertTrue(alertPage.verifyTextBoxAlert());
    }

    @Test(enabled = true)
    public void verifyConfirmAlert() {
        alertPage.clickAlerts();
        Assert.assertTrue(alertPage.verifyConfirmAlert());
    }

}
