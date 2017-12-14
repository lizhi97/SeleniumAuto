package com.landesk.avalanhchebuild.PageObjects_Wendy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;



//import org.openqa.selenium.WebElement;
import com.landesk.PageBase;

public class CreateAppPayloadObject extends PageBase {
	
	public CreateAppPayloadObject(WebDriver driver){
		super(driver); 
		this.driver = driver;
	}
	public void clickNewPayload(){
		waitAndGetElement(driver,By.id("linkAddPayload"),50);
		((JavascriptExecutor) driver).executeScript("PrimeFaces.ab({source:'linkAddPayload',process:'linkAddPayload',update:'dialogContent_dialogNewPayload',oncomplete:function(xhr,status,args){openDialog(dialogNewPayloadVar);}});return false;");

	}
	public void selePlatform(int PlatformType) {
		 switch(PlatformType){
		 case 0:
		 {
			 waitAndGetElement(driver,By.xpath("//div[@class='smartDeviceInput']/table[@id='radioPayloadPlatform']/tbody/tr[1]/td"),15).click();
			 waitAndGetElement(driver,By.id("linkPayloadType_Software"),50).click();
			 break;
		 }
		 case 1:
		 {
			 waitAndGetElement(driver,By.xpath("//div[@class='smartDeviceInput']/table[@id='radioPayloadPlatform']/tbody/tr[2]/td"),15).click();
			 waitAndGetElement(driver,By.id("linkPayloadType_Software"),50).click();
			 break;
			 		 }
		 case 2:
		 {
			 break;
		 }
		 case 3:
		 {
			 break;
		 }
		 }
		 
		 
	     }
	public void InputPayloadName(String PayloadName){
		waitAndGetElement(driver,By.id("txtSoftwarePayloadName"),50).clear();
    	waitAndGetElement(driver,By.id("txtSoftwarePayloadName"),50).sendKeys(PayloadName);
		
	}
	public void DeploymentMethod(int Deployment){
		switch(Deployment){
		case 0:
		{
			waitAndGetElement(driver,By.cssSelector("input[value='false']"),50).click();
			break;
		}
		case 1:
		{
			 waitAndGetElement(driver,By.id("deploymentType-1"),50).click();
			 break;
		}
		}
	}
	public void SoftwareHosting(int hosting){
		switch(hosting){
		case 0:
		{
			waitAndGetElement(driver,By.cssSelector("input[value='storeID']"),50).click();
			break;
		}
		case 1:
		{
			waitAndGetElement(driver,By.cssSelector("input[value='manifest']"),50).click();
			break;
		}
		case 2:
		{
			waitAndGetElement(driver,By.cssSelector("input[value='AvalancheOnDemand']"),50).click();
			break;
		}
		}
	}
	public void iOSChooseApp(String AppID){
		waitAndGetElement(driver,By.id("appleApplicationId"),50).sendKeys(AppID);
		//waitAndGetElement(driver,By.id("searchSoftwarePayloadiOS"),50);
		//((JavascriptExecutor) driver).executeScript("PrimeFaces.ab({source:'searchSoftwarePayloadiOS',process:'searchSoftwarePayloadiOS',update:'dialogContent_dlgAppSearch',oncomplete:function(xhr,status,args){openDialog(dlgAppSearchVar);}});return false;");
	}
	
	public void SavePayload(){
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
	//iOS app
	public void iOSAppName(String Appname){
		waitAndGetElement(driver,By.id("manifestAppName"),50).clear();
    	waitAndGetElement(driver,By.id("manifestAppName"),50).sendKeys(Appname);
		
	}
	
	public void iOSBrowseAppIcon(){
		waitAndGetElement(driver,By.id("softwareAppleImageFileUpload_input"),100).sendKeys("C:\\Users\\Administrator\\Desktop\\BridgeIT\\Gif\\lion.gif");
	}
	
	public void iOSManifestURL(String Manifesturl){
		waitAndGetElement(driver,By.id("appleManifestURL"),50).clear();
    	waitAndGetElement(driver,By.id("appleManifestURL"),50).sendKeys(Manifesturl);
	}
	
    public void iOSBundleID(String Bundleid){
    	waitAndGetElement(driver,By.id("enterpriseBundleId"),50).clear();
    	waitAndGetElement(driver,By.id("enterpriseBundleId"),50).sendKeys(Bundleid);
	}    
    
    public void iOSBundleVersion(String Bundleversion){
    	waitAndGetElement(driver,By.id("enterpriseBundleVersion"),50).clear();
    	waitAndGetElement(driver,By.id("enterpriseBundleVersion"),50).sendKeys(Bundleversion);
	}
    public void iOSLaunchPath(String Launchpath){
    	waitAndGetElement(driver,By.id("launchPath"),50).clear();
    	waitAndGetElement(driver,By.id("launchPath"),50).sendKeys(Launchpath);
	}
   
		
    //Android app
    public void AndroidSoftwareHosting(int hosting){
		switch(hosting){
		case 0:
		{
			waitAndGetElement(driver,By.cssSelector("input[value='playUrl']"),50).click();
			break;
		}
		case 1:
		{
			waitAndGetElement(driver,By.cssSelector("input[value='manifestUrl']"),50).click();
			break;
		}
		case 2:
		{
			waitAndGetElement(driver,By.cssSelector("input[value='AvalancheOnDemand']"),50).click();
			break;
		}
		}
	}
    public void AndroidChooseApp(String AndroidID){
		waitAndGetElement(driver,By.id("androidManifestURLForPlayStore"),50).sendKeys(AndroidID);
		//waitAndGetElement(driver,By.id("searchSoftwarePayloadiOS"),50);
		//((JavascriptExecutor) driver).executeScript("PrimeFaces.ab({source:'searchSoftwarePayloadiOS',process:'searchSoftwarePayloadiOS',update:'dialogContent_dlgAppSearch',oncomplete:function(xhr,status,args){openDialog(dlgAppSearchVar);}});return false;");
	}
    
    public void AndroidAppName(String Appname){
		waitAndGetElement(driver,By.id("androidManifestAppName"),50).clear();
    	waitAndGetElement(driver,By.id("androidManifestAppName"),50).sendKeys(Appname);
		
	}
    public void AndroidBrowseAppIcon(){
		waitAndGetElement(driver,By.id("softwareImageFileUpload_input"),100).sendKeys("C:\\Users\\Administrator\\Desktop\\BridgeIT\\Gif\\lion.gif");
	}
    public void AndrodManifestURL(String Manifesturl){
		waitAndGetElement(driver,By.id("androidManifestURL1"),50).clear();
    	waitAndGetElement(driver,By.id("androidManifestURL1"),50).sendKeys(Manifesturl);
	}
    public void AndroidPackageID(String PackageID){
    	waitAndGetElement(driver,By.id("androidApplicationId"),50).clear();
    	waitAndGetElement(driver,By.id("androidApplicationId"),50).sendKeys(PackageID);
	}
    public void AndroidBundleVersion(String AdnroidBundleversion){
    	waitAndGetElement(driver,By.id("androidBundleVersion"),50).clear();
    	waitAndGetElement(driver,By.id("androidBundleVersion"),50).sendKeys(AdnroidBundleversion);
	}
	

}
