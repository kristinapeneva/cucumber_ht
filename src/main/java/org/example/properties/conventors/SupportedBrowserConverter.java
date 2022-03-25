package org.example.properties.conventors;

import org.example.enumeration.SupportedBrowsers;

import static org.example.enumeration.SupportedBrowsers.LOCAL_CHROME;
import static org.example.enumeration.SupportedBrowsers.LOCAL_FIREFOX;


public class SupportedBrowserConverter {
    public static SupportedBrowsers valueOfWebBrowser(String webBrowser) {


        return switch (webBrowser) {


            case "local_chrome" -> LOCAL_CHROME;
            case "local_firefox" -> LOCAL_FIREFOX;
            case "remote_chrome" -> SupportedBrowsers.REMOTE_CHROME;
            default -> throw new IllegalArgumentException("No appropriate browser found");
        };
    }
}
