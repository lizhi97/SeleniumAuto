package com.landesk;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import com.landesk.ldms.webconsole.PageObjects.MainPageObject;


public class TestCaseBaseForIE {
	protected WebDriver driver;
	protected MainPageObject mPage;
	protected String mainHandle;
	protected boolean debug= true;
	
    protected String getCurrentPath(){
		
		return System.getProperty("user.dir");
	}

	protected WebDriver initIEDriver(){
		String currentDir = getCurrentPath();
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
    	System.setProperty(
    			"webdriver.ie.driver", 
    			currentDir + "\\LoginExe\\IEDriverServerx64.exe");
        return driver = new InternetExplorerDriver(capabilities);	
	}
	protected boolean loginWebconsole(String url,String loginexe){	
		try{
			driver = initIEDriver();
			driver.manage().window().maximize();
			System.out.println("test1");
			mPage = new MainPageObject(driver);		
			Runtime.getRuntime().exec(loginexe);
			System.out.println("test2");
			driver.get(url);
			System.out.println("test3");
			driver.switchTo().alert().accept();
			System.out.println("test4");
			//mPage.letMainPageLoad();
			System.out.println("test5");
			mainHandle=driver.getWindowHandle();
			return true;
		}
		catch (Exception e){			
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
	protected void formatStepResult(boolean stepFuntion,String stepString){
		if (stepFuntion){
			System.out.print("PASSED: ");
		} else{
			System.out.print("FAILED: ");
		}
		System.out.println(stepString);
	}
	
	@AfterClass
	public void afterClass() {
	}

	@AfterMethod
	public void afterMethod() {
	}


	
	@AfterSuite
	public void afterSuite() {
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeClass
	public void beforeClass() {
	}
	
	@BeforeMethod
	public void beforeMethod() {
	}
	
	@BeforeSuite
	public void beforeSuite() {
	} 

	@BeforeTest
	public void beforeTest() {

	}
	
	
	
}
