package SeleniumPratice.SeleniumPratice.pages;

import org.openqa.selenium.WebDriver;

public class TestUtils {

    public static void openApplication(
            WebDriver driver, String url) {

        driver.get(url);
    }
}