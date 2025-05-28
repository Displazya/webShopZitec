package com.automation.framework.frontend;

import com.automation.framework.pages.MenJacketsPage;
import org.junit.jupiter.api.Test;

public class IntegrationTest extends BasePlaywrightTest {

    @Test
    void addProductToCart() {
        MenJacketsPage menJacketsPage = new MenJacketsPage(page);

        menJacketsPage.navigateToMensJackets();
        menJacketsPage.selectProteusJacket();
        menJacketsPage.selectColorOption();
        menJacketsPage.selectSizeXs();
        menJacketsPage.clickAddTocart();





/*        assertThat(createNewAccountPage.logInConfirmation(firstName)).isVisible();
        TestUtils.logMessage("User " + firstName + " successfully created and logged in");*/
    }
}
