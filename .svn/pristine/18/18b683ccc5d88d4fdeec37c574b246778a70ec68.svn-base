package com.landesk.appium;

import java.io.File;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidInitDriver implements AdvancedInitDriver {

	DesiredCapabilities capabilities = new DesiredCapabilities();
	@Override
	public void initIOS(String appPath, String appPackage, String appActivity) {

	}

	@Override
	public void initAndroid(String appPath, String appPackage, String appActivity) throws Exception {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "./");
		File app = new File(appDir, appPath);
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("device","android");
		capabilities.setCapability("app-package", appPackage);
		capabilities.setCapability("app-activity", appActivity);

	}
	@Override
	public DesiredCapabilities getCap(){
		return capabilities;
	}

}
