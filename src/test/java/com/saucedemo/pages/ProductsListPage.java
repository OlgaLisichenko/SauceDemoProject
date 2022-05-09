package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsListPage extends BasePage {

    public ProductsListPage(WebDriver driver) {
        super(driver);
    }

    private By title = By.className("title");
    public By menuButton = By.id("react-burger-menu-btn");

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
}
