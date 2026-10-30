package src.test.java.com.archana.parabank.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.Logger;

import SeleniumPratice.SeleniumPratice.pages.LoginPage;
import SeleniumPratice.SeleniumPratice.utils.LogUtils;

public class LoginTest {

    private static final Logger logger =
            LogUtils.getLogger();

    public static void main(String[] args) {

        WebDriver driver = null;

        try {
            logger.info("Login test started");

            driver = new ChromeDriver();
            logger.info("Chrome browser launched successfully");

            driver.manage().window().maximize();

            driver.get("https://the-internet.herokuapp.com/login");
            logger.info("Login page opened successfully");

            LoginPage loginPage = new LoginPage(driver);

            loginPage.login("tomsmith", "SuperSecretPassword!");
            logger.info("Login action executed");

            logger.info("Current URL: {}", driver.getCurrentUrl());
            logger.info("Page Title: {}", driver.getTitle());

        } catch (Exception e) {
            logger.error("Login test failed", e);
            throw e;

        } finally {
            if (driver != null) {
                driver.quit();
                logger.info("Browser closed successfully");
            }
        }
    }
}