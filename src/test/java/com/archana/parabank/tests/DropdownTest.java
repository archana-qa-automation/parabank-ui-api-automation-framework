package src.test.java.com.archana.parabank.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SeleniumPratice.SeleniumPratice.utils.BrowserFactory;
import SeleniumPratice.SeleniumPratice.utils.ConfigReader;

public class DropdownTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.getProperty("browser");
        driver = BrowserFactory.createBrowser(browser);

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void verifyDropdownSelection() {

        WebElement dropdownElement =
                driver.findElement(By.id("dropdown"));

        Select dropdown = new Select(dropdownElement);

        // Verify dropdown options
        Assert.assertEquals(
            dropdown.getOptions().size(), 3,
            "Dropdown should contain three options"
        );

        // Select Option 1
        dropdown.selectByVisibleText("Option 1");

        Assert.assertEquals(
            dropdown.getFirstSelectedOption().getText(),
            "Option 1",
            "Option 1 was not selected"
        );

        // Select Option 2
        dropdown.selectByVisibleText("Option 2");

        Assert.assertEquals(
            dropdown.getFirstSelectedOption().getText(),
            "Option 2",
            "Option 2 was not selected"
        );

        System.out.println("Dropdown test passed!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}