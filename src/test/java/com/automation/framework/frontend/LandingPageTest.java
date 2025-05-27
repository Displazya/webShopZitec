package com.automation.framework.frontend;

import com.automation.framework.ConfigReader;
import com.automation.framework.TestUtils;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LandingPageTest extends BasePlaywrightTest {

    @Test
    void verifyLandingPage() {
        page.navigate(ConfigReader.getProperty("frontend.homepage"));
        assertThat(page).hasTitle("Home Page");

        //String randomUsername = TestUtils.generateRandomUsername("test", 10);
        //System.out.println(randomUsername);

        String randomUUID = TestUtils.uuidGenerator();
        System.out.println(randomUUID);

    }
}
