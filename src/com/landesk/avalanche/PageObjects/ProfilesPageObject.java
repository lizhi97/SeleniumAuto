package com.landesk.avalanche.PageObjects;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.landesk.PageBase;

public class ProfilesPageObject extends PageBase{


	public ProfilesPageObject(WebDriver driver){
		super(driver); 
		this.driver = driver;

	}

	public void clickProfileFilter(){
		waitAndGetElement(driver,By.id("j_idt377-5-j_idt380"),50);
		((JavascriptExecutor) driver).executeScript("showHideFilters('availableProfilesPanel', true);PrimeFaces.ab({source:'link_availableProfilesPanel_showFilters',process:'link_availableProfilesPanel_showFilters'});return false;");
	}

	public boolean isVisiableFilterProfile(){
		WebElement elementOpenFilter = waitAndGetElement(driver, By.id("link_availableProfilesPanel_showFilters"),60);
		return elementOpenFilter.isEnabled();
	}
	public void checkMobileDeviceFilter(){
		waitAndClickElement(driver,By.id("j_idt377-5-j_idt380"),50);
		((JavascriptExecutor) driver).executeScript("PrimeFaces.ab({source:this,event:'valueChange',process:'j_idt377-5-j_idt380',update:'availableProfilesPanel',params:[{name:'panelFilter',value:'avail_SMARTDEVICE'}]}, arguments[1]);");
	}

	public void clickNewProfile(){
		waitAndGetElement(driver,By.id("linkAddProfile"),50);
		((JavascriptExecutor) driver).executeScript("javascript:displayReusableLightbox('New Profile', 'divAddProfile', 'linkAddProfile')");

	}

	public boolean getStatusCreateButton(){

		if(waitAndGetElement(driver,By.id("linkAddProfile"),50).isEnabled()){
			return true;
		} else{
			return false;
		}
	}

	public void clickMDbutton(){ 
		waitAndGetElement(driver,By.id("linkAvailProfilesCreateMD"),50);
		((JavascriptExecutor) driver).executeScript("mojarra.jsfcljs(document.getElementById('profilePage'),{'linkAvailProfilesCreateMD':'linkAvailProfilesCreateMD','profileType':'MU-DEVICE'},'');return false;");
	}

	public void clickNetworkSetting(){
		waitAndGetElement(driver,By.id("linkAvailProfilesCreateNetwork"),50);
		((JavascriptExecutor) driver).executeScript("mojarra.jsfcljs(document.getElementById('profilePage'),{'linkAvailProfilesCreateNetwork':'linkAvailProfilesCreateNetwork','profileType':'NETWORK'},'');return false;");
	}

	//Zhang Xiaojing -clickNewSoftware
	public void clickNewSoftware(){ 
		waitAndGetElement(driver,By.id("linkAvailProfilesCreateSoftware"),50);
		((JavascriptExecutor) driver).executeScript("mojarra.jsfcljs(document.getElementById('profilePage'),{'linkAvailProfilesCreateSoftware':'linkAvailProfilesCreateSoftware','profileType':'SOFTWARE'},'');return false");
	}

	public void DeleteProfileInputByOrder(int order){
		// gets all rows
		//WebElement table = waitAndGetElement(driver,By.id("availableProfilesTable_data"),60);
		waitAndClickElement(driver,By.id("availableProfilesTable-"+ Integer.toString(order)+"-rowSelect"),60);
		deleteOneProfile();
	}
	
	public void clickProfileNameElement(String name){
		ArrayList<WebElement> item = (ArrayList<WebElement>) waitAndGetElements(driver,By.xpath("*//div[contains(text(),'"+name+"')]"),60);
		WebElement element = null;
		for(int i =0 ;i < item.size();i++ ){
			if(!item.get(i).equals("")){
				 element = item.get(i);
				 element.click();
			}
		}
		
	}
	
	public void clickProfileByName(String name){
		clickProfile(getPorfileNameOrder(name));
	}
	
	public int getPorfileNameOrder(String name){
		// gets all rows
		//WebElement table = waitAndGetElement(driver,By.id("availableProfilesTable_data"),60);
		List<WebElement> rows = waitAndGetElements(driver,By.xpath(".//*[@id='availableProfilesTable_data']/tr/td"),60);
		// for every line, store both columns
		int i=1;
		for (WebElement row : rows) {
			if(row.getText().contains(name)){
				break;
			}   
			i++;

		}
		return i/7;
	}
    
	public void clickProfile(int order){
		waitAndClickElement(driver,By.id("availableProfilesTable-"+ Integer.toString(order)+"-draggedProfileInfo_mobileDevice"),60);
		
	}
	
	public void clickCheckboxOfProfile(int order){
		waitAndClickElement(driver,By.id("availableProfilesTable-"+ Integer.toString(order)+"-rowSelect"),60);
		
	}

	public void deleteOneProfile(){
		waitAndGetElement(driver,By.id("linkDeletePreCheck"),50);
		((JavascriptExecutor) driver).executeScript("PrimeFaces.ab({source:'linkDeletePreCheck',process:'linkDeletePreCheck availableProfilesTable',oncomplete:function(xhr,status,args){args.canDeleteProfile ? confirmDeletion('deleteProfileText', 'linkDeleteAvailableProfiles','availableProfilesTable')                                             : handleOnCompleteArgs(args, null);;}});return false;");
		waitAndClickElement(driver,By.id("linkDeleteConfirm"),50);
	}
	
	

	public void clickAlert() {
		waitAndGetElement(driver,By.id("linkAvailProfilesCreateAlert"),50);
		((JavascriptExecutor) driver).executeScript("mojarra.jsfcljs(document.getElementById('profilePage'),{'linkAvailProfilesCreateAlert':'linkAvailProfilesCreateAlert','profileType':'ALERT'},'');return false");
				
	}
}	
