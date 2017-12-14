package com.landesk.avalanche.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.landesk.PageBase;

public class CreateSoftwareProfileObj extends PageBase{
	
	public CreateSoftwareProfileObj(WebDriver driver){
		super(driver); 
		this.driver = driver;
	}
	
	 public void inputProFileName(String profileName){
	    	waitAndGetElement(driver,By.id("txtSoftwareProfileName"),50).clear();
	    	waitAndGetElement(driver,By.id("txtSoftwareProfileName"),50).sendKeys(profileName);
	    }
	 
	 public void clickSaveButton(){
	    	waitAndGetElement(driver,By.id("linkSoftwareProfileSave"),50);
	    	((JavascriptExecutor) driver).executeScript("mojarra.jsfcljs(document.getElementById('formEditSoftwareProfile'),{'linkSoftwareProfileSave':'linkSoftwareProfileSave'},'');return false");
	    }
	 
	 public void newSoftwarePackage(){
	    	waitAndGetElement(driver,By.id("softwarePackageNewCommand"),50);
	    	((JavascriptExecutor) driver).executeScript("mojarra.jsfcljs(document.getElementById('formSoftwareProfile'),{'softwarePackageNewCommand':'softwarePackageNewCommand'},'');return false");
	    }
	 public void seleSoftpacktoAdd(int packagetype){
	     switch (packagetype){
	     case 0:
	    	 {
	    		 waitAndGetElement(driver,By.cssSelector("input[value='installAvaPackage']"),50).click();
	    		 waitAndGetElement(driver,By.id("txtAvalancheFile_input"),100).sendKeys("E:\\MobileAuto\\auto\\SQL2000SampleDb.msi");
	    		 break;
	    	 }
	     case 1:
	    	 {   waitAndGetElement(driver,By.cssSelector("input[value='installAvaPackage']"),50).click();
	    	     break;
	    	 }
	     case 2:
	    	 {
	    		 waitAndGetElement(driver,By.cssSelector("input[value='installAvaPackage']"),50).click();
	    		 break;
	    	 }
	     }
	     
	     WebElement nextbtn = waitAndGetElement(driver,By.id("btnNext"),50);
	     while(!(nextbtn.isEnabled()))
	     {
			 nextbtn = waitAndGetElement(driver,By.id("btnNext"),10);
		 }
		 nextbtn.click();     
		 
	    }
	 public void inputPackageName(String packageName)
	 {
	    	waitAndGetElement(driver,By.id("txtSoftwarePackageName"),50).clear();
	    	waitAndGetElement(driver,By.id("txtSoftwarePackageName"),50).sendKeys(packageName);
	 }
		 
	 public void clickNextButton()
	 {
		 WebElement nextbtn = waitAndGetElement(driver,By.id("btnNext"),80);
		 nextbtn.click(); 
		 
	 }
	 
	 public void installStatus()
	 {
		 //WebElement fillBar=waitAndGetElement(driver,By.id("fillBarInstallStatus"),50);
		 waitAndGetElement(driver,By.id("fillBarInstallStatus"),100);
		 WebElement nextbtn = waitAndGetElement(driver,By.id("btnNext"),20);
		 nextbtn.click(); 
		 
	 }
	 
	 public void clickFinishbutton (int enable)
	 {
		 switch (enable)
		 {
		 case 1:
			 waitAndGetElement(driver,By.cssSelector("input[value='1']"),10).click();
			 break;
		 case 0:
			 waitAndGetElement(driver,By.cssSelector("input[value='0']"),10).click();
			 break;
		 }
		 waitAndGetElement(driver,By.cssSelector("input[value='Finish']"),10).click();
	 }
}
