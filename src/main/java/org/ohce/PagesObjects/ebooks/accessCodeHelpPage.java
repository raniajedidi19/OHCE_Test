package org.ohce.PagesObjects.ebooks;

import org.ohce.base.base;
import org.openqa.selenium.By;

public class accessCodeHelpPage extends base {

    public accessCodeHelpPage(){}

    By AccessCodeHelpField = By.cssSelector("input[class='c-els-field__input damaged-input__input']");
    By submitButton = By.cssSelector("button[class='button c-els-button button--primary']");
    public By messageDisplayed = By.cssSelector("span.c-els-field__message");

    public void EnterCode(String code) { driver.findElement(AccessCodeHelpField).sendKeys(code);}
    public void clickOnSubmitButton() { driver.findElement(submitButton).click();}

    public String getMessageUnderRecoveryField(){
        return driver.findElement(messageDisplayed).getText();
    }

}
