package src.test.java.com.archana.parabank.tests;

import java.nio.file.Paths;
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

public class FileUploadTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.createBrowser(
            ConfigReader.getProperty("browser")
        );

        driver.get("https://the-internet.herokuapp.com/upload");
    }

    @Test
    public void verifyFileUpload() {

        String filePath = Paths.get(
            System.getProperty("user.dir"),
            "src", "test", "resources", "upload-test.txt"
        ).toAbsolutePath().toString();

        WebElement fileInput =
            driver.findElement(By.id("file-upload"));

        fileInput.sendKeys(filePath);

        driver.findElement(By.id("file-submit")).click();

        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement heading = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.tagName("h3")
            )
        );

        Assert.assertEquals(
            heading.getText().trim(),
            "File Uploaded!"
        );

        WebElement uploadedFile = driver.findElement(
            By.id("uploaded-files")
        );

        Assert.assertEquals(
            uploadedFile.getText().trim(),
            "upload-test.txt"
        );

        System.out.println("File upload test passed!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}