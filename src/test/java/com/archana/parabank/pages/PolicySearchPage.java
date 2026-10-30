package src.test.java.com.archana.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PolicySearchPage {

    WebDriver driver;

    // Constructor
    public PolicySearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By policyNumberField = By.id("policyNumber");
    By searchButton = By.id("search");

    // Action method
    public void searchPolicy(String policyNumber) {
        driver.findElement(policyNumberField).sendKeys(policyNumber);
        driver.findElement(searchButton).click();
    }
}