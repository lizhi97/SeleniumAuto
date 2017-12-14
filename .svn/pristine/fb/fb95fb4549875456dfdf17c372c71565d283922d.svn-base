package com.landesk.ldms.webconsole.PageObjects;



import org.openqa.selenium.WebDriver;



import com.landesk.PageBase;
import com.landesk.ldms.Utils.util;

public class InventoryInfoPageObject extends PageBase {
	private util u = new util();

	public InventoryInfoPageObject(WebDriver d) {
		// super(d);
		this.driver = d;
	}

	public void openWindow() {

		String newhandle = u.switchWindow(driver);
		driver.switchTo().window(newhandle);// switch new window
		this.setDriver(driver);
	}
	
	public void takeScreenshot(String fileMeaning,String destDirectory){
		takeScreenshotAndSave(fileMeaning,destDirectory);
		
	}
}

