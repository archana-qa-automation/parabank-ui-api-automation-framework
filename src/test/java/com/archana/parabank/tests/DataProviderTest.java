package src.test.java.com.archana.parabank.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        return new Object[][] {
            {"agent01", "pass123"},
            {"agent02", "pass456"},
            {"agent03", "pass789"}
        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {
        System.out.println(username + "-" + password);
    }

    @DataProvider(name = "policyData",indices = {0,2 })
    public Object[][] getPolicyData() {

        return new Object[][] {
            {"POL01",5000, true},
            {"POL02", 7500, true},
            {"POL03", 7500, true}
        };
    }

    @Test(dataProvider = "policyData")
    public void verifyPolicy(
            String policyNumber,
            int premium,
            boolean active) {

        System.out.println(
            policyNumber + "-" + premium + "-" + active
        );

        Assert.assertTrue(
            premium > 0,
            "Premium should be greater than zero"
        );
    }
}