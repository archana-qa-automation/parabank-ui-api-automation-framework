package src.test.java.com.archana.parabank.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public static WebDriver createBrowser(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {

            System.out.println("Launching Chrome browser");
            return new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {

            System.out.println("Launching Firefox browser");
            return new FirefoxDriver();

        } else {

            throw new RuntimeException(
                "Unsupported browser: " + browser);
        }
    }
}
