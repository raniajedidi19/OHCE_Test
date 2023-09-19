package org.ohce.helpers;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class CookiesHelper {

    private Set<Cookie> cookies;
    public WebDriver driver;
    public CookiesHelper(WebDriver driver){this.driver = driver;}
    public Set<Cookie> getAllCookies (){

        return cookies = driver.manage().getCookies();
    }
    public void setAllCookies (Set<Cookie> cookies){
        for (Cookie cookie : cookies){
            driver.manage().addCookie(cookie);}
    }



}
