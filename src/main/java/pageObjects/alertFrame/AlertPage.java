package pageObjects.alertFrame;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.Soundbank;
import java.time.Duration;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class AlertPage {

    public WebDriver driver;
    By alertFrame = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]");
    By alertBtn = By.xpath("//span[contains(text(),'Alerts')]");
    By timerAlertButton = By.id("timerAlertButton");
    By alertButton = By.id("alertButton");
    By confirmButton = By.id("confirmButton");
    By promptButton = By.id("promtButton");
    By confirmResult = By.id("confirmResult");
    By promptResult = By.id("promptResult");


    public AlertPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAlerts() {
        clickOnAlertFrame();
        driver.findElement(alertBtn).click();
    }

    public void clickOnAlertFrame() {
        driver.findElement(alertFrame).click();
    }

    public void clickOnTimerAlertButton() {
        driver.findElement(timerAlertButton).click();
    }

    public void clickOnAlertButton() {
        driver.findElement(alertButton).click();
    }

    public void clickOnConfirmButton() {
        driver.findElement(confirmButton).click();
    }

    public void clickOnPromptButton() {
        driver.findElement(promptButton).click();
    }


    public boolean verifyAlert() {
        clickOnAlertButton();
        Alert alt = driver.switchTo().alert();
        String alertText = alt.getText();
        System.out.println();
        alt.accept();
        return alertText.equalsIgnoreCase("You clicked a button");
    }


    public boolean verifyTimerAlert() {
        clickOnTimerAlertButton();
        boolean res = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alt = driver.switchTo().alert();
            String alertText = alt.getText();
            System.out.println();
            alt.accept();
            res = alertText.equalsIgnoreCase("This alert appeared after 5 seconds");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return res;
        }
        return res;
    }

    public boolean verifyConfirmAlert() {
        clickOnConfirmButton();
        boolean res = false;
        String cancelText = "You selected Cancel";
        String okText = "You selected OK";
        Alert alt = driver.switchTo().alert();
        System.out.println(alt.getText());
        alt.accept();
        WebElement text = driver.findElement(confirmResult);
        System.out.println("Confirmation Text: "+text.getText());
        res = text.getText().equalsIgnoreCase(okText);
        clickOnConfirmButton();
        alt.dismiss();
        System.out.println("Confirmation Text: "+text.getText());
        res = text.getText().equalsIgnoreCase(cancelText);
        return res;
    }

    public boolean verifyTextBoxAlert() {
        clickOnPromptButton();
        boolean res = false;
        Alert alt = driver.switchTo().alert();
        String enteredText = "This is prompt text";
        alt.sendKeys(enteredText);
        System.out.println(alt.getText());
        alt.accept();
        WebElement text = driver.findElement(promptResult);
        String resultString = "You entered " + enteredText;
        res = text.getText().equalsIgnoreCase(resultString);
        return res;
    }
}
