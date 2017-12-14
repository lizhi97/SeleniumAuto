package com.landesk.ldms.webconsole.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.landesk.PageBase;
import com.landesk.ldms.Utils.util;

public class ReportViewPageObject extends PageBase{
	 
	private util u = new util();
	public ReportViewPageObject(WebDriver d){
			this.driver = d;
	}
	/**
	 * Open the report view after click the report item in the web console.
	 * Author Trudy
	 * @return
	 */
	public void openPage(){
		
		String newhandle= u.switchWindow(driver);
		driver.switchTo().window(newhandle);//switch new window
		this.setDriver(driver);
		waitForPageLoaded(driver);

        //System.out.println("url1 = " + driver.getCurrentUrl());
        
	}
	
	/**
	 * Check the report show completely.</br> 
	 * Author Trudy
	 * @return
	 */
	public boolean checkReportResult(){
		
	    waitAndSwitchToFrame(driver,"WebReportViewer1_coreViewer",60);
	    String s= waitAndGetElement(driver,By.id("reportContainer"),60).getText();
        boolean b = true;
	    if (!s.contains("LANDesk® Management Suite")) b = false;
	    else b=true;
	    return b;


	}
}