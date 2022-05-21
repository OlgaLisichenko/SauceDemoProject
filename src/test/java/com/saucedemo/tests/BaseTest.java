package com.saucedemo.tests;

import com.saucedemo.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsListPage productsPage;
    protected SideMenu sideMenu;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    protected InformationPage informationPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsListPage(driver);
        sideMenu = new SideMenu(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        informationPage = new InformationPage(driver);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
