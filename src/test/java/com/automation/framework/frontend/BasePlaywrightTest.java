package com.automation.framework.frontend;

import com.automation.framework.ConfigReader;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BasePlaywrightTest {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    private static final String headless = ConfigReader.getProperty(
            "frontend.properties",
            "frontend.browser.headless");

    @BeforeEach
    void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(headless)));
        page = browser.newPage();
    }

    @AfterEach
    void teardown() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}