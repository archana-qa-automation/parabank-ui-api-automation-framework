package com.archana.parabank.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.cssSelector("input[value='Log In']");
    private final By pageTitle = By.cssSelector("h1.title");
    private final By logoutLink = By.linkText("Log Out");
    private final By errorMessage = By.xpath("//*[contains(text(),'could not be verified')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).clear();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getPageTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).getText();
    }

    public boolean isLogoutDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink)).isDisplayed();
    }

    public void refreshPage() {
        driver.navigate().refresh();
        
    }
    public String getErrorMessage() {
    	return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText().trim();
    
    }
}