package pageObjects.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class UploadAndDownloadPage {
    public WebDriver driver;
    By elementCard = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]");
    By uploadAndDownload = By.id("item-7");
    By downloadBtn = By.id("downloadButton");
    By uploadBtn = By.id("uploadFile");
    By uploadedFilePath = By.xpath("//p[@id='uploadedFilePath']");

    public UploadAndDownloadPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickOnUploadAndDownload() {
        clickOnElementCard();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)", "");
        driver.findElement(uploadAndDownload).click();
    }

    public void clickOnElementCard() {
        Actions act = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        WebElement element = driver.findElement(elementCard);
        act.moveToElement(element);
        element.click();
    }

    public void uploadAFile(){
        driver.findElement(uploadBtn).sendKeys("/Users/vinayrana/Downloads/sampleFile.jpeg");
    }


}
