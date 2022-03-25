package org.example.enumeration;

import org.example.invoker.WebDriverInvoker;
import org.example.invoker.implementations.LocalChromeInvoker;
import org.example.invoker.implementations.LocalFirefoxInvoker;
import org.example.invoker.implementations.RemoteChromeInvoker;
import org.openqa.selenium.WebDriver;

public enum SupportedBrowsers {
    LOCAL_FIREFOX(new LocalFirefoxInvoker()),
    LOCAL_CHROME(new LocalChromeInvoker()),
    REMOTE_CHROME(new RemoteChromeInvoker());


    private WebDriverInvoker webDriverInvoker;

    SupportedBrowsers(WebDriverInvoker webDriverInvoker) {
        this.webDriverInvoker = webDriverInvoker;
    }

    public WebDriver getWebDriver() {
        return webDriverInvoker.invokeWebDriver();
    }
}
