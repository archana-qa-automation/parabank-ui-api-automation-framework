package src.test.java.com.archana.parabank.tests;

import SeleniumPratice.SeleniumPratice.pages.LoginPage;
import SeleniumPratice.SeleniumPratice.utils.BrowserFactory;
import SeleniumPratice.SeleniumPratice.utils.ConfigReader;
import SeleniumPratice.SeleniumPratice.utils.ScreenshotUtils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginDataProviderTest {

WebDriver driver;
LoginPage loginPage;

@BeforeMethod
public void setUp() {
    String browser = ConfigReader.getProperty("browser");
    String url = ConfigReader.getProperty("url");

    driver = BrowserFactory.createBrowser(browser);
    driver.manage().window().maximize();
    driver.get(url);

    loginPage = new LoginPage(driver);
}

@DataProvider(name = "loginData")
public Object[][] getLoginData() {
    return new Object[][] {
        {"tomsmith", "WrongPassword1", false},
        {"wronguser", "SuperSecretPassword!", false},
        {"tomsmith", "SuperSecretPassword!", true}
    };
}

@Test(dataProvider = "loginData")
public void loginTest(String username, String password,
                      boolean expectedSuccess) {

    loginPage.login(username, password);

    System.out.println("Username: " + username);
    System.out.println("Expected Success: " + expectedSuccess);
    System.out.println("Current URL: " + driver.getCurrentUrl());
    System.out.println("Page Title: " + driver.getTitle());

    boolean actualSuccess =
            driver.getCurrentUrl().contains("/secure");

    System.out.println("Actual Success: " + actualSuccess);

    System.out.println(
            "URL contains /secure: "
            + driver.getCurrentUrl().contains("/secure")
    );

    Assert.assertEquals(
            actualSuccess,
            expectedSuccess,
            "Login result mismatch for username: " + username
    );
}

@AfterMethod
public void tearDown(ITestResult result) throws IOException {

    if (!result.isSuccess() && driver != null) {
        ScreenshotUtils.takeScreenshot(
                driver, result.getName());
    }

    if (driver != null) {
        driver.quit();
    }
}

}