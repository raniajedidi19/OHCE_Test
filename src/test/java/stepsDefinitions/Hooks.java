package stepsDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.BeforeClass;
import org.ohce.base.base;

import java.io.IOException;


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
