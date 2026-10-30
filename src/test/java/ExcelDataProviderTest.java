import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProviderTest {

    @DataProvider(name = "policyData")
    public Object[][] getPolicyData() throws IOException {

        return ExcelUtils.readExcelData(
                "src/test/resources/PolicyTestData.xlsx",
                "PolicyData");
    }

    @Test(dataProvider = "policyData")
    public void verifyPolicy(String policyNumber, double premium) {

        System.out.println(
                "Policy Number: " + policyNumber
                + " | Premium: " + premium);

        Assert.assertTrue(
                premium > 0,
                "Premium should be greater than zero");
    }
}