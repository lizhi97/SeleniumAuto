package com.landesk.ldms.webconsole.PageObjectsForIE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.landesk.PageBaseForIE;
import com.landesk.ldms.Utils.util;

public class TracertDevicePageObject extends PageBaseForIE{
	private util u = new util();
	public TracertDevicePageObject(WebDriver d){
			super(d);
			this.driver = d;
	}

	public void openWindow(){
		if(debug) System.out.println("open Tracert device page");//execute java script,click New
		String newhandle= u.switchWindow(driver);
		driver.switchTo().window(newhandle);//switch new window
		this.setDriver(driver);
		
	}

	public void checkTracertResult(){
		new WebDriverWait(driver,600).until(
				ExpectedConditions.textToBePresentInElementValue(By.id("textOutput") , "Trace complete")
				);
		WebElement e =  driver.findElement(By.id("textOutput"));
		if(e.getText().contains("Destination host unreachable")){
			if(debug) System.out.println("Trace client failed");}
		else if(e.getText().contains("Request timed out")){
			if(debug) System.out.println("Trace client failed");
		}
		else{
			if(debug) System.out.println("Trace client successful");
		}
	}

	public void clickClosebuttonElement() throws InterruptedException{

		waitAndClickElement(driver, By.id("Form1"),60);
	}
}

