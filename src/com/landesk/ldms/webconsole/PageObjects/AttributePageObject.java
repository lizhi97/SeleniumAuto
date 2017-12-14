package com.landesk.ldms.webconsole.PageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.landesk.PageBase;
import com.landesk.ldms.Utils.util;

public class AttributePageObject extends PageBase{
	private util u = new util();
	public AttributePageObject(WebDriver d){
		//super(d);
		this.driver = d;
	}

	public void clickAddElement(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver, "attrselectattributes", 60);
		((JavascriptExecutor) driver).executeScript("javascript:addItem();");
	}

	public void clickMovedown(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver, "attrselectattributes", 60);
		waitAndClickElement(driver,By.xpath(".//*[@id='btnDown']"),50);

	}

	public void clickOk(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver, "attrselectattributes", 60);
		waitAndClickElement(driver,By.xpath(".//*[@id='selData']/table/tbody/tr[6]/td/input[1]"),50);
		
	}
	public void clickSelAMTElement(){
		driver.switchTo().defaultContent();
		driver.switchTo().frame("attrselectquerytree");
		waitAndClickElement(driver,By.xpath(".//*[@id='1item']"),50);
		//driver.findElement(By.id("1item")).click();

	}
	public void clickTableElement(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver, "attrselectattributes", 60);
		waitAndClickElement(driver,By.xpath(".//*[@id='table1']/tbody/tr[3]/td[1]"),50);

	}

	public void editWindow(){
		 
		String newhandle= u.switchWindow(driver);
		driver.switchTo().window(newhandle);//switch new window
		this.setDriver(driver);
		//System.out.println("Edit windo"+driver.getTitle());

	}
	/**
	 * @author Winsy
	 * @param name
	 */
	public void inputName(String name){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver, "attrselectattributes", 60);
		waitAndGetElement(driver,By.xpath(".//*[@id='_textName']"),60).sendKeys(name);

	}
	public void openWindow(){
		
		
		String newhandle= u.switchWindow(driver);
		driver.switchTo().window(newhandle);//switch new window
		this.setDriver(driver);
	}
	
	


}
