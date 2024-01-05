package tests.elements;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObjects.elements.DynamicPage;
import runner.BaseTest;

import java.io.IOException;

public class DynamicTest extends BaseTest {

    public WebDriver driver;
    public DynamicPage dynamicPage;

//    public DynamicTest() throws IOException {
//        this.driver = getDriver();
//        dynamicPage = new DynamicPage(driver);
//    }

    @Test
    public void verifyDynamicElements() throws IOException, InterruptedException {
        dynamicPage.clickOnDynamicLinks();
        dynamicPage.isClickable();
        dynamicPage.isVisible();
    }
}
