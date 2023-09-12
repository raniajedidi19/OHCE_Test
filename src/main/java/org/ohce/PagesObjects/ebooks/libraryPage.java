package org.ohce.PagesObjects.ebooks;
import org.ohce.base.base;
import org.openqa.selenium.By;


public class libraryPage extends base {

    public libraryPage() {

    }
    By userInfo = By.cssSelector(".user-info-dropdown");

    By logoutBtn = By.cssSelector("button[class='button button--link u-els-anchorize c-els-link']");

    public void clickOnUserInfo() {
        driver.findElement(userInfo).click();
    }
    public void clickOnLogOutBtn() {
        driver.findElement(logoutBtn).click();
    }
}
