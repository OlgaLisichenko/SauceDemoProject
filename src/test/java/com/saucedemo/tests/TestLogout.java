package com.saucedemo.tests;

import com.saucedemo.pages.ProductsListPage;
import com.saucedemo.pages.SideMenu;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogout extends BaseTest {

    @Test
    public void testLogout() {
        loginPage.openPage();
        ProductsListPage productsPage = loginPage.loginWithDefaultUser();
        SideMenu sideMenu = productsPage.clickMenuButton();
        sideMenu.waitElement();
        sideMenu.clickLogoutLink();
        Assert.assertEquals(loginPage.Url(), "https://www.saucedemo.com/");
    }
}
