package org.opencart.main.com.web.pages;

import com.thoughtworks.gauge.Gauge;
import org.opencart.main.com.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends Driver {

    public static String APP_URL = System.getenv("APP_URL");
    @FindBy(xpath = "//a[@title='My Account']")
    public WebElement MyAccount;
    @FindBy(how = How.CSS, using = ".wrapper h1")
    private WebElement pageHeader;
    @FindBy(css = "button.btn-default")
    private WebElement filterBtn;
    @FindBy(css = "input [placeholder = \"Username\"]")
    private WebElement userNameField;
    @FindBy(css = "input [placeholder = \"First Name\"]")
    private WebElement firstNameField;
    @FindBy(css = "input [placeholder = \"Last Name\"]")
    private WebElement lastNameField;
    @FindBy(css = ".table-responsive:nth-child(1) tbody tr:nth-child(3)")
    private WebElement tableRecord;

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