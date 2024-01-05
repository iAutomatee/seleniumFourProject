package tests.elements;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.elements.ElementPage;
import pageObjects.elements.TextBoxPage;
import runner.BaseTest;

import java.io.IOException;


public class TextBoxTest extends BaseTest {
    public WebDriver driver;
    ElementPage elementPage;
    TextBoxPage textBoxPage;

    @Test(description = "TextBox Test",groups = {"Elements","demo"})
    @Description("Test Description: TextBox Test")
    public void verifySubmitFunction() {
        elementPage=demoQaHomePage.clickOnElementCard();
        textBoxPage= elementPage.clickOnTextBox();
        textBoxPage.submitForm();
        Assert.assertTrue(textBoxPage.verifyFormSubmit());
    }

}
