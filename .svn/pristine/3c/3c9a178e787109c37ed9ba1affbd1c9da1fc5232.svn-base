package com.landesk;


import org.openqa.selenium.WebDriver;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import com.landesk.ldms.webconsole.PageObjects.MainPageObject;

public class TestCaseBase{
	protected WebDriver driver;
	protected MainPageObject mPage;
	protected String mainHandle;
	protected boolean debug= false;
	
	protected boolean loginWebconsole(String url,String loginexe){	
		try{
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			mPage = new MainPageObject(driver);		
			Runtime.getRuntime().exec(loginexe);
			driver.get(url);
			mPage.letMainPageLoad();
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
