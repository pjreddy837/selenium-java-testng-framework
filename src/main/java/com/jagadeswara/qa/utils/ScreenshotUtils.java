package com.jagadeswara.qa.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public final class ScreenshotUtils {
    private ScreenshotUtils() {}

    public static Path capture(WebDriver driver, String testName) throws IOException {
        Path directory = Path.of("screenshots");
        Files.createDirectories(directory);

        String safeName = testName.replaceAll("[^a-zA-Z0-9-_]", "_");
        Path destination = directory.resolve(safeName + ".png");
        Path source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE).toPath();
        return Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
    }
}
