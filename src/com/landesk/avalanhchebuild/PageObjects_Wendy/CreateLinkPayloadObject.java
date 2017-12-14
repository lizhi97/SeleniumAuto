package com.landesk.avalanhchebuild.PageObjects_Wendy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.landesk.PageBase;

public class CreateLinkPayloadObject extends PageBase{
	public CreateLinkPayloadObject(WebDriver driver){
		super(driver); 
		this.driver = driver;
	}
	public void clickNewPayload(){
		waitAndGetElement(driver,By.id("linkAddPayload"),50);
		((JavascriptExecutor) driver).executeScript("PrimeFaces.ab({source:'linkAddPayload',process:'linkAddPayload',update:'dialogContent_dialogNewPayload',oncomplete:function(xhr,status,args){openDialog(dialogNewPayloadVar);}});return false;");

	}
	public void chooseLink() 
	{
		waitAndGetElement(driver,By.xpath("//div[@class='smartDeviceInput']/table[@id='radioPayloadPlatform']/tbody/tr[3]/td"),15).click();
		waitAndGetElement(driver,By.id("linkPayloadType_Content_Link"),50).click();	 
		 
	}
	
	public void InputPayloadName(String PayloadName){
		waitAndGetElement(driver,By.id("txtLinkPayloadName"),50).clear();
    	waitAndGetElement(driver,By.id("txtLinkPayloadName"),50).sendKeys(PayloadName);
		
	}
	
	public void InputLabelName(String LabelName){
		waitAndGetElement(driver,By.id("txtLinkLabel"),50).clear();
    	waitAndGetElement(driver,By.id("txtLinkLabel"),50).sendKeys(LabelName);
		
	}
	
	public void InputURL(String LinkUrl){
		waitAndGetElement(driver,By.id("linkUrl"),50).clear();
    	waitAndGetElement(driver,By.id("linkUrl"),50).sendKeys(LinkUrl);
		
	}
	public void LinkOptionsforiOS(){
		waitAndGetElement(driver,By.id("chkLinkPrecomposedIcon"),50).click();	
		waitAndGetElement(driver,By.id("chkLinkFullScreen"),50).click();
	}
	public void DeploymentMethod(int Deployment){
		switch(Deployment){
		case 0:
		{
			waitAndGetElement(driver,By.id("radioLinkDeploymentType-0"),50).click();
			break;
		}
		case 1:
		{
			 waitAndGetElement(driver,By.id("radioLinkDeploymentType-1"),50).click();
			 break;
		}
		}
	}
	public void OpenWith(int OpenMethod){
		switch(OpenMethod){
		case 0:
		{
			waitAndGetElement(driver,By.id("radioLinkType-0"),50).click();
			break;
		}
		case 1:
		{
			 waitAndGetElement(driver,By.id("radioLinkType-1"),50).click();
			 break;
		}
		}
	}
	public void SaveLinkPayload(){
		waitAndGetElement(driver,By.id("buttonPayloadSave"),50).click();
		((JavascriptExecutor) driver).executeScript("validatePayload();;PrimeFaces.ab({source:'buttonPayloadSave',process:'newPayload',update:'primeMessages_dialogNewPayload availablePayloadsPanel dialogContent_dialogNewSmartDeviceProfile',onsuccess:function(data,status,xhr){updateSyncStatusSyncContainer();},oncomplete:function(xhr,status,args){savePayload(args);doValidate(true);}});return false;");
	}
	public void sleep(int msec){
		 try {
				Thread.sleep(msec);
			}
			catch (InterruptedException ie)
			{}			
		}

}

