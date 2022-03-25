package org.example.invoker.implementations;

import org.example.invoker.WebDriverInvoker;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteChromeInvoker implements WebDriverInvoker {
    @Override
    public WebDriver invokeWebDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.WINDOWS);
        capabilities.setBrowserName("chrome");

        try {
            return new RemoteWebDriver(new URL(" http://EPUAKHAW0AC5:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e.getMessage(), e.getCause());
        }
    }
}
