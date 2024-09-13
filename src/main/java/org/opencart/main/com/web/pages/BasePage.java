package org.opencart.main.com.web.pages;

import com.thoughtworks.gauge.Gauge;
import org.opencart.main.com.utils.Driver;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends Driver {

    public static String APP_URL = System.getenv("APP_URL");

    public BasePage() {
        PageFactory.initElements(driver, this);
    }

    public void launchTheApplication() {
        driver.get(APP_URL);
    }

    public void displayAMessage(String message) {
        Gauge.writeMessage(message);
    }
}