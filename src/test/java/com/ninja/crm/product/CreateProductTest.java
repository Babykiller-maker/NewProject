package com.ninja.crm.product;

import java.io.FileInputStream;


import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ninja.crm.generic.javautility.JavaUtilities;
import com.ninja.crm.generic.webdriverutility.BaseClass;
import com.ninja.crm.generic.webdriverutility.WebDriverUtilities;
import com.ninja.crm.objectrepository.CreateProductsPage;
import com.ninja.crm.objectrepository.HomePage;

import com.ninja.crm.objectrepository.ProductsPage;

//@Listeners(com.ninja.crm.listenersutility.ListenersImplementation.class)

public class CreateProductTest extends BaseClass {

	@Test(groups = "smoke")
	public void createProductWithMandatoryFieldTest() throws IOException, ParseException, InterruptedException {
		// Read from Excel
		FileInputStream fis = new FileInputStream("./resources/campaign.xlsx");
		Workbook wb = WorkbookFactory.create(fis);

		// Click on Products link
		HomePage hp = new HomePage(driver);
		hp.getProductsLink().click();
		// Click on CreateProducts
		ProductsPage pg = new ProductsPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(pg.getCreateProduct()));

		try {
		    pg.getCreateProduct().click();
		} catch (ElementClickInterceptedException e) {
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", pg.getCreateProduct());
		}
	
		// ProductName
		// Generate randowm number
		JavaUtilities jup = new JavaUtilities();
		int ranNum = jup.getRandomNumber();

		// Create product With Mandatory fields
		String productName = wb.getSheet("Product").getRow(1).getCell(1).getStringCellValue() + ranNum;
		CreateProductsPage cpp = new CreateProductsPage(driver);
		cpp.getProductName().sendKeys(productName);
		// Quanity
		String quantity = wb.getSheet("Product").getRow(1).getCell(2).getStringCellValue();
		cpp.getQuantity().clear();
		cpp.getQuantity().sendKeys(quantity);
		// Price unit
		String priceUnit = wb.getSheet("Product").getRow(1).getCell(3).getStringCellValue();
		cpp.getPrice().clear();
		cpp.getPrice().sendKeys(priceUnit);

		WebDriverUtilities wdup = new WebDriverUtilities();
		wdup.handleDropDown(cpp.getProductCategory(), 3);
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wdup.handleDropDown(cpp.getVendorId(), 2);
		
		cpp.getAddProductButton().click();	

		
		wait.until(ExpectedConditions.elementToBeClickable(hp.getToastMsg()));
		String msg = hp.getToastMsg().getText();
		// Validate campaign create msg
		Assert.assertTrue(msg.contains("Successfully Added"));
		
	}
}
