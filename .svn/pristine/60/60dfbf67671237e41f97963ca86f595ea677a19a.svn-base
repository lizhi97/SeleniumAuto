package com.landesk.avalanche.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.landesk.PageBase;

public class ViewProfilePageObject extends PageBase{
	
	public ViewProfilePageObject(WebDriver driver){
		super(driver); 
		this.driver = driver;

	}

	 public void clickClosedButton(){
		
		 waitAndClickElement(driver,By.id("linkMdProfileCancel"),50);
		 //((JavascriptExecutor) driver).executeScript("mojarra.jsfcljs(document.getElementById('formMobileDeviceProfile'),{'linkMdProfileCancel':'linkMdProfileCancel'},'');return false");
	 }

	 public void clickEditButton(){
		 waitAndGetElement(driver,By.id("linkMdProfileEdit"),50);
		 waitAndClickElement(driver,By.id("linkMdProfileEdit"),50);
	 }
	 
	 public void clickCloneButton(){
		 waitAndClickElement(driver,By.id("linkMdProfileClone"),50);
	 }
	 
	 public void test(){
		 
		
		 WebElement we = waitAndGetElement(driver,By.xpath(".//*[@id='generalProperties']"),50);
		 System.out.println(we.getText());
	 }
}
