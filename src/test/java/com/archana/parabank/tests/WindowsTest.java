package src.test.java.com.archana.parabank.tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SeleniumPratice.SeleniumPratice.utils.BrowserFactory;
import SeleniumPratice.SeleniumPratice.utils.ConfigReader;

public class WindowsTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.getProperty("browser");
        driver = BrowserFactory.createBrowser(browser);

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
    }

    @Test
    public void verifyMultipleWindows() {

        String parentWindow = driver.getWindowHandle();

        driver.findElement(
            By.linkText("Click Here")
        ).click();

        Set<String> allWindows = driver.getWindowHandles();

        Assert.assertEquals(
            allWindows.size(), 2,
            "Expected two browser windows"
        );

        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        Assert.assertEquals(
            driver.getTitle(),
            "New Window",
            "New window title mismatch"
        );

        driver.close();

        driver.switchTo().window(parentWindow);

        Assert.assertTrue(
            driver.getTitle().contains("The Internet"),
            "Could not return to parent window"
        );

        System.out.println("Multiple windows test passed!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}