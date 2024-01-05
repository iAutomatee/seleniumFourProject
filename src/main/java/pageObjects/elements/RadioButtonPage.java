package pageObjects.elements;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RadioButtonPage {
    public WebDriver driver;
    private static Logger log = Logger.getLogger(Log4j.class.getName());

    By elementCard = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]");
    By radioButton = By.xpath("//*[@id=\"item-2\"]/span");
    By yesRadioS = By.xpath("//input[@id='yesRadio']");
    By yesRadio = By.xpath("//label[@for='yesRadio']");


    By impressiveRadio = By.id("impressiveRadio");
    By noRadioS = By.id("noRadio");
    By noRadio = By.xpath("//label[@for='noRadio']");


    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on Yes radio button")
    public void clickOnYes() {
        driver.findElement(yesRadio).click();
    }

    @Step("Click on Element Card")
    public void clickOnElementCard() {
        log.info("Log4J is Working");
        Actions act = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        WebElement element = driver.findElement(elementCard);
        act.moveToElement(element);
        element.click();
    }

    @Step("Verify if Yes Radio Button Selected")
    public boolean verifyYesRadioButtonSelected() {

        return driver.findElement(yesRadioS).isSelected();

    }

    @Step("Verify if No Radio Button Selected")
    public boolean verifyNoRadioButtonSelected() {

        return driver.findElement(noRadio).isSelected();

    }

}
