package src.test.java.com.archana.parabank.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SeleniumPratice.SeleniumPratice.utils.BrowserFactory;
import SeleniumPratice.SeleniumPratice.utils.ConfigReader;

public class DynamicLoadingTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.getProperty("browser");
        driver = BrowserFactory.createBrowser(browser);

        driver.manage().window().maximize();
        driver.get(
            "https://the-internet.herokuapp.com/dynamic_loading/1"
        );
    }

    @Test
    public void verifyDynamicLoading() {

        driver.findElement(By.cssSelector("#start button")).click();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement result = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("finish")
            )
        );

        Assert.assertEquals(
            result.getText().trim(),
            "Hello World!",
            "Dynamic loading result mismatch"
        );

        System.out.println("Dynamic loading test passed!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}