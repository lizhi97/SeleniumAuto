package com.landesk.avalanche.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.landesk.PageBase;

public class ViewNetworkProfileObj extends PageBase{
	public ViewNetworkProfileObj(WebDriver driver){
		super(driver); 
		this.driver = driver;

	}
	
	public void clickCloseButton(){
		 waitAndGetElement(driver,By.xpath(".//*[@id='linkNetworkProfileClose']"),50);
	//	 waitAndClickElement(driver,By.xpath(".//*[@id='linkNetworkProfileClose']"),50);
		 ((JavascriptExecutor) driver).executeScript("mojarra.jsfcljs(document.getElementById('networkProfilePage'),{'linkNetworkProfileClose':'linkNetworkProfileClose'},'');return false");
	 }

	 public void clickEditButton(){
		 waitAndGetElement(driver,By.id("linkNetworkProfileEdit"),50);
		 waitAndClickElement(driver,By.id("linkNetworkProfileEdit"),50);
	 }
	 
	 public void clickCloneButton(){
		 waitAndClickElement(driver,By.id("linkNetworkProfileClone"),50);
	 }

}
