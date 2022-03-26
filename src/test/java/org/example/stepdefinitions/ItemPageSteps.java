package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import org.example.pageObject.pages.ItemPage;
import org.testng.Assert;

import static org.example.stepdefinitions.BaseSteps.PAGES_STORAGE;

public class ItemPageSteps {
    @Then("The shipping country is {string} on {string}")
    public void theShippingCountryIs(String country, String pageName) {
        String actualCountry = ((ItemPage) PAGES_STORAGE.get(pageName)).getShippingCountry();
        Assert.assertTrue(actualCountry.contains(country), "The chosen shipping country isn't updated.");
    }
}
