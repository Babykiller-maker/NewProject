package com.ninja.crm.campaign;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ninja.crm.generic.fileutility.ExcelUtilities;
import com.ninja.crm.generic.javautility.JavaUtilities;
import com.ninja.crm.generic.webdriverutility.BaseClass;
import com.ninja.crm.objectrepository.CampaignsPage;
import com.ninja.crm.objectrepository.CreateCampaignsPage;
import com.ninja.crm.objectrepository.HomePage;

public class CreateCampaignsTest extends BaseClass {

	
	@Test(groups = "smoke")
	public void createCamapignsWithMandatoryFieldsTest() throws InterruptedException, IOException {
		/* Read the data from excel file */
		ExcelUtilities eu = new ExcelUtilities();
		String campaignName = eu.toReadDataFromExcel("Campaigns", 1, 1);
		String targetSize = eu.toReadDataFromExcel("Campaigns", 1, 2);

		// Click on campaigns link
		HomePage hp = new HomePage(driver);
		hp.getCampaignsLink().click();

		// click on create campaign
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaignButton().click();

		// Create campaigns
		CreateCampaignsPage ccp = new CreateCampaignsPage(driver);
		ccp.getCampaignName().sendKeys(campaignName);
		ccp.getTargetSize().clear();
		ccp.getTargetSize().sendKeys(targetSize);
		ccp.getCreateCampaignButton().click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(hp.getToastMsg()));
		// Validate campaign create msg

		String msg = hp.getToastMsg().getText();
		Assert.assertTrue(msg.contains(campaignName));
		hp.getCrossButton().click();

	}

	@Test
	public void createCampaignsWithExpectedDateTest() throws IOException, InterruptedException {

		// Read the data from excel file
		ExcelUtilities eu = new ExcelUtilities();
		String campaignName = eu.toReadDataFromExcel("Campaigns", 1, 1);
		String targetSize = eu.toReadDataFromExcel("Campaigns", 1, 2);

		// Click on campaigns link
		HomePage hp = new HomePage(driver);
		hp.getCampaignsLink().click();

		// click on create campaign
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaignButton().click();

		// Create campaign with expected date after 30 days
		JavaUtilities jup = new JavaUtilities();
		String expDate = jup.selectExpectedDate(30);
		CreateCampaignsPage ccp = new CreateCampaignsPage(driver);
		ccp.getExpDate().sendKeys(expDate);
		ccp.getCampaignName().sendKeys(campaignName);
		ccp.getTargetSize().clear();
		ccp.getTargetSize().sendKeys(targetSize);
		ccp.getCreateCampaignButton().click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(hp.getToastMsg()));
		// Validate campaign create msg
		String msg = hp.getToastMsg().getText();
		Assert.assertTrue(msg.contains(campaignName));
		hp.getCrossButton().click();

	}

	@Test
	public void createCampaignsWithStatusTest() throws IOException, InterruptedException {

		// Read the data from excel file
		ExcelUtilities eu = new ExcelUtilities();
		String campaignName = eu.toReadDataFromExcel("Campaigns", 1, 1);
		String targetSize = eu.toReadDataFromExcel("Campaigns", 1, 2);

		// Click on campaigns link
		HomePage hp = new HomePage(driver);
		hp.getCampaignsLink().click();

		// click on create campaign
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaignButton().click();

		// Create campaigns
		CreateCampaignsPage ccp = new CreateCampaignsPage(driver);
		ccp.getCampaignName().sendKeys(campaignName);
		ccp.getTargetSize().clear();
		ccp.getTargetSize().sendKeys(targetSize);
		ccp.getCreateCampaignButton().click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(hp.getToastMsg()));
		// Validate campaign create msg

		String msg = hp.getToastMsg().getText();
		Assert.assertTrue(msg.contains(campaignName));
		hp.getCrossButton().click();

	}

}
