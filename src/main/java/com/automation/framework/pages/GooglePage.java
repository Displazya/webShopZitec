package com.automation.framework.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

public class GooglePage {
    private final Page page;
    private final Locator searchInput;
    private final Locator searchButton; // Assuming there's a search button or similar element

    public GooglePage(Page page) {
        this.page = page;
        this.searchInput = page.locator("[aria-label='Search']"); // Or use "#APjFqb"
        this.searchButton = page.locator("input[name='btnK']"); // Example for Google Search button
    }

    public void navigateToGoogle() {
        page.navigate("https://www.google.com");
    }

    public void searchFor(String text) {
        searchInput.fill(text);
        searchInput.press("Enter"); // Or searchButton.click();
    }

    public String getPageTitle() {
        return page.title();
    }
}