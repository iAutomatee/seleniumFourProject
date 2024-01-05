package tests.widgets;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.windoeWidgets.WidgetsPage;
import runner.BaseTest;

import java.io.IOException;

public class WidgetsTest extends BaseTest {
    public WebDriver driver;
    WidgetsPage widgetsPage;



//    public WidgetsTest() throws IOException {
//        System.out.println("Test Constructor Called");
//        this.driver = getDriver();
//
//    }

    @Test(description = "Slider Test",groups = {"Widgets","demo"})
    @Description("Test Description: Slider Test")
    public void verifySlider() {
        widgetsPage=demoQaHomePage.clickOnWindowWidgetsBtn();
        widgetsPage.verifySlider();

    }

    @Test(description = "Progress Bar Test",groups = {"Widgets","demo"})
    @Description("Test Description: Progress Bar Test")
    public void verifyProgressBar() throws InterruptedException {
        widgetsPage=demoQaHomePage.clickOnWindowWidgetsBtn();
        widgetsPage.verifyProgressBar();
    }

    @Test(description = "Tool Tip Test",groups = {"Widgets","demo"})
    @Description("Test Description: Tool Tip Test")
    public void verifyToolTips() throws InterruptedException {
        widgetsPage=demoQaHomePage.clickOnWindowWidgetsBtn();
        Assert.assertTrue(widgetsPage.verifyToolTip());

    }

    @Test(description = " Menus Test",groups = {"Widgets","demo"})
    @Description("Test Description: Menus Test")
    public void verifyMenus() throws InterruptedException {
        widgetsPage=demoQaHomePage.clickOnWindowWidgetsBtn();
        Assert.assertTrue(widgetsPage.verifyMenu());
    }

    @Test(description = "DropDown Test",groups = {"Widgets","demo"})
    @Description("Test Description: DropDown Test")
    public void verifyDropdowns() throws InterruptedException {
        widgetsPage=demoQaHomePage.clickOnWindowWidgetsBtn();
        widgetsPage.selectValue();
    }
}
