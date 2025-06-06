# Automation Framework for Zitec

Automation framework built with Java 21, Playwright for fronend and Rest Assured for backend API testing. Maven is used as build tool and Lombok.

## Key Features

*   **Frontend Testing:** Playwright for browser automation
*   **Backend API Testing:** Rest Assured for testing RESTful APIs
*   **Configurable Environment:** Properties file for backend and frontend variables
*   **Structured Payloads:** Java objects with Lombok

## Prerequisites

*   Java 21
*   Maven 3.6.0
*   Lombok Plugin

## Setup

1.  **Clone the repository:**
    ```bash
    git clone git@github.com:Displazya/webShopZitec.git
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
    **Note:** Test execution is skipped during `mvn clean install` by default.

## Running Tests

### Run all tests

To run all tests (frontend and backend), execute the following Maven command:

```bash
mvn clean test
```


## Framework Components

### Core Utilities

*   [`ConfigReader.java`](src/main/java/com/automation/framework/ConfigReader.java): Utility for reading properties
*   [`TestUtils.java`](src/main/java/com/automation/framework/TestUtils.java): Util methods


### Page Objects (Frontend)

*   [`CreateNewAccountPage.java`](src/main/java/com/automation/framework/pages/CreateNewAccountPage.java)
*   [`MenJacketsPage.java`](src/main/java/com/automation/framework/pages/MenJacketsPage.java)
*   [`ShoppingCartPage.java`](src/main/java/com/automation/framework/pages/ShoppingCartPage.java)

### API Payloads

*   [`CustomerPayload.java`](src/main/java/com/automation/framework/payloads/CustomerPayload.java): Java object for customer

### Test Cases

*   **Frontend Examples:**
    *   `AddProductToCartTest.java`
    *   `CreateNewCustomerTest.java`
    *   `IntegrationTest.java`
*   **Backend Examples:**
    *   `CreateApiCustomerTest.java`: Focuses on creating a new API customer.

## Configuration Files

*   [`frontend.properties`](src/main/resources/frontend.properties): Browser mode, homepage, etc
*   [`backend.properties`](src/main/resources/backend.properties): Base URL, token

## Extending the Framework

*   **Add HTML test reports:** 
*   **Expand logging:** Maybe add logging library? Log4J or?
*   **Implement retry mechanisms:** Maybe retry method/logic for front end
*   **Integrate CI/CD:** Set up Jenkins file 
*   **Improve username/email/pwd generators** 
*   **Confluence** Add confluence link with usage, clean code practices, examples, etc