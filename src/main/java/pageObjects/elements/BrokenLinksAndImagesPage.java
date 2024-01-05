package pageObjects.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BrokenLinksAndImagesPage {
    public WebDriver driver;
    By elementCard = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]");
    By brokenLinkAndImage = By.id("item-6");
    By validLink = By.xpath("//a[contains(text(),'Click Here for Valid Link')]");
    By brokenLink = By.xpath("//a[contains(text(),'Click Here for Broken Link')]");

    public BrokenLinksAndImagesPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickOnBrokenLinks() {
        clickOnElementCard();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)", "");
        driver.findElement(brokenLinkAndImage).click();
    }

    public void clickOnElementCard() {
        Actions act = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        WebElement element = driver.findElement(elementCard);
        act.moveToElement(element);
        element.click();
    }

    public String getValidLinkUrl() {
        WebElement validLinks = driver.findElement(validLink);
        return validLinks.getAttribute("href");
    }

    public String getBrokenLinkUrl() {
        WebElement invalidLinks = driver.findElement(brokenLink);
        return invalidLinks.getAttribute("href");
    }

    public int getHttpStatus(String link) throws IOException {
        URL url = new URL(link);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.connect();
        int status = con.getResponseCode();
        System.out.println("Status Code: " + status);
        return status;
    }

    public boolean isValidLinkBroken() throws IOException {
        boolean isValidLink = false;
        if (getHttpStatus(getValidLinkUrl()) > 200 && getHttpStatus(getValidLinkUrl()) < 400) {
            isValidLink = true;
        }
        return isValidLink;
    }
    public boolean isValidLinkOrBroken() throws IOException {
        boolean isLinkValid = false;
        if (getHttpStatus(getBrokenLinkUrl()) > 200 && getHttpStatus(getBrokenLinkUrl()) < 400) {
            isLinkValid = true;
        }
        return isLinkValid;
    }


}
