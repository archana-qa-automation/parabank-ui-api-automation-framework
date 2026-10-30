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

public class DynamicControlsTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.createBrowser(
            ConfigReader.getProperty("browser")
        );

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void verifyCheckboxRemoveAndAdd() {

        driver.findElement(By.id("checkbox")).isDisplayed();

        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        wait.until(
            ExpectedConditions.invisibilityOfElementLocated(
                By.id("checkbox")
            )
        );

        Assert.assertTrue(
            driver.findElement(By.id("message")).getText()
                .contains("It's gone!")
        );

        driver.findElement(By.xpath("//button[text()='Add']")).click();

        wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("checkbox")
            )
        );

        Assert.assertTrue(
            driver.findElement(By.id("checkbox")).isDisplayed()
        );

        System.out.println("Checkbox remove/add test passed!");
    }

    @Test
    public void verifyInputEnableAndDisable() {

        WebElement input = driver.findElement(
            By.cssSelector("#input-example input")
        );

        Assert.assertFalse(input.isEnabled(),
            "Input should initially be disabled");

        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector("#input-example input")
            )
        );

        input.sendKeys("Policy123");

        Assert.assertEquals(input.getAttribute("value"), "Policy123");

        driver.findElement(By.xpath("//button[text()='Disable']")).click();

        wait.until(
            ExpectedConditions.not(
                ExpectedConditions.elementToBeClickable(
                    By.cssSelector("#input-example input")
                )
            )
        );

        Assert.assertFalse(input.isEnabled(),
            "Input should be disabled again");

        System.out.println("Input enable/disable test passed!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
