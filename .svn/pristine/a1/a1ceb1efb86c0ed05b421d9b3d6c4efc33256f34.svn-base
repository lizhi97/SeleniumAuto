package com.landesk.ldms.webconsole.TestCasesForIE;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.landesk.TestCaseBaseForIE;
import com.landesk.ldms.Utils.UtilWeb;
import com.landesk.ldms.webconsole.PageObjects.DeliveryMethodsPageObject;
import com.landesk.ldms.webconsole.PageObjects.DistributionPackagePageObject;
import com.landesk.ldms.webconsole.PageObjects.ScheduledTaskPageObject;

/**
 * <b>59577: Schedule software packages from Team packages group with different limited scopes</b><br>
 * 1.Create a team in the LDMS Win32 Console and add two limited users A and B to it.<br>
 * 2.Assign the users with different limited scopes, and the two scopes have some overlap.<br>
 * 3.Login to the webconsole with the use A which belongs to the team.<br>
 * 4.Target some clients, make user some of them are in the scope of user B.<br>
 * 5.Select Distribution->Distribution.<br>
 * 6.Create a software package(exe) under the team packages.<br>
 * 7.Create a software distribution task using the software package, with the team as the owner.<br>
 * 8.Create a delivery method(Policy-supported push) under the team methods.<br>
 * 9.Edit the distribution task under team tasks, select the new delivery method, add the targeted clients, and save the task.<br>
 * 10.Login to the webconsole with the user B which belongs to the team.<br>
 * 11.Start the task created by user A.<br>
 *  @author JerryZhang
*/

public class SchedulePackages  extends TestCaseBaseForIE{
	
	ScheduledTaskPageObject sPage;	
	boolean debug = false;
	 /**
	 *
	 * @param url Webconsole base url
	 * @param loginexe AutoIT executable file to log in the webconsole with administrator
	 * @param loginexe1 AutoIT executable file to log in the webconsole with user winsy1
	 * @param loginexe2 AutoIT executable file to log in the webconsole with user winsy2
	 * @param user1 User winsy1 
	 * @param CoreName 
	 * @param Cliet1
	 * @param Cliet2
	 *  @param PrimaryFile The primary file to be distributed to the client
	 * @param context For TestNG
	 * @throws Exception
	 */
	@Parameters({"url","loginexe","loginexe1","loginexe2","user1","CoreName","client1","client2","PrimaryFile"})
	@Test
	public void schedulePackages(String url, String loginexe,String loginexe1,String loginexe2,String user1,String CoreName, String client1, String client2, String PrimaryFile,ITestContext context) throws Exception{
		
		System.out.println("Prepared: "+"1.Create a team in the LDMS Win32 Console and add two limited users A and B to it.");
		System.out.println("Prepared: "+"2.Assign the users with different limited scopes, and the two scopes have some overlap.");
		formatStepResult(loginWebconsole(url,loginexe1),"3.Login to the webconsole with the user A which belongs to the team.");

		
		formatStepResult(targetClients(client1,client2),"4.Target some clients, make user some of them are in the scope of user B.");		
		formatStepResult(displayPackages(),"5.Select Distribution->Distribution. Expected:The team packages should be displayed on the Web Console successfully.");
		formatStepResult(createPackage(PrimaryFile),"6.Create a software package(exe) under the team packages.");
		formatStepResult(createTask(),"7.Create a software distribution task using the software package, with the team as the owner.");
		formatStepResult(createMethod(CoreName, user1),"8.Create a delivery method(Policy-supported push) under the team methods.");
		formatStepResult(editTask(),"9.Edit the distribution task under team tasks, select the new delivery method, add the targeted clients, and save the task.");
		formatStepResult(loginWebconsole(url,loginexe2),"10.Login to the webconsole with the user B which belongs to the team.");
		formatStepResult(startTask(),"11.Start the task created by user A.");
		UtilWeb uWeb=new UtilWeb();
		uWeb.DeleteDistritask(url, loginexe, "59577_package", "Policy-supported push", "59577_DelMethod", "59577_task");
		driver.close();
		driver.quit();
		
	}
	
	private boolean targetClients(String client1, String client2){
		try {
			mPage.clickMyDevicesElement();
			mPage.clickDevicePlusElement();
			mPage.clickAllDevicesElement();
			
			mPage.rightClickDeviceByName(client1);
			mPage.ClickTargetMenu();
			mPage.rightClickDeviceByName(client2);
			mPage.ClickTargetMenu();
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	private boolean displayPackages(){
		try {
			mPage.clickDistribution();
			mPage.clicKDistribution1();	
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	private boolean createPackage(String PrimaryFile){
		try {
			mPage.clickTeamPackageElement();		
			mPage.clickNewPackageButton();
			DistributionPackagePageObject dPage=new DistributionPackagePageObject(driver);
			dPage.NewPackageWindow();
			//dPage.OpenPackageWindow();
			dPage.selectPackage("Executable");
			dPage.inputText("59577_package");
			dPage.inputDescription("Package for test case 59577");
			dPage.inputPrimaryFile(PrimaryFile);
			dPage.clickOk();
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	private boolean createTask(){
		try {
			mPage.setDriverByHandle(mainHandle);
			driver.navigate().refresh();
			mPage.letMainPageLoad();
					
			mPage.clickDistribution();
			mPage.clicKDistribution1();	
			mPage.clickTeamPackageElement();
			mPage.clickPackgeElement("59577_package");
			
		    //mPage.rightClickOnePackage("59577_package");
		    //mPage.ClickRightScheduleMenu();

			sPage = new ScheduledTaskPageObject(driver);
			sPage.ScheduledTaskWindow();
			sPage.inputTaskName("59577_task");
			sPage.selectOwner("selenium team");
			sPage.clickOkTask();
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	private boolean createMethod(String CoreName, String user1){
		try {
			mPage.setDriverByHandle(mainHandle);
			mPage.clickDeliveryTaskTeam();
			
			mPage.clicKDeliverymethodtab();
			
			if (!mPage.isMethodPresent("Policy-supported push","59577_DelMethod")){
				mPage.clickTeamMethodsElement();
				mPage.selectMethType("Policy-supported push");
				DeliveryMethodsPageObject dePage=new DeliveryMethodsPageObject(driver);
				dePage.newDeliveryMethWindow();
				dePage.inputMethodName("59577_DelMethod");
				dePage.selectOwner(CoreName+"\\"+user1);
				dePage.clickFeeBackAndTimingElement();
				dePage.selectUI("Display progress to user");
				dePage.clickOkMethodsElement();
				mPage.setDriverByHandle(mainHandle);
			}
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	private boolean editTask(){
		try {
			mPage.clickDistributiontaskstab();
			mPage.clickDeliveryTaskTeam();
			mPage.selectDistribuTaskName("59577_task"); 
			mPage.ClickEditElement();
			sPage=new ScheduledTaskPageObject(driver);
			sPage.OpenScheduledTaskWindow();
			sPage.clickDeliveryMethodElement();
			sPage.selectMethod("59577_DelMethod");
			sPage.clickTargetDriver();
			sPage.clickAddTargetList();
			sPage.clickOkTask();
			//driver.close();
			driver.quit();
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	private boolean startTask(){
		try {
			mPage.clickDistribution();
			mPage.clicKDistribution1();	
			mPage.clickDistributiontaskstab();
			mPage.clickDeliveryTaskTeam();
			mPage.selectDistribuTaskName("59577_task");
			mPage.clickStartNowElement();
			Assert.assertEquals(mPage.clickFreshButtonforTasksState("59577_task"),true); 
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}

}
