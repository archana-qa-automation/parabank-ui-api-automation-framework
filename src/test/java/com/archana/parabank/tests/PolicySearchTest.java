package src.test.java.com.archana.parabank.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PolicySearchTest {

    @DataProvider(name = "policyData")
    public Object[][] getPolicyData() {
        return new Object[][] {
            {"POL101"},
            {"POL102"},
            {"POL103"}
        };
    }

    @Test(dataProvider = "policyData", groups = "smoke")
    public void searchPolicyTest(String policyNumber) {

        System.out.println("Policy Number: " + policyNumber);
    }
}