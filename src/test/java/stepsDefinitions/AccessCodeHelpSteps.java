package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.ohce.PagesObjects.common.SSOPage;
import org.ohce.PagesObjects.ebooks.accessCodeHelpPage;
import org.ohce.PagesObjects.ebooks.libraryPage;
import org.ohce.PagesObjects.ebooks.loginPage;
import org.ohce.base.base;
import org.ohce.helpers.CookiesHelper;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WindowType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class AccessCodeHelpSteps extends base {

    loginPage login = new loginPage();
    SSOPage Auth0Form = new SSOPage();
    libraryPage library = new libraryPage();
    accessCodeHelpPage accessCodeHelp = new accessCodeHelpPage();

    CookiesHelper cookies = new CookiesHelper(driver);

    public AccessCodeHelpSteps() {
        try {
            File file = new File("src/main/java/org/ohce/envProperties/dev.properties");
            FileInputStream fis = new FileInputStream(file);
            prop.load(fis);
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Given("user is on homepage")
    public void user_is_on_homepage() {
        driver.get(prop.getProperty("EBOOKS_BASEURL"));
        login.acceptCookies();
        String username = prop.getProperty("USERNAME1");
        String password = prop.getProperty("PASSWORD1");
        login.clickLoginButton();
        Auth0Form.setUsername(username);
        Auth0Form.setPassword(password);
        Auth0Form.submitLogin();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("user redeems invalid code")
    public void user_redeems_invalid_code() {
        String invalidCode = prop.getProperty("INVALID");
        library.EnterCode(invalidCode);
        library.clickOnRedeemButton();
        library.clickOnAccessCodeHelpLink();
    }

    @Then("user access the access code help page successfully using the link")
    public void user_access_the_access_code_help_page_successfully_using_the_link() {
        String originalWindow = driver.getWindowHandle();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // loop to switch the window
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
        String expectedTitle = "Access Code Help | Elsevier eBooks+";
        Assert.assertEquals(expectedTitle, driver.getTitle());
    }

    @When("user is on access code help page")
    public void user_is_on_access_code_help_page() {
        Set<Cookie> coo = cookies.getAllCookies();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(prop.getProperty("ACH_URL"));
        //Restore all cookies from previous session
        cookies.setAllCookies(coo);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to(driver.getCurrentUrl());
    }

    @When("user enters an invalid Book ISBN")
    public void user_enters_an_invalid_book_isbn() {
        String InvalidIsbn = prop.getProperty("INVALID_ISBN");
        accessCodeHelp.EnterCode(InvalidIsbn);
    }

    @Then("check the error message displayed")
    public void check_the_error_message_displayed() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertTrue(accessCodeHelp.getMessageUnderRecoveryField().contains("We are not able to process your request. Visit Customer Support for help."));
    }

    @When("user enters a valid Book ISBN")
    public void user_enters_a_valid_book_isbn() {
        String validIsbn = prop.getProperty("VALID_ISBN");
        accessCodeHelp.EnterCode(validIsbn);
    }

    @When("user clicks the submit button")
    public void user_clicks_the_submit_button() {
        accessCodeHelp.clickOnSubmitButton();
    }

    @Then("check the message displayed")
    public void check_the_message_displayed() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertEquals("Book: Diagnostic Ultrasound", accessCodeHelp.getMessageUnderRecoveryField());
    }

}
