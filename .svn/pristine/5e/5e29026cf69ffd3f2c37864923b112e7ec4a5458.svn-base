package com.landesk.ldms.webconsole.TestCasesForIE;


import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.landesk.TestCaseBaseForIE;
import com.landesk.ldms.webconsole.PageObjects.CopyDeviceToTeamPageObject;
import com.landesk.ldms.webconsole.PageObjects.ScheduledScriptTaskPageObject;

/**
 * <b>59651: Schedule scripts from Team scripts group using device group.</b><br>
 * 1.Create a team in the LDMS Win32 Console and add an limited user to it.<br>
 * 2.Assign the user with limited scope.<br>
 * 3.Select Distribution->Manage scripts, create a Custom script under the Team scripts.<br>
 * 4.Login to the webconsole with the user which belongs to the team.<br>
 * 5.Copy some devices from All devices group to the Team devices group.<br>
 * 6.Select Distribution->Scripts.<br>
 * 7.Create a script distribution task using the new script.<br>
 * 8.Edit the distribution task under my tasks, add the team devices group, and save the task.<br>
 * 9.Start the task.<br>
 * 
 * author Li,zhenguo
 * @param url - Webconsole's address
 * @param user1 - Team user log into the web console
 * @param context
 * @throws Exception
 */

public class ScheduleTeamScriptUsingTeamDeviceGroup  extends TestCaseBaseForIE {
	
	ScheduledScriptTaskPageObject sPage;
	boolean debug = false;
	@Parameters({"url","user1"})
	@Test
	public void  scheduleTeamScriptUsingTeamDeviceGroup(String url,String user1, ITestContext context) throws Exception{
		System.out.println("Prepared: "+"1.Create a team in the LDMS Win32 Console and add an limited user to it.");
		System.out.println("Prepared: "+"2.Assign the user with limited scope.");
		System.out.println("Prepared: "+"3.Select Distribution->Manage scripts, create a Custom script under the Team scripts.");
		formatStepResult(loginWebconsole(url,user1),"4.Login to the webconsole with the user which belongs to the team.");
		mainHandle=driver.getWindowHandle();
		formatStepResult(copyDeviceToTeamGroup(),"5.Copy some devices from All devices group to the Team devices group.");
		formatStepResult(selectScriptItem(),"6.Select Distribution->Scripts.");
		String taskName="InventoryScanCustom";
		formatStepResult(createScriptTask(taskName),"7.Create a script distribution task using the new script.");
		formatStepResult(editScriptTask(taskName),"8.Edit the distribution task under my tasks, add the team devices group, and save the task.");
		formatStepResult(startScriptTask(taskName),"9.Start the task.");
		formatStepResult(deleteScriptTask(taskName),"Delete the script task successfully.");
		driver.close();
		driver.quit();
	    		
	}

	private boolean copyDeviceToTeamGroup(){
		try {
			mPage.clickMyDevicesElement();
			mPage.clickDevicePlusElement();
			mPage.clickAllDevicesElement();
			mPage.clickOneDevice("2");
			mPage.clickMoveCopyButton();
			CopyDeviceToTeamPageObject ctPage= new CopyDeviceToTeamPageObject(driver);
			ctPage.openWindow();
			ctPage.selectTeamGroup();
			ctPage.clickCopyButton();
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}

	private boolean selectScriptItem(){
		try {
			mPage.setDriverByHandle(mainHandle);
			mPage.clickDistribution();
			mPage.clickSciptsItem();
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	private boolean createScriptTask(String taskName){
		try {
			mPage.clickTeamSciptsItem();
			mPage.rightClickOneTeamScript(taskName);
			mPage.clickScheduleMenu();
			mPage.inputTeamScripTaskName(taskName);
			sPage= new ScheduledScriptTaskPageObject(driver);
			sPage.ScheduledTaskWindow();
			sPage.saveScriptTask();
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	private boolean editScriptTask(String taskName){
		try {
			mPage.setDriverByHandle(mainHandle);
			mPage.clickMyTasksUnderCustomScriptTasks();
			mPage.rightClickOneTask(taskName);
			mPage.clickEditMenu();
			sPage= new ScheduledScriptTaskPageObject(driver);
			sPage.ScheduledTaskWindow();
			sPage.clickTargetDevicesTab();
			sPage.setTargetDevicesByTeamGroup("'selenium team' devices", "86");
			sPage.saveScriptTask();
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}	
	}
	
	private boolean startScriptTask(String taskName){
		try {
			mPage.setDriverByHandle(mainHandle);
			mPage.clickMyTasksUnderCustomScriptTasks();
			mPage.rightClickOneTask(taskName);
			mPage.clickStartnowMenu();
			mPage.clickFreshButtonforCustomScriptTasks(taskName);
			mPage.rightClickOneTask(taskName);
			mPage.clickViewTaskStatus();
			mPage.doubleClickAllDevices();
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}	
	}
	
	private boolean deleteScriptTask(String taskName){
		try {
			mPage.clickMyTasksUnderCustomScriptTasks();
			mPage.rightClickOneTask(taskName);
			mPage.clickDeleteMenu();
			mPage.deleteScriptTask();
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}	
	}
}

