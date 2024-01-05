package pageObjects.form;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FormFillPage {
    public WebDriver driver;
    By praticeForm = By.xpath("//span[contains(text(),'Practice Form')]");
    By formCard = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]");
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By userEmail = By.id("userEmail");
    By userNumber = By.id("userNumber");
    By gender = By.xpath("//label[contains(text(),'Male')]");
    By dateOfBirthInput = By.id("dateOfBirthInput");
    By hobbiesSport = By.xpath("//label[contains(text(),'Sports')]");
    By hobbiesMusic = By.xpath("//label[contains(text(),'Music')]");
    By uploadPicture = By.id("uploadPicture");
    By currentAddress = By.id("currentAddress");
    By state = By.xpath("//div[contains(text(),'Select State')]");
    By city = By.xpath("//div[contains(text(),'Select City')]");
    By submitBtn = By.id("submit");

    public FormFillPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnFormCard() {
//        Actions act = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        WebElement form = driver.findElement(formCard);
//        act.moveToElement(formCard);
        form.click();
    }

    public void fillForm() {
        driver.findElement(praticeForm).click();
        driver.findElement(firstName).sendKeys("ABC");
        driver.findElement(lastName).sendKeys("DEFG");
        driver.findElement(userEmail).sendKeys("ABC@ABC.com");
        driver.findElement(userNumber).sendKeys("9999999999");
        //driver.findElement(dateOfBirthInput).sendKeys("20 May 2023");
        driver.findElement(gender).click();
        driver.findElement(hobbiesSport).click();
        driver.findElement(hobbiesMusic).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)", "");
        driver.findElement(uploadPicture).sendKeys("/Users/vinayrana/Downloads/sampleFile.jpeg");
        driver.findElement(currentAddress).sendKeys("Abc Def XYZ");
        js.executeScript("window.scrollBy(0,600)", "");
        driver.findElement(state).click();
        driver.findElement(By.xpath("//div[contains(text(),'NCR')]")).click();
        driver.findElement(city).click();
        js.executeScript("window.scrollBy(0,600)", "");
        driver.findElement(By.xpath("//div[contains(text(),'Delhi')]")).click();
        driver.findElement(submitBtn).click();
    }
}
