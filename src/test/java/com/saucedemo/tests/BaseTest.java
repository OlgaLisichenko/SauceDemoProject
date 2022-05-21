package com.saucedemo.tests;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsListPage;
import com.saucedemo.pages.SideMenu;
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

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsListPage(driver);
        sideMenu = new SideMenu(driver);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
