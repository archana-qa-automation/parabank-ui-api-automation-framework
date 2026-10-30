import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcelFile {

    public static void main(String[] args) throws IOException {

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("PolicyData");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("PolicyNumber");
        header.createCell(1).setCellValue("Premium");

        Row row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("POL01");
        row1.createCell(1).setCellValue(5000);

        Row row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue("POL02");
        row2.createCell(1).setCellValue(7500);

        Row row3 = sheet.createRow(3);
        row3.createCell(0).setCellValue("POL03");
        row3.createCell(1).setCellValue(9000);

        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);

        try (FileOutputStream output =
                new FileOutputStream("src/test/resources/PolicyTestData.xlsx")) {

            workbook.write(output);
        }

        workbook.close();

        System.out.println("Excel file created successfully!");
    }
}