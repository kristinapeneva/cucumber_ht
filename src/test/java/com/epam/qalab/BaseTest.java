package com.epam.qalab;

import org.example.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected final WebDriver webDriver = new WebDriverFactory().getWebDriver();

    protected void setUpDriver() {
        webDriver.manage().window().maximize();
    }

    protected void quit() {
        webDriver.quit();
    }
}
