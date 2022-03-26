package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.modules.DeliverToPopUpModule;
import org.testng.Assert;

import java.util.List;

import static org.example.stepdefinitions.BaseSteps.PAGES_STORAGE;

public class DeliverToModuleSteps {

    @When("User enters zipcode {string} on {string}")
    public void userEntersZipCode(String zipCode, String pageName) {
        ((DeliverToPopUpModule) PAGES_STORAGE.get(pageName)).inputZipCode(zipCode);
    }

    @And("User clicks on apply and continue buttons on {string}")
    public void clickOnApplyAndContinueButtons(String pageName) {
        ((DeliverToPopUpModule) PAGES_STORAGE.get(pageName)).applyButtonClick().continueButtonClick();
    }

    @Then("User can choose {string} from the dropdown menu of locations on {string}")
    public void countryIsOnTheListOfShippingCountries(String country, String pageName) {
        List<String> listOfCountries = ((DeliverToPopUpModule) PAGES_STORAGE.get(pageName)).getListOfCountries();
        Assert.assertTrue(listOfCountries.contains(country), "The list of countries doesn't contain the chosen country.");
    }

    @When("User chooses shipping country {string} and clicks on done button on {string}")
    public void userChoosesShippingCountryAndClicksOnDoneButton(String country, String pageName) {
        ((DeliverToPopUpModule) PAGES_STORAGE.get(pageName)).selectCountry(country).doneButtonClick();
    }

}
