package com.jagadeswara.qa.tests;

import com.jagadeswara.qa.base.BaseTest;
import com.jagadeswara.qa.config.ConfigReader;
import com.jagadeswara.qa.pages.InventoryPage;
import com.jagadeswara.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void validUserCanLogin() {
        LoginPage loginPage = new LoginPage(
                com.jagadeswara.qa.driver.DriverFactory.getDriver());
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(
                com.jagadeswara.qa.driver.DriverFactory.getDriver());
        Assert.assertEquals(inventoryPage.getTitle(), "Products",
                "User should land on the Products page after login.");
    }

    @Test(dataProvider = "invalidCredentials")
    public void invalidUserCannotLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(
                com.jagadeswara.qa.driver.DriverFactory.getDriver());
        loginPage.login(username, password);

        Assert.assertTrue(loginPage.getErrorMessage().contains(
                        "Username and password do not match"),
                "An explanatory login error should be displayed.");
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() {
        return new Object[][] {
                {"invalid_user", "wrong_password"},
                {"standard_user", "wrong_password"}
        };
    }
}
