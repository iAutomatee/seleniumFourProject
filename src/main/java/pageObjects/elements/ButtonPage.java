package pageObjects.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ButtonPage {
    public WebDriver driver;
    By elementCard = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]");
    By button = By.id("item-4");
    By doubleClickBtn = By.xpath(".//button[text()='Double Click Me']");
    By rightClickBtn = By.xpath(".//button[text()='Right Click Me']");
    By clickMeBtn = By.xpath(".//button[text()='Click Me']");

    By doubleClickMsg = By.xpath("//p[@id='doubleClickMessage']");
    By rightClickMsg = By.xpath("//p[@id='rightClickMessage']");
    By clickMeMsg = By.xpath("//p[@id='dynamicClickMessage']");

    public ButtonPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickOnButton() {
        clickOnElementCard();
        driver.findElement(button).click();
    }


    public void clickOnElementCard() {
        Actions act = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        WebElement element = driver.findElement(elementCard);
        act.moveToElement(element);
        element.click();
    }

    public void clickOnDoubleClickMeButton() {
        Actions act = new Actions(driver);
        act.doubleClick(driver.findElement(doubleClickBtn)).perform();
    }

    public void clickOnRightClickMeButton() {
        Actions act = new Actions(driver);
        act.contextClick(driver.findElement(rightClickBtn)).perform();
    }

    public void clickOnClickMeButton() {
        driver.findElement(clickMeBtn).click();
    }


    public boolean verifyDoubleClick() {
        clickOnDoubleClickMeButton();
        String s = driver.findElement(doubleClickMsg).getText();
        String exp = "You have done a double click";
        return s.equalsIgnoreCase(exp);
    }

    public boolean verifyRightClick() {
        clickOnRightClickMeButton();
        String s = driver.findElement(rightClickMsg).getText();
        String exp = "You have done a right click";
        return s.equalsIgnoreCase(exp);
    }

    public boolean verifyClickMe() {
        clickOnClickMeButton();
        String s = driver.findElement(clickMeMsg).getText();
        String exp = "You have done a dynamic click";
        return s.equalsIgnoreCase(exp);
    }
}
