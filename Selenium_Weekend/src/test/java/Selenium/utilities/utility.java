package Selenium.utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;



import org.testng.log4testng.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Reporter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class utility {

	static Logger log = Logger.getLogger(utility.class);
	
	public static void logFileSetup() {
		
		
		String logPropertyPath = "D:\\Selenium\\Training\\Selenium_Weekend\\src\\test\\java\\Selenium\\logFileProperty\\log4j.properties";
		PropertyConfigurator.configure(logPropertyPath);
		
	}
	
	public static void LogInfo(String message) {
		logFileSetup();
		log.info(message);
		
		
	}
	public static void LogError(String message) {
		logFileSetup();
		log.error(message);
		
		
	}
	
	public static void buildReport(String message) {
		
		Reporter.log(message);
	}
	
	public static void generateLogReportInfo(String message) {
		buildReport(message);
		LogInfo(message);
	}
	
	public static void generateLogReportError(String message) {
		buildReport(message);
		LogError(message);
	}
	
	public static void handlingExcelSetup() throws IOException{
		
		XSSFCell cell;
		XSSFSheet sheet;
		XSSFWorkbook work_book;
		try {
			File getExcelPath = new File("D:\\Selenium\\Training\\Selenium_Weekend\\src\\test\\java\\Selenium\\excelFiles\\Credentials.xlsx");
			FileInputStream stream = new FileInputStream(getExcelPath);
			work_book = new XSSFWorkbook(stream);
			sheet = work_book.getSheetAt(0);
		
			cell = sheet.getRow(1).getCell(2);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			String dataValue = cell.getStringCellValue(); 
		}catch(Exception e) {
			System.out.println("No data in that row");
		}

	}
	
	
	
		
}
