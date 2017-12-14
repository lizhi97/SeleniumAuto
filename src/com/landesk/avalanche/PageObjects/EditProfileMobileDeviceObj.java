package com.landesk.avalanche.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.landesk.PageBase;

public class EditProfileMobileDeviceObj extends PageBase {
	
	public EditProfileMobileDeviceObj(WebDriver driver){
		super(driver); 
		this.driver = driver;
	}
	
    public void inputProFileName(String profileName){
    	waitAndGetElement(driver,By.id("txtMdProfileName"),50).clear();
    	waitAndGetElement(driver,By.id("txtMdProfileName"),50).sendKeys(profileName);
    }
	
    public void checkEnableBox(){
    	waitAndClickElement(driver,By.id("chkMdProfileEnabled"),50);
    }
    
	public boolean getCheckBoxValueStatus() {
		if (waitAndGetElement(driver, By.id("chkMdProfileEnabled"), 50)
				.isSelected()) {
			return true;
		} else {
			return false;
		}

	}
	

	
	public boolean getInputTextStatus(){
		if(waitAndGetElement(driver, By.id("txtMdProfileName"), 50).isEnabled()){
			return true;
		}else{
			return false;
		}
	}
    
    public void clickSaveButton(){
    	waitAndGetElement(driver,By.id("linkMdProfileSave"),50);
    	((JavascriptExecutor) driver).executeScript("PrimeFaces.ab({source:'linkMdProfileSave',process:'linkMdProfileSave generalProperties geofenceSettingsPart1 geofenceSettingsPart2 locationBasedtag panelRcSettings divManagedPanels',update:'pageMessages'});return false;");
    }
    
    public void clearProfileNameText(){
    	waitAndGetElement(driver,By.id("txtMdProfileName"),50).clear();
    }
    
    public String getWarninMessageWarning(){
    	String actualString = waitAndGetElement(driver,By.xpath(".//*[@id='pageMessages']/div/ul/li/span"),50).getText();
    	return actualString;
    }
      
    public void clickWizardButton(){
    	waitAndClickElement(driver,By.id("linkMdProfileSelectionCritWizard"),50);
    }
    public void clickOnWizardSelectList(){
    	waitAndClickElement(driver,By.id("filterPropertiesDdl"),50);
    	
    	
    }
    public void selectColumnsItem(){
    	waitAndClickElement(driver,By.xpath(".//option[contains(text(),'Columns')]"),50);
    	
    }
    
    public void clickInsertButton(){
    	
    	waitAndClickElement(driver,By.id("button_insert"),50);
    }
    
    
    public void clickEqualButton(){
    	
    	waitAndClickElement(driver,By.id("button_eq"),50);
    }
    
    public void clickWizardOKButton(){
    	
    	waitAndClickElement(driver,By.id("formEditMobileDeviceProfileSelCrit-j_idt674"),50);
    }
    
    public void inputWizardField(){
    	
    	waitAndGetElement(driver,By.id("formEditMobileDeviceProfileSelCrit-txtSelectionCriteria"),50).sendKeys("3");
    }
    
    public void clickClosedButton(){
		 waitAndGetElement(driver,By.id("linkMdProfileCancel"),50);
		 waitAndClickElement(driver,By.id("linkMdProfileCancel"),50);
	 }
    
}
