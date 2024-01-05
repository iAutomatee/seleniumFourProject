package tests.alertFrames;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.alertFrame.WindowsHandlePage;
import runner.BaseTest;

import java.io.IOException;

public class WindowsHandleTest extends BaseTest {
    public WebDriver driver;
    WindowsHandlePage alertFramePage;

//    public WindowsHandleTest() throws IOException {
//        this.driver = getDriver();
//        alertFramePage = new WindowsHandlePage(driver);
//    }

    @Test(enabled = true)
    public void verifyNewTab() {
        alertFramePage.clickBrowserWindows();
        Assert.assertTrue(alertFramePage.verifyNewTab());
    }

    @Test(enabled = true)
    public void verifyNewWindow() {
        alertFramePage.clickBrowserWindows();
        Assert.assertTrue(alertFramePage.verifyNewWindow());
    }

    @Test(enabled = false)
    public void verifyNewWindowMessage() {
        alertFramePage.clickBrowserWindows();
        alertFramePage.verifyNewWindowMessage();
//        Assert.assertTrue(alertFramePage.verifyNewWindowMessage());
    }


}
