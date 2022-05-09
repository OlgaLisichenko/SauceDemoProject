package com.saucedemo.tests;

import com.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest {

    @Test
    public void testSuccessLogin() {
        loginPage.openPage();
        loginPage.loginWithDefaultUser();
        Assert.assertEquals(productsPage.getPageTitle(),"PRODUCTS");
    }

    @Test
    public void testEmptyPassword() {
        loginPage.openPage();
        loginPage.setUserName(LoginPage.STANDARD_USER).setPassword("").clickLogin();
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }

    @Test
    public void testFailedLogin() {
        loginPage.openPage();
        loginPage.login("aaaa", "1111");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void testEmptyUserName() {
        loginPage.openPage();
        loginPage.login("", LoginPage.DEFAULT_PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test
    public void testLockedOutUser() {
        loginPage.openPage();
        loginPage.login("locked_out_user", LoginPage.DEFAULT_PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void testPerformanceGlitchUser() {
        loginPage.openPage();
        loginPage.login("performance_glitch_user", LoginPage.DEFAULT_PASSWORD);
        Assert.assertEquals(productsPage.getPageTitle(), "PRODUCTS");
    }
}
