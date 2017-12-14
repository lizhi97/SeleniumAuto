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
 * 
 * 59619 Distribute a team package to a query group with MSI package
 * 
 * 1.Create a team in the LDMS Win32 Console and add an limited user to it.
 * 2.Login to the web console with the user which belongs to the team. 
 * 3.SelectReporting->Queries. 
 * 4.Create a query with the team as the owner. 
 * 5.Select Distribution->Distribution. 
 * 6.Create a software package(MSI) under the team packages. 
 * 7.Create a software distribution task using the software package.
 * 8.Create a delivery method(Policy) under the team methods. 
 * 9.Edit the distribution task under my tasks, check the "Teams package" displays in the Distribution package list, select the new delivery method, add the query group, and save the task. 
 * 10.Open edit of task and change owner to the team.
 * 11.Start the task.
 * 
 * @author Ericqu
 */
public class CreateDistriQueryTask extends TestCaseBase {


	private UtilWeb utlWeb = new UtilWeb();
	//private ScheduledTaskPageObject sPage = new ScheduledTaskPageObject(driver);
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
	
	private boolean createMSIPackage(String queryName,String packagefile){
		
		
		try {
				mPage.clickDistribution();
				mPage.clicKDistribution1();
				mPage.clickTeamPackageElement();
				DistributionPackagePageObject dPage = new DistributionPackagePageObject(driver);
				dPage.NewPackageWindow();
				dPage.selectPackage("MSI");
				dPage.inputText(queryName);
				dPage.inputPrimaryFile(packagefile);
				dPage.inputDescription("MSI pkg");
				dPage.clickOk();
				mPage.setDriverByHandle(mainHandle);
				if(debug)System.out.println("Create a MSI package successfully");
				return true;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(debug)e.printStackTrace();
			return false;
		}
	}
	
	private boolean createPolicyMethod(String queryName,String mainHandle){
		try {
			mPage.clickDeliveryMethElement();
			mPage.clickTeamMethodsElement();
			mPage.clickPolicyMethElement();
			DeliveryMethodsPageObject methPage = new DeliveryMethodsPageObject(driver);
			methPage.newDeliveryMethWindow();
			methPage.selectOwner("Public");
			methPage.clickFeeBackAndTimingElement();
			methPage.inputMethodName(queryName);
			methPage.clickOkMethodsElement();  
			if(debug)System.out.println("Create a policy method successfully");
			return true;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			if(debug)e.printStackTrace();
			return false;
		}
	}
	
	private boolean createDeliveryTask(String queryName){
		try {
			mPage.setDriverByHandle(mainHandle);
			mPage.clickTeamPackageElement();
			mPage.selectDistrPackage(queryName);
			mPage.clickNewTaskButton();
			ScheduledTaskPageObject sPage = new ScheduledTaskPageObject(driver);
			sPage.ScheduledTaskWindow();
			//sPage.ScheduledTaskWindowNew();
			//String distributionTaskname = "Distribution" + queryName;
			sPage.inputTaskName("Distribution" + queryName);
			sPage.selectTeamOwner();
			sPage.clickDeliveryMethodElement();
			sPage.selectPolicyMethodType();
			sPage.selectMethod(queryName);
			sPage.inputTaskName("Distribution" + queryName);
			sPage.clickTargetDriver();
			sPage.selectQueryName(queryName);
			sPage.clickAddQuerybutton();
			sPage.clickOkTask();
			mPage.setDriverByHandle(mainHandle);
			mPage.clicKDistribution1();
			mPage.clickDeliveryTaskElement();
			mPage.clickDeliveryTaskTeam();
			mPage.selectDistribuTaskName("Distribution" + queryName);
			mPage.clickStartNowElement();
			if(debug)System.out.println("Create Delivery task successfully");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(debug)e.printStackTrace();
			return false;
		}
		
	}
	
	private boolean startDelivery(String queryName){
		try {
			ScheduledTaskPageObject sPage = new ScheduledTaskPageObject(driver);
			mPage.clickFreshButtonforTasksState("Distribution"+queryName);
			String taskName = "getPolicy123";
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
			mPage.selectDistribuTaskName(taskName);
			for (int i = 0; i < 50; i++) {
				mPage.selectDistribuTaskName(taskName);
				String taskstatus = mPage.getTaskState(taskName);
				if (taskstatus.equals("Working") || taskstatus.equals("Waiting")) {
					Thread.sleep(6000);
					mPage.clickFreshButtonforTasks();

				} else {
					System.out.println("Delete the target of getPolicy task");
					mPage.selectDistribuTaskName("getPolicy123");
					mPage.ClickEditElement();
					//sPage = new ScheduledTaskPageObject(driver);
					sPage.EditTaskwindow();
					sPage.clickTargetDriver();
					sPage.deleteTargerDriver(queryName);
					sPage.clickOkTask();
					break;
				}
			}
			Thread.sleep(40000);
			mPage.setDriverByHandle(mainHandle);
			mPage.selectDistribuTaskName("Distribution"+queryName);
			mPage.rightClickOneTask("Distribution"+queryName);
			mPage.pressRefreshMenu();
			mPage.selectDistribuTaskName("Distribution"+queryName);
			mPage.rightClickOneTask("Distribution"+queryName);
			mPage.ViewTaskStatus();
			mPage.exportTaskResult();
			if(debug)System.out.println("Start delivery task successfully");
			return true;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			if(debug)e.printStackTrace();
			return false;
		}
		
	}
	
	private boolean deleteDisTask(String url,String admin,String queryName, String policy ,String groupName,String distributionTaskname){
		try {
			utlWeb.DeleteDistritask(url, admin, queryName, policy, groupName,
					distributionTaskname);
			mPage.setDriverByHandle(mainHandle);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	private boolean deleteQuery(String queryName,String queryGroup,String admin,String url){
		utlWeb.deleteQuery(queryName, queryGroup, admin, url);
		return true;
	}
	/**
	 * @param url
	 *            Web console portal
	 * @param loginexe
	 *            AutoIT executable file to log in the web console
	 * @param packagefile
	 *            MSI package file url
	 * @param context
	 * @throws Exception
	 */
	@Parameters({ "url", "loginexe", "admin", "packagefile", "computerName",
			"queryName", "queryGroup" })
	@Test
	public void createDistriQuerytask(String url, String loginexe,
			String admin, String packagefile, String computerName,
			String queryName, String queryGroup, ITestContext context) throws Exception{
		
		
		
		formatStepResult(loginWebconsole(url, loginexe) ,"1.Login with limited user which belong to a team");
		formatStepResult(goToQueryButton(),"2.SelectReporting->Queries.");
		formatStepResult(createQuery(queryName, queryGroup, computerName),"3.Start to create a query with team user");
		formatStepResult(createMSIPackage(queryName, packagefile),"4.Start to create a MSI package");
		formatStepResult(createPolicyMethod(queryName, queryGroup),"5.start a create a policy method");
		formatStepResult(createDeliveryTask(queryName),"6.Create a distribution task and start to run");
		formatStepResult(startDelivery(queryName),"7.start to run the delivery task");
		formatStepResult(deleteDisTask(url, admin, queryName, "Policy", queryName, "Distribution"+queryName),"8.Delete task");
		formatStepResult(deleteQuery(queryName, queryGroup, admin, url),"9.Delete query");
		mPage.setDriverByHandle(mainHandle);
		driver.close();
		driver.quit();
	}
}
