package com.landesk.ldms.webconsole.TestCases;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.landesk.TestCaseBase;
import com.landesk.ldms.webconsole.PageObjects.AttributePageObject;
import com.landesk.ldms.webconsole.PageObjects.MainPageObject;

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

public class CustomColumSetting  extends TestCaseBase{
	
	MainPageObject mPage = new MainPageObject(driver);
	AttributePageObject aPage= new AttributePageObject(driver);
	
	boolean debug = true;
	
	@Parameters({"url","loginexe","column1","column2",})
	@Test
	public void customColumSetting(String url, String loginexe,String column1,String column2,ITestContext context){
		
		formatStepResult(loginAndCreateNewColumnset(url,loginexe,column1),"1.Login to the Web console and create a new column set with different attributes.");
		formatStepResult(addNewColumn(column2),"2.Try to add a new column");
		formatStepResult(deleteOldColumn(column1),"3.Try to delete the old column");
		formatStepResult(changeOrderForColumn(column2),"4.Try to change the order of the column");
		formatStepResult(removeDefaulteColumn(url,loginexe,column2),"5.Remove all default column sets and add others");
		
	
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
