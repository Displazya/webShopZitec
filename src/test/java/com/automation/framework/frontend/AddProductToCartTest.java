package com.automation.framework.frontend;

import com.automation.framework.TestUtils;
import com.automation.framework.pages.MenJacketsPage;
import com.automation.framework.pages.ShoppingCartPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.WaitForSelectorState;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AddProductToCartTest extends BasePlaywrightTest {

    @Test
    void addProductToCart() {
        MenJacketsPage menJacketsPage = new MenJacketsPage(page);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(page);

        menJacketsPage.navigateToMensJackets();
        menJacketsPage.selectProteusJacket();
        menJacketsPage.selectColorOption();
        menJacketsPage.selectSizeXs();
        menJacketsPage.clickAddTocart();
        assertThat(menJacketsPage.getAddedToCartMesssage()).isVisible();

        shoppingCartPage.navigateToCart();
        assertThat(menJacketsPage.getProteusJacket()).isVisible();
        TestUtils.logMessage("Product " + menJacketsPage.getProteusJacket() + " is in cart");
    }
}
