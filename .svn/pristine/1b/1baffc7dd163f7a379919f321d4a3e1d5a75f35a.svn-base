package com.landesk.avalanche.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.landesk.PageBase;

public class EditNetworkProfileObj extends PageBase{
	public EditNetworkProfileObj(WebDriver driver){
		super(driver); 
		this.driver = driver;
	}
	
	public void clickSaveButton(){
    	waitAndGetElement(driver,By.xpath(".//*[@id='linkNetworkProfileSave']"),50);
    	((JavascriptExecutor) driver).executeScript("mojarra.jsfcljs(document.getElementById('netProEditForm'),{'linkNetworkProfileSave':'linkNetworkProfileSave'},'');return false");
    }

}
