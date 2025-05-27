# Automation Framework

This project provides an automation framework built with Java 21, Playwright for frontend testing, and Rest Assured for backend testing. Maven is used as the build tool.


## Prerequisites

*   Java Development Kit (JDK) 21 or higher
*   Maven 3.6.0 or higher
*   **Lombok Plugin for IDE:** If using IntelliJ IDEA, install the Lombok plugin to ensure proper IDE support (no red squigglies, correct autocompletion).

## Setup

1.  **Clone the repository:**
    ```bash
    git clone <repository_url>
    cd automation-framework
    ```
2.  **Install Playwright browsers:**
    After the first Maven build, Playwright will download the necessary browser binaries. If you need to manually install them, you can run:
    ```bash
    mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install"
    ```
3.  **Build the project:**
    ```bash
    mvn clean install
    ```

## Running Tests

### Run all tests

To run all tests (frontend and backend), execute the following Maven command:

```bash
mvn clean test
```

### Run specific frontend tests

To run only frontend tests, you can use the `test` goal with a specific test class:

```bash
mvn test -Dtest=GoogleSearchTest
mvn test -Dtest=GoogleSearchTestNew
mvn test -Dtest=LoginTest
```

### Run specific backend tests

To run only backend tests, you can use the `test` goal with a specific test class:

```bash
# Example: If you had a BackendSampleTest.java
# mvn test -Dtest=BackendSampleTest
```

## Framework Components

### Core Utilities

*   **`ConfigReader.java`**: A utility class to read properties from `frontend.properties` file, providing a centralized way to manage configurations.
*   **`TestUtils.java`**: A utility class containing common helper methods like `logMessage` and `waitFor` for use across test cases.

### Frontend Testing (Playwright)

*   **`BasePlaywrightTest.java`**: This class initializes and tears down Playwright, Browser, and Page objects for each frontend test. It ensures a clean browser instance for every test.
*   **Page Object Model (POM)**:
    *   **`GooglePage.java`**: Represents the Google search page, encapsulating its elements and actions.
    *   **`LoginPage.java`**: Represents a generic login page, encapsulating its elements and login actions. **Remember to update placeholder selectors and URLs in this class to match your application.**
*   **Sample Test Cases:**
    *   **`GoogleSearchTest.java`**: A sample frontend test demonstrating how to navigate to Google, perform a search, and assert the page title.
    *   **`GoogleSearchTestNew.java`**: An updated sample frontend test demonstrating Google search, incorporating `TestUtils` and `GooglePage` for better structure and logging.
    *   **`LoginTest.java`**: A basic login test case demonstrating navigation to a login page, filling credentials, and asserting successful login, utilizing `LoginPage` and `TestUtils`.

### Backend Testing (Rest Assured)

*   **`BaseApiTest.java`**: This class sets up the base URI for API requests using Rest Assured. You can extend this class to add common headers, authentication, or other request specifications for your API tests.

## Extending the Framework

*   Add HTML test reports via surefire?
*   Expand logging