package com.ninja.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignsPage {

WebDriver driver;
	
	public CreateCampaignsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(name = "campaignName")
	private WebElement campaignName;
	
	@FindBy(name = "targetSize")
	private WebElement targetSize;
	
	
	@FindBy(name = "expectedCloseDate")
	private WebElement expDate;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement createCampaignButton;

	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getTargetSize() {
		return targetSize;
	}

	public WebElement getExpDate() {
		return expDate;
	}

	public WebElement getCreateCampaignButton() {
		return createCampaignButton;
	}
}
