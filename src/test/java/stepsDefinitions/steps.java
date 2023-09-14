package stepsDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.ohce.PagesObjects.common.SSOPage;
import org.ohce.PagesObjects.ebooks.libraryPage;
import org.ohce.PagesObjects.ebooks.loginPage;
import org.ohce.base.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class steps extends base {

    loginPage login = new loginPage();
    SSOPage Auth0Form = new SSOPage();
    libraryPage library = new libraryPage();

    public steps() {
        try {
            File file = new File("src/main/java/org/ohce/envProperties/dev.properties");
            FileInputStream fis = new FileInputStream(file);
            prop.load(fis);
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Given("user goes to the base url")
    public void user_goes_to_the_base_url() {

        driver.get(prop.getProperty("EBOOKS_BASEURL"));
    }


    @When("Login page opens successfully")
    @Then("Login page opens again")
    public void login_page_opens() {
        String actualTitle = driver.getTitle();
        String ExpectedSignInPageTitle = "Log in or Sign up | Elsevier eBooks+";
        Assert.assertEquals(ExpectedSignInPageTitle, actualTitle);

    }

    @Then("user accept cookies")
    public void user_accept_cookies() {

        login.acceptCookies();
    }

    @Given("user enters his credentials and login")
    public void user_enters_his_credentials_and_login() {
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

    @Then("user is logged in successfully to his library")
    public void user_is_logged_in_successfully_to_his_library() {
        String ActualProductPageTitle = driver.getTitle();
        String ExpectedProductPageTitle = "Home | Elsevier eBooks+";
        Assert.assertEquals(ExpectedProductPageTitle, ActualProductPageTitle);

    }

    @When("user log out")
    public void user_log_out() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        library.clickOnUserInfo();
        library.clickOnLogOutBtn();
    }


    @When("user enters his credentials and try login")
    public void user_enters_his_credentials_and_try_login() {
        String username = prop.getProperty("USERNAME2");
        String password = prop.getProperty("PASSWORD2");
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
        @Then("user gets an error message")
        public void user_gets_an_error_message() {
            String actualMessage = Auth0Form.getMessage();
            String ExpectedMessage = "Wrong username or password.";
            Assert.assertEquals(ExpectedMessage, actualMessage);

        }
}
