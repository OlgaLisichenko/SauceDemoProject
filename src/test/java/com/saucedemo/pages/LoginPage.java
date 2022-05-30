package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.PropertyReader;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By userNameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.xpath("//h3");

    PropertyReader reader = new PropertyReader();

    public void openPage() {
        driver.get(reader.getLoginUrl());
    }

    public String Url() {
       return driver.getCurrentUrl();
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }

    public LoginPage setUserName(String userName) {
        driver.findElement(userNameField).sendKeys(userName);
        return this;
    }

    public LoginPage setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public ProductsListPage clickLogin() {
        getLoginButton().click();
        return new ProductsListPage(driver);
    }

    public ProductsListPage login(String username, String password) {
        setUserName(username);
        setPassword(password);
        return clickLogin();
    }

    public ProductsListPage loginWithDefaultUser() {
        return login(reader.getUsername(),reader.getPassword());
    }

    public void waitMessageEmptyPassword() {
        wait.until(ExpectedConditions.textToBe(errorMessage, "Epic sadface: Password is required"));
    }

    public void waitMessageLockedOutUser() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3"))));
    }

    public void waitMessageEmptyUser() {
        wait.until(ExpectedConditions.textToBe(errorMessage, "Epic sadface: Username is required"));
    }

    public void waitMessageFailedLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
    }
}
