package com.ninja.crm.generic.webdriverutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtilities {

	public void handleDropDown(WebElement we,int index) {
		Select sel = new Select(we);
		sel.selectByIndex(index);
	}
	
	public void mouseHoverAction(WebDriver driver,WebElement WE) {
		Actions act = new Actions(driver);
		act.moveToElement(WE).click().perform();
	}
	
}
