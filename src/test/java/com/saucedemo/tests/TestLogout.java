package com.saucedemo.tests;

import com.saucedemo.pages.ProductsListPage;
import com.saucedemo.pages.SideMenu;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogout extends BaseTest {

    @Test
    public void testLogout() {
        loginPage.openPage();
        loginPage.isPageOpen();
        ProductsListPage productsPage = loginPage.loginWithDefaultUser();
        productsPage.isPageOpen();
        SideMenu sideMenu = productsPage.clickMenuButton();
        sideMenu.isPageOpen();
        sideMenu.clickLogoutLink();
        Assert.assertEquals(loginPage.Url(), "https://www.saucedemo.com/");
    }
}
