package com.landesk.ldms.Utils;
import java.io.IOException;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.landesk.PageBase;
import com.landesk.ldms.webconsole.PageObjects.MainPageObject;
import com.landesk.ldms.webconsole.PageObjects.QueryAttributeNameObject;
import com.landesk.ldms.webconsole.PageObjects.QueryDialogNameObject;
import com.landesk.ldms.webconsole.PageObjects.QuerySavePageObject;
import com.landesk.ldms.webconsole.PageObjects.QuerySortPageObject;
public class UtilWeb extends PageBase{
	
/**
 * go to click query button from left panel	
 * @param mPage
 */
public void goToClickQuery(MainPageObject mPage){
	mPage.clickQueryButton();
}
/**
 * create a query 
 * @param driver  load the current page driver
 * @param mPage   load the current mainPage object
 * @param queryName  define a valuable queryName
 * @param queryGroup select the valuable queryGroup
 * @param computerName select an exist device for query target
 */

public boolean findQueryElement(WebDriver driver, MainPageObject mPage,String queryName){
	
	try {
		
		driver.findElement(By.xpath("//td[contains(text(),'"+queryName+"')]"));
		return true;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		if(debug)e.printStackTrace();
		return false;
	}
}
public void createQuery(String mainHandle,WebDriver driver,MainPageObject mPage,String queryName,String queryGroup,String computerName) {

			mPage.clickQueryButton();
			mPage.checkToSelectTeam(queryGroup);
			mPage.goToQueryListFrame();
			if(findQueryElement(driver,mPage,queryName)){
				mPage.deleteQuery(queryName);
			}
			
			mPage.checkToSelectTeam(queryGroup);
			mPage.goToNewQueryFrame();
			mPage.clickNewQueryButton();
			mPage.goToNewFrameCondition();	
			mPage.clickConditionEdit();
			QueryDialogNameObject  qDPage = new QueryDialogNameObject(driver);
			qDPage.openWindow();
			qDPage.goToComputerLeftFrame();
			qDPage.selectDeviceName();
			qDPage.goToConditionFrame();
			qDPage.selectExistValue(computerName);
			qDPage.selectBool();
			qDPage.goToAddFrame();
			qDPage.ClickAddButton();
			qDPage.ClickOKButton();
			mPage.setDriverByHandle(mainHandle);
			mPage.goToNewFrameCondition();
			mPage.clickArrbuttonEdit();
			QueryAttributeNameObject qAPage = new QueryAttributeNameObject(driver);
			qAPage.openWindow();
			qAPage.goToAttrQueryTreeFrame();
			qAPage.selectDeviceID();
			qAPage.goToAttrFrame();
			qAPage.goToClickAddButton();
			qAPage.goToAttrQueryTreeFrame();
			qAPage.selectDeviceName();
			qAPage.goToClickAddButton();
			qAPage.goToAttrFrame();
			qAPage.goToClickOKButton();
			
			mPage.setDriverByHandle(mainHandle);
			mPage.goToNewFrameCondition();
			mPage.clickSortButtonEdit();
			
			QuerySortPageObject qsPage = new QuerySortPageObject(driver);
			qsPage.openWindow();
			qsPage.goToSelectSort();
			qsPage.goToClickAddButton();
			qsPage.goToSelectSec();
			qsPage.goToClickAddButton();
			qsPage.goToClickOKButton();
			
			mPage.setDriverByHandle(mainHandle);
			mPage.goToNewFrameCondition();
			mPage.clickSaveQueryButton();
			QuerySavePageObject  qSavePage = new QuerySavePageObject(driver);
			qSavePage.openWindow();
			qSavePage.inputQueryName(queryName);
			qSavePage.clickSaveButton();
	}

/**
 * <b>Delete user's SWD package and method and task.</b>,<br>
 * 1. Login web console with Administrator user.</br>
 * 2. Delete user's task from 'All tasks' list.</br>
 *    a. Check the task's status.</br>
 *    b. If the task's status is 'Working', waiting. </br>
 *    c. If the task's status is not 'Working'.</br>
 *    d. Delete the task.</br>  
 * 3. Delete user's method from 'All delivery methods' list.</br>
 * 4. Delete user's package from 'All distribution packages' list.</br>
 * Author Trudy
 * @param url  define web console URL.
 * @param loginexe  AutoIT executable file to log in the web console.
 * @param packageName  define a SWD distribution package name which user want to delete.
 * @param DistriMethType define a delivery method type which user want to delete.
 * @param methodName define a delivery method name which user want to delete.
 * @param taskName  define a task name which user want to delete.
 * @throws Exception
 */

public void DeleteDistritask(String url, String loginexe,String packageName,String DistriMethType,String methodName,String taskName) throws Exception{
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().window();
		MainPageObject mPage = new  MainPageObject(driver);
		Runtime.getRuntime().exec(loginexe);
		driver.get(url);
		mPage.letMainPageLoad();
		
		//switch to Distribution panel
		mPage.clickDistribution();
		mPage.clicKDistribution1();
		mPage.clickDistributiontaskstab();
		
		//Delete distribution task
		mPage.selectAlltaskNode();
		mPage.selectDistribuTaskName(taskName);
		
		
		for(int i = 0; i<50; i++){
			mPage.selectDistribuTaskName(taskName);
			String taskstatus=mPage.getTaskStatus();
			if (taskstatus.equals("Working"))
		    {
				Thread.sleep(6000);
				mPage.clickFreshButtonforTasks();
		    }else {
		    	mPage.clickDeleteSWDtaskElement();
		    	
		    	break;
		    }
		}
		
		//delete Delivery method
		mPage.clicKDeliverymethodtab();
		mPage.selectAllMethNode();
		mPage.selectMethType(DistriMethType);
		mPage.selectMethName(methodName);
		mPage.clickDeleteSWDMethodElement();
		
		 //Delete distribution package 
		mPage.clicKDistribution1();
		mPage.selectDistrPackagenode();
		mPage.selectDistrPackage(packageName);
		mPage.clickDeleteSWDPackElement();
		driver.close();
		driver.quit();
	}
	
	
	/**
	 * Delete query by queryName
	 * @author Ericqu
	 * @param queryName 
	 * @param queryGroup
	 * @param computerName
	 * @param loginexe
	 * @param url 
	 */
	public void deleteQuery(String queryName,String queryGroup,String loginexe,String url){
		WebDriver driver = new FirefoxDriver();
	
		driver.manage().window().maximize();;
		MainPageObject mPage = new  MainPageObject(driver);
		
		try {
			Runtime.getRuntime().exec(loginexe);
		} catch (IOException e) {
			
			e.printStackTrace(); 
		}
		driver.get(url);
		mPage.letMainPageLoad();
		mPage.clickQueryButton();
		mPage.checkToSelectTeam(queryGroup);
		mPage.deleteQuery(queryName);
		driver.close();
		driver.quit();
	}

}
