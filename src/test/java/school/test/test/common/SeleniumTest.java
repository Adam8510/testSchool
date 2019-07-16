package school.test.test.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class SeleniumTest {
    protected WebDriver driver;
//    private WebDriverFactory webDriverFactory = getWebDriverFactory();
//
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

//    @AfterMethod
//    public void eachTestTeardown(){
//        try {
//            new RegistrationConfirmationPage(driver).clickLogout();
//        } catch (Exception e) {
//        }
//    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
