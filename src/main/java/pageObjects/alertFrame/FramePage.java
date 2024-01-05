package pageObjects.alertFrame;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class FramePage {

    public WebDriver driver;
    By alertFrame = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]");
    By framesBtn = By.xpath("//span[contains(text(),'Frames')]");
    By framesOne = By.xpath("//iframe[@id='frame1']");
    By framesTwo = By.xpath("//iframe[@id='frame2']");
    By frame = By.tagName("iframe");
    By framesText = By.xpath("//h1[@id='sampleHeading']");


    public FramePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnFrames() {
        clickOnAlertFrame();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        driver.findElement(framesBtn).click();
    }

    public void clickOnAlertFrame() {
        driver.findElement(alertFrame).click();
    }

//    public void clickOnFrameOne() {
//        driver.findElement(alertFrame).click();
//    }
//
//    public void clickOnFrameTwo() {
//        driver.findElement(timerAlertButton).click();
//    }


    public int getIframeCount() {
        List<WebElement> frames = driver.findElements(frame);
        System.out.println(frames.size());
        return frames.size();
    }

    public String getFrameOneText(By frame) {
        driver.switchTo().frame(driver.findElement(frame));
        return driver.findElement(framesText).getText();
    }

    public boolean verifyFrameTextOne() {
        System.out.println("iFrame Count:" + getIframeCount());
        String s = getFrameOneText(framesOne);
        System.out.println(s);
        return s.equalsIgnoreCase("This is a sample page");

    }

    public boolean verifyFrameTextTwo() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        String s = getFrameOneText(framesTwo);
        return s.equalsIgnoreCase("This is a sample page");
    }

}
