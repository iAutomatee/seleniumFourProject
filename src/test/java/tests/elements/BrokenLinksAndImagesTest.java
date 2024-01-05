package tests.elements;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.elements.BrokenLinksAndImagesPage;
import runner.BaseTest;

import java.io.IOException;

public class BrokenLinksAndImagesTest extends BaseTest {

    public WebDriver driver;
    public BrokenLinksAndImagesPage brokenLinksAndImagesPage;

//    public BrokenLinksAndImagesTest() throws IOException {
//        this.driver = getDriver();
//        brokenLinksAndImagesPage = new BrokenLinksAndImagesPage(driver);
//    }

    @Test
    public void verifyLinks() throws IOException {
        brokenLinksAndImagesPage.clickOnBrokenLinks();
        Assert.assertTrue(brokenLinksAndImagesPage.isValidLinkBroken());
        Assert.assertFalse(brokenLinksAndImagesPage.isValidLinkOrBroken());
    }
}
