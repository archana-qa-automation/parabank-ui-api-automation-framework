package com.archana.parabank.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.archana.parabank.base.BaseTest;
import com.archana.parabank.pages.LoginPage;
import com.archana.parabank.utils.ConfigReader;

public class LoginTest extends BaseTest {
	private static final String ERROR_MESSAGE = "The username and password could not be verified.";

    @Test(description = "TS_01 - Login with valid username and password")
    public void validLogin() {
    	 System.out.println("USER=[" + ConfigReader.get("username") + "] PASSLEN=" + ConfigReader.get("password").length());
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
        Assert.assertEquals(loginPage.getPageTitle(), "Accounts Overview");
        Assert.assertTrue(loginPage.isLogoutDisplayed());
    }

    @Test(description = "TS_02 - Verify user session after browser refresh")
    public void sessionAfterRefresh() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
        Assert.assertEquals(loginPage.getPageTitle(), "Accounts Overview");
        loginPage.refreshPage();
        Assert.assertTrue(loginPage.isLogoutDisplayed());
       
    }
    @Test(description = "TS_03 - Login with invalid username")
    		public void invalidUsername() {
    	LoginPage loginPage = new LoginPage(driver);
    	loginPage.login("Wrong_user_xyz", ConfigReader.get("password"));
    	Assert.assertEquals(loginPage.getPageTitle(), "Error!");
    	Assert.assertEquals(loginPage.getErrorMessage(),
    			"The username and password could not be verified.");
    	
    }
    
    @Test(description = "TS_04 - Login with invalid password")
    		public void invalidPassword() {
    	LoginPage loginPage = new LoginPage(driver);
    	loginPage.login("Wrong_user_xyz", ConfigReader.get("password"));
    	Assert.assertEquals(loginPage.getPageTitle(), "Error!");
    	Assert.assertEquals(loginPage.getErrorMessage(),
    			"The username and password could not be verified.");
    }
    @Test(description = "TS_05 - Login with invalid username and invalid password")
    		public void invalidUsernameAndPassword() {
    	LoginPage loginPage = new LoginPage(driver);
    	loginPage.login("Wrong_user_xyz", ConfigReader.get("password"));
    	Assert.assertEquals(loginPage.getPageTitle(), "Error!");
    	Assert.assertEquals(loginPage.getErrorMessage(),
    			"The username and password could not be verified.");
}
}