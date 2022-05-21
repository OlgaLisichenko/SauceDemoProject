package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogout extends BaseTest {

    @Test
    public void testLogout() {
        loginPage.openPage();
        loginPage.loginWithDefaultUser();
        productsPage.clickMenuButton();
        sideMenu.clickLogoutLink();
        Assert.assertEquals(loginPage.Url(), "https://www.saucedemo.com/");
    }
}
