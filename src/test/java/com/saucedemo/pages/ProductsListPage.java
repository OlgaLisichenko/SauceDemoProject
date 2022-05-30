package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProductsListPage extends BasePage {

    public ProductsListPage(WebDriver driver) {
        super(driver);
    }

    private By menuButton = By.id("react-burger-menu-btn");
    private By cartLink = By.className("shopping_cart_link");
    private By addToCartButton = By.tagName("button");
    private By cartBadge = By.cssSelector(".shopping_cart_badge");
    private By productName = By.cssSelector(".inventory_item_name");
    private By productDesc = By.cssSelector(".inventory_item_desc");
    private By price = By.cssSelector(".inventory_item_price");
    private By productsList = By.cssSelector(".inventory_item");
    private By select = By.tagName("select");

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

    public WebElement getCartBadge() {
        return driver.findElement(cartBadge);
    }

    public String numberCartBadge() {
        return getCartBadge().getText();
    }

    public List<WebElement> getProducts() {
        return driver.findElements(productsList);
    }

    public WebElement getSelectedProduct(int index) {
        return getProducts().get(index);
    }

    public WebElement getAddToCart(int index) {
        return getSelectedProduct(index).findElement(addToCartButton);
    }

    public ProductsListPage clickAddToCart(int index) {
        getAddToCart(index).click();
        return this;
    }

    public String getName(int index) {
        return getSelectedProduct(index).findElement(productName).getText();
    }

    public String getDescription(int index) {
        return getSelectedProduct(index).findElement(productDesc).getText();
    }

    public String getPrice(int index) {
        return getSelectedProduct(index).findElement(price).getText();
    }

    public Select getSelect() {
        return new Select(driver.findElement(select));
    }

    public void selectValue(String value) {
        getSelect().selectByVisibleText(value);
    }

    public List<String> getProductsNames() {
        List<String> names = new ArrayList<>();
        for (WebElement product: getProducts()) {
            names.add(product.findElement(productName).getText());
        }
        return names;
    }

    public List<Double> getProductsPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement product: getProducts()) {
            prices.add(Double.parseDouble(product.findElement(price).getText().replace("$", "")));
        }
        return prices;
    }

    public void waitProductPageLoading() {
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
    }

    public void waitPageTitleLoading() {
        wait.until(ExpectedConditions.textToBe(title,"PRODUCTS"));
    }
}

