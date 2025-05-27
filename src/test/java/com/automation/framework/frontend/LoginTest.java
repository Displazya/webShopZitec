package com.automation.framework.frontend;

import org.junit.jupiter.api.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.automation.framework.pages.LoginPage; // Import the LoginPage class
import com.automation.framework.TestUtils; // Import TestUtils for logging

public class LoginTest extends BasePlaywrightTest {

    private final String loginUrl = "https://example.com/login"; // Replace with your actual login page URL


    @Test
    void basicLoginTest() {
        LoginPage loginPage = new LoginPage(page);
        String dashboardUrl = "https://example.com/dashboard"; // Replace with the URL after successful login

        TestUtils.logMessage("Navigating to login page: " + loginUrl);
        loginPage.navigateToLoginPage(loginUrl);
        assertThat(page).hasURL(loginUrl);
        TestUtils.logMessage("Successfully navigated to login page.");

        TestUtils.logMessage("Attempting to login with testuser/testpass");
        loginPage.login("testuser", "testpass");
        TestUtils.waitFor(3000); //used here just for demo purposes

        TestUtils.logMessage("Verifying successful login.");
        assertThat(page).hasURL(dashboardUrl);
        // Example: Assert that a welcome message or dashboard element is visible
        // assertThat(loginPage.getWelcomeMessageLocator()).isVisible();
        TestUtils.logMessage("Login test completed successfully.");
    }
}