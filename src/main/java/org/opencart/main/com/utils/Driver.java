package org.opencart.main.com.utils;

import com.thoughtworks.gauge.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class Driver {

    private static final Logger logger = Logger.getLogger(Driver.class.getName());
    // Holds the WebDriver instance
    public static WebDriver driver;
    // Initialize a driver instance of required browser

    @BeforeScenario

    public static void initializeDriver() {
        if (driver == null) {
            logger.info(Driver.class.getName() + " ***** Before Scenario Initialize Driver *****");
            driver = DriverFactory.getDriver();
            driver.manage().window().maximize();
        } else {
            logger.info(" ***** Before Scenario Driver Already Initialized *****");
        }
    }

    @AfterScenario
    public WebDriver closeDriver() {
        logger.info(Driver.class.getName() + " ***** After Scenario Close Driver *****");
        try {
            if (driver != null) {
                driver.close();
                logger.info(Driver.class.getName() + " ***** Close Driver *****");
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return driver = null;
    }

    // Kill the driver instance
    @AfterSuite
    public void killEdgeDriver() {
        try {
            if (driver != null) {
                driver.quit();
                logger.info(Driver.class.getName() + " ***** Quit Driver *****");
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    @AfterStep()
    public void screenshot(ExecutionContext context) {
        try {
            if (context.getCurrentStep().getIsFailing() || System.getenv("screenshot_for_all").equalsIgnoreCase("true")) {
                CommonUtils.pauseFor(1000);
                takesScreenshot(String.valueOf(System.currentTimeMillis()));
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

    private void takesScreenshot(String pictureName) {
        try {
            String fileName = "images/" + pictureName + ".png";
            File file = new File(System.getenv("gauge_reports_dir") + "/html-report/" + fileName);
            if (file.exists()) {
                file.delete();
            }
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, file);
            Gauge.writeMessage("<a href='../" + fileName + "'><img src='../" + fileName + "' width='800' height='480'></a>");
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
    }
}