package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private By continueShoppingButton = By.id("continue-shopping");
    private By checkoutButton = By.id("checkout");
    private By removeButton = By.xpath("//button[text()='Remove']");
    private By name = By.cssSelector(".inventory_item_name");
    private By desc = By.cssSelector(".inventory_item_desc");
    private By price = By.cssSelector(".inventory_item_price");
    private By removedItem = By.cssSelector(".removed_cart_item");

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

    public CheckoutPage clickCheckoutButton() {
        getCheckoutButton().click();
        return new CheckoutPage(driver);
    }

    public WebElement getRemoveButton() {
        return driver.findElement(removeButton);
    }

    public CartPage clickRemoveButton() {
        getRemoveButton().click();
        return this;
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

    WebDriverWait wait = new WebDriverWait(driver, 10);
    public void waitCartPageLoading() {
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/cart.html"));
    }
}
