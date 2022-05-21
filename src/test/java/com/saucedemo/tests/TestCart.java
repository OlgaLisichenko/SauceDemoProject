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

        String expectedProductName = productsPage.getName();
        String expectedDescription = productsPage.getDescription();
        String expectedPrice = productsPage.getPrice();

        productsPage.clickAddToCart();
        Assert.assertEquals(productsPage.numberCartBadge(), "1"); //Проверка отображения количества товаров в корзине.
        productsPage.clickCartLink();
        Assert.assertEquals(cartPage.getName(), expectedProductName); //Проверка правильности отображения названия товара.
        Assert.assertEquals(cartPage.getDescription(), expectedDescription); //Проверка правильности отображения описания товара.
        Assert.assertEquals(cartPage.getPrice(), expectedPrice); //Проверка правильности отображения цены товара.
        cartPage.clickRemoveButton();
        Assert.assertFalse(cartPage.getRemovedItem().isDisplayed()); //Проверка на отсутствие информации о товаре после его удаления.
    }
}
