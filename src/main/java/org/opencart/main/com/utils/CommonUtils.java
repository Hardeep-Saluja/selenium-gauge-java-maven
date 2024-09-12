package org.opencart.main.com.utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class CommonUtils extends Driver{

    public static String getMessage(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    public static void clickButton(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public static void enterTextInTextBox(WebElement element, String txt){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(element));
        if(element.isEnabled()){
            element.click();
            element.clear();
            element.sendKeys(txt);
        }else{
            System.out.println("Element is NOT enabled");
        }
    }

    public static void enterDigitsInTextBox(WebElement element, int digit){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(element));
        if(element.isEnabled()){
            element.click();
            element.sendKeys(Keys.CONTROL + "a");
            element.sendKeys(Keys.DELETE);
            element.sendKeys(String.valueOf(generateRandomDigits(digit)));
        }else{
            System.out.println("Element is NOT enabled");
        }
    }

    public static void selectCheckBox(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(element));
        if(!element.isSelected()){
            element.click();
        }else{
            System.out.println("Element is NOT enabled");
        }
    }

    public static int generateRandomDigits(int n){
        int m = (int) Math.pow(10, n-1);
        return m + new Random().nextInt(9*m);
    }
}
