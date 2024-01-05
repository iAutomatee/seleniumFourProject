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

public class WebTablePage {
    public WebDriver driver;
    By elementCard = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]");
    By checkBox = By.xpath("//*[@id=\"item-1\"]/span");



    public WebTablePage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickOnCheckBox() {
        clickOnElementCard();
        driver.findElement(checkBox).click();
    }



    public void clickOnElementCard() {
        Actions act = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        WebElement element = driver.findElement(elementCard);
        act.moveToElement(element);
        element.click();
    }



//    public boolean isCheckBoxSelected(){
//       boolean isSelected= false;
//
//        return isSelected;
//    }

}
