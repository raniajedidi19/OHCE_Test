package org.ohce.PagesObjects.common;
import org.ohce.base.base;
import org.openqa.selenium.By;


public class SSOPage extends base {
    public SSOPage() {
    }
    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By submitSSOBtn = By.name("submit");
    public By errorMessage = By.cssSelector(".animated.fadeInUp");
    public void setUsername(String name) {
        driver.findElement(usernameField).sendKeys(name);
    }
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void submitLogin() {
        driver.findElement(submitSSOBtn).click();
    }
    public String getMessage(){
       return driver.findElement(errorMessage).getText();
    }

}
