package src.test.java.com.archana.parabank.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SeleniumPratice.SeleniumPratice.utils.BrowserFactory;
import SeleniumPratice.SeleniumPratice.utils.ConfigReader;

public class CheckboxTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.getProperty("browser");
        driver = BrowserFactory.createBrowser(browser);

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void verifyCheckboxSelection() {

        List<WebElement> checkboxes =
                driver.findElements(
                    By.cssSelector("input[type='checkbox']")
                );

        // Verify total checkboxes
        Assert.assertEquals(
            checkboxes.size(), 2,
            "Expected exactly two checkboxes"
        );

        WebElement firstCheckbox = checkboxes.get(0);
        WebElement secondCheckbox = checkboxes.get(1);

        // Verify initial state
        Assert.assertFalse(
            firstCheckbox.isSelected(),
            "First checkbox should initially be unchecked"
        );

        Assert.assertTrue(
            secondCheckbox.isSelected(),
            "Second checkbox should initially be checked"
        );

        // Select first checkbox
        firstCheckbox.click();

        Assert.assertTrue(
            firstCheckbox.isSelected(),
            "First checkbox was not selected"
        );

        // Deselect second checkbox
        secondCheckbox.click();

        Assert.assertFalse(
            secondCheckbox.isSelected(),
            "Second checkbox was not deselected"
        );

        System.out.println("Checkbox test passed!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}