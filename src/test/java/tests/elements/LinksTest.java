package tests.elements;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.elements.LinksPage;
import runner.BaseTest;

import java.io.IOException;

public class LinksTest extends BaseTest {

    public WebDriver driver;
    public LinksPage linksPage;
//
//    public LinksTest() throws IOException {
//        this.driver = getDriver();
//        linksPage = new LinksPage(driver);
//    }

    @Test
    public void verifySelectAllFunctionality() {
       Assert.assertTrue(linksPage.verifyNewTabNavigationUrl());
    }
}
