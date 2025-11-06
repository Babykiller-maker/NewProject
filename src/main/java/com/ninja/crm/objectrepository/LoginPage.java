package com.ninja.crm.objectrepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id = "username")
	private WebElement username;

	@FindBy(id = "inputPassword")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signInButton;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignInButton() {
		return signInButton;
	}

	public void loginIntoApplication(String URL, String USERNAME, String PASSWORD) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		getUsername().sendKeys(USERNAME);
		getPassword().sendKeys(PASSWORD);
		getSignInButton().click();
	}

	
	
}
