package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.pageObject.modules.DeliverToPopUpModule;
import org.example.pageObject.pages.HomePage;
import org.testng.Assert;

import static org.example.stepdefinitions.BaseSteps.PAGES_STORAGE;
import static org.example.stepdefinitions.BaseSteps.webDriver;

public class HomePageSteps {


        @Given("User is on {string}")
        public void userIsOnHomePage(String pageName) {
            HomePage homePage = new HomePage(webDriver);
            PAGES_STORAGE.put(pageName, homePage);
            homePage.open();
        }

        @And("User clicks on deliver to button on {string}")
        public void clickOnDeliverToButton(String pageName) {

            PAGES_STORAGE.put("Deliver To Module", ((HomePage) PAGES_STORAGE.get(pageName)).deliverToButtonClick());
        }

        @When("User enters zipcode {string} on {string}")
        public void userEntersZipCode(String zipCode, String pageName) {
            ((DeliverToPopUpModule) PAGES_STORAGE.get(pageName)).inputZipCode(zipCode);
        }


        @And("User clicks on apply and continue buttons on {string}")
        public void clickOnApplyAndContinueButtons(String pageName) {
            ((DeliverToPopUpModule) PAGES_STORAGE.get(pageName)).applyButtonClick().continueButtonClick();
        }


        @And("The {string} is refreshed")
        public void refreshHomePage(String pageName) {
            ((HomePage) PAGES_STORAGE.get(pageName)).refreshPage();
        }


        @Then("The new location contains {string} on {string}")
        public void userGetsErrorMessage(String newLocation, String pageName) {
            String changedLocation = ((HomePage) PAGES_STORAGE.get(pageName)).getNewLocation();
            Assert.assertTrue(changedLocation.contains(newLocation));
        }

}
