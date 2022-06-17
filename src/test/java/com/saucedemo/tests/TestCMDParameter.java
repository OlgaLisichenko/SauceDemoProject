package com.saucedemo.tests;

import com.saucedemo.User;
import com.saucedemo.pages.ProductsListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCMDParameter extends BaseTest{

    // Тест для проверки команды для пробрасывания параметра из mvn command line
    // mvn -Dtest=TestCMDParameter -Dparameter=performance_glitch_user test
    @Test
    public void testCMDParameter() {
        String name = System.getProperty("parameter");
        System.out.println("Test with parameter CMD");
        System.out.println("Parameter name: " + System.getProperty("parameter"));
        loginPage.openPage();
        loginPage.isPageOpen();
        ProductsListPage productsPage = loginPage.login(new User(name, reader.getPassword()));
        productsPage.waitProductPageLoading();
        productsPage.isPageOpen();
        Assert.assertEquals(productsPage.getPageTitle(), reader.getProductsPageTitle());
    }
}
