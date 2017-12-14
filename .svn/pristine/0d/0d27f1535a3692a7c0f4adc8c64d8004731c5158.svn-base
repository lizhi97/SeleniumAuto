package com.landesk.ldms.webconsole.PageObjectsForIE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.landesk.PageBaseForIE;
import com.landesk.ldms.Utils.util;

public class PingDevicePageObject extends PageBaseForIE{
	private util u = new util();
	public PingDevicePageObject(WebDriver d){
			super(d);
			this.driver = d;
	}

	public void openWindow(){
		if(debug) System.out.println("open Ping Device page");//execute java script,click New
		String newhandle= u.switchWindow(driver);
		driver.switchTo().window(newhandle);//switch new window
		this.setDriver(driver);
		
	}
	
	public void ClickOkbuttonElement() throws InterruptedException{
		new WebDriverWait(driver,120).until(
				ExpectedConditions.textToBePresentInElementValue(By.id("textOutput") , "Packets")
				);
		WebElement e =  driver.findElement(By.id("textOutput"));
		if(e.getText().contains("TTL")){
			if(debug) System.out.println("Ping client successful");}
		else{
			if(debug) System.out.println("Ping client failed");
		}
		waitAndClickElement(driver,By.id("Form1"),60);
	}

}
