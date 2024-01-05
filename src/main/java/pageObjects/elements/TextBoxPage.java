package pageObjects.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TextBoxPage {
    public WebDriver driver;


    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
    }


    By userName = By.id("userName");
    By userEmail = By.id("userEmail");
    By currentAddress = By.id("currentAddress");
    By permanentAddress = By.id("permanentAddress");
    By submit = By.id("submit");
    By result = By.id("output");
    By elementCard = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[1]");



    public void getDriverValue() {
        System.out.println("Home DRIVER: " + driver);
    }

    @Step("Submit Form")
    public void submitForm() {
        driver.findElement(userName).sendKeys("My Name");
        driver.findElement(userEmail).sendKeys("myemail@gmail.com");
        driver.findElement(currentAddress).sendKeys("MY address");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,150)", "");
        driver.findElement(permanentAddress).sendKeys("MY OLD address");
        driver.findElement(submit).click();
    }

    @Step("Verify Form Submit")
    public boolean verifyFormSubmit() {
        submitForm();
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)","");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(result));
        return driver.findElement(result).isDisplayed();
    }



    public void clickOnElementCard() {
        Actions act = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        WebElement element = driver.findElement(elementCard);
        act.moveToElement(element);
        element.click();
    }

}
