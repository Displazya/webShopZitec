# Automation Framework for Zitec

This project provides an automation framework built with Java 21, Playwright for frontend testing, and hopefully Rest Assured for backend testing. Maven is used as the build tool.


## Prerequisites

*   Java Development Kit (JDK) 21 or higher
*   Maven 3.6.0 or higher
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

## Running Tests

### Run all tests

To run all tests (frontend and backend), execute the following Maven command:

```bash
mvn clean test
```

### Run specific frontend tests

To run only frontend tests, you can use the `test` goal with a specific test class:

```bash
mvn test -Dtest=CreateNewCustomer
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

*  To add

## Extending the Framework

*   Add HTML test reports via surefire?
*   Expand logging