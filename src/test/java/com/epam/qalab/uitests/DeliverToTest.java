package com.epam.qalab.uitests;

import com.epam.qalab.BaseTest;
import org.example.pageObject.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

public class DeliverToTest extends BaseTest {

    @BeforeTest
    public void setUp() {
        setUpDriver();
    }

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void verifyZipCode() {
        String zipCode = "37219";
        HomePage homePage = new HomePage(webDriver);
        String newLocation = homePage
                .open()
                .deliverToButtonClick()
                .inputZipCode(zipCode)
                .applyButtonClick()
                .continueButtonClick()
                .refreshPage()
                .getNewLocation();

        Assert.assertTrue(newLocation.contains("Nashville 37219"), "The 'Deliver to' location isn't updated.");
    }

    @Test
    public void polandIsPresent() {
        HomePage homePage = new HomePage(webDriver);
        List<String> listOfCountries = homePage
                .open()
                .deliverToButtonClick()
                .getListOfCountries();

        Assert.assertTrue(listOfCountries.contains("Poland"), "The list of countries doesn't contain Poland.");
    }

    @Test
    public void shippingToCountry() {
        String country = "Bulgaria";
        HomePage homePage = new HomePage(webDriver);
        String shippingCountry = homePage
                .open()
                .deliverToButtonClick()
                .selectCountry(country)
                .doneButtonClick()
                .refreshPage()
                .choosingCategory()
                .choosingItem()
                .getShippingCountry();

        Assert.assertTrue(shippingCountry.contains(country), "The chosen shipping country isn't updated.");
    }

    @AfterMethod
    public void preparePage() {
        webDriver.navigate().refresh();
    }

}
