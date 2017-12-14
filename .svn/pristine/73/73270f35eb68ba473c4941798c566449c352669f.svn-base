package com.landesk.ldms.webconsole.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.landesk.PageBase;
import com.landesk.ldms.Utils.util;

public class ScheduledScriptTaskPageObject extends PageBase{
	private util u;
	public ScheduledScriptTaskPageObject(WebDriver d){		
		super(d); 
		this.driver = d;
		u = new util();
	}
	
	public void ScheduledTaskWindow(){
		String newhandle= u.switchWindow(driver);
		driver.switchTo().window(newhandle);//switch new window
		this.setDriver(driver);
	}
	
	public void clickOverviewTab() throws InterruptedException{
		waitAndClickElement(driver,By.xpath(".//*[@id='overview_navLink']"),50);
	//	Thread.sleep(2000);
	}
	
	public void clickTargetDevicesTab(){
		waitAndClickElement(driver,By.xpath(".//*[@id='targets_navLink']"),50);
	}
	
	public void setTargetDevicesByTeamGroup(String name,String d){
		WebElement el = waitAndGetElement(driver,By.xpath(".//*[@id='_addGroupDropdownlist']"),60);
		new Select(el).selectByVisibleText("'selenium team' devices");
		waitAndClickElement(driver,By.xpath(".//*[@id='_addGroupButton']"),50);
	}
	
	public void setOwnerToTeam(){
		WebElement el = waitAndGetElement(driver,By.xpath(".//*[@id='owner_dropdownlist']"),60);
		new Select(el).selectByVisibleText("selenium team");
	}
	
	public void setTargetDevicesByTeamQuery(String TeamQueryName){
		WebElement el = waitAndGetElement(driver,By.xpath(".//*[@id='_addQueryDropdownlist']"),60);
		new Select(el).selectByVisibleText(TeamQueryName);
		waitAndClickElement(driver,By.xpath(".//*[@id='_addQueryButton']"),50);
	}
	
	public void saveScriptTask(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};
		waitAndClickElement(driver,By.xpath(".//*[@id='_okButton']"),50);
	}
	
	public void startScriptTask(){
		waitAndClickElement(driver,By.xpath(".//*[@id='setSchedule_navLink']"),50);
		waitAndClickElement(driver,By.xpath(".//*[@id='rSched1']"),50);
		waitAndClickElement(driver,By.xpath(".//*[@id='_okButton']"),50);
	}
}

