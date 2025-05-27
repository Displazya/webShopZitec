package com.automation.framework.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import lombok.Data;

public class LoginPage {
    private final Page page;
    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator loginButton;

    public LoginPage(Page page) {
        this.page = page;
        this.usernameInput = page.locator("#username"); // Replace with actual selector
        this.passwordInput = page.locator("#password"); // Replace with actual selector
        this.loginButton = page.locator("#loginButton"); // Replace with actual selector
    }

    public void navigateToLoginPage(String url) {
        page.navigate(url);
    }

    public void login(String username, String password) {
        usernameInput.fill(username);
        passwordInput.fill(password);
        loginButton.click();
    }

    public String getCurrentUrl() {
        return page.url();
    }
}