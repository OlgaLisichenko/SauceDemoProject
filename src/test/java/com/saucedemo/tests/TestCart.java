package com.saucedemo.tests;

import com.saucedemo.tests.base.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCart extends BaseTest {

    @Test(description = "Clicking 'Continue Shopping' button")
    @Description("Check of clicking 'Continue Shopping' button and opening Products page")
    public void testContinueShoppingButton() {
        cartPageSteps.openingCartPage();
        cartPage.clickContinueShoppingButton();
        productsPage.isPageOpen();

        Assert.assertEquals(productsPage.getPageTitle(), reader.getProductsPageTitle());
    }

    @Test(description = "Clicking 'Checkout' button")
    @Description("Check of clicking 'Checkout' button and opening Checkout page")
    public void testCheckoutButton() {
        checkoutPageSteps.openingCheckoutPage();

        Assert.assertEquals(checkoutPage.getPageTitle(), reader.getCheckoutPageTitle());
    }

    @Test(description = "Adding and removing item")
    @Description("Check adding and removing item in cart")
    public void testAddRemoveItem() {
        loginSteps.loginWithStandardUser();

        String expectedProductName = productsPage.getName(5);
        String expectedDescription = productsPage.getDescription(5);
        String expectedPrice = productsPage.getPrice(5);

        productsPage.clickAddToCart(5);

        Assert.assertEquals(productsPage.numberCartBadge(), "1");  //Checking the display of the number of products in the basket

        productsPage.clickCartLink();
        cartPage.isPageOpen();

        Assert.assertEquals(cartPage.getName(), expectedProductName);       //Checking the correctness of the display of the product name
        Assert.assertEquals(cartPage.getDescription(), expectedDescription);//Checking whether the product description is displayed correctly
        Assert.assertEquals(cartPage.getPrice(), expectedPrice);            //Checking the correctness of the display of the product price

        cartPage.clickRemoveButton(0);

        Assert.assertEquals(cartPage.getSizeProductList(),0); //Checking the absence of an item in the cart after it is deleted
    }
}
