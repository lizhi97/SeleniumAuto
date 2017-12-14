package com.landesk.appium;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobileInitDriver implements InitDriver{
	MobileAdapterInitDriver mobileAdapterInitDriver;
	protected RemoteWebDriver driver;	
	@Override
	public void initDriver(String OS, String appPath, String appPackage, String appActivity) throws Exception {
		if(OS.equalsIgnoreCase("IOS") || OS.equalsIgnoreCase("Android")){
			mobileAdapterInitDriver = new MobileAdapterInitDriver(OS);	
			mobileAdapterInitDriver.initDriver(OS, appPath, appPackage, appActivity);
			driver = new SwipeableWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), mobileAdapterInitDriver.getCap());
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}else{
			System.out.println(OS + " is not supported");
		}

	}
	public void clickElement(By by, int s){
		WebDriverWait wait = new WebDriverWait(driver, s); 
		wait.until(ExpectedConditions.elementToBeClickable(by)); 
		driver.findElement(by).click();
	}

	public WebElement getElementWait(By by, int s){
		WebDriverWait wait = new WebDriverWait(driver, s);
		wait.until(ExpectedConditions.elementToBeClickable(by)); 
		WebElement el = driver.findElement(by);
		return el;
	}

}
