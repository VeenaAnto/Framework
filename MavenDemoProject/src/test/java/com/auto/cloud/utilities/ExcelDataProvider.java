package com.auto.cloud.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	
	public ExcelDataProvider() {

		

		File src = new File("C:\\Users\\VeenaA\\eclipse-workspace\\MavenDemoProject\\TestData\\LoginData.xlsx");
		
		try {
			FileInputStream fin = new FileInputStream(src);
			wb = new XSSFWorkbook(fin);
		} catch (Exception e) {

			System.out.println("Exception"+e.getMessage());
		}
	}
    public String getStringData(String sheetname, int row, int column) {
    	
    	return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
    	
    }
	
}