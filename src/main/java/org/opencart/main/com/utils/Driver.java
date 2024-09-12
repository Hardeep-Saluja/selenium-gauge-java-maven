package org.opencart.main.com.utils;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;

public class Driver {

    // Holds the WebDriver instance
    public static WebDriver driver;

    // Initialize a driver instance of required browser
    @BeforeSuite

    public void initializeDriver() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
    }

    // Close the driver instance
    @AfterSuite
    public void closeDriver() {
        driver.quit();
    }
}