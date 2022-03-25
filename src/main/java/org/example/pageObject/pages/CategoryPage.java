package org.example.pageObject.pages;

import org.example.pageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategoryPage extends BasePage {
    WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

    @FindBy(xpath = "//*[contains(@class,'s-main-slot ')]/div[@data-component-type='s-search-result'][1]//h2/a")
    private WebElement keyboardItem;

    public CategoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ItemPage choosingItem() {
        wait.until(ExpectedConditions.visibilityOf(keyboardItem));
        keyboardItem.click();
        return new ItemPage(webDriver);
    }

}
