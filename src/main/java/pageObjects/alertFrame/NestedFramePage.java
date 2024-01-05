package pageObjects.alertFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NestedFramePage {

    public WebDriver driver;
    By alertFrame = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]");
    By nestedFramesBtn = By.xpath("//span[contains(text(),'Nested Frames')]");
    By framesOne = By.xpath("//iframe[@id='frame1']");
    By frame = By.tagName("iframe");
    By childFrameText = By.xpath("/html/body/p");
    By parentFrameText = By.xpath("/html/body/text()");


    public NestedFramePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnNestedFrames() {
        clickOnAlertFrame();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        driver.findElement(nestedFramesBtn).click();
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

    public String getChildFrameText(By frame) {
        driver.switchTo().frame(driver.findElement(frame));
        driver.switchTo().frame(0);
        return driver.findElement(childFrameText).getText();
    }


    public boolean verifyChildFrameText() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        String s = getChildFrameText(framesOne);
        System.out.println(s);
        return s.equalsIgnoreCase("Child Iframe");
    }

}
