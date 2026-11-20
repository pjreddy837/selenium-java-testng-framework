package com.jagadeswara.qa.base;

import com.jagadeswara.qa.config.ConfigReader;
import com.jagadeswara.qa.driver.DriverFactory;
import com.jagadeswara.qa.utils.ScreenshotUtils;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverFactory.initializeDriver();
        DriverFactory.getDriver().get(ConfigReader.baseUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        WebDriver driver;
        try {
            driver = DriverFactory.getDriver();
            if (result.getStatus() == ITestResult.FAILURE) {
                try {
                    ScreenshotUtils.capture(driver, result.getMethod().getMethodName());
                } catch (IOException exception) {
                    System.err.println("Could not save failure screenshot: " + exception.getMessage());
                }
            }
        } catch (IllegalStateException ignored) {
            // Driver initialization failed; nothing to clean up.
        } finally {
            DriverFactory.quitDriver();
        }
    }
}
