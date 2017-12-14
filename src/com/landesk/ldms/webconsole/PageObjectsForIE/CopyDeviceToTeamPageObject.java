package com.landesk.ldms.webconsole.PageObjectsForIE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.landesk.PageBaseForIE;
import com.landesk.ldms.Utils.util;

public class CopyDeviceToTeamPageObject extends PageBaseForIE{
	private util u = new util();
	public CopyDeviceToTeamPageObject(WebDriver d){
		super(d);
		this.driver = d;
	}

	public void openWindow(){
		if(debug) System.out.println("open move/copy to group page");//execute java script,click New
		String newhandle= u.switchWindow(driver);
		driver.switchTo().window(newhandle);//switch new window
		this.setDriver(driver);
	}
	
	public void selectTeamGroup(){
		waitAndClickElement(driver,By.xpath(".//*[@id='group94']/span"),50);
	}
	
	public void clickCopyButton(){
		waitAndClickElement(driver,By.xpath(".//*[@id='_copyButton']"),50);
	}
}