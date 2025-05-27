package com.automation.framework.frontend;

import com.automation.framework.TestUtils;
import com.automation.framework.pages.CreateNewAccountPage;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CreateNewCustomer extends BasePlaywrightTest {

    @Test
    void createNewCustomer() {
        CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage(page);
        String firstName = TestUtils.generateRandomString();
        String lastName = TestUtils.generateRandomString();
        String email = TestUtils.generateRandomString("test@", ".com");
        String password = TestUtils.uuidGenerator();

        createNewAccountPage.navigateToCreateAccountPage();
        createNewAccountPage.createNewAccount(firstName, lastName, email, password);
        createNewAccountPage.clickCreateAccount();
        assertThat(page).hasURL(createNewAccountPage.getCurrentUrl());

        assertThat(createNewAccountPage.logInConfirmation(firstName));
        TestUtils.logMessage("User " + firstName + " successfully created and logged in");
    }
}
