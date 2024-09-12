package org.opencart.main.com.web.pages;

import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.junit.Assert;
import org.opencart.main.com.utils.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CustomerSignup extends BasePage {


    @FindBy(xpath = "//a[@title='My Account']")
    public WebElement linkMyAccount;
    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/li/a[contains(text(),'Register')]")
    public WebElement linkRegister;
    @FindBy(name = "firstname")
    public WebElement firstNameField;
    @FindBy(how = How.CSS, using = ".wrapper h1")
    private WebElement pageHeader;
    @FindBy(css = "button.btn-default")
    private WebElement filterBtn;
    @FindBy(name = "lastname")
    private WebElement lastNameField;
    @FindBy(id = "input-email")
    private WebElement emailId;
    @FindBy(id = "input-telephone")
    private WebElement inputTelephoneNum;
    @FindBy(id = "input-password")
    private WebElement passwordField;
    @FindBy(id = "input-confirm")
    private WebElement confirmPasswordField;
    @FindBy(xpath = "//input[@type ='checkbox'][@name='agree']")
    private WebElement chkBxPrivacyPolicy;
    @FindBy(xpath = "//input[@type ='submit'][@value='Continue']")
    private WebElement btnContinue;
    @FindBy(xpath = "//div[@id='content']")
    private WebElement txtSuccessMsg;
    @FindBy(css = ".table-responsive:nth-child(1) tbody tr:nth-child(3)")
    private WebElement tableRecord;
    public static final String SIGN_UP_SUCCESS_MSG = "Your Account Has Been Created!\n" +
            "Congratulations! Your new account has been successfully created!\n" +
            "You can now take advantage of member privileges to enhance your online shopping experience with us.\n" +
            "If you have ANY questions about the operation of this online shop, please e-mail the store owner.\n" +
            "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";

    public void registerCustomerWith(Table table) {
        for (TableRow row : table.getTableRows()) {
            CommonUtils.clickButton(linkMyAccount);
            CommonUtils.clickButton(linkRegister);
            CommonUtils.enterTextInTextBox(firstNameField, row.getCell("FIRST NAME"));
            CommonUtils.enterTextInTextBox(lastNameField, row.getCell("LAST NAME"));
            CommonUtils.enterTextInTextBox(emailId, row.getCell("EMAIL ID"));
            CommonUtils.enterDigitsInTextBox(inputTelephoneNum, 10);
            CommonUtils.enterTextInTextBox(passwordField, row.getCell("PASSWORD"));
            CommonUtils.enterTextInTextBox(confirmPasswordField, row.getCell("PASSWORD"));
            CommonUtils.selectCheckBox(chkBxPrivacyPolicy);
            CommonUtils.clickButton(btnContinue);
            Assert.assertEquals("SUCCESS MESSAGE IS NOT AS EXPECTED", SIGN_UP_SUCCESS_MSG, CommonUtils.getMessage(txtSuccessMsg));
        }
    }

    public void registerCustomerWith(String customer, String email, String password) {
        CommonUtils.clickButton(linkMyAccount);
        CommonUtils.clickButton(linkRegister);
        CommonUtils.enterTextInTextBox(firstNameField, customer.toUpperCase() + " FIRST NAME");
        CommonUtils.enterTextInTextBox(lastNameField, customer.toUpperCase() + " LAST NAME");
        CommonUtils.enterTextInTextBox(emailId, email);
        CommonUtils.enterDigitsInTextBox(inputTelephoneNum, 10);
        CommonUtils.enterTextInTextBox(passwordField, password);
        CommonUtils.enterTextInTextBox(confirmPasswordField, password);
        CommonUtils.selectCheckBox(chkBxPrivacyPolicy);
        CommonUtils.clickButton(btnContinue);
        //Assert.assertEquals("SUCCESS MESSAGE IS NOT AS EXPECTED", SIGN_UP_SUCCESS_MSG, CommonUtils.getMessage(txtSuccessMsg));
    }
}