package com.crm.autodesk.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * its developed using apache POI libraries,which used to handle Microsoft Excel sheet 
 * @author CHANNAKESHVA REDDY
 *
 */
public class ExcelUtility {
	/**
	 * it is used to read the data from excel based on arguments
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return 
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fin = new FileInputStream(".\\src\\test\\resources\\TestData\\testData.xlsx");
		Workbook workbook = WorkbookFactory.create(fin);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		String Data = row.getCell(cellNum).getStringCellValue();
		workbook.close();
		return Data;
	}
	/**
	 * used to get the last row number on specified sheet
	 * @param sheetName
	 * @return 
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fin = new FileInputStream(".\\src\\test\\resources\\TestData\\testData.xlsx");
		Workbook workbook = WorkbookFactory.create(fin);
		Sheet sheet = workbook.getSheet(sheetName);
		workbook.close();
		return sheet.getLastRowNum();
	}
	/**
	 * used to write the testdata into ExcelSheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data 
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public void writeDataIntoExcel(String sheetName, int rowNum, int cellNum, String data) throws EncryptedDocumentException, IOException {
		FileInputStream fin = new FileInputStream(".\\src\\test\\resources\\TestData\\testData.xlsx");
		Workbook workbook = WorkbookFactory.create(fin);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData\\testData.xlsx");
		workbook.write(fos);
		workbook.close();
	}

}
