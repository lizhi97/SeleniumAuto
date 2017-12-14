package com.landesk.ldms.webconsole.TestCases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.landesk.TestCaseBase;
import com.landesk.ldms.webconsole.PageObjects.InventoryScanPageObject;
import com.landesk.ldms.webconsole.PageObjects.MainPageObject;

public class RemoteExecute  extends TestCaseBase{
	WebDriver driver;
	String mainHandle;
	MainPageObject mPage;
	
	/**
	 * <b>Remote execute with parameters</b><br>
	 * 1.Install a core and add nodes to the core.<br>
	 * 2.Point a web browser to the core.<br>
	 * 3.Open a browser.<br>
	 * 4.Point to the core with an http command: http://[CoreName]/remote.<br>
	 * 5.Click Device view>My devices.<br>
	 * 6.Select All devices.<br>
	 * 7.R-Click the client machines and select Scan devices.<br>
	 * 8.Target more than two client machines.<br>
	 * 9.R-Click the client machines and on the target list.<br>
	 * 10.D-Click the client machines on the target list.<br>
	 * 
	 * 
	 * author Jack,cheng
	 * @param url
	 * @param loginexe
	 * @param context
	 * @throws Exception
	 */

	
	@Parameters({"url","loginexe","deviceName"})
	@Test
	public void  remoteExecute(String url,String loginexe,String deviceName, ITestContext context) throws Exception{
		System.out.println("Prepared: "+"1.Install a core and add nodes to the core.");
		System.out.println("Prepared: "+"2.Point a web browser to the core.");
		
		/*
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		String mainHandle = driver.getWindowHandle();
		MainPageObject mPage = new MainPageObject(driver);
		
		*/
		formatStepResult(openBrowser(),"3.Open a browser");			
		
		/*
		Runtime.getRuntime().exec(loginexe);
		driver.get(url);
		*/
		
		formatStepResult(openCoreURL(driver,loginexe,url),"4.Point to the core with an http command: http://[CoreName]/remote.");			
	//	System.out.println("PASSED: "+"5.Initiate an inventory scan.");
		/*
		mPage.letMainPageLoad();
		mPage.clickMyDevicesElement();
		*/
		
		formatStepResult(clickMydevice(mPage),"5.Click Device view>My devices.");
		
		/*
		mPage.clickDevicePlusElement();
		mPage.clickAllDevicesElement();
		*/
		
		formatStepResult(clickAllDevice(mPage),"6.Select All devices.");
		
	
		//mPage.rightClickOneDevice("2");
		/*
		mPage.rightClickDeviceByName(deviceName);
		mPage.ClickRightScanMenu();

	
		InventoryScanPageObject iPage=new InventoryScanPageObject(driver);
		iPage.openWindow();
	
		iPage.clickScanbuttonElement();
	
		iPage.checkScanResult();
		iPage.ClickOkbuttonElement();
        */
        
		formatStepResult(startInventoyScan(mPage,deviceName,driver),"7.R-Click the client machines and select Scan devices.");
		
		/*
		//switch to main page.
		mPage.setDriverByHandle(mainHandle);
		//mPage.rightClickOneDevice("2");
		mPage.rightClickDeviceByName(deviceName);
		mPage.ClickTargetMenu();
	    */
		
		formatStepResult(targerDevice(mPage,deviceName,mainHandle),"8.Target more than two client machines.");
		
		
		/*
		mPage.rightClickTargetElement();
		Assert.assertEquals(0, mPage.isContainScanmenu(), "Shortcut menu of \"Scan\" was found");
		*/
		formatStepResult(checkRightClickMenu(mPage),"9.R-Click the client machines and on the target list.");
		
		
		//mPage.checkDoubleclickmenu(deviceName);
		
		formatStepResult(checkDoubleClickMenu(mPage,deviceName),"10.D-Click the client machines on the target list.");
		
		driver.close();
		driver.quit();		

	}
	
	private boolean openBrowser(){
		try {	
			 driver = new FirefoxDriver();
		driver.manage().window().maximize();
		mainHandle = driver.getWindowHandle();
		mPage = new MainPageObject(driver);


			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	
	private boolean openCoreURL(WebDriver driver,String loginexe,String url){
		try {		
			Runtime.getRuntime().exec(loginexe);
		    driver.get(url);



			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	private boolean clickMydevice(MainPageObject mPage){
		try {		
			mPage.letMainPageLoad();
			mPage.clickMyDevicesElement();
			


			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	private boolean startInventoyScan(MainPageObject mPage,String deviceName,WebDriver driver){
		try {		
			
		
			//mPage.rightClickOneDevice("2");
			mPage.rightClickDeviceByName(deviceName);
			mPage.ClickRightScanMenu();

		
			InventoryScanPageObject iPage=new InventoryScanPageObject(driver);
			iPage.openWindow();
		
			iPage.clickScanbuttonElement();
		
			iPage.checkScanResult();
			iPage.ClickOkbuttonElement();
			


			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	private boolean clickAllDevice(MainPageObject mPage){
		try {		
			mPage.clickDevicePlusElement();
			mPage.clickAllDevicesElement();
			


			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	private boolean targerDevice(MainPageObject mPage,String deviceName,String mainHandle){
		try {		
			
			/**switch to main page.*/
			mPage.setDriverByHandle(mainHandle);
			mPage.rightClickDeviceByName(deviceName);
			mPage.ClickTargetMenu();
			
	
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	private boolean checkRightClickMenu(MainPageObject mPage){
		try {		
			
			mPage.rightClickTargetElement();
			Assert.assertEquals(0, mPage.isContainScanmenu(), "Shortcut menu of \"Scan\" was found");
	
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	

	
	private boolean checkDoubleClickMenu(MainPageObject mPage,String deviceName){
		try {		
			mPage.checkDoubleclickmenu(deviceName);

			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	
}
