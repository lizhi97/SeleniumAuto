package com.landesk.appium;

import org.openqa.selenium.remote.DesiredCapabilities;

public class MobileAdapterInitDriver implements InitDriver{
	AdvancedInitDriver advancedInitDriver;
	public MobileAdapterInitDriver(String osType){
		
		if(osType.equalsIgnoreCase("IOS")) {
			advancedInitDriver = new IOSInitDriver();
		}else if(osType.equalsIgnoreCase("Android")){
			advancedInitDriver = new AndroidInitDriver();
		}
	}
	@Override
	public void initDriver(String OS, String appPath, String appPackage, String appActivity) throws Exception{
		if(OS.equalsIgnoreCase("IOS")) {
			advancedInitDriver.initIOS(appPath, appPackage, appActivity);
		}else if(OS.equalsIgnoreCase("Android")){
			advancedInitDriver.initAndroid(appPath, appPackage, appActivity);
		}
		
		
	}
	public DesiredCapabilities getCap(){
		
			return advancedInitDriver.getCap();
		}
		
		
	

}
