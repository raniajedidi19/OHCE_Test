package org.ohce.PagesObjects.ebooks;
import org.ohce.base.base;
import org.openqa.selenium.By;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class loginPage extends base {

    public loginPage() {
    }

    By loginBtn = By.cssSelector("div.main-container:nth-child(2) div.container div.login-page div.login-button-group:nth-child(3) > button.button.c-els-button:nth-child(1)");
    By signUpBtn = By.cssSelector("");
    By AcceptAllCookiesBtn = By.cssSelector("button#onetrust-accept-btn-handler");

    public void clickLoginButton() {
        driver.findElement(loginBtn).click();
    }
    public void acceptCookies(){
        driver.findElement(AcceptAllCookiesBtn).click();
    }

}
