package tests.elements;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.elements.ElementPage;
import pageObjects.home.DemoQaHomePage;
import runner.BaseTest;
import utills.Listeners.TestListener;

import java.io.IOException;

@Listeners({TestListener.class})
public class ElementTest extends BaseTest {

    public WebDriver driver;
    ElementPage elementPage;


    @Test(description = "UI Elements on Page Test", groups = {"Elements", "demo"})
    @Description("Test Description: UI Elements on Page Test")
    @Story("EPIC-123")
    public void verifyElementPage() {
        elementPage = demoQaHomePage.clickOnElementCard();
        Assert.assertTrue(elementPage.isElementsPresentOnElementsPage());
    }

    @Test(description = "verify Links", groups = {"Elements", "demo"})
    @Description("Test Description: Verify Links")
    @Story("EPIC-1243")
    public void verifyLinks() throws IOException {
        elementPage = demoQaHomePage.clickOnElementCard();
        Assert.assertFalse(elementPage.verifyLinks("https://demoqa.com"));
    }
}
