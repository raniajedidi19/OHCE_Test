package stepsDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.ohce.base.base;
import org.openqa.selenium.WebDriver;

public class Hooks extends base {


    @Before
    public void beforeEveryTest() {
        lunchBrowser();
    }

    @After
    public void afterEveryTest(){
        closeBrowser();
    }
}
