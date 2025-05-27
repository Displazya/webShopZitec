package com.automation.framework.frontend;

import org.junit.jupiter.api.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.automation.framework.TestUtils;
import com.automation.framework.pages.GooglePage; // Import the GooglePage class

public class GoogleSearchTestNew extends BasePlaywrightTest {

    @Test
    void googleSearchForTest() {
        GooglePage googlePage = new GooglePage(page);

        TestUtils.logMessage("Navigating to Google.com");
        googlePage.navigateToGoogle();
        assertThat(page).hasTitle("Google");
        TestUtils.logMessage("Successfully navigated to Google.com");

        // Note: The accept all button click might be specific to your locale/session.
        // For a robust solution, consider handling cookies/consent in BasePlaywrightTest or a dedicated utility.
        // page.locator("#W0wltc > div").click();
        // TestUtils.logMessage("Clicked on accept all button");

        TestUtils.logMessage("Searching for 'test'");
        googlePage.searchFor("test");
        TestUtils.waitFor(2000); // used here just for demo purposes

        assertThat(page).hasTitle("test - Google Search"); // Updated assertion for typical Google search result title
        TestUtils.logMessage("Search for 'test' completed successfully.");
    }
}