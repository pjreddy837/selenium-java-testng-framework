# Selenium Java TestNG Automation Framework

A sample UI automation framework built with **Java 17, Selenium WebDriver, TestNG and Maven**. It demonstrates a practical Page Object Model structure, reusable browser setup, explicit waits, data-driven tests, failure screenshots and GitHub Actions CI.

[![Selenium TestNG CI](https://github.com/pjreddy837/selenium-java-testng-framework/actions/workflows/test.yml/badge.svg)](https://github.com/pjreddy837/selenium-java-testng-framework/actions/workflows/test.yml)

## Technology stack

| Tool | Purpose |
|---|---|
| Java 17 | Programming language |
| Selenium WebDriver 4 | Browser automation |
| TestNG | Test execution, assertions and DataProvider |
| Maven | Build and dependency management |
| WebDriverManager | Browser driver setup |
| GitHub Actions | Continuous integration |

## Project structure

```text
src/
├── main/java/com/jagadeswara/qa/
│   ├── config/       # Runtime configuration
│   ├── driver/       # WebDriver lifecycle
│   ├── pages/        # Page Object classes
│   └── utils/        # Screenshot utility
└── test/
    ├── java/com/jagadeswara/qa/
    │   ├── base/     # Test setup and teardown
    │   └── tests/    # TestNG test classes
    └── resources/
        └── test-data/
docs/                 # Test strategy and scope
.github/workflows/    # CI pipeline
pom.xml
testng.xml
```

## Scenarios covered

- Successful login using the public demo account.
- Login rejection for invalid credentials using a TestNG DataProvider.
- Add a product to the cart and verify the cart badge.
- Verify the item name on the cart page.

The tests run against [SauceDemo](https://www.saucedemo.com/), a public demonstration application. This repository is a portfolio/sample project, not evidence of testing on a production client system.

## Prerequisites

- JDK 17 or newer
- Maven 3.8+
- Chrome, Firefox or Edge browser

Check your setup:

```bash
java -version
mvn -version
```

## Run locally

Clone the repository and execute:

```bash
git clone https://github.com/pjreddy837/selenium-java-testng-framework.git
cd selenium-java-testng-framework
mvn clean test
```

Choose a browser:

```bash
mvn clean test -Dbrowser=chrome -Dheadless=false
mvn clean test -Dbrowser=firefox -Dheadless=true
mvn clean test -Dbrowser=edge -Dheadless=true
```

Chrome headless mode is enabled by default. WebDriverManager resolves the matching browser driver.

## Reports and screenshots

TestNG/Surefire reports are generated under:

```text
target/surefire-reports/
```

When a test fails after the browser has initialized, a screenshot is saved under:

```text
screenshots/
```

## Continuous integration

The GitHub Actions workflow runs on pushes to `main`, pull requests targeting `main`, and manual dispatch. It sets up Java 17, runs the Maven TestNG suite in headless Chrome, and uploads test reports/screenshots as workflow artifacts.

## Engineering notes

- Keep page locators and page actions inside Page Objects.
- Prefer explicit waits over fixed sleeps.
- Keep test data and environment configuration separate from test logic.
- Do not commit passwords, access tokens or production data.
- Add independent tests for checkout, sorting, filtering and negative flows as the suite grows.

## License

This project is licensed under the MIT License. See [LICENSE](LICENSE).
