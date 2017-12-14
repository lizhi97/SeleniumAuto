package com.landesk.ldms.webconsole.TestCasesForIE;




import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.landesk.TestCaseBaseForIE;
import com.landesk.ldms.webconsole.PageObjects.InventoryScanPageObject;
import com.landesk.ldms.webconsole.PageObjects.PingDevicePageObject;
import com.landesk.ldms.webconsole.PageObjects.TracertDevicePageObject;

/**
 * <b>62497: The functions in the right-click menu of agent on the Web Console should work well</b><br>
 * 1.Loin to the web console as Administrator.<br>
 * 2.Right-click the client in the My devices->All devices list<br>
 * 3.Select ¡°Target¡± the device<br>
 * 4.Select ¡°Ping device¡±<br>
 * 5.Select ¡°Tracert device¡±<br>
 * 6.Select "Scan device"<br>
 * author Li,zhenguo
 * @param url - Webconsole's address
 * @param loginexe - Administrator log into the web console
 * @param DeviceId - The id of device
 * @param context
 * @throws Exception
 */

public class RightClickMenuTest  extends TestCaseBaseForIE{
	
	@Parameters({"url","loginexe","DeviceId"})
	@Test
	public void  rightClickMenuTest(String url,String loginexe, String DeviceId, ITestContext context) throws Exception{
		formatStepResult(loginWebconsole(url,loginexe),"1.Loin to the web console as Administrator.");
		formatStepResult(rightClickOneDevice(DeviceId),"2.Right-click the client in the My devices->All devices list");
		formatStepResult(selectTargetMenu(DeviceId),"3.Select 'Target' the device");
		formatStepResult(selectPingMenu(DeviceId),"4.Select 'Ping device'");
		formatStepResult(selectTracertMenu(DeviceId),"5.Select 'Tracert device'");
		formatStepResult(selectScanDeviceMenu(DeviceId),"6.Select 'Scan device'");
		driver.close();
	    driver.quit();
	}
	
	private boolean rightClickOneDevice(String DeviceId){
		try {
			mPage.clickMyDevicesElement();
			mPage.clickDevicePlusElement();
			mPage.clickAllDevicesElement();
			mPage.rightClickOneDevice(DeviceId);
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	private boolean selectTargetMenu(String DeviceId){
		try {
			String dname = mPage.getDeviceName(DeviceId);
			mPage.ClickTargetMenu();
			mPage.compareDeviceName(dname);
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	private boolean selectPingMenu(String DeviceId){
		try {
			mPage.rightClickOneDevice(DeviceId);
			mPage.ClickRightPingMenu();
			PingDevicePageObject PingPage=new PingDevicePageObject(driver);
			PingPage.openWindow();
			PingPage.ClickOkbuttonElement();
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	private boolean selectTracertMenu(String DeviceId){
		try {
			mPage.setDriverByHandle(mainHandle);
			mPage.rightClickOneDevice(DeviceId);
			mPage.ClickRightTracertMenu();
			TracertDevicePageObject TracertPage=new TracertDevicePageObject(driver);
			TracertPage.openWindow();
			TracertPage.checkTracertResult();
			TracertPage.clickClosebuttonElement();
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	private boolean selectScanDeviceMenu(String DeviceId){
		try {
			mPage.setDriverByHandle(mainHandle);
			mPage.rightClickOneDevice(DeviceId);
			mPage.ClickRightScanMenu();
			InventoryScanPageObject iPage=new InventoryScanPageObject(driver);
			iPage.openWindow();
			iPage.clickScanbuttonElement();
			iPage.checkScanResult();
			iPage.ClickOkbuttonElement();
			mPage.setDriverByHandle(mainHandle);
			return true;
		}
		catch (Exception e){
			if (debug) e.printStackTrace();
			return false;
		}
	}

}
