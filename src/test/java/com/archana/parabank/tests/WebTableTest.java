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

public class WebTableTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.getProperty("browser");
        driver = BrowserFactory.createBrowser(browser);

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    @Test
    public void verifyTableData() {

        WebElement table = driver.findElement(By.id("table1"));

        List<WebElement> rows =
                table.findElements(By.cssSelector("tbody tr"));

        Assert.assertEquals(
            rows.size(), 4,
            "Expected four data rows"
        );

        boolean recordFound = false;

        for (WebElement row : rows) {

            List<WebElement> cells =
                    row.findElements(By.tagName("td"));

            String firstName = cells.get(1).getText().trim();
            String lastName = cells.get(0).getText().trim();
            String email = cells.get(2).getText().trim();

            if (firstName.equals("John")
                    && lastName.equals("Smith")) {

                Assert.assertEquals(
                    email,
                    "jsmith@gmail.com",
                    "John Smith email mismatch"
                );

                recordFound = true;
                break;
            }
        }

        Assert.assertTrue(
            recordFound,
            "John Smith record was not found"
        );

        System.out.println("Web table test passed!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}