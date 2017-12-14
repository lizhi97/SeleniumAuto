package com.landesk.ldms.webconsole.TestCasesForIE;


import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.landesk.TestCaseBaseForIE;
import com.landesk.ldms.Utils.UtilWeb;
import com.landesk.ldms.webconsole.PageObjects.AttributePageObject;
import com.landesk.ldms.webconsole.PageObjects.DeliveryMethodsPageObject;
import com.landesk.ldms.webconsole.PageObjects.DistributionPackagePageObject;
import com.landesk.ldms.webconsole.PageObjects.InventoryInfoPageObject;
import com.landesk.ldms.webconsole.PageObjects.ScheduledTaskPageObject;
/**
 * Check browser other than IE, for example Firefox works well in web console.
 * 1.Loin to the core console as Administrator and check the inventory info of a client machine.
 * 2.Create a query and run it
 * 3.Do a distribute task
 * @author Han, Ying(Helen)
 */
public class CheckBaseFuncationTest extends TestCaseBaseForIE {
	
	AttributePageObject aPage= new AttributePageObject(driver);
	InventoryInfoPageObject iPage = new InventoryInfoPageObject(driver);
	
	boolean debug = false;
	
	@Parameters({"url","loginexe","packName","methodName","packagefile","deviceName","computerName"})
	@Test
	public void  checkBaseFuncationTest(String url,String loginexe,String packName,String methodName,String packagefile,String deviceName,String computerName,ITestContext context) throws Exception{
		formatStepResult(loginAndCheckInventoryInfo(url, loginexe,deviceName),"1.Loin to the core console as Administrator and check the inventory info of a client machine.");
        formatStepResult(CreateQueryAndRun(url,loginexe,computerName),"2.Create a query and run it"); 
        formatStepResult(DoDistributeTask(url,loginexe,packName,methodName,packagefile,deviceName,computerName),"3.Do a distribute task");
        
        //UtilWeb utlWeb =new UtilWeb();
        		
        //if (debug)  System.out.println("*begin to delete task, method ,package and Query.*");
		//utlWeb.DeleteDistritask(url, loginexe, packName, "Policy",methodName, "hy-Ditribution");

		//if (debug) System.out.println("*begin to delete Query");
		//utlWeb.deleteQuery("hy-query", "hy-queryGroup",loginexe,url);
		 
		//if (debug) System.out.println("*end to delete task, method ,package and Query ");
		//mPage.setDriverByHandle(mainHandle);
		//driver.close();
		//driver.quit();
      
	}	
		
		private boolean loginAndCheckInventoryInfo(String url, String loginexe,String deviceName){
			try{
				loginWebconsole(url,loginexe);
				//mainHandle=driver.getWindowHandle();
				mPage.clickMyDevicesElement();
				mPage.clickDevicePlusElement();
				mPage.clickAllDevicesElement();
				mPage.rightClickDeviceByName(deviceName);
				mPage.ClickTargetMenu();
				if(debug) System.out.println("Select a Device");//select a device
				//View Inventory info
				mPage.clickTargetProperties();
				mPage.clickTargetViewInventory();
				mPage.waitForPageLoaded(driver);
				InventoryInfoPageObject iPage = new InventoryInfoPageObject(driver);
				iPage.openWindow();
				iPage.waitForPageLoaded(driver);
				if(debug) System.out.println("Check Inventory Info");//Check Inventory Info
				//screenshot
				iPage.takeScreenshotAndSave("InventoryInfo", "d:/test-output");
				iPage.close();
		   return true;
		}catch(Exception e){
			if (debug) e.printStackTrace();
			return false;
		 }
		}
		
		private boolean CreateQueryAndRun(String url, String loginexe,String computerName){
				try{
					/**create a new query*/
					UtilWeb utlWeb =new UtilWeb();
					mPage.setDriverByHandle(mainHandle);
					mPage.clickQueryButton();
					utlWeb.createQuery(mainHandle,driver, mPage, "hy-query", "My queries",computerName);
					if(debug) System.out.println("Create a query");//Create a query
					mPage.setDriverByHandle(mainHandle);
					
					/**Run a new query*/
					mPage.clickQueryButton();
					mPage.clickMyQueriesButton();
					mPage.clickMyQuerieslist();
					mPage.clickMyQuerieslistRunbutton();
					if(debug) System.out.println("Run a query");//Run a query
					
					//screenshot
					mPage.takeScreenshotAndSave("Queryresult", "d:/test-output");
					mPage.setDriverByHandle(mainHandle);

					utlWeb.deleteQuery("hy-query", "My queries", loginexe, url);
					if(debug) System.out.println("Delete a query");//Delete a query
					mPage.setDriverByHandle(mainHandle);
			   return true;
			}catch(Exception e){
				if (debug) e.printStackTrace();
				return false;
			 }
		 }
		
		private boolean DoDistributeTask(String url, String loginexe,String packName,String methodName,String packagefile,String deviceName,String computerName){
			try{
				/**Create one MSI package */
			    mPage.clickDistribution();
				mPage.clicKDistribution1();
				mPage.clickTeamPackageElement();
				if(mPage.isPackagePresent(packName)){
					System.out.println("The package is existing");
				}
				else{
					System.out.println("The package is non-existing and we will create it");
				}
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
				if(debug) System.out.println("Create one MSI package");//Create one MSI package

			    /**create one Policy method*/
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
				if(debug) System.out.println("Create one Policy method");//Create one Policy method
			
				//target a device
				mPage.setDriverByHandle(mainHandle);
				mPage.clickMyDevicesElement();
				mPage.clickDevicePlusElement();
				mPage.clickAllDevicesElement();
				mPage.rightClickDeviceByName(deviceName);
				mPage.ClickTargetMenu();
				mPage.rightClickTargetElement();
				if(debug) System.out.println("Target a device");//Target a device
			
				/**select package and create one task.*/
				driver.get(url);
				mPage.letMainPageLoad();
				mPage.clickDistribution();
				mPage.clicKDistribution1();
				mPage.clickTeamPackageElement();
				mPage.clickPackgeElement(packName);
				ScheduledTaskPageObject sPage = new ScheduledTaskPageObject(driver);
				sPage.ScheduledTaskWindow();
				String distributionTaskname = "hy-Ditribution";
			    sPage.inputTaskName(distributionTaskname);
				sPage.selectTeamOwner();
				sPage.clickDeliveryMethodElement();
				sPage.selectPolicyMethodType();
				sPage.selectMethod(methodName);
				sPage.clickTargetDriver();
				sPage.clickAddTargetList();
			    sPage.clickOkTask();
			    if(debug) System.out.println("Select package and create one task");//Select package and create one task
				
				/**Switch to Main Page and Start task.*/
				mPage.setDriverByHandle(mainHandle);
			    mPage.clickDeliveryTaskElement();
				mPage.clickDeliveryTaskTeam();
				mPage.selectDistribuTaskName(distributionTaskname);
				mPage.clickStartNowElement();
				if(debug) System.out.println("Start one task");//Start one task
				
				/**check the  status of the task.*/
				mPage.clickFreshButtonforTasksState(distributionTaskname);
				if(debug) System.out.println("Check the  status of the task");//Check the  status of the task
				
				/**Start GetPolicy Task.*/
			    String taskName="HYgetPolicyTask";
			    mPage.selectDistribuTaskName(taskName);
			    mPage.ClickEditElement();
			    sPage = new ScheduledTaskPageObject(driver);
			    sPage.EditTaskwindow();
			    sPage.clickTargetDriver();
			    sPage.clickAddTargetList();
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
				 	    sPage.selectTargetedDevice();
				 	    sPage.deleteTargetedDevice();
				 		sPage.clickOkTask();
				    	
				    	break;
				    	
				    }
				}
				
				Thread.sleep(80000);
				
				 mPage.setDriverByHandle(mainHandle);
			     mPage.selectDistribuTaskName(distributionTaskname);
			     mPage.rightClickOneTask(distributionTaskname);
			     mPage.pressRefreshMenu();
			     mPage.selectDistribuTaskName(distributionTaskname);
			     mPage.rightClickOneTask(distributionTaskname);
			     mPage.ViewTaskStatus();
			     mPage.exportTaskResult();
			
				 
				 /** begin to delete task, method ,package*/
				 //System.out.println("ssssssssssssssssssssssssssssssssssssss");
				 UtilWeb utlWeb =new UtilWeb();
				 utlWeb.DeleteDistritask(url, loginexe, packName, "Policy",methodName, distributionTaskname);
				 if(debug) System.out.println("Delete task, method ,package");//Delete task, method ,package
				 mPage.setDriverByHandle(mainHandle);
				 System.out.println("close the window");
				 driver.close();
				 driver.quit();
				 return true;
			}catch(Exception e){
				if (debug) e.printStackTrace();
				return false;
			 }
			
		}
		}
		
