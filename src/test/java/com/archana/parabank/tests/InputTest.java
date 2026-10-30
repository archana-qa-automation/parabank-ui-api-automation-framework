package src.test.java.com.archana.parabank.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SeleniumPratice.SeleniumPratice.utils.BrowserFactory;
import SeleniumPratice.SeleniumPratice.utils.ConfigReader;

public class InputTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.getProperty("browser");
        driver = BrowserFactory.createBrowser(browser);

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/inputs");
    }

    @Test
    public void verifyNumberInput() {

        WebElement input = driver.findElement(By.tagName("input"));

        input.sendKeys("12345");

        Assert.assertEquals(
            input.getAttribute("value"),
            "12345",
            "Input value was not entered correctly"
        );

        input.sendKeys(Keys.CONTROL, "a");
        input.sendKeys("67890");

        Assert.assertEquals(
            input.getAttribute("value"),
            "67890",
            "Input value was not replaced correctly"
        );

        System.out.println("Input test passed!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}