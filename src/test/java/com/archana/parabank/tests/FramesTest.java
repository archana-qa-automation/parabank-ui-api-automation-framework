package src.test.java.com.archana.parabank.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SeleniumPratice.SeleniumPratice.utils.BrowserFactory;
import SeleniumPratice.SeleniumPratice.utils.ConfigReader;

public class FramesTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.getProperty("browser");
        driver = BrowserFactory.createBrowser(browser);

        driver.manage().window().maximize();
        driver.get(
            "https://the-internet.herokuapp.com/nested_frames"
        );
    }

    @Test
    public void verifyNestedFrames() {

        // Switch to top-level frame
        driver.switchTo().frame("frame-top");

        // Switch to the left frame inside frame-top
        driver.switchTo().frame("frame-left");

        WebElement body = driver.findElement(By.tagName("body"));

        Assert.assertEquals(
            body.getText().trim(),
            "LEFT",
            "Left frame text mismatch"
        );

        // Return to the main page
        driver.switchTo().defaultContent();

        System.out.println("Nested frames test passed!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}