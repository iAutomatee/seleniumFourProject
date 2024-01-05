package tests.elements;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObjects.elements.CheckBoxPage;
import runner.BaseTest;

import java.io.IOException;

public class CheckBoxTest extends BaseTest {

    public WebDriver driver;
    public CheckBoxPage checkBoxPage;

//    public CheckBoxTest() throws IOException {
//        this.driver = getDriver();
//        checkBoxPage = new CheckBoxPage(driver);
//    }

    @Test
    public void verifySelectAllFunctionality() {
        checkBoxPage.clickOnCheckBox();
        checkBoxPage.selectAll();
    }
}
