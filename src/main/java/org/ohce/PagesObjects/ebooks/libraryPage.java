package org.ohce.PagesObjects.ebooks;

import org.ohce.base.base;
import org.openqa.selenium.By;


public class libraryPage extends base {

    public libraryPage() {}

    By userInfo = By.cssSelector(".user-info-dropdown");
    By redeemField = By.cssSelector("input[class='c-els-field__input redemption-field__input']");
    By redeemButton = By.cssSelector("button[class='button c-els-button button--primary']");
    By logoutBtn = By.cssSelector("button[class='button button--link u-els-anchorize c-els-link']");
    By additionalContentLink = By.cssSelector("a[href='/redeem-additional-content']");
    By accessCodeHelpLink = By.cssSelector("a[class='c-els-link help-link']");
    public void clickOnUserInfo() {
        driver.findElement(userInfo).click();
    }

    public void clickOnLogOutBtn() {
        driver.findElement(logoutBtn).click();
    }

    public void EnterCode(String code) { driver.findElement(redeemField).sendKeys(code);}
    public void clickOnRedeemButton() { driver.findElement(redeemButton).click();}
    public void clickOnAccessCodeHelpLink (){driver.findElement(accessCodeHelpLink).click();}

    public void clickOnAdditionalContentLink(){driver.findElement(additionalContentLink).click();}
}
