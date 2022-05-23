package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }
    private By productList = By.cssSelector(".cart_item_label");
    private By continueShoppingButton = By.id("continue-shopping");
    private By checkoutButton = By.id("checkout");
    private By removeButton = By.xpath("//button[text()='Remove']");
    private By productName = By.cssSelector(".inventory_item_name");
    private By desc = By.cssSelector(".inventory_item_desc");
    private By price = By.cssSelector(".inventory_item_price");
    private By removedItem = By.cssSelector(".removed_cart_item");

    public static final String EXPECTED_PAGE_TITLE = "YOUR CART";

    public WebElement getContinueShoppingButton() {
        return driver.findElement(continueShoppingButton);
    }

    public List<WebElement> getProductsList() {
        return driver.findElements(productList);
    }

    public List<String> getProductNamesList() {
        List<String> names = new ArrayList<>();
        for (WebElement product : getProductsList()) {
            names.add(product.findElement(productName).getText());
        }
        return names;
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

    public CartPage clickRemoveButton(int productNumberInList) {
        getProductsList().get(productNumberInList);
        getRemoveButton().click();
        return this;
    }

    public String getName() {
        return driver.findElement(productName).getText();
    }

    public String getDescription() {
        return driver.findElement(desc).getText();
    }

    public String getPrice() {
        return driver.findElement(price).getText();
    }

    WebDriverWait wait = new WebDriverWait(driver, 10);
    public void waitCartPageLoading() {
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/cart.html"));
    }
}
