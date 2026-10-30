package src.test.java.com.archana.parabank.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SeleniumPratice.SeleniumPratice.utils.BrowserFactory;
import SeleniumPratice.SeleniumPratice.utils.ConfigReader;

public class AlertsTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.getProperty("browser");
        driver = BrowserFactory.createBrowser(browser);

        driver.manage().window().maximize();
        driver.get(
            "https://the-internet.herokuapp.com/javascript_alerts"
        );
    }

    @Test
    public void verifySimpleAlert() {

        driver.findElement(
            By.xpath("//button[text()='Click for JS Alert']")
        ).click();

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(
            alert.getText(),
            "I am a JS Alert",
            "Alert message mismatch"
        );

        alert.accept();

        Assert.assertTrue(
            driver.getPageSource().contains("You successfully clicked an alert"),
            "Alert result message was not displayed"
        );

        System.out.println("Simple alert test passed!");
    }

    @Test
    public void verifyConfirmDismiss() {

        driver.findElement(
            By.xpath("//button[text()='Click for JS Confirm']")
        ).click();

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(
            alert.getText(),
            "I am a JS Confirm",
            "Confirm message mismatch"
        );

        alert.dismiss();

        Assert.assertTrue(
            driver.getPageSource().contains("You clicked: Cancel"),
            "Cancel result was not displayed"
        );

        System.out.println("Confirm dismiss test passed!");
    }

    @Test
    public void verifyPromptAlert() {

        driver.findElement(
            By.xpath("//button[text()='Click for JS Prompt']")
        ).click();

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(
            alert.getText(),
            "I am a JS prompt",
            "Prompt message mismatch"
        );

        alert.sendKeys("Selenium QA");
        alert.accept();

        Assert.assertTrue(
            driver.getPageSource().contains("You entered: Selenium QA"),
            "Prompt input result was not displayed"
        );

        System.out.println("Prompt alert test passed!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}