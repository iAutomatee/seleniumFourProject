package pageObjects.alertFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class WindowsHandlePage {

    public WebDriver driver;
    By alertFrame = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]");
    By newTab = By.id("tabButton");
    By windowButton = By.id("windowButton");
    By messageWindowButton = By.id("messageWindowButton");
    By browserWindows = By.xpath("//span[contains(text(),'Browser Windows')]");
    By message = By.tagName("body");

    public WindowsHandlePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickBrowserWindows() {
        clickOnAlertFrame();
        driver.findElement(browserWindows).click();
    }

    public void clickOnAlertFrame() {
        driver.findElement(alertFrame).click();
    }

    public void clickOnNewTab() {
        driver.findElement(newTab).click();
    }

    public void clickOnNewWindowButton() {
        driver.findElement(windowButton).click();
    }

    public void clickMessageWindowButton() {
        driver.findElement(messageWindowButton).click();
    }


    public boolean verifyNewTab() {
        String originalTab = driver.getWindowHandle();
        System.out.println("Original: " + originalTab);
        clickOnNewTab();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("Tabs Before Delete: " + tabs.toString());
        tabs.remove(originalTab);
        String newTab = tabs.get(0);
        driver.switchTo().window(newTab);
        System.out.println("Tabs after Delete: " + tabs.toString());
        String url = driver.getCurrentUrl();
        System.out.println("New Tab URL: " + url);
        driver.close();
        driver.switchTo().window(originalTab);
        return url.equalsIgnoreCase("https://demoqa.com/sample");
    }

    public boolean verifyNewWindow() {
        String originalTab = driver.getWindowHandle();
        System.out.println("Original: " + originalTab);
        clickOnNewWindowButton();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("Tabs Before Delete: " + tabs.toString());
        tabs.remove(originalTab);
        String newTab = tabs.get(0);
        driver.switchTo().window(newTab);
        System.out.println("Tabs after Delete: " + tabs.toString());
        String url = driver.getCurrentUrl();
        System.out.println("New Tab URL: " + url);
        driver.close();
        driver.switchTo().window(originalTab);
        return url.equalsIgnoreCase("https://demoqa.com/sample");
    }

    public void verifyNewWindowMessage() {
        String originalTab = driver.getWindowHandle();
        System.out.println("Original: " + originalTab);
        clickMessageWindowButton();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("Tabs Before Delete: " + tabs.toString());
        tabs.remove(originalTab);
        String newTab = tabs.get(0);
        driver.switchTo().window(newTab);
        System.out.println("Tabs after Delete: " + tabs.toString());
        String windowMessageText = driver.findElement(message).getText();
        System.out.println("windowMessageText: " + windowMessageText);
        driver.close();
    }


}
