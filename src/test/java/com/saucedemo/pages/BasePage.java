package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;
    protected By title = By.className("title");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.findElement(title).getText();
    }
}
