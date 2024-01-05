package tests.elements;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.elements.ElementPage;
import pageObjects.elements.RadioButtonPage;
import runner.BaseTest;


public class RadioButtonTest extends BaseTest {
    public WebDriver driver;
    RadioButtonPage radioButtonPage;
    ElementPage elementPage;

//    RadioButtonTest() throws IOException {
//        //super();
//        this.driver = getDriver();
//        radioButtonPage = new RadioButtonPage(driver);
//    }

//    @Test
//    public void driverTest() {
//        radioButtonPage.getDriverValue();
//    }

    @Test(description = "UI Elements on Page", groups = {"Elements", "demo"})
    @Description("Test Description: Radio Button Test")
    public void verifySubmitFunction() throws InterruptedException {
        elementPage = demoQaHomePage.clickOnElementCard();
        radioButtonPage = elementPage.clickOnRadioButton();
        radioButtonPage.clickOnYes();
        Assert.assertTrue(radioButtonPage.verifyYesRadioButtonSelected());
        Assert.assertFalse(radioButtonPage.verifyNoRadioButtonSelected());
    }


    @Test(description = "UI dataProvider test", groups = {"data"},dataProvider = "getData")
    @Description("Test Description: UI data Provider Test")
    public void verifyDataProvider(String userName, String password) {
        System.out.println("UserName: "+userName);
        System.out.println("Password: "+password);
    }

    @Test(description = "UI Elements on Page", groups = {"Elements", "demo"})
    @Description("Test Description: Radio Button Test")
    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[3][2];
        data[0][0] = "Username1";
        data[0][1] = "Password1";
        data[1][0] = "Username2";
        data[1][1] = "Password2";
        data[2][0] = "Username3";
        data[2][1] = "Password3";
        return data;
    }
}
