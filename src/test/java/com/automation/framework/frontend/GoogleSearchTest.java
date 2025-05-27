package com.automation.framework.frontend;

import org.junit.jupiter.api.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class GoogleSearchTest extends BasePlaywrightTest {

    @Test
    void googleSearchTest() {
        page.navigate("https://www.google.com");
        assertThat(page).hasTitle("Google");

        page.locator("[aria-label='Search']").fill("Playwright");
        page.locator("[aria-label='Search']").press("Enter");

        assertThat(page).hasTitle("Playwright - Google Search");
    }
}