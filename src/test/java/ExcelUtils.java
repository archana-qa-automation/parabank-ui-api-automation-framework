import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static Object[][] readExcelData(
            String filePath, String sheetName) throws IOException {

        try (FileInputStream input =
                     new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(input)) {

            Sheet sheet = workbook.getSheet(sheetName);

            int rowCount = sheet.getLastRowNum();

            Object[][] data = new Object[rowCount][2];

            for (int i = 1; i <= rowCount; i++) {

                Row row = sheet.getRow(i);

                data[i - 1][0] =
                        row.getCell(0).getStringCellValue();

                data[i - 1][1] =
                        row.getCell(1).getNumericCellValue();
            }

            return data;
        }
    }
}