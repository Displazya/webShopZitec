package com.automation.framework.pages;

import com.automation.framework.ConfigReader;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CreateNewAccountPage {
    private final Page page;
    private final Locator firstNameInput;
    private final Locator lastNameInput;
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator confirmPasswordInput;
    private final Locator createButton;
    private final static String createNewAccountUrl = "/customer/account/create/";


    public CreateNewAccountPage(Page page) {
        this.page = page;
        this.firstNameInput = page.locator("#firstname");
        this.lastNameInput = page.locator("#lastname");
        this.emailInput = page.locator("#email_address");
        this.passwordInput = page.locator("#password");
        this.confirmPasswordInput = page.locator("#password-confirmation");
        this.createButton = page.locator("[title='Create an Account']");
    }

    public void navigateToCreateAccountPage() {
        page.navigate(ConfigReader.getProperty("frontend.properties","frontend.homepage") + createNewAccountUrl);
    }

    public void createNewAccount(String firstName,
                                 String lastName,
                                 String email,
                                 String password
    ) {
        firstNameInput.fill(firstName);
        lastNameInput.fill(lastName);
        emailInput.fill(email);
        passwordInput.fill(password);
        confirmPasswordInput.fill(password);
    }

    public void clickCreateAccount() {
        createButton.click();
    }

    public String getCurrentUrl() {
        return page.url();
    }

    public Locator createdUserName(String expectedUsername) {
        return page.locator("div.box-content").filter(new Locator.FilterOptions().setHasText(expectedUsername));
    }
}


