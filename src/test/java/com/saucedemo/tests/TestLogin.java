package com.saucedemo.tests;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest {

    @Test
    public void testSuccessLogin() {
        loginPage.openPage();
        ProductsListPage productsPage = loginPage.loginWithDefaultUser();
        productsPage.waitPageTitleLoading();
        Assert.assertEquals(productsPage.getPageTitle(),ProductsListPage.EXPECTED_PAGE_TITLE);
    }

    @Test
    public void testEmptyPassword() {
        loginPage.openPage();
        loginPage.setUserName(LoginPage.STANDARD_USER).setPassword("").clickLogin();
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
        loginPage.login("", LoginPage.DEFAULT_PASSWORD);
        loginPage.waitMessageEmptyUser();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test
    public void testLockedOutUser() {
        loginPage.openPage();
        loginPage.login("locked_out_user", LoginPage.DEFAULT_PASSWORD);
        loginPage.waitMessageLockedOutUser();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void testPerformanceGlitchUser() {
        loginPage.openPage();
        ProductsListPage productsPage = loginPage.login("performance_glitch_user", LoginPage.DEFAULT_PASSWORD);
        productsPage.waitProductPageLoading();
        Assert.assertEquals(productsPage.getPageTitle(), "PRODUCTS");
    }
}
