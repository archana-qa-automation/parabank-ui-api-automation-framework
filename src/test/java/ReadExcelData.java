import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

    public static void main(String[] args) throws IOException {

        String path = "src/test/resources/PolicyTestData.xlsx";

        FileInputStream input = new FileInputStream(path);

        Workbook workbook = new XSSFWorkbook(input);

        Sheet sheet = workbook.getSheet("PolicyData");

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            Row row = sheet.getRow(i);

            String policyNumber =
                    row.getCell(0).getStringCellValue();

            double premium =
                    row.getCell(1).getNumericCellValue();

            System.out.println(
                    "Policy Number: " + policyNumber
                    + " | Premium: " + premium);
        }

        workbook.close();
        input.close();
    }
}