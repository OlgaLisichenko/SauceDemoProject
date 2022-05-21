package com.saucedemo.tests;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.ProductsListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCart extends BaseTest {

    @Test  //Проверка кнопки "Continue Shopping".
    public void testContinueShoppingButton() {
        loginPage.openPage();
        ProductsListPage productsPage = loginPage.loginWithDefaultUser();
        CartPage cartPage = productsPage.clickCartLink();
        cartPage.clickContinueShoppingButton();
        productsPage.waitProductPageLoading();
        Assert.assertEquals(productsPage.getPageTitle(), "PRODUCTS");
    }

    @Test //Проверка кнопки "Checkout".
    public void testCheckoutButton() {
        loginPage.openPage();
        ProductsListPage productsPage = loginPage.loginWithDefaultUser();
        CartPage cartPage = productsPage.clickCartLink();
        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
        checkoutPage.waitCheckoutPageLoading();
        Assert.assertEquals(checkoutPage.getPageTitle(), "CHECKOUT: YOUR INFORMATION");
    }

    @Test  //Проверка возможности добавления товара в корзину и его удаления.
    public void testAddRemoveItem() {
        loginPage.openPage();
        ProductsListPage productsPage = loginPage.loginWithDefaultUser();

        String expectedProductName = productsPage.getName();
        String expectedDescription = productsPage.getDescription();
        String expectedPrice = productsPage.getPrice();

        productsPage.clickAddToCart();
        Assert.assertEquals(productsPage.numberCartBadge(), "1"); //Проверка отображения количества товаров в корзине.
        CartPage cartPage = productsPage.clickCartLink();
        cartPage.waitCartPageLoading();
        Assert.assertEquals(cartPage.getName(), expectedProductName); //Проверка правильности отображения названия товара.
        Assert.assertEquals(cartPage.getDescription(), expectedDescription); //Проверка правильности отображения описания товара.
        Assert.assertEquals(cartPage.getPrice(), expectedPrice); //Проверка правильности отображения цены товара.
        cartPage.clickRemoveButton();
        Assert.assertFalse(cartPage.getRemovedItem().isDisplayed()); //Проверка на отсутствие информации о товаре после его удаления.
    }
}