package tests.elements;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObjects.elements.UploadAndDownloadPage;
import runner.BaseTest;

import java.io.IOException;

public class UploadAndDownloadTest extends BaseTest {

    public WebDriver driver;
    public UploadAndDownloadPage uploadAndDownloadPage;

//    public UploadAndDownloadTest() throws IOException {
//        this.driver = getDriver();
//        uploadAndDownloadPage = new UploadAndDownloadPage(driver);
//    }

    @Test
    public void verifyUploadDownload() throws IOException {
        uploadAndDownloadPage.clickOnUploadAndDownload();
        uploadAndDownloadPage.uploadAFile();
    }
}
