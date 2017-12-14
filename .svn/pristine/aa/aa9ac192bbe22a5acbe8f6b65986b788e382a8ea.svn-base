package com.landesk.ldms.webconsole.TestCasesForIE;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.landesk.TestCaseBaseForIE;
import com.landesk.ldms.webconsole.PageObjects.MainPageObject;
import com.landesk.ldms.webconsole.PageObjects.RealtimeMonitorPageObject;

public class RealtimeMonitor  extends TestCaseBaseForIE{
	
	
	/**
	 * 62505 Real-time monitoring can open in Web Console
	 *  1. Launch the Real-time inventory and monitoring web console about an agent from the core console.	The graph of the real-time performance should display correctly.
	 *  2. In the left navigation pane, click Monitoring.	
	 *  3. Click the Performance counter settings tab. Then select a counter from Objects->Instances->Counters you want to monitor.	
	 *  4. Specify upper and lower thresholds, and then click Apply to add the monitored counter successfully.
	 *  5. Click the Active performance counters tab. In the Counters drop-down list, select the counter , then select View real-time data to display the graph of real-time performance.
	 *  6. Then select View historical data to display the graph of historical performance.	The graph of the historical performance should display correctly.
	 * 
	 * Author JerryZhang
	 * @param url Webconsole base url
	 * @param loginexe AutoIT executable file to log in the webconsole
	 * @param client
	 * @param context For TestNG
	 * @throws Exception
	 */
	@Parameters({"url","loginexe","client"})
	@Test
	public void realtimeMonitor(String url, String loginexe,String client,ITestContext context) throws Exception{
		WebDriver driver = new FirefoxDriver();				
		driver.manage().window().maximize();
		MainPageObject mPage = new MainPageObject(driver);
		Runtime.getRuntime().exec(loginexe);
		driver.get(url);
		mPage.letMainPageLoad();
		mPage.clickMyDevicesElement();
		mPage.clickDevicePlusElement();
		mPage.clickAllDevicesElement();
		

		mPage.doubleClickDevice(client);
		
		RealtimeMonitorPageObject rPage=new RealtimeMonitorPageObject(driver);
		rPage.openWindow();
		rPage.switchLeftLeft();		
		rPage.clickMonitoringElement();		
		
		rPage.swithToTabsFrame();
		rPage.clickPcsTabElement();
		
		rPage.swithToBottomFrame();
		
		rPage.clickNetInterfaceElement();		
		
		//rPage.clickIntelPROElement();
		rPage.clickLocalAreaElement();
		
		rPage.clickBytesReceivedElement();
		rPage.updateLowerThreshold("10");
		rPage.updateUpperThreshold("100000000");
		rPage.clickApplyBtnElement();
		
		rPage.swithToTabsFrame();
		rPage.clickApcTabElement();
		
		rPage.swithToBottomFrame();
		rPage.selectBytesOptionElement();
		
		rPage.clickRealtimeRadioElement();
	
		rPage.takeScreenshot("realtimeData","test-output");
		rPage.clickHistoricalRadioElement();
		
		rPage.takeScreenshot("historicalData","test-output");
		
		driver.close();
		driver.quit();		
	}
	

}
