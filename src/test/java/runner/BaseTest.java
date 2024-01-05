package runner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pageObjects.elements.ElementPage;
import pageObjects.home.DemoQaHomePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;


public class BaseTest {

    private static WebDriver driver;
    protected DemoQaHomePage demoQaHomePage;

    public WebDriver initializeDriver() {
        System.out.println("initializeDriver......");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        System.out.println("Set Driver: " + driver);
        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }


    /*Method is to get BASE URL from Property file*/
//    @BeforeMethod(alwaysRun=true)
//    public DemoQaHomePage launchWebApplication() throws IOException
//    {
//        driver = initializeDriver();
//        driver.get(getDataFromProperty("BASE_URL"));
//        demoQaHomePage = new DemoQaHomePage(driver);
//        return demoQaHomePage;
//    }

    /*Method is to get BASE URL from parameters*/
    @Parameters("URL")
    @BeforeMethod(alwaysRun = true)
    public DemoQaHomePage launchWebApplication(@Optional("https://demoqa.com/") String url) throws IOException {
        driver = initializeDriver();
        driver.get(url);
        demoQaHomePage = new DemoQaHomePage(driver);
        return demoQaHomePage;
    }

    public String getDataFromProperty(String key) throws IOException {
        Properties prop = new Properties();
        File file = new File("/Users/vinayrana/Documents/seleniumFourProject/src/main/resources/data.properties");
        FileInputStream fis = new FileInputStream(file);
        prop.load(fis);
        return prop.getProperty(key);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }


    public void takesScreenShot(String testMethodName) {
        driver = getDriver();
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        String timestamp = date.toString().replace(":", "_").replace(" ", "_");
        try {
            FileUtils.copyFile(file, new File("/Users/vinayrana/Documents/seleniumFourProject/src/main/java/screenshots/" + testMethodName + "_" + timestamp + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
