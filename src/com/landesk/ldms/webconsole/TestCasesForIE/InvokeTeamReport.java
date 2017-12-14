package com.landesk.ldms.webconsole.TestCasesForIE;


import java.io.IOException;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.landesk.TestCaseBaseForIE;
import com.landesk.ldms.webconsole.PageObjectsForIE.MainPageObject;
import com.landesk.ldms.webconsole.PageObjectsForIE.ReportViewPageObject;

/**
 *<b>Team reports can run successfully.</b><br>
 *1.Create a team in the LDMS Win32 Console and add two limited users to it.<br>
 *2.Login to the core server with the user A which belongs to the team.<br>
 *3.Select Reporting / Monitoring, select team reports.<br>
 *4.Click New Custom Report from the toolbar.<br>
 *5.Specify the Title, Description, and select Load from LDMS query.<br>
 *6.Select a query from the query groups, and click OK.<br>
 *7.Specify the Chart type and Query field.<br>
 *8.Click Ok to create the new report.<br>
 *9.Login to the web console with the user B which belongs to the same team.<br>
 *10.Select Reporting->Reports, and then expand the team reports.<br>
 *11.Try to run the new report.<br>
 * author Trudy
 */

public class InvokeTeamReport  extends TestCaseBaseForIE{
	
	ReportViewPageObject rePage;
	
	boolean debug = false;
	
	/**
	 * 
	 * @param url define web console URL.
	 * @param loginexe  AutoIT executable file to log in the web console.
	 * @param teamreportname  Define a team report name which user want to invoke from the web console.
	 * @param context
	
	 */

	@Parameters({"url","loginexe","teamreportname"})
	@Test
	
	public void invokeTeamReport(String url, String loginexe, String teamreportname, ITestContext context) throws IOException{
		System.out.println("Prepared: "+"1.Create a team in the LDMS Win32 Console and add two limited users to it.");
		System.out.println("Prepared: "+"2.Login to the core server with the user A which belongs to the team.");
		System.out.println("Prepared: "+"3.Select Reporting / Monitoring, select team reports.");
		System.out.println("Prepared: "+"4.Click New Custom Report from the toolbar.");
		System.out.println("Prepared: "+"5.Specify the Title, Description, and select Load from LDMS query.");
		System.out.println("Prepared: "+"6.Select a query from the query groups, and click OK.");
		System.out.println("Prepared: "+"7.Specify the Chart type and Query field.");
		System.out.println("Prepared: "+"8.Click Ok to create the new report.");
		
		//System.out.println("test1");
        formatStepResult(loginWebconsole(url,loginexe),"9.Login to the web console with the user B which belongs to the same team.");
		
		formatStepResult(clickTeamReportNode(),"10.Select Reporting->Reports, and then expand the team reports.");
	
		formatStepResult(openTeamReport(teamreportname),"11.Try to run the new report.");
		
		formatStepResult(checkReportResult(),"11.a.check the Report result");
		
	}
	
	private boolean clickTeamReportNode(){
		try {
		mainHandle = driver.getWindowHandle();
		mPage.clickReportsElement();
		if(debug) System.out.println("click report in left panel.");
		mPage.clickTeamreportsPlusElement();
		if(debug) System.out.println("click team report Node in right panel.");
		Thread.sleep(2000);
		return true;
	}catch(Exception e){
		if (debug) e.printStackTrace();
		return false;
	}
}  
	private boolean openTeamReport(String teamreportname){
		try {
		rePage= new ReportViewPageObject(driver);
		mPage.clickTeamReport(teamreportname);
		if(debug) System.out.println("Click: " + teamreportname);
	    rePage.openPage();
	    if(debug) System.out.println("Open " + teamreportname);
	    Thread.sleep(2000);
	    
		return true;
	}catch(Exception e){
		if (debug) e.printStackTrace();
		return false;
	}
}   
	private boolean checkReportResult(){
		try {
	    boolean a=rePage.checkReportResult();
	    Assert.assertEquals(a, true, "The team's report failed to be invoked.");
	    driver.close();
		if(debug) System.out.println("Close the report page.");
		mPage.setDriverByHandle(mainHandle);
		driver.close();
		driver.quit();
		if(debug) System.out.println("Close the web console");
			
		return true;
	}catch(Exception e){
		if (debug) e.printStackTrace();
		return false;
	}
}
}
