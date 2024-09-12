package org.opencart.test.com.web.pages;


import com.thoughtworks.gauge.Step;
import org.opencart.main.com.web.pages.BasePage;

public class BasePageSteps {
 BasePage basePage = new BasePage();

    @Step("Launch the application URL")
    public void launchTheApplication() {
        basePage.launchTheApplication();
    }

    @Step("Display a message <message>")
    public void displayMessage(String message) {
        basePage.displayAMessage(message);
    }
}
