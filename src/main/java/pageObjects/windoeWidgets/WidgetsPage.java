package pageObjects.windoeWidgets;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.security.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class WidgetsPage {

    public WebDriver driver;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]")
    WebElement windowWidgetsBtn;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/span[1]")
    WebElement slideBar;

    @FindBy(xpath = "//span[contains(text(),'Slider')]")
    WebElement sliderBtn;

    @FindBy(xpath = "//button[@id='startStopButton']")
    WebElement startBtn;

    @FindBy(xpath = "//button[@id='resetButton']")
    WebElement resetBtn;

    @FindBy(xpath = "//span[contains(text(),'Progress Bar')]")
    WebElement progressBarBtn;

    @FindBy(xpath = "//*[contains(text(),'Tool Tips')]")
    WebElement ToolTipBtn;

    @FindBy(xpath = "//button[@id='toolTipButton']")
    WebElement hoverMeBtn;

    @FindBy(xpath = "//div[@class='tooltip-inner']")
    WebElement toolTips;

    @FindBy(xpath = "//div[contains(text(),'100%')]")
    WebElement progressBar;

    @FindBy(xpath = "//input[@id='toolTipTextField']")
    WebElement hoverMeTextBox;

    By progressBarr = By.xpath("//div[contains(text(),'100%')]");


    By menuBtn = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[8]/span[1]");
    By menuOneBtn = By.xpath("//a[contains(text(),'Main Item 1')]");
    By menuTwoBtn = By.xpath("//a[contains(text(),'Main Item 2')]");
    By menuThreeBtn = By.xpath("//a[contains(text(),'Main Item 3')]");
    By menuTwoList = By.xpath("//a[contains(text(),'Main Item 2')]//following::ul[1]/li/a");
    By subSubList = By.xpath("//a[contains(text(),'SUB SUB LIST »')]//following::ul/li/a");


    By selectMenuBtn = By.xpath("//span[contains(text(),'Select Menu')]");
    // By selectValueDropdown = By.xpath("//div[contains(text(),'Group 1, option 1')]");
    By selectOneDropdown = By.xpath("//div[contains(text(),'Select Title')]");
    By oldStyleDropdown = By.id("oldSelectMenu");
    By multiSelectDropdown = By.xpath("//div[contains(text(),'Select...')]");
    By standardMultiSelectDropdown = By.id("cars");
    By selectValueDropdown = By.id("withOptGroup");

    public WidgetsPage(WebDriver driver) {
        System.out.println("Page Class constructor called");
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickOnSlideBar() {
        slideBar.click();
    }


    public void clickOnSlideBtn() {
        sliderBtn.click();
    }


    public void clickOnProgressBarBtn() {
        progressBarBtn.click();
    }

    public void clickOnStartBtn() {
        startBtn.click();
    }

    public void clickOnResetBtn() {
        resetBtn.click();
    }

    public void clickOnToolTipBtn() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");
        ToolTipBtn.click();
    }


    public void clickOnMenuBtn() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");
        driver.findElement(menuBtn).click();
    }

    public void clickOnSelectMenuBtn() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");
        driver.findElement(selectMenuBtn).click();
    }

    @Step("Verify Slider")
    public void verifySlider() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        clickOnSlideBtn();
        Actions act = new Actions(driver);
        WebElement slider = slideBar;
        act.moveToElement(slider).clickAndHold().moveByOffset(100, 0).perform();
    }

    @Step("Verify Progress Bar")
    public void verifyProgressBar() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        clickOnProgressBarBtn();
        clickOnStartBtn();
        // Thread.sleep(10000);
        // System.out.println("PROGRESS: " + progress.getText());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated((progressBarr)));
        //  System.out.println("PROGRESS: " + progress.getText());
        clickOnResetBtn();
    }

    @Step("Verify Tool Tip")
    public boolean verifyToolTip() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        clickOnToolTipBtn();
        Actions act = new Actions(driver);
        act.moveToElement(hoverMeBtn).perform();
        Thread.sleep(10000);
        WebElement toolTip = toolTips;
        String expectedToolTipText = "You hovered over the Button";
        // To get the tool tip text and assert
        String toolTipText = toolTip.getText();
        System.out.println("toolTipText-->" + toolTipText);
        return expectedToolTipText.equalsIgnoreCase(toolTipText);
    }

    @Step("Verify Menu")
    public boolean verifyMenu() throws InterruptedException {
        List<String> expectedMenu = new ArrayList<String>();
        List<String> actualMenu = new ArrayList<String>();
        List<String> actualOptions = new ArrayList<String>();
        expectedMenu.add("Sub Item");
        expectedMenu.add("Sub Item");
        expectedMenu.add("SUB SUB LIST »");

        List<String> expectedOptions = new ArrayList<String>();
        expectedOptions.add("Sub Sub Item 1");
        expectedOptions.add("Sub Sub Item 2");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        clickOnMenuBtn();
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(menuTwoBtn)).perform();
        Thread.sleep(5000);
        List<WebElement> options = driver.findElements(menuTwoList);
        for (WebElement s : options) {
            actualMenu.add(s.getText());
            System.out.println(s.getText());
            if (s.getText().equalsIgnoreCase("SUB SUB LIST »")) {
                Actions actions = new Actions(driver);
                actions.moveToElement(s).perform();
                List<WebElement> subOptions = driver.findElements(subSubList);
                for (WebElement s1 : subOptions) {
                    actualOptions.add(s1.getText());
                    System.out.println(s1.getText());
                }
            }
        }
        System.out.println("******");
        System.out.println(expectedMenu);
        System.out.println("******");
        System.out.println(actualMenu);
        System.out.println("******");
        System.out.println(expectedOptions);
        System.out.println("******");
        System.out.println(actualOptions);
        System.out.println("******");

        return expectedMenu.equals(actualMenu) && expectedOptions.equals(actualOptions);
    }

    @Step("Select Value")
    public void selectValue() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        clickOnSelectMenuBtn();
        js.executeScript("window.scrollBy(0,250)", "");

        List<WebElement> x = driver.findElements(selectValueDropdown);
        System.out.println(x);

//        WebElement oldStyle = driver.findElement(oldStyleDropdown);
//        Select select = new Select(oldStyle);
//        select.selectByIndex(3);
//        js.executeScript("window.scrollBy(0,350)", "");
//        WebElement multi = driver.findElement(standardMultiSelectDropdown);
//        Select select1 = new Select(multi);
//        if (select1.isMultiple()) {
//            select1.selectByIndex(2);
//            select1.selectByIndex(3);
//        }

    }
}
