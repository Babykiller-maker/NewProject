package com.ninja.crm.generic.webdriverutility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.ninja.crm.generic.fileutility.PropertyUtilities;
import com.ninja.crm.objectrepository.HomePage;
import com.ninja.crm.objectrepository.LoginPage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseClass {
	public WebDriver driver = null;
	public static WebDriver sdriver;
	PropertyUtilities pr = new PropertyUtilities();
	WebDriverUtilities wup = new WebDriverUtilities();

	@BeforeSuite(groups = "smoke")
	public void beforeSuite() {
		Reporter.log("Eastbilish Database Connectivity", true);
	}

	@BeforeMethod(groups = "smoke")
	public void beforeMethod() throws IOException {
		String URL = pr.toReadDataFromPropertyFile("url");
		String USERNAME = pr.toReadDataFromPropertyFile("username");
		String PASSWORD = pr.toReadDataFromPropertyFile("password");

		// Login into the application
		LoginPage lp = new LoginPage(driver);
		lp.loginIntoApplication(URL, USERNAME, PASSWORD);
		Reporter.log("Login Done", true);
	}

	@AfterMethod(groups = "smoke")
	public void afterMethod() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		Thread.sleep(500);
		hp.getCrossButton().click();
		wup.mouseHoverAction(driver, hp.getProfile());
		hp.getLogOut().click();
		
		Reporter.log("LogOut Done", true);
	}

	@BeforeClass(groups = "smoke")
//	@Parameters("browser")
	public void beforeClass() throws IOException {
//		String BROWSER=browser;
		String BROWSER = pr.toReadDataFromPropertyFile("browser");
//		String BROWSER = System.getProperty("browser");

		
//		String BROWSER = System.getProperty("browser");

		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);
		settings.addArguments("--start-maximized");
		settings.addArguments("--disable-gpu");
		settings.addArguments("--remote-allow-origins=*");

		// Launch the Browser
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver(settings);
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}
		sdriver=driver;
		Reporter.log("Launching browser", true);
	}

	@BeforeTest(groups = "smoke")
	public void beforeTest() {
		Reporter.log("Pre-Condition", true);
	}

	@AfterTest(groups = "smoke")
	public void afterTest() {
		Reporter.log("Post-Condition", true);
	}

	@AfterClass(groups = "smoke")
	public void afterClass() {
		
		driver.quit();
		Reporter.log("Closing browser", true);
	}

	@AfterSuite(groups = "smoke")
	public void afterSuite() {
		Reporter.log("Close Database Connection", true);
	}

}
