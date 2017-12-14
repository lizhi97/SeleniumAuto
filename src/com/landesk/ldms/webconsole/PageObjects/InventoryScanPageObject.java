package com.landesk.ldms.webconsole.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.landesk.PageBase;
import com.landesk.ldms.Utils.util;

public class InventoryScanPageObject extends PageBase{
	private util u = new util();
	public InventoryScanPageObject(WebDriver d){
		super(d);
		this.driver = d;
	}

	public void openWindow(){
		if(debug) System.out.println("open inventory scan page");//execute java script,click New
		String newhandle= u.switchWindow(driver);
		driver.switchTo().window(newhandle);//switch new window
		this.setDriver(driver);

	}

	public void clickScanbuttonElement() throws InterruptedException{
        waitAndClickElement(driver,By.xpath("//input[@id='btnStartScan']"),50);
	}

	public void checkScanResult(){
		WebElement e = waitAndGetElement(driver,By.id("_errordiv"),300);
		if(e.getText().contains("successfully")){
			if(debug) System.out.println("The agent is scanned successfully.");
		}else{
			if(debug) System.out.println("The agent failed to be scanned.");
		}
	}
	/**
 * @
 */
	public void ClickOkbuttonElement(){
	//	driver.findElement(By.id("btnClose")).click();
		waitAndClickElement(driver,By.id("btnClose"),50);
	}
	





}
