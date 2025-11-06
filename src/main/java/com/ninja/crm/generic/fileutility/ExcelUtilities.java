package com.ninja.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Siddhant
 * 
 * We are using these to read the excel data 
 * 
 * 
 */

public class ExcelUtilities {

	public String toReadDataFromExcel(String sheet,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		// Read the data from excel
		// Create the object of physical file
		FileInputStream fs = new FileInputStream("./resources/campaign.xlsx");

		// Open excel in read mode
		Workbook wb = WorkbookFactory.create(fs);
		
		String data = wb.getSheet(sheet).getRow(rowNum).getCell(cellNum).getStringCellValue();
		
		return data;
	}
}
