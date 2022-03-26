package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import org.example.pageObject.pages.CategoryPage;

import static org.example.stepdefinitions.BaseSteps.PAGES_STORAGE;

public class CategoryPageSteps {
    @And("User chooses item on {string}")
    public void userChoosesItem(String pageName) {
        PAGES_STORAGE.put("Item Page", ((CategoryPage) PAGES_STORAGE.get(pageName)).choosingItem());
    }
}
