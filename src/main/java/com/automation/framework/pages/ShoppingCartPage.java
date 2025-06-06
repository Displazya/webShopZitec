package com.automation.framework.pages;

import com.automation.framework.ConfigReader;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ShoppingCartPage {
    private final Page page;
    private final Locator proteusJacket;
    private final Locator proceedToCheckout;
    private final static String cartUrl = "/checkout/cart/";


    public ShoppingCartPage(Page page) {
        this.page = page;
        this.proteusJacket = page.locator("[alt='Proteus Fitness Jackshirt']");
        this.proceedToCheckout = page.locator("text=Proceed to Checkout");
    }

    public void navigateToCart() {
        page.navigate(ConfigReader.getProperty("frontend.properties","frontend.homepage") + cartUrl);
    }

    public void clickProceedToCheckout() {
        proceedToCheckout.click();
    }
}


