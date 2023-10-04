package org.ohce.PagesObjects.ebooks;

import org.ohce.base.base;
import org.openqa.selenium.By;

public class redeemAdditionalContentPage extends base {

    public redeemAdditionalContentPage(){}

    By orderNumberField = By.cssSelector("input.c-els-field__input[data-testid='order-number-input']");
    By ISBNField = By.cssSelector("input.c-els-field__input[data-testid='ISBN-field-input']");

    By successMsgForOrderNumber = By.xpath("//span[contains(text(), 'Order Number successful')]");

    By failedMsgForOrderNumber = By.cssSelector(".c-els-field__message.c-els-field__message--error.input-message");

    By MsgForISBN = By.xpath("//span[normalize-space()='Book: Campbell-Walsh Urology']");
    By ErrorMsgForISBN = By.cssSelector(".c-els-field__message.c-els-field__message--error.input-message");

    By submitBtn = By.cssSelector(".button.c-els-button.button--primary");

    By firstBookInTheLibrary = By.cssSelector(".entitlement-item:first-of-type");

    public void clickSubmitBtn(){
        driver.findElement(submitBtn).click();
    }

    public Boolean checkBookExistingOnTop(String title) {
        String titleFoundOnTop = driver.findElement(firstBookInTheLibrary).getText();
        if (titleFoundOnTop.equals(title)) {
            return true;
        }else return false;
    }


    public boolean checkBtnStatus(){
        return driver.findElement(submitBtn).isEnabled();
    }

    public void enterOrderNumber(String code){
        driver.findElement(orderNumberField).sendKeys(code);
    }

    public String getsuccessMessage(){
        return driver.findElement(successMsgForOrderNumber).getText();
    }
    public String getfailedMessage(){
        return driver.findElement(failedMsgForOrderNumber).getText();
    }

    public void enterISBN(String code){
        driver.findElement(ISBNField).sendKeys(code);
    }
    public String getIsbnMessage(){
        return driver.findElement(MsgForISBN).getText();
    }
    public String getIsbnErrorMessage(){
        return driver.findElement(ErrorMsgForISBN).getText();
    }


}
