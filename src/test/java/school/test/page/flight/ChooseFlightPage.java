package school.test.page.flight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChooseFlightPage extends AbstractFlightsPage{

    @FindBy(id = "ctl00_mainContent_ddl_originStation1_CTXT")
    private WebElement from;

    @FindBy(name = "destinationStation")
    private WebElement to;


    public ChooseFlightPage(WebDriver driver) {
        super(driver);
    }
    public ChooseFlightPage(WebDriver driver, String url){
        super(driver);
        driver.get(url);
    }
}
