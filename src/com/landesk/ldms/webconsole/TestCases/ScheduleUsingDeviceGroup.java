package com.landesk.ldms.webconsole.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.landesk.TestCaseBase;
import com.landesk.ldms.Utils.UtilWeb;
import com.landesk.ldms.webconsole.PageObjects.CopyDeviceToTeamPageObject;
import com.landesk.ldms.webconsole.PageObjects.DeliveryMethodsPageObject;
import com.landesk.ldms.webconsole.PageObjects.DistributionPackagePageObject;
import com.landesk.ldms.webconsole.PageObjects.MainPageObject;
import com.landesk.ldms.webconsole.PageObjects.ScheduledTaskPageObject;


public class ScheduleUsingDeviceGroup {


/**
* <b>59625: schedule software packages from Team packages group using device group.</b><br>
* 1.Create a team in the LDMS Win32 Console and add an limited user to it.<br>
* 2.Assign the user with limited scope.<br>
* 3.Login to the webconsole with the user which belongs to the team.<br>
* 4.Copy some devices from All devices group to the Team devices group.<br>
* 5.Select Distribution->Distribution.<br>
* 6.Create a software package(bat) under My packages.<br>
* 7.Create a software distribution task using the software package.<br>
* 8.Create a delivery method(Multicast) under the team methods.<br>
* 9.Edit the distribution task under my tasks, select the new delivery method, add the team devices group, and save the task.<br>
* 10.Start the task.<br>
* author Winsy1
*/
public class TestAdminTask  extends TestCaseBase {
	boolean debug = true;	

/**
* @param url web console address
* @param user1 AutoIT executable file to log in the web console with user winsy1
* @param preName
* @param DistriMethType Multicast method
* @param packName Bet package Name=preName+packName
* @param methodName Multicast method name=preName+methodName
* @param taskName Bet scheduled task
* @param packagefile Bet package file url
* @param context
* @throws Exception
*/
@Parameters({"url","user1","loginexe","preName","packName","DistriMethType","methodName","taskName","packagefile"})
@Test
public void ScheduleUsingDeviceGroup(String url, String user1,String loginexe,String preName,String packName,String DistriMethType,String methodName,String taskName,String packagefile,ITestContext context) throws Exception{
	System.out.println("Prepared: "+"1.Create a team in the LDMS Win32 Console and add an limited user to it.");
	System.out.println("Prepared:"+"2.Assign the user with limited scope.");
	formatStepResult(loginWebconsole(url,loginexe),	"3.Login to the webconsole with the user which belongs to the team.");
	formatStepResult(copyDevices(),	"4.Copy some devices from All devices group to the Team devices group.");
	formatStepResult(returnDistribution(),	"5.Select Distribution->Distribution.");
	formatStepResult(createBatPackage(preName,packName,packagefile),"6.Create a software package(bat) under My packages.");
	formatStepResult(createBatTask(preName,packName,taskName),	"7.Create a software distribution task using the software package.");
	formatStepResult(createMulMethod(preName,methodName),	"8.Create a delivery method(Multicast) under the team methods.");
	formatStepResult(editBatTask(preName,methodName,taskName),	"9.Edit the distribution task under my tasks, select the new delivery method, add the team devices group, and save the task.");
	formatStepResult(startBatTask(preName,taskName),	"10.Start the task.");
	
}

private boolean copyDevices(){
	try{
		mPage.clickOneDevice("2");
		mPage.clickMoveCopyButton();
		CopyDeviceToTeamPageObject ctPage= new CopyDeviceToTeamPageObject(driver);
		ctPage.openWindow();
		ctPage.selectTeamGroup();
		ctPage.clickCopyButton();
		mPage.setDriverByHandle(mainHandle);
		Thread.sleep(2000);
		mPage.clickOneDevice("3");
		mPage.clickMoveCopyButton();
		CopyDeviceToTeamPageObject ct2Page= new CopyDeviceToTeamPageObject(driver);
		ct2Page.openWindow();
		ct2Page.selectTeamGroup();
		ct2Page.clickCopyButton();
	
		return true;
	}catch(Exception e){
	    if (debug) e.printStackTrace();
	    return false;
	}
}
private boolean returnDistribution(){
	try{
		mPage.setDriverByHandle(mainHandle);
		mPage.clickDistribution();
		mPage.clicKDistribution1();
		return true;
	}catch(Exception e){
	    if (debug) e.printStackTrace();
	    return false;
	}
}

private boolean createBatPackage(String preName,String packName,String packagefile){
	try{
		mPage.clickTeamPackageElement();
		DistributionPackagePageObject dPage = new DistributionPackagePageObject(driver);
		
		dPage.NewPackageWindow();
		dPage.selectPackage("Batch File");
		dPage.inputText(preName+packName);
		dPage.inputPrimaryFile(packagefile);
		dPage.inputDescription("Batch File-echo.bat");
		dPage.ClickAccoutPage();
		dPage.clickOk();
		return true;
	}catch(Exception e){
	    if (debug) e.printStackTrace();
	    return false;
	}
}

private boolean createBatTask(String preName,String packName,String taskName){
	try{
		mPage.setDriverByHandle(mainHandle);
		mPage.clickPackgeElement(preName+packName);
		ScheduledTaskPageObject sPage = new ScheduledTaskPageObject(driver);
		Thread.sleep(2000);
		sPage.ScheduledTaskWindow();
		sPage.inputTaskName(preName+taskName);
		sPage.clickOkTask();
		return true;
	}catch(Exception e){
	    if (debug) e.printStackTrace();
	    return false;
	}
}

private boolean createMulMethod(String preName,String methodName){
	try{
		mPage.setDriverByHandle(mainHandle);
		mPage.clickDeliveryMethElement();
		mPage.clickTeamMethodsElement();
		mPage.clickMulticastMethElement();
		
		DeliveryMethodsPageObject methPage = new DeliveryMethodsPageObject(driver);
		methPage.newDeliveryMethWindow();
		Thread.sleep(2000);
		methPage.inputMethodName(preName+methodName);
		methPage.selectOwner( "Public");
		methPage.clickOkMethodsElement();
		return true;
	}catch(Exception e){
	    if (debug) e.printStackTrace();
	    return false;
	}
}

private boolean editBatTask(String preName,String methodName,String taskName){
	try{
		mPage.setDriverByHandle(mainHandle);
		mPage.clickDistributiontaskstab();
		mPage.clickDeliveryTaskTeam();
		mPage.selectDistribuTaskName(taskName); 
		mPage.ClickEditElement();
		ScheduledTaskPageObject sPage = new ScheduledTaskPageObject(driver);
		Thread.sleep(2000);
		sPage.ScheduledTaskWindow();
		sPage.selectOwner("W2K8R2-SEL\\winsy1");
		sPage.clickDeliveryMethodElement();
		sPage.selectMethodType("Multicast (cache only)", "1");
		sPage.selectMethod(preName+methodName);
		sPage.clickTargetDriver();
		sPage.selectTargetGroup("'selenium team' devices");
		sPage.clickAddGroup();
		sPage.inputTaskName(preName+taskName);
		sPage.clickOkTask();
		return true;
	}catch(Exception e){
	    if (debug) e.printStackTrace();
	    return false;
	}
}

private boolean startBatTask(String preName,String taskName){
	try{
		mPage.setDriverByHandle(mainHandle);
		mPage.clickScheduledTask();
		mPage.clickTaskElement(preName+taskName);
		mPage.clickTaskStartNow();
		mPage.doubleClickTask(preName+taskName);
		mPage.clickRefreshTask();
		
		return true;
	}catch(Exception e){
		if (debug) e.printStackTrace();
		return false;
	}
}
	
}
@Parameters({"url","user1","loginexe","preName","packName","DistriMethType","methodName","taskName","packagefile"})
@Test
public void ScheduleUsingDeviceGroup1(String url, String user1,String loginexe,String preName,String packName,String DistriMethType,String methodName,String taskName,String packagefile,ITestContext context) throws Exception{
	WebDriver driver = new FirefoxDriver();
	UtilWeb utilWeb =new UtilWeb();
	driver.manage().window().maximize();
	MainPageObject mPage = new MainPageObject(driver);
	Runtime.getRuntime().exec(user1);
	driver.get(url);
	mPage.letMainPageLoad();
	
	String mainHandle = driver.getWindowHandle();
	mPage.clickOneDevice("2");
	mPage.clickMoveCopyButton();
	CopyDeviceToTeamPageObject ctPage= new CopyDeviceToTeamPageObject(driver);
	ctPage.openWindow();
	ctPage.selectTeamGroup();
	ctPage.clickCopyButton();
	mPage.setDriverByHandle(mainHandle);
	Thread.sleep(2000);
	mPage.clickOneDevice("3");
	mPage.clickMoveCopyButton();
	CopyDeviceToTeamPageObject ct2Page= new CopyDeviceToTeamPageObject(driver);
	ct2Page.openWindow();
	ct2Page.selectTeamGroup();
	ct2Page.clickCopyButton();
	mPage.setDriverByHandle(mainHandle);
	mPage.clickDistribution();
	mPage.clicKDistribution1();
	mPage.clickTeamPackageElement();
	DistributionPackagePageObject dPage = new DistributionPackagePageObject(driver);
	
	dPage.NewPackageWindow();
	dPage.selectPackage("Batch File");
	dPage.inputText(preName+packName);
	dPage.inputPrimaryFile(packagefile);
	dPage.inputDescription("Batch File-echo.bat");
	dPage.ClickAccoutPage();
	dPage.clickOk();
	mPage.setDriverByHandle(mainHandle);
	mPage.clickDeliveryMethElement();
	mPage.clickTeamMethodsElement();
	mPage.clickMulticastMethElement();
	
	DeliveryMethodsPageObject methPage = new DeliveryMethodsPageObject(driver);
	methPage.newDeliveryMethWindow();
	Thread.sleep(2000);
	methPage.inputMethodName(preName+methodName);
	methPage.selectOwner( "Public");
	methPage.clickOkMethodsElement();
	mPage.setDriverByHandle(mainHandle);
	mPage.clickPackgeElement(preName+packName);
	ScheduledTaskPageObject sPage = new ScheduledTaskPageObject(driver);
	Thread.sleep(2000);
	sPage.ScheduledTaskWindow();
	sPage.selectOwner("W2K8R2-SEL\\winsy1");
	sPage.clickDeliveryMethodElement();
	sPage.selectMethodType("Multicast (cache only)", "1");
	sPage.selectMethod(preName+methodName);
	sPage.clickTargetDriver();
	sPage.selectTargetGroup("'selenium team' devices");
	sPage.clickAddGroup();
	sPage.inputTaskName(preName+taskName);
	sPage.clickOkTask();
	mPage.setDriverByHandle(mainHandle);
	mPage.clickScheduledTask();
	mPage.clickTaskElement(preName+taskName);
	mPage.clickTaskStartNow();
	mPage.doubleClickTask(preName+taskName);
	mPage.clickRefreshTask();
	driver.close();
	driver.quit();
	utilWeb.DeleteDistritask(url, loginexe, packName, DistriMethType, methodName, taskName);
	
}
}
