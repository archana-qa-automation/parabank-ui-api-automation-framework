package src.test.java.com.archana.parabank.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumPratice.SeleniumPratice.utils.WaitUtils;
import SeleniumPratice.SeleniumPratice.utils.JavaScriptUtils;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(css = "button[type='submit']")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

 // Practicing Git change tracking
 // Feature branch practice
    public void login(String user, String pass) {

        System.out.println("Entering username...");
        username.sendKeys(user);

        System.out.println("Entering password...");
        password.sendKeys(pass);

        System.out.println("Scrolling to login button...");
        JavaScriptUtils.scrollToElement(driver, loginButton);

        System.out.println("Clicking login button...");
        WaitUtils.clickWhenReady(driver, loginButton);

        System.out.println("Login button clicked.");
    }
}