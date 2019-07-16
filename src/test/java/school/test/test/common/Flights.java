package school.test.test.common;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import school.test.page.flight.ChooseFlightPage;

public class Flights {

    private String url;

    @BeforeClass(alwaysRun = true)
    @Parameters({"url"})


    public void blazedemoAssertionClassSetup(ITestContext context, String url) {
        this.url = url;
    }

    public void airlineTest(){
        new ChooseFlightPage(driver, url)
                .run

    }

}
