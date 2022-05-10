package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private By title = By.className("title");
    private By cancelButton = By.id("cancel");
    private By continueButton = By.id("continue");
    private By cartLink = By.className("shopping_cart_link");
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");

    public String getPageTitle() {
        return driver.findElement(title).getText();
    }

    public WebElement getCancelButton() {
        return driver.findElement(cancelButton);
    }

    public CartPage clickCancelButton() {
        getCancelButton().click();
        return new CartPage(driver);
    }

    public WebElement getContinueButton() {
        return driver.findElement(continueButton);
    }

    public CartPage clickContinueButton() {
        getContinueButton().click();
        return new CartPage(driver);
    }

    public WebElement getCartLink() {
        return driver.findElement(cartLink);
    }

    public CartPage clickCartLink() {
        getCartLink().click();
        return new CartPage(driver);
    }

    public CheckoutPage setFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
        return this;
    }

    public CheckoutPage setLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
        return this;
    }
}
