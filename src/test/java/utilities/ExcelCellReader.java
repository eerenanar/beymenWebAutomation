package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelCellReader {
    public static void main(String[] args) {
    	readCell(1, 2); 
    }
    public static void readCell(int rowNumber, int columnNumber) {
    	
        try {
            // Excel dosyasının yolu ve adı
            String filePath = "ExcelFile.xlsx";
            FileInputStream file = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            Row row = sheet.getRow(rowNumber); // Satır
            Cell cell = row.getCell(columnNumber); // Sütun

            // Hücre içeriğini yazdır
            if (cell != null) {
                switch (cell.getCellType()) {
                    case STRING:
                        System.out.println("Hücre Değeri (String): " + cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        System.out.println("Hücre Değeri (Numeric): " + cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        System.out.println("Hücre Değeri (Boolean): " + cell.getBooleanCellValue());
                        break;
                    default:
                        System.out.println("Hücre Değeri: ");
                }
            } else {
                System.out.println("Hücre boş");
            }

            // Dosyayı kapat
            workbook.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}