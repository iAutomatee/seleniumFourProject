package tests.forms;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObjects.form.FormFillPage;
import runner.BaseTest;

import java.io.IOException;

public class FormFillTest extends BaseTest {
    public WebDriver driver;
    FormFillPage formFillPage;
//    public FormFillTest() throws IOException {
//        this.driver=getDriver();
//         formFillPage= new FormFillPage(driver);
//    }

    @Test
    public void fillCompleteForm(){
        formFillPage.clickOnFormCard();
        formFillPage.fillForm();
    }


}
