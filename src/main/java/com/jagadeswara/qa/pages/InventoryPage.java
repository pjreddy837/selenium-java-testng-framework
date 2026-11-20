package com.jagadeswara.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InventoryPage extends BasePage {
    private final By pageTitle = By.cssSelector("[data-test='title']");
    private final By firstAddToCartButton = By.cssSelector(
            "[data-test='add-to-cart-sauce-labs-backpack']");
    private final By cartBadge = By.cssSelector("[data-test='shopping-cart-badge']");
    private final By shoppingCartLink = By.cssSelector("[data-test='shopping-cart-link']");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).getText();
    }

    public void addBackpackToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(firstAddToCartButton)).click();
    }

    public String getCartCount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge)).getText();
    }

    public void openCart() {
        driver.findElement(shoppingCartLink).click();
    }
}
