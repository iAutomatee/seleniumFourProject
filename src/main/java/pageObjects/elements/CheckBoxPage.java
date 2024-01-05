package pageObjects.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckBoxPage {
    public WebDriver driver;
    By elementCard = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]");
    By checkBox = By.xpath("//*[@id=\"item-1\"]/span");
    By expandAll = By.xpath("//button[@title='Toggle']");
    By selectAll = By.xpath("//span[@class='rct-checkbox']");
    By desktopText = By.xpath("//span[contains(text(),'Desktop')]");
    By checkBoxList = By.xpath("//ol/li//span[@class='rct-title']");


    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickOnCheckBox() {
        clickOnElementCard();
        driver.findElement(checkBox).click();
    }

    public void clickOnExpand() {
        driver.findElement(expandAll).click();
    }

    public void clickOnElementCard() {
        Actions act = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        WebElement element = driver.findElement(elementCard);
        act.moveToElement(element);
        element.click();
    }

    public void selectAll() {
        clickOnExpand();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(desktopText));
        List<WebElement> checkBoxLists = driver.findElements(checkBoxList);
        System.out.println("Checkbox List:");
        for (WebElement s : checkBoxLists) {
            System.out.println(s.getText());
        }
        driver.findElement(selectAll).click();
    }

//    public boolean isCheckBoxSelected(){
//       boolean isSelected= false;
//
//        return isSelected;
//    }

}
