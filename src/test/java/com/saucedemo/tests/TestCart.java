package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCart extends BaseTest {

    @Test  //Проверка кнопки "Continue Shopping".
    public void testContinueShoppingButton() {
        loginPage.openPage();
        loginPage.loginWithDefaultUser();
        productsPage.clickCartLink();
        cartPage.clickContinueShoppingButton();
        Assert.assertEquals(productsPage.getPageTitle(), "PRODUCTS");
    }

    @Test //Проверка кнопки "Checkout".
    public void testCheckoutButton() {
        loginPage.openPage();
        loginPage.loginWithDefaultUser();
        productsPage.clickCartLink();
        cartPage.clickCheckoutButton();
        Assert.assertEquals(checkoutPage.getPageTitle(), "CHECKOUT: YOUR INFORMATION");
    }

    @Test  //Проверка возможности добавления товара в корзину и его удаления.
    public void testAddRemoveItem() {
        loginPage.openPage();
        loginPage.loginWithDefaultUser();
        productsPage.clickAddToCart();
        Assert.assertEquals(productsPage.numberCartBadge(), "1"); //Проверка отображения количества товаров в корзине.
        productsPage.clickCartLink();
        Assert.assertEquals(productsPage.getName(), cartPage.getName()); //Проверка правильности отображения названия товара.
        Assert.assertEquals(productsPage.getDescription(), cartPage.getDescription()); //Проверка правильности отображения описания товара.
        Assert.assertEquals(productsPage.getPrice(), cartPage.getPrice()); //Проверка правильности отображения цены товара.
        cartPage.clickRemoveButton();
        Assert.assertFalse(cartPage.getRemovedItem().isDisplayed()); //Проверка на отсутствие информации о товаре после его удаления.
    }
}
