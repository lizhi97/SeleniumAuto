package com.landesk.avalanche.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.landesk.PageBase;

public class CreateNewNetworkProfileObj extends PageBase {
	
	public CreateNewNetworkProfileObj(WebDriver driver){
		super(driver); 
		this.driver = driver;
	}
	
    public void inputProFileName(String profileName){
    	waitAndGetElement(driver,By.id("txtNetworkProfileName"),50).clear();
    	waitAndGetElement(driver,By.id("txtNetworkProfileName"),50).sendKeys(profileName);
    }
    
   	
    public void editMDIpAddressPools(){
        waitAndGetElement(driver,By.id("MuIpPoolCommand"),50);
        ((JavascriptExecutor) driver).executeScript(";PrimeFaces.ab({source:'MuIpPoolCommand',process:'MuIpPoolCommand',update:'ipAddressPoolContent hiddenIpData',oncomplete:function(xhr,status,args){onDialogIPAddressPoolsShow(dialogIPAddressPoolsVar);}});return false;");
    
    }
    
    public void inputIpAddressRange(){
    	waitAndGetElement(driver,By.id("txtIpStart1"),50);
    	waitAndGetElement(driver,By.id("txtIpStart2"),50);
    	//((JavascriptExecutor) driver).executeScript("ipPartNext(event, this,'txtIpStart2', 'hiddenIpStart')");
    	((JavascriptExecutor) driver).executeScript("return restrictIpPart(event, this, 'txtIpStart2');");
    	((JavascriptExecutor) driver).executeScript("ipPartNext(event, this,'txtIpStart2', 'hiddenIpStart')");
//    	System.out.println("element statu="+ e.isEnabled());
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
    
    
    public void checkEnableBox(){
    	waitAndClickElement(driver,By.id("chkNetworkEnabled"),50);
    }
    
    public void checkManageWWAN(){
    	waitAndClickElement(driver,By.id("chkManageWWAN"),50);
    }
    
    public void clickSaveButton(){
    	waitAndGetElement(driver,By.id("linkNetworkProfileSave"),50);
    	((JavascriptExecutor) driver).executeScript("mojarra.jsfcljs(document.getElementById('netProEditForm'),{'linkNetworkProfileSave':'linkNetworkProfileSave'},'');return false");
    }
    
            
    public void clickCloneButton(){
    	waitAndGetElement(driver,By.id("linkNetworkProfileClone"),50);
//     	waitAndClickElement(driver,By.id("linkNetworkProfileClone"),50);
    	((JavascriptExecutor) driver).executeScript("mojarra.jsfcljs(document.getElementById('networkProfilePage'),{'linkNetworkProfileClone':'linkNetworkProfileClone'},'');return false");
    }
    
    public void clickEditButton(){
    	waitAndGetElement(driver,By.id("linkNetworkProfileEdit"),50);
//     	waitAndClickElement(driver,By.id("linkNetworkProfileClone"),50);
    	((JavascriptExecutor) driver).executeScript("mojarra.jsfcljs(document.getElementById('networkProfilePage'),{'linkNetworkProfileEdit':'linkNetworkProfileEdit'},'');return false");
    }
    
    public String getIpAddressPoolInfo(){
    	String actualString = waitAndGetElement(driver,By.id("linkMobileDeviceIPAddressPool"),50).getText();
    	return actualString;
    }
    public void clickCloseButton(){
       	waitAndGetElement(driver,By.id("linkNetworkProfileClose"),50);
 //      	waitAndClickElement(driver,By.id("linkNetworkProfileClose"),50);
       	((JavascriptExecutor) driver).executeScript("mojarra.jsfcljs(document.getElementById('networkProfilePage'),{'linkNetworkProfileClose':'linkNetworkProfileClose'},'');return false");
    }

   
    
}
