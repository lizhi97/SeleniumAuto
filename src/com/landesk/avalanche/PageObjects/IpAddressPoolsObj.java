package com.landesk.avalanche.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.landesk.PageBase;

public class IpAddressPoolsObj extends PageBase{
	
	public IpAddressPoolsObj(WebDriver driver){
		super(driver); 
		this.driver = driver;
	}
	
	public void inputIpAddressRange(){
    	waitAndGetElement(driver,By.id("txtIpStart1"),50).clear();
    	waitAndGetElement(driver,By.id("txtIpStart1"),50).sendKeys("172");
    	waitAndGetElement(driver,By.id("txtIpStart2"),50).clear();
    	waitAndGetElement(driver,By.id("txtIpStart2"),50).sendKeys("29");
    	waitAndGetElement(driver,By.id("txtIpStart3"),50).clear();
    	waitAndGetElement(driver,By.id("txtIpStart3"),50).sendKeys("40");
    	waitAndGetElement(driver,By.id("txtIpStart4"),50).clear();
    	waitAndGetElement(driver,By.id("txtIpStart4"),50).sendKeys("2");
    	waitAndGetElement(driver,By.id("txtIpEnd1"),50).clear();
    	waitAndGetElement(driver,By.id("txtIpEnd1"),50).sendKeys("172");
    	waitAndGetElement(driver,By.id("txtIpEnd2"),50).clear();
    	waitAndGetElement(driver,By.id("txtIpEnd2"),50).sendKeys("29");
    	waitAndGetElement(driver,By.id("txtIpEnd3"),50).clear();
    	waitAndGetElement(driver,By.id("txtIpEnd3"),50).sendKeys("40");
    	waitAndGetElement(driver,By.id("txtIpEnd4"),50).clear();
    	waitAndGetElement(driver,By.id("txtIpEnd4"),50).sendKeys("10");
    }
	
	public void clickAddButton(){
		waitAndGetElement(driver,By.id("linkAddIps"),50);
		waitAndClickElement(driver,By.id("linkAddIps"),50);
	}
	
	public void clickSaveButton(){
		waitAndGetElement(driver,By.id("linkSaveIpPoolDialog"),50);
		waitAndClickElement(driver,By.id("linkSaveIpPoolDialog"),50);
	}
}
