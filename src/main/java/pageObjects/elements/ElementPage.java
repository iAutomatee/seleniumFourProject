package pageObjects.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ElementPage {

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]")
    WebElement elementCard;

    @FindBy(xpath = "//*[@id=\"item-1\"]/span")
    WebElement elementCard1;

    @FindBy(xpath = "//*[@id=\"item-2\"]/span")
    WebElement elementCard2;

    @FindBy(xpath = "//*[@id=\"item-3\"]/span")
    WebElement elementCard3;

    @FindBy(xpath = "//*[@id=\"item-4\"]/span")
    WebElement elementCard4;

    @FindBy(xpath = "//*[@id=\"item-5\"]/span")
    WebElement elementCard5;

    @FindBy(xpath = "//*[@id=\"item-0\"]/span")
    WebElement textBox;

    @FindBy(xpath = "//*[@id=\\\"item-1\\\"]/span")
    WebElement checkBox;

    @FindBy(xpath = "//span[contains(text(),'Radio Button')]")
    WebElement radioButton;

    @FindBy(id = "item-4")
    WebElement button;

    @FindBy(id = "item-5")
    WebElement links;

    @FindBy(id = "item-5")
    WebElement brokenLinkAndImage;

    @FindBy(id = "item-8")
    WebElement dynamicLink;

    @FindBy(id = "item-7")
    WebElement uploadAndDownload;

    By linksBroken = By.tagName("a");

    public ElementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Click on Text Box")
    public TextBoxPage clickOnTextBox() {
        textBox.click();
        return new TextBoxPage(driver);
    }

    public CheckBoxPage clickOnCheckBox() {
        checkBox.click();
        return new CheckBoxPage(driver);
    }

    @Step("Click on radio button")
    public RadioButtonPage clickOnRadioButton() {
        radioButton.click();
        return new RadioButtonPage(driver);
    }

    public ButtonPage clickOnButton() {
        button.click();
        return new ButtonPage(driver);
    }

    public BrokenLinksAndImagesPage clickOnBrokenLinks() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)", "");
        brokenLinkAndImage.click();
        return new BrokenLinksAndImagesPage(driver);
    }

    public UploadAndDownloadPage clickOnUploadAndDownload() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)", "");
        uploadAndDownload.click();
        return new UploadAndDownloadPage(driver);
    }

    public DynamicPage clickOnDynamicLinks() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)", "");
        dynamicLink.click();
        return new DynamicPage(driver);
    }

    public void getDriverValue() {
        System.out.println("Login DRIVER: " + driver);
    }

//    public void clickOnElementCard() {
//        Actions act = new Actions(driver);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,350)", "");
//        WebElement element = elementCard;
//        act.moveToElement(element);
//        element.click();
//    }

    @Step("Verify if Elements Present On Elements Page")
    public boolean isElementsPresentOnElementsPage() {
        boolean isPresent = false;
        String checkBox = elementCard1.getText();
        String radioButton = elementCard2.getText();
        String webTables = elementCard3.getText();
        String buttons = elementCard4.getText();
        String links = elementCard5.getText();
        if (elementCard1.isDisplayed()) {
            isPresent = true;
        }
        if (elementCard2.isDisplayed()) {
            isPresent = true;
        }
        if (elementCard3.isDisplayed()) {
            isPresent = true;
        }
        if (elementCard4.isDisplayed()) {
            isPresent = true;
        }
        if (elementCard5.isDisplayed()) {
            isPresent = true;
        }
        return isPresent;
    }


    public int getLinkCount() {
        List<WebElement> link = driver.findElements(linksBroken);
        int count = link.size();
        System.out.println("count:" + count);
        return count;
    }


    public List<String> getLinks() {
        List<WebElement> link = driver.findElements(linksBroken);
        List<String> linkUrl = new ArrayList<>();
        for (WebElement e : link) {
            linkUrl.add(e.getAttribute("href"));
        }
        return linkUrl;
    }

    public boolean verifyLinks(String url1) throws IOException {
        boolean isBroken = false;
        URL url = new URL(url1);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.connect();
        int statusCode = con.getResponseCode();
        System.out.println("Status Code: " + statusCode);
        if (statusCode >= 400) {
            isBroken = true;
        }
        return isBroken;
    }

    public void verifyBrokenLink() {
        boolean isLinkBroken = false;

    }
}
