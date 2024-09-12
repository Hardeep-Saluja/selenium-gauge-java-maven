package org.opencart.main.com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

class DriverFactory {

    // Get a new WebDriver Instance.
    public static WebDriver getDriver() {
        String browser = System.getenv("BROWSER");
        System.out.println("Browser is: "+browser);
        switch (browser.toUpperCase()) {
            case "IE":
            case "CHROME":
            case "FIREFOX":
            case "EDGE":
                String strEdgeExePath = System.getenv("EDGE_DRIVER_PATH");
                System.setProperty("webdriver.edge.driver", strEdgeExePath);
                EdgeOptions browserOptions = new EdgeOptions();
                //browserOptions.
                return new EdgeDriver(browserOptions);
            default:
                throw new RuntimeException("Unsupported browser!");
        }
    }
}