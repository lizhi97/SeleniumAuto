package com.landesk.appium;

import java.io.File;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IOSInitDriver implements AdvancedInitDriver {
	
	DesiredCapabilities capabilities = new DesiredCapabilities();
	@Override
	public void initIOS(String appPath, String appPackage, String appActivity) throws Exception {
		if(containsChar(appPackage, '/')){
			// it is .app files
			File classpathRoot = new File(System.getProperty("user.dir"));
			File appDir = new File(classpathRoot, "/");
			File app = new File(appDir,"");
			capabilities.setCapability("app", app.getAbsolutePath() + appPackage);
			//System.out.println(app.getAbsolutePath() + appPackage);
		}else{
			//it is real device with .ipa
			capabilities.setCapability("app",appPackage);
		}
		if(appPath.equalsIgnoreCase("iphone")){
			capabilities.setCapability("device","iphone");
		}else if(appPath.equalsIgnoreCase("ipad")){
			capabilities.setCapability("device","ipad");
		}else{
			capabilities.setCapability("device","iphone");
		}


	   // bouldlId com.landesk.portal
	
	}
	private boolean containsChar(String s, char search) {
	    if (s.length() == 0)
	        return false;
	    else
	        return s.charAt(0) == search || containsChar(s.substring(1), search);
	}
	public DesiredCapabilities getCap(){
		return capabilities;
	}
	@Override
	public void initAndroid(String appPath, String appPackage, String appActivity) {
		

	}

}
