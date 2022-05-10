package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCheckout extends BaseTest {

    @Test //Проверка кнопки "Cancel".
    public void testCancelButton() {
        loginPage.openPage();
        loginPage.loginWithDefaultUser();
        productsPage.clickCartLink();
        cartPage.clickCheckoutButton();
        checkoutPage.clickCancelButton();
        Assert.assertEquals(cartPage.getPageTitle(), "YOUR CART");
    }

    @Test //Проверка кнопки "Continue".
    public void testContinueButton() {
        loginPage.openPage();
        loginPage.loginWithDefaultUser();
        productsPage.clickCartLink();
        cartPage.clickCheckoutButton();
        checkoutPage.clickContinueButton();
        Assert.assertEquals(informationPage.getErrorMessage(), "Error: First Name is required");
    }

    @Test //Проверка ссылки "Cart".
    public void testCartLink() {
        loginPage.openPage();
        loginPage.loginWithDefaultUser();
        productsPage.clickCartLink();
        cartPage.clickCheckoutButton();
        checkoutPage.clickCartLink();
        Assert.assertEquals(cartPage.getPageTitle(), "YOUR CART");
    }

    @Test //Проверка нажатия кнопки "Continue" при незаполненном поле "Zip/Postal Code".
    public void test() {
        loginPage.openPage();
        loginPage.loginWithDefaultUser();
        productsPage.clickCartLink();
        cartPage.clickCheckoutButton();
        checkoutPage.setFirstName("qwerty");
        checkoutPage.setLastName("abcd");
        checkoutPage.clickContinueButton();
        Assert.assertEquals(informationPage.getErrorMessage(), "Error: Postal Code is required");
    }
}
