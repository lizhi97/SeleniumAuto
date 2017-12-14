package com.landesk;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.landesk.avalanche.PageObjects.LoginPageObject;


public class AvalanchePageTestCasesBase {
	
	protected WebDriver driver;
	protected LoginPageObject lPage;
	protected String mainHandle;
	protected boolean debug= false;
	
	
	protected String getOSInfor(){
		Properties prop = System.getProperties();
		String os = prop.getProperty("os.name");
		System.out.println(os);
		return os;
	}
	
	protected String getCurrentPath(){
		
		return System.getProperty("user.dir");
	}
	
	protected WebDriver initChromeDriver() {
		
		String os = getOSInfor();
		if(os.startsWith("Mac")) {
			System.setProperty("webdriver.chrome.driver", getCurrentPath()+"/chromeDriver/chromeDriverForMac");
			driver = new ChromeDriver();
		} else if(os.startsWith("Win")) {
			System.setProperty("webdriver.chrome.driver", getCurrentPath()+"/chromeDriver/chromeDriverForWin.exe");
			driver = new ChromeDriver();
		}
		
		return driver;
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
	public boolean LoginAvalanchePage(String url,String username,String password){
		try{
			driver = initChromeDriver();
			lPage = new LoginPageObject(driver);
			mainHandle=driver.getWindowHandle();
			driver.manage().window().maximize();
			driver.get(url);
			lPage.waitForPageLoaded(driver);
			lPage.inputUsername(username);
			lPage.inputPassword(password);
			lPage.clickLoginButton();
			mainHandle=driver.getWindowHandle();
			return true;
		}
		catch (Exception e){			
			if (debug) e.printStackTrace();
			return false;
		}
	}
	
}
