package tests.alertFrames;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.alertFrame.AlertPage;
import pageObjects.alertFrame.FramePage;
import runner.BaseTest;

import java.io.IOException;

public class FrameTest extends BaseTest {
    public WebDriver driver;
    FramePage framePage;


    @BeforeMethod
    public void routeToAlerts(){

    }

//    public FrameTest() throws IOException {
//        this.driver = getDriver();
//        framePage = new FramePage(driver);
//    }

    @Test(enabled = false)
    public void verifyFrameOneText() {
        framePage.clickOnFrames();
        Assert.assertTrue(framePage.verifyFrameTextOne());
    }

    @Test(enabled = true)
    public void verifyFrameTwoText() {
        framePage.clickOnFrames();
        Assert.assertTrue(framePage.verifyFrameTextTwo());
    }
}
