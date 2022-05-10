package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsListPage extends BasePage {

    public ProductsListPage(WebDriver driver) {
        super(driver);
    }

    private By title = By.className("title");
    private By menuButton = By.id("react-burger-menu-btn");
    private By cartLink = By.className("shopping_cart_link");
    private By addToCartButton = By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt");
    private By cartBadge = By.cssSelector(".shopping_cart_badge");
    private By name = By.cssSelector(".inventory_item_name");
    private By desc = By.cssSelector(".inventory_item_desc");
    private By price = By.cssSelector(".inventory_item_price");

    public String getPageTitle() {
        return driver.findElement(title).getText();
    }

    public WebElement getMenuButton() {
        return driver.findElement(menuButton);
    }

    public SideMenu clickMenuButton() {
        getMenuButton().click();
        return new SideMenu(driver);
    }

    public WebElement getCartLink() {
        return driver.findElement(cartLink);
    }

    public CartPage clickCartLink() {
        getCartLink().click();
        return new CartPage(driver);
    }

    public WebElement getAddToCart() {
        return driver.findElement(addToCartButton);
    }

    public ProductsListPage clickAddToCart() {
        getAddToCart().click();
        return this;
    }

    public WebElement getCartBadge() {
        return driver.findElement(cartBadge);
    }

    public String numberCartBadge() {
        return getCartBadge().getText();
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
}
