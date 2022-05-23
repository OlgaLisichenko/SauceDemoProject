package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SideMenu extends BasePage{

    public SideMenu(WebDriver driver) {
        super(driver);
    }

    private By logoutLink = By.id("logout_sidebar_link");
    private By leftMenu = By.cssSelector(".bm-menu-wrap");

    public WebElement getLogoutLink() {
        return driver.findElement(logoutLink);
    }

    public LoginPage clickLogoutLink() {
        getLogoutLink().click();
        return new LoginPage(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, 10);
    public void waitElement() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(leftMenu));
    }
}
