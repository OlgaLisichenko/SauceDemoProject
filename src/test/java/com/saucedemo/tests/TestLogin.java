package com.saucedemo.tests;

import com.saucedemo.pages.ProductsListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest {

    @Test
    public void testSuccessLogin() {
        loginPage.openPage();
        ProductsListPage productsPage = loginPage.loginWithDefaultUser();
        productsPage.waitPageTitleLoading();
        Assert.assertEquals(productsPage.getPageTitle(),reader.getProductsPageTitle());
    }

    @Test
    public void testEmptyPassword() {
        loginPage.openPage();
        loginPage.setUserName(reader.getUsername()).setPassword("").clickLogin();
        loginPage.waitMessageEmptyPassword();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }

    @Test
    public void testFailedLogin() {
        loginPage.openPage();
        loginPage.login("aaaa", "1111");
        loginPage.waitMessageFailedLogin();
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void testEmptyUserName() {
        loginPage.openPage();
        loginPage.login("", reader.getPassword());
        loginPage.waitMessageEmptyUser();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test
    public void testLockedOutUser() {
        loginPage.openPage();
        loginPage.login("locked_out_user", reader.getPassword());
        loginPage.waitMessageLockedOutUser();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void testPerformanceGlitchUser() {
        loginPage.openPage();
        ProductsListPage productsPage = loginPage.login("performance_glitch_user", reader.getPassword());
        productsPage.waitProductPageLoading();
        Assert.assertEquals(productsPage.getPageTitle(), "PRODUCTS");
    }
}
