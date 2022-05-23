package com.saucedemo.tests;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.ProductsListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCheckout extends BaseTest {

    @Test //Проверка кнопки "Cancel".
    public void testCancelButton() {
        loginPage.openPage();
        ProductsListPage productsPage = loginPage.loginWithDefaultUser();
        CartPage cartPage = productsPage.clickCartLink();
        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
        checkoutPage.clickCancelButton();
        cartPage.waitCartPageLoading();
        Assert.assertEquals(cartPage.getPageTitle(), CartPage.EXPECTED_PAGE_TITLE);
    }

    @Test //Проверка кнопки "Continue".
    public void testContinueButton() {
        loginPage.openPage();
        ProductsListPage productsPage = loginPage.loginWithDefaultUser();
        CartPage cartPage = productsPage.clickCartLink();
        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
        checkoutPage.clickContinueButton();
        checkoutPage.waitMessageLoading();
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: First Name is required");
    }

    @Test //Проверка ссылки "Cart".
    public void testCartLink() {
        loginPage.openPage();
        ProductsListPage productsPage = loginPage.loginWithDefaultUser();
        CartPage cartPage = productsPage.clickCartLink();
        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
        checkoutPage.clickCartLink();
        cartPage.waitCartPageLoading();
        Assert.assertEquals(cartPage.getPageTitle(), CartPage.EXPECTED_PAGE_TITLE);
    }

    @Test //Проверка нажатия кнопки "Continue" при незаполненном поле "Zip/Postal Code".
    public void testEmptyPostalCode() {
        loginPage.openPage();
        ProductsListPage productsPage = loginPage.loginWithDefaultUser();
        CartPage cartPage = productsPage.clickCartLink();
        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
        checkoutPage.setFirstName("qwerty").setLastName("abcd").clickContinueButton();
        checkoutPage.waitErrorMessage();
        Assert.assertEquals(checkoutPage.getErrorMessage(), "Error: Postal Code is required");
    }
}
