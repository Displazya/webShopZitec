package com.automation.framework.frontend;

import com.automation.framework.ConfigReader;
import com.automation.framework.TestUtils;
import com.automation.framework.pages.CreateNewAccountPage;
import com.automation.framework.pages.MenJacketsPage;
import com.automation.framework.pages.ShoppingCartPage;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class IntegrationTest extends BasePlaywrightTest {

    @Test
    void integrationTest() {
        MenJacketsPage menJacketsPage = new MenJacketsPage(page);
        CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage(page);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(page);


        //Verify homepage
        page.navigate(ConfigReader.getProperty("frontend.properties","frontend.homepage"));
        assertThat(page).hasTitle("Home Page");

        //Create a new customer and verify that is logged in
        String firstName = TestUtils.generateRandomString();
        String lastName = TestUtils.generateRandomString();
        String email = TestUtils.generateRandomString("test@", ".com");
        String password = TestUtils.uuidGenerator();

        createNewAccountPage.navigateToCreateAccountPage();
        createNewAccountPage.createNewAccount(firstName, lastName, email, password);
        createNewAccountPage.clickCreateAccount();
        assertThat(page).hasURL(createNewAccountPage.getCurrentUrl());

        assertThat(createNewAccountPage.createdUserName(firstName)).isVisible();
        TestUtils.logMessage("User " + firstName + " successfully created and logged in");

        //Add Proteus Jacket to cart and verify it
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
