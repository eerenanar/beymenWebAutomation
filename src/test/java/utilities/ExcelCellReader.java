package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelCellReader {
    public static void main(String[] args) {
    	String cellData = readCell(0, 1);
    	System.out.println("Returned Cell Data: " + cellData);
    }
    public static String readCell(int rowNumber,int cellNumber) {
    	String cellData = null;
        try {
        	String projectPath = System.getProperty("user.dir");
            FileInputStream file = new FileInputStream(new File(projectPath+"/ExcelFile.xlsx"));
            
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            Row row = sheet.getRow(rowNumber); 
            Cell cell = row.getCell(cellNumber); 

            if (cell != null) {
                switch (cell.getCellType()) {
                    case STRING:
                    	cellData = cell.getStringCellValue();
                        System.out.println("Hücre Değeri (String): " + cell.getStringCellValue());
                        break;
                    case NUMERIC:
                    	cellData = String.valueOf(cell.getNumericCellValue());
                        System.out.println("Hücre Değeri (Numeric): " + cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                    	cellData = String.valueOf(cell.getBooleanCellValue());
                        System.out.println("Hücre Değeri (Boolean): " + cell.getBooleanCellValue());
                        break;
                    default:
                        System.out.println("Hücre Değeri: ");
                }
            } else {
                System.out.println("Hücre boş");
            }

            workbook.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return cellData;
    }
}