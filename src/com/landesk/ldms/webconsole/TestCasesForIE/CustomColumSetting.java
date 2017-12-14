package com.landesk.ldms.webconsole.TestCasesForIE;


import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.landesk.TestCaseBaseForIE;
import com.landesk.ldms.Utils.util;
import com.landesk.ldms.webconsole.PageObjectsForIE.AttributePageObject;
import com.landesk.ldms.webconsole.PageObjectsForIE.MainPageObject;

/**
 * Custom column set on the web console 
 * <b>62502: Custom column sets</b><br>
 * 1.Login to the Web console and create a new column set with different attributes.<br>
 * 2.Try to add a new column <br>
 * 3.Try to delete the old column <br>
 * 4.Try to change the order of the column<br>
 * 5.Remove all default column sets and add others<br>
 * 
 * @author Winsy
 */

public class CustomColumSetting  extends TestCaseBaseForIE{
	
	MainPageObject mPage = new MainPageObject(driver);
	AttributePageObject aPage= new AttributePageObject(driver);
	
	boolean debug = true;
	
	@Parameters({"url","loginexe","column1","column2",})
	@Test
	public void customColumSetting(String url, String loginexe,String column1,String column2,ITestContext context){
		
		formatStepResult(loginWebconsole1(url,loginexe,column1),"loginIE");
		//formatStepResult(loginAndCreateNewColumnset(url,loginexe,column1),"1.Login to the Web console and create a new column set with different attributes.");
		//formatStepResult(addNewColumn(column2),"2.Try to add a new column");
		//formatStepResult(deleteOldColumn(column1),"3.Try to delete the old column");
		//formatStepResult(changeOrderForColumn(column2),"4.Try to change the order of the column");
		//formatStepResult(removeDefaulteColumn(url,loginexe,column2),"5.Remove all default column sets and add others");
		
	
	}
	
	protected boolean loginWebconsole1(String url,String loginexe,String colName){	
		
		String currentDir = System.getProperty("user.dir");
		System.out.println("Current Dir: " + currentDir);
		
		try{
			util uu= new util();
			System.setProperty("webdriver.ie.driver", currentDir + "\\LoginExe\\IEDriverServer.exe");
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			driver=new InternetExplorerDriver(ieCapabilities);
//			driver=new InternetExplorerDriver();
//			driver = initIEDriver();
//			driver.manage().window().maximize();
//			System.out.println("test1");
//			mPage = new MainPageObject(driver);		
			
			
//			Runtime.getRuntime().exec(loginexe);
			
			driver.get(url);

			Process p = Runtime.getRuntime().exec("c:\\jruby\\bin\\jruby.bat " + currentDir + "\\LoginExe\\login.ruby");
			p.waitFor();
			
			System.out.println("Current Dir: " + currentDir);
			
//			driver.switchTo().frame("main");
//			driver.switchTo().frame("left");
//			driver.switchTo().frame("left");
//			driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/table[2]/tbody/tr/td/a")).click();

			
			
//			System.out.println("test2");
//			driver.get(url);
//			System.out.println("test3");
//			driver.switchTo().alert().accept();
//			System.out.println("test4");
			Thread.sleep(5000);
			//mPage.letMainPageLoad();
			System.out.println("test5");
			mainHandle=driver.getWindowHandle();
			System.out.println("handler=" + mainHandle);
			uu.isAlertPresent(driver);
			mPage.clickAdminGroupElement();
			mPage.clickperfGroupElement();
			Thread.sleep(2000);
			mPage.clickCustomSettingElement();
			Thread.sleep(2000);
			mPage.clickNewColumSet();
			AttributePageObject aPage= new AttributePageObject(driver);
			Thread.sleep(2000);
			mPage.clickNewColumSet();
			aPage.openWindow();
			aPage.clickSelAMTElement();
			if(debug) System.out.println("select AMT GUID");//select AMT GUID
			aPage.clickAddElement();
			if(debug) System.out.println("click Add");//click Add
			aPage.inputName(colName);
			if(debug) System.out.println("input name");//input name
			aPage.clickOk();
			if(debug) System.out.println("click OK--New");//click OK--New
	
			return true;
		}
		catch (Exception e){			
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	private boolean loginAndCreateNewColumnset(String url, String loginexe,String colName){
		try{
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			mPage = new MainPageObject(driver);		
			Runtime.getRuntime().exec(loginexe);
			driver.get(url);
			mPage.letMainPageLoad();
			mainHandle=driver.getWindowHandle();
			
			mPage.clickAdminGroupElement();
			mPage.clickperfGroupElement();
			Thread.sleep(2000);
			mPage.clickCustomSettingElement();
			Thread.sleep(2000);
			mPage.clickNewColumSet();
			AttributePageObject aPage= new AttributePageObject(driver);
			Thread.sleep(2000);
			mPage.clickNewColumSet();
			aPage.openWindow();
			aPage.clickSelAMTElement();
			if(debug) System.out.println("select AMT GUID");//select AMT GUID
			aPage.clickAddElement();
			if(debug) System.out.println("click Add");//click Add
			aPage.inputName(colName);
			if(debug) System.out.println("input name");//input name
			aPage.clickOk();
			if(debug) System.out.println("click OK--New");//click OK--New
	
			return true;
		}catch(Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	private boolean addNewColumn(String colName){
		try {
			mPage.setDriverByHandle(mainHandle);
			Thread.sleep(2000);
			mPage.clickNewColumSet();
			AttributePageObject aPage = new AttributePageObject(driver);
			Thread.sleep(2000);

			aPage.openWindow();
			aPage.inputName(colName);
			aPage.clickOk();
			
			return true;
		}catch(Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
		
	}
	
	private boolean deleteOldColumn(String colName){
		try{
			
			mPage.setDriverByHandle(mainHandle);
			Thread.sleep(2000);
			mPage.clickcolumnElement(colName);
			Thread.sleep(2000);
			mPage.clickDeleteElement();
			return true;
		}catch(Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	private boolean changeOrderForColumn(String colName){
		
		try{
			mPage.clickcolumnElement(colName);
			if(debug) System.out.println(" select the custom columns winsyColumnSet2");//select the custom columns (1,4)
			mPage.clickEditColumSet();
			aPage= new AttributePageObject(driver);
			Thread.sleep(2000);
			aPage.editWindow();
			aPage.clickTableElement();
			aPage.clickMovedown();
			aPage.clickOk();
			if(debug) System.out.println("click OK--Edit");
			mPage.setDriverByHandle(mainHandle);
			//Thread.sleep(3000);
			mPage.clickcolumnElement(colName);
			mPage.clickToolbarElement();
			mPage.clickMyDevicesElement();
	
			
			boolean b = mPage.getOrderIPAddress();
			Assert.assertEquals(b, true,"the IP Address order is changed");
			driver.close();
			driver.quit();
			return true;
		}catch(Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	private boolean removeDefaulteColumn(String url, String loginexe,String colName){
		try{
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().window();
			MainPageObject mPage = new  MainPageObject(driver);
			Runtime.getRuntime().exec(loginexe);
			driver.get(url);
			mPage.letMainPageLoad();
			
			mPage.clickAdminGroupElement();
			mPage.clickperfGroupElement();
			mPage.clickCustomSettingElement();
			mPage.clickcolumnElement(colName);
			mPage.clickDeleteElement();
			driver.close();
			driver.quit();
			return true;
		}catch(Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	
	
}
