package com.landesk.ldms.webconsole.TestCases;


import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.landesk.TestCaseBase;
import com.landesk.ldms.Utils.UtilWeb;
import com.landesk.ldms.webconsole.PageObjects.DeliveryMethodsPageObject;
import com.landesk.ldms.webconsole.PageObjects.DistributionPackagePageObject;
import com.landesk.ldms.webconsole.PageObjects.ScheduledTaskPageObject;
/**
 * <b>Schedule software packages from Team packages group using query group which created by other team member.</b><br>
 * 1.Create a team in the LDMS Win32 Console and add two limited users to it.<br>
 * 2.Assign the users with limited scope.<br>
 * 3.Login to the web console with the user A which belongs to the team.<br>
 * 4.Select Reporting->Queries/<br>
 * 5.Create a query with the team as the owner.<br>
 * 6.Select Distribution->Distribution.<br>
 * 7.Create a software package(MSI) under the team packages.<br>
 * 8.Create a delivery method(Policy) under the team methods.<br>
 * 9.Login to the web console with the user B which belongs to the same team.<br>
 * 10.Create a software distribution task using the software package which created by user A.<br>
 * 11.Edit the distribution task under my tasks, select the delivery method which created by user A, add the targeted clients using query which created by user A, and save the task.<br>
 * 12.Start the task.<br>
 * @author Jack.cheng
 */

public class DeploySoftwareWithPolicy  extends TestCaseBase{
	private UtilWeb utlWeb = new UtilWeb();
	ScheduledTaskPageObject sPage = new ScheduledTaskPageObject(driver);
	boolean debug = false;

	/** 
	 * @param url  web console address 
	 * @param user1  AutoIT executable file to log in the web console with user winsy1
	 * @param user2  AutoIT executable file to log in the web console with user winsy2
	 * @param preName
	 * @param packName      MSI package Name=preName+packName
	 * @param methodName    Method name= preName+methodName
	 * @param packagefile   SWD package file url
	 * @param context
	 * @throws Exception
	 */
	
	@Parameters({"url","loginexe","user1","user2","computerName","packName","methodName","packagefile"})
	@Test
	public void deploySoftwareWithPolicy(String url,String loginexe,String user1,String user2,String computerName,String packName,String methodName,String packagefile, ITestContext context) throws Exception{
		System.out.println("Prepared: "+"1.Create a team in the LDMS Win32 Console and add two limited users to it.");
		System.out.println("Prepared: "+"2.Assign the users with limited scope.");
		formatStepResult(loginWebconsole(url,user1),"3.Login to the web console with the user A which belongs to the team.");
		mainHandle = driver.getWindowHandle();	
		String queryGroup="'selenium team' queries";
		//UtilWeb utlWeb =new UtilWeb();
		String queryName="001jackquery";
		String distributionTaskname="Ditribution"+queryName;
		//utlWeb.createQuery(mainHandle,driver,mPage, queryName,queryGroup,computerName);
		
		
		formatStepResult(goToQueryButton(),"3.SelectReporting->Queries.");
		formatStepResult(createQuery(queryName, queryGroup, computerName),"4.Start to create a query with team user");
		formatStepResult(ClickDistribution(),"6.Select Distribution->Distribution.");		
		if(mPage.isPackagePresent(packName)){
			if(debug) System.out.println("The package is existing");
		}
		else{
			if(debug) System.out.println("The package is non-existing and we will create it");
			
			/**Create one MSI package */
			formatStepResult(CreateMsiPackage(packName,packagefile),"7.Create a software package(MSI) under the team packages.");			
		}
	
		
		/**create one Policy method*/
		formatStepResult(CreateOnePolicy(methodName),"8.Create a delivery method(Policy) under the team methods.");	
		formatStepResult(loginWebconsole(url,user2),"9.Login to the web console with the user B which belongs to the same team.");	
	    mainHandle = driver.getWindowHandle();
		formatStepResult(CreateOneTask(packName,queryName),"10.Create a software distribution task using the software package which created by user A.");		
		formatStepResult(editTask(queryName,methodName),"11.Edit the distribution task under my tasks, select the delivery method which created by user A, add the targeted clients using query which created by user A, and save the task.");
				
		/**Switch to Main Page and Start task.*/
		formatStepResult(startTask(queryName),"12.Start the task.");			
		checkTaskResult(queryName);
		
		
		
	     if (debug)  System.out.println("*begin to delete task, method ,package and Query.*");
		 utlWeb.DeleteDistritask(url, loginexe, packName, "Policy",methodName, distributionTaskname);

		 if (debug) System.out.println("*begin to delete Query");
		 utlWeb.deleteQuery(queryName, queryGroup, loginexe,url);
		 
		 if (debug) System.out.println("*end to delete task, method ,package and Query ");
		 mPage.setDriverByHandle(mainHandle);
		 driver.close();
		 driver.quit();
		
	}
	
	private boolean ClickDistribution(){
		try {
			mPage.setDriverByHandle(mainHandle);
			mPage.clickDistribution();
			mPage.clicKDistribution1();	
			mPage.clickTeamPackageElement();
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	
	private boolean CreateMsiPackage(String packName,String packagefile){
		try {
			mPage.clickTeamPackageElement();
			DistributionPackagePageObject dPage = new DistributionPackagePageObject(driver);
			Thread.sleep(2000);
			dPage.NewPackageWindow();
			dPage.selectPackage("MSI");
			dPage.inputText(packName);
			dPage.inputPrimaryFile(packagefile);
			dPage.inputDescription("MSI pkg");
			dPage.ClickAccoutPage();
			dPage.clickOk();
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	private boolean CreateOnePolicy(String methodName){
		try {
			mPage.setDriverByHandle(mainHandle);
			mPage.clickDeliveryMethElement();
			mPage.clickTeamMethodsElement();
			mPage.clickPolicyMethElement();
			
			DeliveryMethodsPageObject methPage = new DeliveryMethodsPageObject(driver);
			methPage.newDeliveryMethWindow();

			methPage.inputMethodName(methodName);
			methPage.selectOwner( "Public");


			methPage.selectTypeandfrequencypolicy();
			methPage.clickOkMethodsElement();
			mPage.setDriverByHandle(mainHandle);
			
			/**switch to  user winsy2*/
			driver.close();
			driver.quit();
			
			
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	private boolean CreateOneTask(String packName,String queryName){
		try {
			mPage.clickDistribution();
			mPage.clicKDistribution1();
			mPage.clickTeamPackageElement();
			mPage.clickPackgeElement(packName);
			
			ScheduledTaskPageObject sPage = new ScheduledTaskPageObject(driver);
			sPage.ScheduledTaskWindow();
			
			String distributionTaskname = "Ditribution"+queryName;
		    sPage.inputTaskName(distributionTaskname);
	//		sPage.selectTeamOwner();
			sPage.clickOkTask();	
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	private boolean editTask(String queryName,String methodName){
		try {
			mPage.setDriverByHandle(mainHandle);
			mPage.clickDistributiontaskstab();
			mPage.selectMytaskNode();
			mPage.selectDistribuTaskName("Ditribution"+queryName); 
			mPage.ClickEditElement();
			sPage=new ScheduledTaskPageObject(driver);
			sPage.OpenScheduledTaskWindow();		
			sPage.clickDeliveryMethodElement();
			sPage.selectPolicyMethodType();
			sPage.selectMethod(methodName);
			sPage.clickTargetDriver();
			sPage.selectQueryName(queryName);
			sPage.clickAddQuerybutton();
			sPage.clickOkTask();			
			
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	
	private boolean startTask(String queryName){
		try {
			mPage.setDriverByHandle(mainHandle);
			mPage.clickDistributiontaskstab();
			mPage.selectMytaskNode();
			mPage.selectDistribuTaskName("Ditribution" + queryName);
			mPage.clickStartNowElement();

			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	private boolean checkTaskResult(String queryName){
		try {
			/**check the  status of the task.*/
			mPage.clickFreshButtonforTasksState("Ditribution"+queryName);

			
			/**Start GetPolicy Task.*/
		    String taskName="JackGetPolicyTask";
		    mPage.selectDistribuTaskName(taskName);
		    mPage.ClickEditElement();
		    sPage = new ScheduledTaskPageObject(driver);
		    sPage.EditTaskwindow();
		    sPage.clickTargetDriver();
			sPage.selectQueryName(queryName);
			sPage.clickAddQuerybutton();
			sPage.clickSchedleTask();
			sPage.ClickStartNowOption();
			sPage.SelectAllDevice();
			sPage.clickOkTask();
			mPage.setDriverByHandle(mainHandle);
			mPage.clickFreshButtonforTasks();
			/**check the status of  "getPolicyTask".*/
			 
			mPage.selectDistribuTaskName(taskName);
			for(int i = 0; i<50; i++){
				mPage.selectDistribuTaskName(taskName);
				String taskstatus=mPage.getTaskState(taskName);
				if (taskstatus.equals("Working")||taskstatus.equals("Waiting"))
			    {
					Thread.sleep(6000);
					mPage.clickFreshButtonforTasks();
		
			    }else {
			    	System.out.println("Delete the target of getPolicy task");
			    	mPage.selectDistribuTaskName(taskName);
			 	    mPage.ClickEditElement();
			 	    sPage = new ScheduledTaskPageObject(driver);
			 	    sPage.EditTaskwindow();
			 	    sPage.clickTargetDriver();
			 	    sPage.deleteTargerDriver(queryName);
			 		sPage.clickOkTask();
			    	
			    	break;
			    	
			    }
			    }
			
			Thread.sleep(40000);
			
			 mPage.setDriverByHandle(mainHandle);
		     mPage.selectDistribuTaskName("Ditribution"+queryName);
		     mPage.rightClickOneTask("Ditribution"+queryName);
		     mPage.pressRefreshMenu();
		     mPage.selectDistribuTaskName("Ditribution"+queryName);
		     mPage.rightClickOneTask("Ditribution"+queryName);
		     mPage.ViewTaskStatus();
			 mPage.exportTaskResult();
			

			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	
	private boolean goToQueryButton(){
		try {
			utlWeb.goToClickQuery(mPage);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(debug)e.printStackTrace();
			return false;
		}
	}
	private boolean createQuery(String queryName,String queryGroup,String computerName ){
		try {
			
			utlWeb.createQuery(mainHandle,driver, mPage, queryName, queryGroup, computerName);
			mPage.setDriverByHandle(mainHandle);
			mPage.clickQueryButton();
			if(debug) System.out.println("create a query successfully");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(debug)e.printStackTrace();
			return false;
		}
	}
	

}
