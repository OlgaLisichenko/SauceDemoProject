package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private By title = By.className("title");
    private By continueShoppingButton = By.id("continue-shopping");
    private By checkoutButton = By.id("checkout");
    private By removeButton = By.id("remove-sauce-labs-bolt-t-shirt");
    private By name = By.cssSelector(".inventory_item_name");
    private By desc = By.cssSelector(".inventory_item_desc");
    private By price = By.cssSelector(".inventory_item_price");
    private By removedItem = By.cssSelector(".removed_cart_item");

    public String getPageTitle() {
        return driver.findElement(title).getText();
    }

    public WebElement getContinueShoppingButton() {
        return driver.findElement(continueShoppingButton);
    }

    public ProductsListPage clickContinueShoppingButton() {
        getContinueShoppingButton().click();
        return new ProductsListPage(driver);
    }

    public WebElement getCheckoutButton() {
        return driver.findElement(checkoutButton);
    }

    public CartPage clickCheckoutButton() {
        getCheckoutButton().click();
        return this;
    }

    public WebElement getRemoveButton() {
        return driver.findElement(removeButton);
    }

    public CheckoutPage clickRemoveButton() {
        getRemoveButton().click();
        return new CheckoutPage(driver);
    }

    public String getName() {
        return driver.findElement(name).getText();
    }

    public String getDescription() {
        return driver.findElement(desc).getText();
    }

    public String getPrice() {
        return driver.findElement(price).getText();
    }

    public WebElement getRemovedItem() {
        return driver.findElement(removedItem);
    }
}
