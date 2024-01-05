package pageObjects.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LinksPage {
    public WebDriver driver;
    By elementCard = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]");
    By links =By.id("item-5");
    By simpleLink = By.id("simpleLink");
    By dynamicLink = By.id("dynamicLink");
    By created = By.id("created");
    By noContent = By.id("no-content");
    By moved = By.id("moved");
    By badRequest = By.id("bad-request");
    By unauthorized = By.id("unauthorized");
    By forbidden = By.id("forbidden");
    By invalidUrl = By.id("invalid-url");


    public LinksPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickOnLinks() {
        clickOnElementCard();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)", "");
        driver.findElement(links).click();
    }

    public void clickOnElementCard() {
        Actions act = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        WebElement element = driver.findElement(elementCard);
        act.moveToElement(element);
        element.click();
    }

    public void clickOnHome() {
        clickOnLinks();
        driver.findElement(simpleLink).click();
    }

    public void clickOnHomeNOnRs() {
        driver.findElement(dynamicLink).click();
    }

    public void clickOnCreated() {
        driver.findElement(created).click();
    }

    public void clickOnNoContent() {
        driver.findElement(noContent).click();
    }

    public void clickOnMoved() {
        driver.findElement(moved).click();
    }


    public void clickOnBadRequest() {
        driver.findElement(badRequest).click();
    }

    public void clickOnUnauthorized() {
        driver.findElement(unauthorized).click();
    }

    public void clickOnForbidden() {
        driver.findElement(forbidden).click();
    }

    public void clickOnNotFound() {
        driver.findElement(invalidUrl).click();
    }


    public boolean verifyNewTabNavigationUrl() {
        boolean matched = false;
        String originalTab = driver.getWindowHandle();
        clickOnHome();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

        tabs.remove(originalTab);
        driver.switchTo().window(tabs.get(0));
        if (driver.getCurrentUrl().equalsIgnoreCase("https://demoqa.com/")) {
            matched = true;
        }
        driver.close();
        driver.switchTo().window(originalTab);
        return matched;
    }

}
