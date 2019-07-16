package school.test.page.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import school.test.assertion.common.Assertion;

public abstract class Page {
    protected WebDriver driver;

    public Page (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public <G extends Page, T extends Assertion<G>> T check(T assertion){
        assertion.setPage((G)this);
        return assertion;
    }

    public WebDriver getDriver(){
        return driver;
    }
}
