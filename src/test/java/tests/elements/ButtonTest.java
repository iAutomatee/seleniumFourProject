package tests.elements;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.elements.ButtonPage;
import runner.BaseTest;

import java.io.IOException;

public class ButtonTest extends BaseTest {

    public WebDriver driver;
    public ButtonPage buttonPage;

//    public ButtonTest() throws IOException {
//        this.driver = getDriver();
//        buttonPage = new ButtonPage(driver);
//    }

    @Test
    public void verifyAllButtonFunctionality() {

        buttonPage.clickOnButton();
      Assert.assertTrue(buttonPage.verifyDoubleClick());
        Assert.assertTrue(buttonPage.verifyRightClick());
        Assert.assertTrue(buttonPage.verifyClickMe());
    }
}
