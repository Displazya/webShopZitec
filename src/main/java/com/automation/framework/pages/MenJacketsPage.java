package com.automation.framework.pages;

import com.automation.framework.ConfigReader;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

public class MenJacketsPage {
    private final Page page;
    @Getter
    private final Locator proteusJacket;
    @Getter
    private final Locator addedToCartMesssage;
    private final Locator colorOptionBlack;
    private final Locator sizeXs;
    private final Locator addToCartButton;
    private final static String mensJacketUrl = "men/tops-men/jackets-men.html";


    public MenJacketsPage(Page page) {
        this.page = page;
        //Todo improve for selectors that have nth
        this.proteusJacket = page.locator(
                "img.product-image-photo[alt='Proteus Fitness Jackshirt'][src*='mj12-orange_main_1.jpg']").nth(0);
        //this.proteusJacket = page.locator("img.product-image-photo[alt='Proteus Fitness Jackshirt'][src*='mj12-orange_main_1.jpg']");
        this.colorOptionBlack = page.locator("#option-label-color-93-item-49");
        this.sizeXs = page.locator("#option-label-size-143-item-166");
        this.addToCartButton = page.locator("#product-addtocart-button");
        this.addedToCartMesssage = page.locator("div[data-bind='html: $parent.prepareMessageForHtml(message.text)']").nth(0);
    }

    public void navigateToMensJackets() {
        page.navigate(ConfigReader.getProperty("frontend.properties", "frontend.homepage") + mensJacketUrl);
    }

    public void selectProteusJacket() {
        proteusJacket.click();
    }

    public void selectColorOption() {
        colorOptionBlack.click();
    }

    public void selectSizeXs() {
        sizeXs.click();
    }

    public void clickAddTocart() {
        addToCartButton.click();
    }

    //Todo: Idea -> add Jira improvement ticket -> Scrap products from specific category,
    // add them to a list and create a method that adds to cart a random one each time
}


