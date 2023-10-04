package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.ohce.PagesObjects.common.SSOPage;
import org.ohce.PagesObjects.ebooks.libraryPage;
import org.ohce.PagesObjects.ebooks.loginPage;
import org.ohce.PagesObjects.ebooks.redeemAdditionalContentPage;
import org.ohce.base.base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class redeemAdditionalContentSteps extends base {
    loginPage login = new loginPage();
    SSOPage Auth0Form = new SSOPage();
    libraryPage library = new libraryPage();
    redeemAdditionalContentPage AdditionalContent = new redeemAdditionalContentPage();

    @Given("user is on the homepage")
    public void user_is_on_homepage() {
        driver.get(prop.getProperty("EBOOKS_BASEURL"));
        login.acceptCookies();
        String username = prop.getProperty("USERNAME3");
        String password = prop.getProperty("PASSWORD3");
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

    @When("user clicks on the link No Access Code?")
    public void user_clicks_on_the_link() {
        library.clickOnAdditionalContentLink();
    }

    @Then("user is redirected to Redeem Additional Content page successfully")
    public void user_is_redirected_to_redeem_additional_content_page_successfully() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertEquals("Redeem additional content | Elsevier eBooks+", driver.getTitle());
    }

    @Given("user is on Redeem Additional Content page")
    public void user_is_on_redeem_additional_content_page() {
        library.clickOnAdditionalContentLink();
    }

    @When("user enters a valid order number")
    public void user_enters_a_valid_order_number() {
        String validOrderNumber = prop.getProperty("amazonOrderNumber_1");
        AdditionalContent.enterOrderNumber(validOrderNumber);
        Assert.assertEquals("Order Number successful", AdditionalContent.getsuccessMessage());

    }

    @And("user enters a valid ISBN")
    public void user_enters_a_valid_isbn() {
        String validISBN = prop.getProperty("VALIDISBN1");
        AdditionalContent.enterISBN(validISBN);
        String bookTitle = prop.getProperty("BookTitle1");
        Assert.assertEquals("Book: "+ bookTitle, AdditionalContent.getIsbnMessage());
    }

    @Then("the redeem button is enabled")
    public void the_redeem_button_is_enabled() {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(AdditionalContent.checkBtnStatus());
    }

    @When("user click on the redeem button")
    public void user_click_on_the_redeem_button() {
        AdditionalContent.clickSubmitBtn();
    }

    @Then("user will be redirected to the product page")
    public void user_will_be_redirected_to_the_product_page() {
        // Attendre que l'URL change (redirection automatique)
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(prop.getProperty("EBOOKS_BASEURL")+"redeem-additional-content")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Assert.assertEquals("Home | Elsevier eBooks+", driver.getTitle());
        driver.navigate().refresh();
    }

    @And("the book should be added successfully to the top of the list")
    public void the_book_should_be_added_successfully_to_the_top_of_the_list() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".entitlement-item:first-of-type"))));
        String bookTitle = prop.getProperty("BookTitle1");
        Assert.assertTrue(AdditionalContent.checkBookExistingOnTop(bookTitle));
    }
    @When("user Fills in order number input with invalid data")
    public void user_fills_in_order_number_input_with_invalid_data() {
        String inValidOrderNumber = prop.getProperty("amazonOrderNumber_invalid");
        AdditionalContent.enterOrderNumber(inValidOrderNumber);

    }
    @Then("Check that order number validation message is displayed")
    public void check_that_order_number_validation_message_is_displayed() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(AdditionalContent.getfailedMessage().contains("We are not able to process your request. Visit Customer Support for help."));
    }

    @When("user Fills in ISBN input with invalid data")
    public void user_fills_in_isbn_input_with_invalid_data() {
        String inValidISBN = prop.getProperty("invalidISBNac");
        AdditionalContent.enterISBN(inValidISBN);
    }
    @Then("Check that ISBN validation message is displayed")
    public void check_that_isbn_validation_message_is_displayed() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(AdditionalContent.getIsbnErrorMessage().contains("We are not able to process your request. Visit Customer Support for help."));
    }


    @When("user enters a valid used order number")
    public void user_enters_a_valid_used_order_number() {
        String ValidUsedOrderNumber = prop.getProperty("amazonOrderNumber_2_used");
        AdditionalContent.enterOrderNumber(ValidUsedOrderNumber);

    }
    @And("user Fills in ISBN input with valid data")
    public void user_fills_in_isbn_input_with_valid_data() {
        String ValidISBN = prop.getProperty("VALIDISBN1");
        AdditionalContent.enterISBN(ValidISBN);
    }
    @Then("Check that order number error is shown")
    public void check_that_order_number_error_is_shown() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(AdditionalContent.getfailedMessage().contains("The order number "+prop.getProperty("amazonOrderNumber_2_used")+" has already been used"));
    }

    @When("user enters a valid unused order number")
    public void user_enters_a_valid_unused_order_number() {
        String ValidUnUsedOrderNumber = prop.getProperty("amazonOrderNumber_3");
        AdditionalContent.enterOrderNumber(ValidUnUsedOrderNumber);
    }
    @When("user Fills in ISBN used input with valid data")
    public void user_fills_in_isbn_used_input_with_valid_data() {
        String ValidUsedISBN = prop.getProperty("UsedValidIsbn");
        AdditionalContent.enterISBN(ValidUsedISBN);
    }
    @Then("Check that ISBN error is shown")
    public void check_that_isbn_error_is_shown() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(AdditionalContent.getIsbnErrorMessage().contains("User is already entitled to content: "+prop.getProperty("UsedValidIsbn")));

    }

}
