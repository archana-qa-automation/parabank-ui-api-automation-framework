package Demo;

/*import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1Practice {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        
        driver.get("https://www.google.com");

        String parentWindow = driver.getWindowHandle();

        System.out.println("Parent Tab: " + driver.getTitle());

        
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://sampleapp.tricentis.com/101/");

        
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.flipkart.com/");

        
        Set<String> allWindows = driver.getWindowHandles();

        System.out.println("Total Windows/Tabs: " + allWindows.size());

        
        String insuranceWindow = "";

       
        for (String window : allWindows) {

            driver.switchTo().window(window);

            if (driver.getCurrentUrl().contains("sampleapp.tricentis.com")) {

                insuranceWindow = window;

                System.out.println("Insurance Application found");
                System.out.println("Insurance Handle: " + insuranceWindow);
            }
        }

        
        driver.switchTo().window(parentWindow);

        System.out.println("Current Tab: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());

        
        driver.switchTo().window(insuranceWindow);

        System.out.println("Insurance Tab: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());
        
        driver.switchTo().window(parentWindow);
        System.out.println("Back to Parent Tab:" +driver.getTitle());

        
        driver.quit();
    }
}*/


