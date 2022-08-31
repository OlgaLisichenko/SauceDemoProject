package com.saucedemo.pages;

import com.saucedemo.User;
import com.saucedemo.utils.AllureUtils;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.saucedemo.utils.PropertyReader;

@Log4j2
public class LoginPage extends BasePage{

    @FindBy(id = "user-name")
    public WebElement userNameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(xpath = "//h3")
    public WebElement errorMessage;

    PropertyReader reader = new PropertyReader();

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    @Step("Waiting for Login page to load")
    public LoginPage isPageOpen() {
        wait.until(ExpectedConditions.urlToBe(reader.getLoginUrl()));
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Opening www.saucedemo.com")
    public void openPage() {
        log.info("Navigate to {}", reader.getLoginUrl());
        driver.get(reader.getLoginUrl());
    }

    public String Url() {
       return driver.getCurrentUrl();
    }

    public LoginPage setUserName(String userName) {
        log.info("Set {} like username for login", userName);
        userNameField.sendKeys(userName);
        return this;
    }

    public LoginPage setPassword(String password) {
        log.info("Set {} like password for login", password);
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Getting error message")
    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        AllureUtils.takeScreenshot(driver);
        return errorMessage.getText();
    }

    public ProductsListPage clickLogin() {
        loginButton.click();
        return new ProductsListPage(driver);
    }

    @Step("Login with User '{user}'")
    public ProductsListPage login(User user) {
        return setUserName(user.getUsername()).setPassword(user.getPassword()).clickLogin();
    }

    @Step("Login with standard user")
    public ProductsListPage loginWithStandardUser() {
        login(new User(reader.getUsername(),reader.getPassword()));
        return new ProductsListPage(driver);
    }
}
