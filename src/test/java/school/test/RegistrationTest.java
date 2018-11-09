package school.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationTest {

    static WebDriver driver;

    @BeforeClass
    public static void classSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Before

    public void testSetup() {
        driver.get("http://parabank.parasoft.com/");
        driver.manage().window().fullscreen();
        //driver.wait(10);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }


    @Test
    public void checkLoginLabelsAndFields(){
        WebElement loginPanel = driver.findElement(By.id("leftPanel"));
        //WebElement header = loginPanel.findElement(By.xpath("//h2[@href='username']"));
        //assertTrue(driver.findElement(By.cssSelector("//h2[@href='']")).isDisplayed());
        WebElement login = loginPanel.findElement(By.name("username"));
        assertTrue("assert is displayed login field", login.isDisplayed());

        WebElement password = loginPanel.findElement(By.name("password"));
        assertTrue("is displayed password field", password.isDisplayed());

    }
    @Test
    public void shouldReturnFields(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //WebElement registerButton1 = driver.findElement(By.cssSelector("a[href='register.htm']"));
        WebElement registerButton = driver.findElement(By.xpath(("//div[@id='loginPanel']/p[last()]/a")));
        assertTrue("is register button displayed", registerButton.isDisplayed());
        registerButton.click();

        String baseTable = driver.findElement(By.cssSelector("table.form2")).getText();
        System.out.println(baseTable);

        assertTrue(driver.findElement(By.id("customer.firstName")).isDisplayed());
        assertTrue(driver.findElement(By.id("customer.lastName")).isDisplayed());
        assertTrue(driver.findElement(By.id("customer.address.street")).isDisplayed());
        assertTrue(driver.findElement(By.id("customer.address.city")).isDisplayed());
        assertTrue(driver.findElement(By.id("customer.address.state")).isDisplayed());
        assertTrue(driver.findElement(By.id("customer.address.zipCode")).isDisplayed());
        assertTrue(driver.findElement(By.id("customer.phoneNumber")).isDisplayed());
        assertTrue(driver.findElement(By.id("customer.ssn")).isDisplayed());
        assertTrue(driver.findElement(By.id("customer.username")).isDisplayed());
        assertTrue(driver.findElement(By.id("customer.password")).isDisplayed());
        assertTrue(driver.findElement(By.id("repeatedPassword")).isDisplayed());

        driver.findElement(By.xpath("//input[@value='Register']")).isDisplayed();
    }
    @Test
    public void shouldAppearErrorIfEmptyPasswordAndConfirmation(){

        driver.findElement(By.xpath(("//div[@id='loginPanel']/p[last()]/a"))).click();

        driver.findElement(By.id("customer.firstName")).sendKeys("Adam");
        driver.findElement(By.id("customer.lastName")).sendKeys("Moskal");
        driver.findElement(By.id("customer.address.street")).sendKeys("2 Pułku Lotniczego");
        driver.findElement(By.id("customer.address.city")).sendKeys("Kraków");
        driver.findElement(By.id("customer.address.state")).sendKeys("Małopolska");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("00-111");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("111 222 333");
        driver.findElement(By.id("customer.ssn")).sendKeys("06");
        driver.findElement(By.id("customer.username")).sendKeys("09655423");

        driver.findElement(By.xpath("//input[@value='Register']")).click();

        assertEquals("Password is required.", driver.findElement(By.id("customer.password.errors")).getText());
        assertEquals("Password confirmation is required.", driver.findElement(By.id("repeatedPassword.errors")).getText());
    }
    @Test
    public void ShouldAppearNoConfirmationValueError(){
        driver.findElement(By.xpath(("//div[@id='loginPanel']/p[last()]/a"))).click();

        driver.findElement(By.id("customer.firstName")).sendKeys("Adam");
        driver.findElement(By.id("customer.lastName")).sendKeys("Moskal");
        driver.findElement(By.id("customer.address.street")).sendKeys("2 Pułku Lotniczego");
        driver.findElement(By.id("customer.address.city")).sendKeys("Kraków");
        driver.findElement(By.id("customer.address.state")).sendKeys("Małopolska");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("00-111");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("111 222 333");
        driver.findElement(By.id("customer.ssn")).sendKeys("06");
        driver.findElement(By.id("customer.username")).sendKeys("09655423");
        driver.findElement(By.id("customer.password")).sendKeys("NoweAlaMaPsa123");

        driver.findElement(By.xpath("//input[@value='Register']")).click();

        assertEquals("Password confirmation is required.", driver.findElement(By.id("repeatedPassword.errors")).getText());
    }
    @Test
    public void shouldAppearNoUserNameValueError() {
        driver.findElement(By.xpath(("//div[@id='loginPanel']/p[last()]/a"))).click();

        driver.findElement(By.id("customer.lastName")).sendKeys("Moskal");
        driver.findElement(By.id("customer.address.street")).sendKeys("2 Pułku Lotniczego");
        driver.findElement(By.id("customer.address.city")).sendKeys("Kraków");
        driver.findElement(By.id("customer.address.state")).sendKeys("Małopolska");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("00-111");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("111 222 333");
        driver.findElement(By.id("customer.ssn")).sendKeys("06");
        driver.findElement(By.id("customer.username")).sendKeys("09655423");
        driver.findElement(By.id("customer.password")).sendKeys("NoweAlaMaPsa123");
        driver.findElement(By.id("repeatedPassword")).sendKeys("NoweAlaMaPsa123");

        driver.findElement(By.xpath("//input[@value='Register']")).click();

        assertEquals("First name is required.", driver.findElement(By.id("customer.firstName.errors")).getText());
    }
    @Test
    public void shouldFieldsAreNotEmptyErrors(){
        driver.findElement(By.xpath(("//div[@id='loginPanel']/p[last()]/a"))).click();
        driver.findElement(By.xpath("//input[@value='Register']")).click();

        assertEquals("First name is required.", driver.findElement(By.id("customer.firstName.errors")).getText());
        assertEquals("Last name is required.", driver.findElement(By.id("customer.lastName.errors")).getText());
        assertEquals("Address is required.", driver.findElement(By.id("customer.address.street.errors")).getText());
        assertEquals("City is required.", driver.findElement(By.id("customer.address.city.errors")).getText());
        assertEquals("State is required.", driver.findElement(By.id("customer.address.state.errors")).getText());
        assertEquals("Zip Code is required.", driver.findElement(By.id("customer.address.zipCode.errors")).getText());
        assertEquals("Social Security Number is required.", driver.findElement(By.id("customer.ssn.errors")).getText());
        assertEquals("Username is required.", driver.findElement(By.id("customer.username.errors")).getText());
        assertEquals("Password is required.", driver.findElement(By.id("customer.password.errors")).getText());
        assertEquals("First name is required.", driver.findElement(By.id("customer.firstName.errors")).getText());
        assertEquals("First name is required.", driver.findElement(By.id("customer.firstName.errors")).getText());
        assertEquals("Password confirmation is required.", driver.findElement(By.id("repeatedPassword.errors")).getText());

    }
}


