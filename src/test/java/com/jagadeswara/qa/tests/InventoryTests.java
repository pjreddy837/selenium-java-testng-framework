package com.jagadeswara.qa.tests;

import com.jagadeswara.qa.base.BaseTest;
import com.jagadeswara.qa.driver.DriverFactory;
import com.jagadeswara.qa.pages.CartPage;
import com.jagadeswara.qa.pages.InventoryPage;
import com.jagadeswara.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryTests extends BaseTest {
    @Test
    public void userCanAddBackpackToCart() {
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(DriverFactory.getDriver());
        Assert.assertEquals(inventoryPage.getTitle(), "Products");
        inventoryPage.addBackpackToCart();

        Assert.assertEquals(inventoryPage.getCartCount(), "1",
                "Cart badge should reflect one item.");

        inventoryPage.openCart();
        CartPage cartPage = new CartPage(DriverFactory.getDriver());
        Assert.assertEquals(cartPage.getFirstItemName(), "Sauce Labs Backpack");
    }
}
