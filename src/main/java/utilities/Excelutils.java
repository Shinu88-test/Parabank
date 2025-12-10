package utilities;

import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

public class Excelutils {
	

	
	 public static  Object[][] getExcelData(String filePath, String fileName) throws IOException
	 
	 {
		 
		 String fullPath = Paths.get(filePath, fileName).toString().replace("\\", "/"); // Normalize path
		 
         FileInputStream fis = new FileInputStream ("D:\\automation\\Parabank.demo\\Testdata\\TestData.xlsx");
         Workbook workbook = new XSSFWorkbook(fis); // Use HSSFWorkbook for .xls files
         Sheet sheet = workbook.getSheet("Sheet1");

         int rowCount = sheet.getLastRowNum();//2
         int colCount = sheet.getRow(0).getLastCellNum();//1

         Object[][] data = new Object[rowCount][colCount];
         System.out.println("Rows: " + data.length + ", Columns: " + data[0].length);
         
         for (Object[] row : data) {
             System.out.println("Row data: " + java.util.Arrays.toString(row));
         }

         for (int i = 1; i <= rowCount; i++) // ROW 
         {
             Row row = sheet.getRow(i);//XSSFROW
             if (row != null) 
             {
                 for (int j = 0; j < colCount; j++) //CELLS
                 {
                     Cell cell = row.getCell(j);//XSSFCELL
                     System.out.println(cell.toString());
                     
           
                     if (cell != null) {
                         switch (cell.getCellType()) {
                             case STRING:
                                 data[i-1][j] = cell.getStringCellValue();
                                 break;
                             case NUMERIC:
                                 data[i-1][j] = String.valueOf(cell.getNumericCellValue()); // Convert to string if needed
                                 break;
                             case BOOLEAN:
                                 data[i-1][j] = String.valueOf(cell.getBooleanCellValue());
                                 break;
                             default:
                                 data[i-1][j] = "";
                         }
                     } else {
                         data[i-1][j] = "";
                     }
                 }
             }
         }
         workbook.close();
         fis.close();
         return data;
     }

}
