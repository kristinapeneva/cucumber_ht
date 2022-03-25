package org.example.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.factory.WebDriverFactory;
import org.example.pageObject.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class BaseSteps {
    public static final Map<String, BasePage> PAGES_STORAGE = new HashMap<>();

    public static WebDriver webDriver;

    @Before
    public void initWebDriver() {
        webDriver = new WebDriverFactory().getWebDriver();
    }

    @After
    public void afterScenario() {
        webDriver.close();
        webDriver.quit();

        PAGES_STORAGE.clear();
    }
}
