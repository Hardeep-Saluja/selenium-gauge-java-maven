package org.opencart.test.com.web.pages;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import org.opencart.main.com.web.pages.BasePage;
import org.opencart.main.com.web.pages.CustomerSignup;

public class CustomerSignupSteps extends BasePage {
    CustomerSignup signUp = new CustomerSignup();

    @Step("Sign up as <customer> with email <customer@example.com> and <password>")
    public void registerCustomerWith(String customer, String email, String password) {
        signUp.registerCustomerWith(customer, email, password);
    }

    @Step("Sign up as new customer using <table>")
    public void registerCustomerWith(Table table) {
        signUp.registerCustomerWith(table);
    }
}