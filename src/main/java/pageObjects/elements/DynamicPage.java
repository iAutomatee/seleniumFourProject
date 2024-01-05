package pageObjects.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class DynamicPage {
    public WebDriver driver;
    By elementCard = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]");
    By dynamicLink = By.id("item-8");
    By enableAfter = By.id("enableAfter");
    By visibleAfter = By.id("visibleAfter");

    public DynamicPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickOnDynamicLinks() {
        clickOnElementCard();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)", "");
        driver.findElement(dynamicLink).click();
    }

    public void clickOnElementCard() {
        Actions act = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        WebElement element = driver.findElement(elementCard);
        act.moveToElement(element);
        element.click();
    }

    public void isClickable() throws InterruptedException {
        WebElement enableAfterBtn = driver.findElement(enableAfter);
        boolean enabled = enableAfterBtn.isEnabled();
        System.out.println("Is enabled Before: " + enabled);
        try {
            WebElement visibleAfterBtn = driver.findElement(visibleAfter);
            boolean visible = visibleAfterBtn.isDisplayed();
            System.out.println("Is Visible Before: " + visible);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        Thread.sleep(5000);
        boolean enabled1 = enableAfterBtn.isEnabled();
        System.out.println("Is enabled After: " + enabled1);
    }

    public void isVisible() throws InterruptedException {
        WebElement visibleAfterBtn = driver.findElement(visibleAfter);
//        boolean visible = visibleAfterBtn.isDisplayed();
//        System.out.println("Is Visible Before: " + visible);
//        Thread.sleep(5000);
        boolean visible1 = visibleAfterBtn.isDisplayed();
        System.out.println("Is Visible After: " + visible1);
    }

}
