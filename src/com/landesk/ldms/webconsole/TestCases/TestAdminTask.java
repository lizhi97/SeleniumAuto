package com.landesk.ldms.webconsole.TestCases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.landesk.TestCaseBase;
import com.landesk.ldms.Utils.UtilWeb;
import com.landesk.ldms.webconsole.PageObjects.DeliveryMethodsPageObject;
import com.landesk.ldms.webconsole.PageObjects.DistributionPackagePageObject;
import com.landesk.ldms.webconsole.PageObjects.MainPageObject;
import com.landesk.ldms.webconsole.PageObjects.ScheduledTaskPageObject;

public class TestAdminTask  extends TestCaseBase {
	boolean debug = true;
	
	/**
	 *<b>Schedule software packages from Team Packages group with administrator user</b><br>
	 *1.Create a team in the LDMS Win32 Console and add an admin user to it.<br>
	 *2.Login to the Standalone webconsole with the user which belongs to the team.<br>
	 *3.Select Distribution->Distribution.<br>
     *4.Create a software package(swd) under the team packages.<br>
     *5.Create a software distribution task using the software package.<br>
     *6.Create a delivery method(Push) under the team methods.<br>
     *7.Edit the distribution task under my tasks, select the new delivery method, add the targeted clients, and start the task.<br> 
	 * author Winsy
	 */
	@Parameters({"url","loginexe","packageName","DistriMethType","methodName","taskName","packagefile"})
	@Test
	public void testAdminTask(String url, String loginexe,String packageName,String DistriMethType,String methodName,String taskName,String packagefile,ITestContext context) throws Exception{
		System.out.println("Prepared: "+"1.Create a team in the LDMS Win32 Console and add an admin user to it.");
		formatStepResult(loginWebconsole(url,loginexe),"2.Login to the Standalone webconsole with the user which belongs to the team.");
		formatStepResult(returnDistribution(),"3.Select Distribution->Distribution.");
		formatStepResult(createSWDPackage(packageName,packagefile),"4.Create a software package(swd) under the team packages.");
		formatStepResult(createSWDTask(packageName,taskName),"5.Create a software distribution task using the software package.");
		formatStepResult(createPushMethod(methodName),"6.Create a delivery method(Push) under the team methods.");
		formatStepResult(editSWDTask(taskName,methodName),"7.Edit the distribution task under my tasks, select the new delivery method, add the targeted clients, and start the task.");
	}
	
	private boolean returnDistribution(){
		try{
			mPage.clickMyDevicesElement();
			mPage.clickDevicePlusElement();
			mPage.clickAllDevicesElement();
			mPage.rightClickOneDevice("2");
			mPage.ClickTargetMenu();
			mPage.rightClickOneDevice("3");
			mPage.ClickTargetMenu();

			String mainHandle = driver.getWindowHandle();
			mPage.clickDistribution();
			mPage.clicKDistribution1();
			return true;
	      }catch(Exception e){
		    if (debug) e.printStackTrace();
		    return false;
	      }
	}
	private boolean createSWDPackage(String packageName,String packagefile){
		try{
			mPage.clickTeamPackageElement();
			

			DistributionPackagePageObject dPage = new DistributionPackagePageObject(driver);
			
			dPage.NewPackageWindow();
			
			dPage.selectPackage("SWD Package");
			
			dPage.inputText(packageName);
			dPage.inputPrimaryFile(packagefile);
			dPage.inputDescription("asp pkg");
			dPage.clickOk();
			return true;
		}catch(Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	private boolean createSWDTask(String packageName,String taskName){
		try{
			Thread.sleep(2000);
			mPage.setDriverByHandle(mainHandle);
			mPage.clickPackgeElement(packageName);
			ScheduledTaskPageObject sPage = new ScheduledTaskPageObject(driver);
			
			sPage.ScheduledTaskWindow();
			sPage.inputTaskName(taskName);
			sPage.selectOwnerAdmin();
			sPage.clickOkTask();
			return true;
		}catch(Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	private boolean createPushMethod(String methodName){
		try{
			mPage.setDriverByHandle(mainHandle);
			mPage.clickDeliveryMethElement();
			mPage.clickTeamMethodsElement();
			mPage.clickPushMethElement();
			DeliveryMethodsPageObject methPage = new DeliveryMethodsPageObject(driver);
			methPage.newDeliveryMethWindow();
			methPage.selectOwner("selenium team");
			methPage.clickFeeBackAndTimingElement();
			methPage.selectUI("Display progress to user");
			methPage.inputMethodName(methodName);
			methPage.clickOkMethodsElement();
			return true;
		}catch(Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	private boolean editSWDTask(String taskName,String methodName){
		try{
			mPage.clickDistributiontaskstab();
			mPage.clickDeliveryTaskTeam();
			mPage.selectDistribuTaskName(taskName); 
			mPage.ClickEditElement();
			ScheduledTaskPageObject sPage = new ScheduledTaskPageObject(driver);
			
			sPage.ScheduledTaskWindow();
			sPage.selectOwnerAdmin();
			sPage.clickDeliveryMethodElement();
			sPage.selectMethodType("Push", "3");
			sPage.selectMethod(methodName);
			sPage.clickTargetDriver();
			sPage.clickAddTargetList();
			
			sPage.clickOkTask();
			mPage.setDriverByHandle(mainHandle);
			mPage.clickScheduledTask();
			mPage.clickTaskElement(taskName);
			mPage.clickTaskStartNow();
			mPage.doubleClickTask(taskName);
			mPage.clickRefreshTask();
			driver.close();
			driver.quit();
			//utilWeb.DeleteDistritask(url, loginexe, packageName, DistriMethType, methodName, taskName);
			return true;
		}catch(Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * @param url Web console address
	 * @param loginexe AutoIT executable file to log in the web console
	 * @param packagefile SWD package file url
	 * @param context
	 * @throws Exception
	 */
	@Parameters({"url","loginexe","packageName","DistriMethType","methodName","taskName","packagefile"})
	@Test
	public void testAdminTask1(String url, String loginexe,String packageName,String DistriMethType,String methodName,String taskName,String packagefile,ITestContext context) throws Exception{
		WebDriver driver = new FirefoxDriver();
		UtilWeb utilWeb = new UtilWeb();
		driver.manage().window().maximize();
	
		MainPageObject mPage = new MainPageObject(driver);
		Runtime.getRuntime().exec(loginexe);
		driver.get(url);
		mPage.letMainPageLoad();
		mPage.clickMyDevicesElement();
		mPage.clickDevicePlusElement();
		mPage.clickAllDevicesElement();
		mPage.rightClickOneDevice("2");
		mPage.ClickTargetMenu();
		mPage.rightClickOneDevice("3");
		mPage.ClickTargetMenu();
		
		String mainHandle = driver.getWindowHandle();
		mPage.clickDistribution();
		mPage.clicKDistribution1();
		mPage.clickTeamPackageElement();
		

		DistributionPackagePageObject dPage = new DistributionPackagePageObject(driver);
		
		dPage.NewPackageWindow();
		
		dPage.selectPackage("SWD Package");
		
		dPage.inputText(packageName);
		dPage.inputPrimaryFile(packagefile);
		dPage.inputDescription("asp pkg");
		dPage.clickOk();
		mPage.setDriverByHandle(mainHandle);
		mPage.clickDeliveryMethElement();
		mPage.clickTeamMethodsElement();
		mPage.clickPushMethElement();
		DeliveryMethodsPageObject methPage = new DeliveryMethodsPageObject(driver);
		methPage.newDeliveryMethWindow();
		methPage.selectOwner("selenium team");
		methPage.clickFeeBackAndTimingElement();
		methPage.selectUI("Display progress to user");
		methPage.inputMethodName(methodName);
		methPage.clickOkMethodsElement();
		mPage.setDriverByHandle(mainHandle);
	//	mPage.clickSWD2PackgeElement();
		mPage.clickPackgeElement(packageName);
		ScheduledTaskPageObject sPage = new ScheduledTaskPageObject(driver);
		
		sPage.ScheduledTaskWindow();
		sPage.selectOwnerAdmin();
		sPage.clickDeliveryMethodElement();
		sPage.selectMethodType("Push", "3");
		sPage.selectMethod(methodName);
		sPage.clickTargetDriver();
		sPage.clickAddTargetList();
		sPage.inputTaskName(taskName);
		sPage.clickOkTask();
		mPage.setDriverByHandle(mainHandle);
		mPage.clickScheduledTask();
		mPage.clickTaskElement(taskName);
		mPage.clickTaskStartNow();
		mPage.doubleClickTask(taskName);
		mPage.clickRefreshTask();
		driver.close();
		driver.quit();
		utilWeb.DeleteDistritask(url, loginexe, packageName, DistriMethType, methodName, taskName);



	}

}
