package com.landesk.avalanche.PageObjects;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.landesk.PageBase;

public class CreateNewAlertProfileObj extends PageBase{
	
	public CreateNewAlertProfileObj(WebDriver driver){
		super(driver); 
		this.driver = driver;

	}
	
	 public String inputAlertProfileName(int length){
			String  base = "newalertprofilename";
			Random random = new Random();
			StringBuffer sb = new StringBuffer();
			for (int i =0; i<length; i++){
				int number = random.nextInt(base.length());
				sb.append(base.charAt(number));
			}
			return sb.toString();

}
	
	 public void inputAlertProfileName(String profileName){
	    	waitAndGetElement(driver,By.id("txtAlertProfileName"),50).clear();
	    	waitAndGetElement(driver,By.id("txtAlertProfileName"),50).sendKeys(profileName);
	    }
	 
	 public void clickAlertProfileSaveButton(){
	    	waitAndGetElement(driver,By.id("linkAlertProfileSave"),50);
	    	((JavascriptExecutor) driver).executeScript("mojarra.jsfcljs(document.getElementById('alertProfileForm'),{'linkAlertProfileSave':'linkAlertProfileSave'},'');return false");
	    }
	 
	 public void clickAlertProfileCloseButton(){
	       	waitAndGetElement(driver,By.id("linkAlertProfileClose"),50);
	    	((JavascriptExecutor) driver).executeScript("mojarra.jsfcljs(document.getElementById('alertProfileForm0'),{'linkAlertProfileClose':'linkAlertProfileClose'},'');return false");
	    }
	 
	 public void clickAlertProfileCancleButton(){
	       	waitAndGetElement(driver,By.id("linkAlertProfileCancel"),50);
	    	((JavascriptExecutor) driver).executeScript("mojarra.jsfcljs(document.getElementById('alertProfileForm'),{'linkAlertProfileCancel':'linkAlertProfileCancel'},'');return false");
	    }
	 
	 public void clickAlertProfileCloneButton(){
	       	waitAndGetElement(driver,By.id("linkAlertProfileClone"),50);
	    	((JavascriptExecutor) driver).executeScript("mojarra.jsfcljs(document.getElementById('alertProfileForm0'),{'linkAlertProfileClone':'linkAlertProfileClone'},'');return false");
	    }
	 
	 public void clickCheckboxOfAlertProfile(int order){
			waitAndClickElement(driver,By.id("availableProfilesTable-"+ Integer.toString(order)+"-rowSelect"),60);
			
		}
	 
	 public void selectAlertProfile(){
			waitAndGetElement(driver,By.id("link_availableProfilesPanel_showFilters"),50);
			((JavascriptExecutor) driver).executeScript("showHideFilters('availableProfilesPanel', true);PrimeFaces.ab({source:'link_availableProfilesPanel_showFilters',process:'link_availableProfilesPanel_showFilters'});return false;");
		 	/*waitAndGetElement(driver,By.id("j_idt380-0-j_idt383"),50);
			((JavascriptExecutor) driver).executeScript("PrimeFaces.ab({source:this,event:'valueChange',process:'j_idt380-0-j_idt383',update:'availableProfilesPanel',params:[{name:'panelFilter',value:'avail_ALERT'}]}, arguments[1]);");*/
			waitAndClickElement(driver,By.id("j_idt380-0-j_idt383"),50);
	 }
	 
	 public void clickApplyButton(){
			waitAndClickElement(driver,By.id("linkAvailProfApply"),50);
	 }
	 
	 public void clickScheduleDeployButton(){
		 	WebElement e = waitAndGetElement(driver,By.id("btnSyncProfile"),60);
		 	System.out.println("tttttt="+e.getText());
		 	
			waitAndClickElement(driver,By.xpath(".//*[@id='btnSyncProfile']"),50);
	 }
	 
	 public void clickApplyProfileButton(){
			waitAndGetElement(driver,By.id("linkFinishWizard"),50);
			((JavascriptExecutor) driver).executeScript("disableScreenForUpdate()");

	 }
	 
	 public void clickEditButton(){
			waitAndGetElement(driver,By.id("linkAlertProfileEdit"),50);
			((JavascriptExecutor) driver).executeScript("mojarra.jsfcljs(document.getElementById('alertProfileForm0'),{'linkAlertProfileEdit':'linkAlertProfileEdit'},'');return false");
	 }
	  
	 public void clickAlertProfileName(){
			waitAndClickElement(driver,By.xpath(".//*[@id='availableProfilesTable-0-draggedProfileInfo_mobileDevice']/div[2]"),50);
	 }
	 	 
	public void sleep(int msec){
		 try {
				Thread.sleep(msec);
			}
			catch (InterruptedException ie)
			{}			
		}
	 
	 public void deleteAlertProfile(){
			waitAndGetElement(driver,By.id("linkDeletePreCheck"),100);
			((JavascriptExecutor) driver).executeScript("PrimeFaces.ab({source:'linkDeletePreCheck',process:'linkDeletePreCheck availableProfilesTable',oncomplete:function(xhr,status,args){args.canDeleteProfile ? confirmDeletion('deleteProfileText', 'linkDeleteAvailableProfiles','availableProfilesTable')                                             : handleOnCompleteArgs(args, null);;}});return false;");
			waitAndClickElement(driver,By.id("linkDeleteConfirm"),50);			
		}
}
