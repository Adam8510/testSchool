package school.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Unit test for simple App.
 */
public class BlazeDemoTest {

    static WebDriver driver;

    @BeforeClass
    public static void classSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Before

    public void testSetup() {
        driver.get("http://blazedemo.com");

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void holidayImageIsShown() {


        WebElement vaclink = driver.findElement(By.xpath("//a[@href='vacation.html']"));
        vaclink.click();

        WebElement vacImg = driver.findElement(By.xpath("//img"));
        assertTrue("image is not alloved", vacImg.isDisplayed());
    }

    @Test
    public void holidayImageIsShown2() {

        WebElement vaclink = driver.findElement(By.xpath("//a[@href='vacation.html']"));
        vaclink.click();

        WebElement vacImg = driver.findElement(By.xpath("//img"));
        assertTrue("image is not alloved", vacImg.isDisplayed());
    }

    @Test
    public void verifySomething(){
        WebElement from = driver.findElement(By.name("fromPort"));
        new Select(from).selectByValue("Boston");

        WebElement toPort = driver.findElement(By.name("toPort"));
        new Select(toPort).selectByValue("Berlin");

        driver.findElement(By.className("btn-primary")).click();

        //////////powinno byc message, expected w assert///////////////////
        //assertEquals("label not shown as expected", "Flights ");
        assertEquals("label not shown as expected", "Flights ", "");
        driver.findElement(By.xpath("/h3")).getText();
    }
}
