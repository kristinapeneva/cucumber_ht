package org.example.pageObject.pages;

import org.example.pageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BasePage {
    @FindBy(xpath = "//*[@id='contextualIngressPtLabel_deliveryShortLine']")
    private WebElement depositToInfo;

    public ItemPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getShippingCountry() {
        String shippingCountry = depositToInfo.getText();
        return shippingCountry;
    }

}
