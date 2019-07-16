package school.test.page.flight;

import org.openqa.selenium.WebDriver;
import school.test.page.common.Page;
import school.test.page.flight.component.HeaderComponent;

public class AbstractFlightsPage extends Page {

    private HeaderComponent header;

    public  AbstractFlightsPage(WebDriver driver){
        super(driver);
        header = new HeaderComponent(driver);

    }

    public HeaderComponent getHeader() {
        return header;
    }
}
