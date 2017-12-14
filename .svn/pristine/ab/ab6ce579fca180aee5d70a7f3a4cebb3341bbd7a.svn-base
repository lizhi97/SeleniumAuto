package com.landesk.ldms.webconsole.PageObjectsForIE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import com.landesk.PageBaseForIE;
import com.landesk.ldms.Utils.util;

import java.lang.Thread;

public class RealtimeMonitorPageObject extends PageBaseForIE{
	private util u = new util();
	public RealtimeMonitorPageObject(WebDriver d){
		super(d);
		this.driver = d;
	}
	
	/**
	 * Switch to new page window 
	 */
	public void openWindow(){
		
		String newhandle= u.switchWindow(driver);
		driver.switchTo().window(newhandle);//switch new window
		if(debug) System.out.println(driver.getCurrentUrl());
		this.setDriver(driver);
		
	}
	
	/**
	 * Switch to the second 'left' frame on real-time monitor page
	 */
	public void switchLeftLeft(){	
			driver.switchTo().defaultContent();
			waitAndSwitchToFrame(driver,"main",60);
			waitAndSwitchToFrame(driver,"left",60);
			waitAndSwitchToFrame(driver,"left",60);		
	}
	
	/**
	 * Switch to 'tabs' frame on real-time monitor page
	 */
    public void swithToTabsFrame(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"servercore",60);
		waitAndSwitchToFrame(driver,"footer",60);
		waitAndSwitchToFrame(driver,"tabs",60);
	}
    
	/**
	 * Switch to 'd_bottom' frame on real-time monitor page
	 */
    public void swithToBottomFrame(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"servercore",60);
		waitAndSwitchToFrame(driver,"body",60);
		waitAndSwitchToFrame(driver,"d_bottom",60);
	}
	
	/**
	 * Click 'monitoring' link on real-time monitor page
	 */
	public void clickMonitoringElement(){
		
		if(debug) System.out.println(driver.findElement(By.id("aText2")).getText());
		//driver.findElement(By.id("aText2")).click();
		waitAndClickElement(driver,By.id("aText2"),60);

	}
	
	/**
	 * Click 'performance counter settings' tab on real-time monitor page
	 */
	public void clickPcsTabElement(){
		//driver.findElement(By.id("1tab")).click();	  
		waitAndClickElement(driver,By.id("1tab"),60);
	}
	
	/**
	 * Click 'Net Interface' element on real-time monitor page
	 */
	public void clickNetInterfaceElement(){
		//driver.findElement(By.cssSelector("td.itemNot[title='Network Interface']")).click(); 
		waitAndClickElement(driver,By.cssSelector("td.itemNot[title='Network Interface']"),120);
	}
	
	/**
	 * Click 'Intel[R] PRO_1000 MT Network Connection' element on real-time monitor page
	 */
	public void clickIntelPROElement(){
		//driver.findElement(By.cssSelector("td.itemNot[title='Intel[R] PRO_1000 MT Network Connection']")).click();  
		waitAndClickElement(driver,By.cssSelector("td.itemNot[title='Intel[R] PRO_1000 MT Network Connection']"),60);
	}
	
	/**
	 * Click 'Local Area Connection' element on real-time monitor page
	 */
	public void clickLocalAreaElement(){ 
		waitAndClickElement(driver,By.cssSelector("td.itemNot[title='Local Area Connection* 9']"),60);
	}
	
	/**
	 * Click 'Bytes Received/sec' element on real-time monitor page
	 */
	public void clickBytesReceivedElement(){
		//driver.findElement(By.cssSelector("td.itemNot[title='Bytes Received/sec']")).click();     
		waitAndClickElement(driver,By.cssSelector("td.itemNot[title='Bytes Received/sec']"),60);
	}
	
	/**
	 * Click 'apply' button on real-time monitor page
	 */
	public void clickApplyBtnElement(){
		//driver.findElement(By.id("m_btnApply")).click();   
		waitAndClickElement(driver,By.id("m_btnApply"),60);
	}
	
	/**
	 * Click 'active performance counters' tab on real-time monitor page
	 */
	public void clickApcTabElement(){
		//driver.findElement(By.id("0tab")).click(); 
		waitAndClickElement(driver,By.id("0tab"),60);
	}
	
	/**
	 * Click 'real-time' radio button on real-time monitor page
	 */
	public void clickRealtimeRadioElement(){
		//driver.findElement(By.id("m_rbList_0")).click();
		waitAndClickElement(driver,By.id("m_rbList_0"),60);
	}
	
	/**
	 * Click 'historical' radio button on real-time monitor page
	 */
	public void clickHistoricalRadioElement(){
		//driver.findElement(By.id("m_rbList_1")).click();
		waitAndClickElement(driver,By.id("m_rbList_1"),60);
	}
	
	/**
	 * Select one option from 'counters:' drop-down menu
	 */
	public void selectBytesOptionElement(){
		//driver.findElement(By.id("m_ddList")).findElement(By.xpath("//option[contains(.,'Bytes Received')]")).click();
		//Select dropDown=new Select(driver.findElement(By.id("m_ddList")));
		Select dropDown=new Select(waitAndGetElement(driver,By.id("m_ddList"),60));		
		dropDown.selectByIndex(0);;
	}
	
	/**
	 * Update 'Lower Threshold' input field on real-time monitor page
	 * @param lowValue
	 */
	public void updateLowerThreshold(String lowValue){
		//driver.findElement(By.id("textBoxLowThreshold")).sendKeys(lowValue); 
		waitAndGetElement(driver,By.id("textBoxLowThreshold"),60).sendKeys(lowValue);
	} 
	
	/**
	 * Update 'Upper Threshold' input field on real-time monitor page
	 * @param highValue
	 */
	public void updateUpperThreshold(String highValue){
		//driver.findElement(By.id("textBoxHiThreshold")).sendKeys(highValue);  
		waitAndGetElement(driver,By.id("textBoxHiThreshold"),60).sendKeys(highValue);
	}
	
	/**
	 * Take a screenshot by calling takeScreenshotAndSave method of PageBase.java.
	 * @param fileMeaning File meaning which will be part of the saved screenshot file name.
	 * @param destDirectory Destination directory to save the screenshot file.
	 */
	public void takeScreenshot(String fileMeaning,String destDirectory) throws Exception{
		Thread.sleep(10000);
		takeScreenshotAndSave(fileMeaning,destDirectory);		
	}

			
}
