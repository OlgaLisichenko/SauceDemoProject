package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InformationPage extends BasePage {

    public InformationPage(WebDriver driver) {
        super(driver);
    }

    private By errorMessage = By.xpath("//h3");

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
