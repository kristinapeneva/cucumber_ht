package org.example.pageObject.modules;

import org.example.pageObject.BasePage;
import org.example.pageObject.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DeliverToPopUpModule extends BasePage {
    WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

    @FindBy(id = "GLUXZipUpdateInput")
    private WebElement zipCodeField;

    @FindBy(xpath = "//*[@data-action='GLUXPostalUpdateAction']")
    private WebElement applyButton;

    @FindBy(xpath = "//div[@class='a-popover-footer']//input[@id='GLUXConfirmClose']")
    private WebElement continueButton;

    @FindBy(xpath = "//span[@class='a-dropdown-container']")
    private WebElement dropDownContainer;

    @FindBy(xpath = "//select[@class='a-native-dropdown']")
    private WebElement select;

    @FindBy(xpath = "//button[@name='glowDoneButton']")
    private WebElement doneButton;

    public DeliverToPopUpModule(WebDriver webDriver) {
        super(webDriver);
    }

    public DeliverToPopUpModule inputZipCode(String zipCode) {
        wait.until(ExpectedConditions.visibilityOf(zipCodeField));
        zipCodeField.sendKeys(zipCode);
        return this;
    }

    public DeliverToPopUpModule applyButtonClick() {
        applyButton.click();
        return this;
    }

    public HomePage continueButtonClick() {
        wait.until(ExpectedConditions.visibilityOf(continueButton));
        continueButton.click();
        return new HomePage(webDriver);
    }

    public List<String> getListOfCountries() {
        wait.until(ExpectedConditions.elementToBeClickable(dropDownContainer));
        Select dropdown = new Select(select);
        List<String> list = new ArrayList<>();
        for (WebElement element: dropdown.getOptions()) {
            list.add(element.getText());
        }
        return list;
    }

    public DeliverToPopUpModule selectCountry(String country) {
        wait.until(ExpectedConditions.elementToBeClickable(dropDownContainer));
        Select dropdown = new Select(select);
        dropdown.selectByVisibleText(country);
        return this;
    }

    public HomePage doneButtonClick() {
        this.doneButton.click();
        return new HomePage(webDriver);
    }
}
