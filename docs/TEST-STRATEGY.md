# UI Automation Test Strategy

## Objective
Demonstrate a maintainable UI automation approach for core user journeys on the public SauceDemo training application.

## Scope
- Login with valid credentials.
- Reject invalid credentials.
- Add a product to the shopping cart.
- Verify cart badge and cart item details.

## Design
- Page Object Model keeps locators and page actions out of test methods.
- DriverFactory centralizes browser lifecycle and supports Chrome, Firefox and Edge.
- ConfigReader allows system properties and environment variables to override defaults.
- Explicit waits are used for key visibility and clickability conditions.
- TestNG DataProvider covers multiple invalid credential combinations.
- Failure screenshots are saved under `screenshots/`.

## Execution
Run the suite with Maven:

```bash
mvn clean test
mvn clean test -Dbrowser=firefox -Dheadless=true
mvn clean test -Dbrowser=chrome -Dheadless=false
```

## Out of scope
API, performance, security, accessibility, cross-device and production-system testing are not covered by this sample repository.
