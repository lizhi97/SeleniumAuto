package com.landesk.ldms.webconsole.TestCasesForIE;




import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.landesk.TestCaseBaseForIE;
import com.landesk.ldms.Utils.UtilWeb;
import com.landesk.ldms.webconsole.PageObjects.ScheduledScriptTaskPageObject;

/**
 * <b>59672: Schedule team scripts</b><br>
 * 1.Create a team in the LDMS Win32 Console and add an limited user to it.<br>
 * 2.Assign the user with limited scope.<br>
 * 3.Login to the core server with the user A which belongs to the team.<br>
 * 4.Select Distribution->Manage scripts, create a Custom script under the Team scripts.<br>
 * 5.Login to the web console with the user B which belongs to the same team.<br>
 * 6.Select Reporting->Queries.<br>
 * 7.Create a query with the team as the ower.<br>
 * 8.Create a script distribution task using the script which created by user A, with the team as the owner.<br>
 * 9.Edit the distribution task under Team tasks, add query group, and save the task.<br>
 * 10.Start the task.
 * 
 * author Li,zhenguo
 * @param url - Webconsole's address
 * @param user1 - Team user log into the web console
 * @param user2 - Administrator log into the web console
 * @param context
 * @throws Exception
 */

public class ScheduleTeamScripts  extends TestCaseBaseForIE{
	ScheduledScriptTaskPageObject sPage;
	boolean debug = false;
	
	@Parameters({"url","user1","user2"})
	@Test
	public void  scheduleTeamScripts(String url, String user1, String user2,ITestContext context) throws Exception{
		System.out.println("Prepared: "+"1.Create a team in the LDMS Win32 Console and add an limited user to it.");
		System.out.println("Prepared: "+"2.Assign the user with limited scope.");
		System.out.println("Prepared: "+"3.Login to the core server with the user A which belongs to the team.");
		System.out.println("Prepared: "+"4.Select Distribution->Manage scripts, create a Custom script under the Team scripts.");
		formatStepResult(loginWebconsole(url,user1),"5.Login to the web console with the user B which belongs to the same team.");
		String queryName="Team query for script task"; 
		String queryGroup="'selenium team' queries";
		String computerName = "W7X64SP1-SEL";
		System.out.println("PASSED: "+"6.Select Reporting->Queries.");
		formatStepResult(createQuery(queryName,queryGroup,computerName),"7.Create a query with the team as the ower.");
		String taskName="InventoryScanCustom";
		formatStepResult(createTeamScriptTask(taskName),"8.Create a script distribution task using the script which created by user A, with the team as the ower.");
		formatStepResult(editTeamScriptTask(taskName),"9.Edit the distribution task under Team tasks, add query group, and save the task.");
		formatStepResult(startTeamScriptTask(taskName),"10.Start the task.");
		driver.close();
	    driver.quit();
	   
	    //switch to administrator user
	    formatStepResult(loginWebconsole(url,user2),"Administrator log into the web console.");
	    formatStepResult(deleteTeamScriptTask(taskName),"Delete team script task.");
	    formatStepResult(deleteTeamScriptQuery(),"Delete team script query.");
		driver.close();
	    driver.quit();
	}

	private boolean createQuery(String queryName, String queryGroup, String computerName){
		try {
			UtilWeb utlWeb =new UtilWeb();
			utlWeb.createQuery(mainHandle,driver,mPage,queryName,queryGroup,computerName);
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}

	private boolean createTeamScriptTask(String taskName){
		try {
			mPage.setDriverByHandle(mainHandle);
			mPage.clickDistribution();
			mPage.clickSciptsItem();
			mPage.clickTeamSciptsItem();
			mPage.rightClickOneTeamScript(taskName);
			mPage.clickScheduleMenu();
			mPage.inputTeamScripTaskName(taskName);
			sPage= new ScheduledScriptTaskPageObject(driver);
			sPage.ScheduledTaskWindow();
			sPage.setOwnerToTeam();
			sPage.saveScriptTask();
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	private boolean editTeamScriptTask(String taskName){
		try {
			mPage.setDriverByHandle(mainHandle);
			mPage.clickTeamTasksUnderCustomScriptTasks();
			mPage.rightClickOneTask(taskName);
			mPage.clickEditMenu();
			sPage= new ScheduledScriptTaskPageObject(driver);
			sPage.ScheduledTaskWindow();
			sPage.clickTargetDevicesTab();
			sPage.setTargetDevicesByTeamQuery("Team query for script task");
			sPage.saveScriptTask();
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}	
	}
		private boolean startTeamScriptTask(String taskName){
			try {
				mPage.setDriverByHandle(mainHandle);
				mPage.clickTeamTasksUnderCustomScriptTasks();
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
		
		private boolean deleteTeamScriptTask(String taskName){
			try {
				mPage.clickDistribution();
				mPage.clickSciptsItem();
				mPage.clickTeamTasksUnderCustomScriptTasks();
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
		
		private boolean deleteTeamScriptQuery(){
			try {
				mPage.clickQueryButton();
				mPage.checkToSelectTeam("'selenium team' queries");
				mPage.deleteQuery("Team query for script task");
				return true;
			}
			catch (Exception e){
				if (debug) e.printStackTrace();
				return false;
			}	
		}
	}

