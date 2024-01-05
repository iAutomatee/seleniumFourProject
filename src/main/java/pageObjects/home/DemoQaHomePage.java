package pageObjects.home;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pageObjects.elements.ElementPage;
import pageObjects.windoeWidgets.WidgetsPage;

public class DemoQaHomePage {
    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]")
    WebElement elementCard;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]")
    WebElement formCard;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]")
    WebElement alertFrame;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]")
    WebElement windowWidgetsBtn;


    public DemoQaHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Click on Element Card")
    public ElementPage clickOnElementCard() {
        Actions act = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        WebElement element = elementCard;
        act.moveToElement(element);
        element.click();
       return new ElementPage(driver);
    }

    @Step("click On Window Widgets Btn")
    public WidgetsPage clickOnWindowWidgetsBtn() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        windowWidgetsBtn.click();
        return new WidgetsPage(driver);
    }


}
