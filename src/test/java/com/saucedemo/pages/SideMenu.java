package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SideMenu extends BasePage{

    public SideMenu(WebDriver driver) {
        super(driver);
    }

    private By logoutLink = By.id("logout_sidebar_link");

    public WebElement getLogoutLink() {
        return driver.findElement(logoutLink);
    }

    public LoginPage clickLogoutLink() {
        getLogoutLink().click();
        return new LoginPage(driver);
    }
}
