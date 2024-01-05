package tests.alertFrames;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.alertFrame.FramePage;
import pageObjects.alertFrame.NestedFramePage;
import runner.BaseTest;

import java.io.IOException;

public class NestedFrameTest extends BaseTest {
    public WebDriver driver;
    NestedFramePage nestedFramePage;


    @BeforeMethod
    public void routeToAlerts(){

    }

//    public NestedFrameTest() throws IOException {
//        this.driver = getDriver();
//        nestedFramePage = new NestedFramePage(driver);
//    }


    @Test(enabled = true)
    public void verifyFrameTwoText() {
        nestedFramePage.clickOnNestedFrames();
        Assert.assertTrue(nestedFramePage.verifyChildFrameText());
    }
}
