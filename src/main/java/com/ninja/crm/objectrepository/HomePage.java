package com.ninja.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;

	@FindBy(linkText = "Leads")
	private WebElement leadsLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLink;
	
	@FindBy(linkText = "Products")
	private WebElement ProductsLink;
	
	public WebElement getProductsLink() {
		return ProductsLink;
	}

	@FindBy(linkText = "Quotes")
	private WebElement quotesLink;
	
	@FindBy(linkText = "Sales Order")
	private WebElement salesOrderLink;
	
	@FindBy(linkText = "Invoice")
	private WebElement invoiceLink;
	
	@FindBy(xpath = "//div[@class='nav-link']")
	private WebElement adminConsole;
	
	@FindBy(xpath = "//div[@class='user-icon']")
	private WebElement profile;

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getQuotesLink() {
		return quotesLink;
	}

	public WebElement getSalesOrderLink() {
		return salesOrderLink;
	}

	public WebElement getInvoiceLink() {
		return invoiceLink;
	}

	public WebElement getAdminConsole() {
		return adminConsole;
	}

	public WebElement getProfile() {
		return profile;
	}
	
	@FindBy(xpath = "//div[contains(text(),'Logout')]")
	private WebElement logOut;
	public WebElement getLogOut() {
		return logOut;
	}
	
	@FindBy(xpath = "//button[contains(@class,'close-button Toastify')]")
	private WebElement crossButton;

	public WebElement getCrossButton() {
		return crossButton;
	}
	
	@FindBy(xpath = "//div[@role='alert']")
	private WebElement toastMsg;
	public WebElement getToastMsg() {
		return toastMsg;
	}
}
