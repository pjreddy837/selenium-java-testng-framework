package com.jagadeswara.qa.config;

public final class ConfigReader {
    private ConfigReader() {}

    public static String get(String key, String defaultValue) {
        String systemValue = System.getProperty(key);
        if (systemValue != null && !systemValue.isBlank()) {
            return systemValue;
        }

        String environmentValue = System.getenv(key.toUpperCase().replace('.', '_'));
        return environmentValue == null || environmentValue.isBlank()
                ? defaultValue
                : environmentValue;
    }

    public static String baseUrl() {
        return get("baseUrl", "https://www.saucedemo.com/");
    }

    public static String browser() {
        return get("browser", "chrome");
    }

    public static boolean headless() {
        return Boolean.parseBoolean(get("headless", "true"));
    }
}
