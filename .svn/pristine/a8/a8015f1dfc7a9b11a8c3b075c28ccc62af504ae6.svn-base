package com.landesk.avalanchebuild.TestCases_Wendy;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.landesk.AvalanchePageTestCasesBase;
import com.landesk.avalanhchebuild.PageObjects_Wendy.CreateAppPayloadObject;
import com.landesk.avalanche.PageObjects.CreateNewAlertProfileObj;
import com.landesk.avalanche.PageObjects.MainPageAvalancheObj;
//import com.landesk.avalanche.PageObjects.ProfilesPageObject;
import com.landesk.avalanche.PageObjects.ProfilesPageObject;

public class CreateAppPayload extends AvalanchePageTestCasesBase {
	 
	private MainPageAvalancheObj mp;
	private CreateAppPayloadObject appPayload;
	@Parameters({"url","username","password"})
	@Test
	//Create iOS app payload//
	public void CreateiOSAppPayload(String url,String username,String password){
	     LoginAvalanchePage(url,username,password);
	     mp = new  MainPageAvalancheObj(driver);
		 appPayload = new CreateAppPayloadObject(driver);
		 mp.clickProfileButton();
		 for (int i=0;i<1;i++)
		 {
		 appPayload.clickNewPayload();
		 appPayload.sleep(5000);
		 appPayload.selePlatform(0);
		 appPayload.InputPayloadName("iOSappstore"+i);
		 appPayload.DeploymentMethod(1);
		 appPayload.sleep(5000);
		 appPayload.SoftwareHosting(0);
		 appPayload.iOSChooseApp("469337564");
		 appPayload.SavePayload();
		 }
 
	 }
	@Test
	public void CreateiOSManifestPayload(){
		 for (int i=0;i<1;i++)
		 {
		 appPayload.clickNewPayload();
		 appPayload.sleep(5000);
		 appPayload.selePlatform(0);
		 appPayload.InputPayloadName("iOSmanifest"+i);
		 appPayload.DeploymentMethod(1);
		 appPayload.sleep(5000);
		 appPayload.SoftwareHosting(1);
		 appPayload.iOSAppName("App"+i);
		 appPayload.iOSBrowseAppIcon();
		 appPayload.iOSManifestURL("https://mobilitytest.landesk.com/Studio-288.plist");
		 appPayload.iOSBundleID("com.landesk.studio");
		 appPayload.iOSBundleVersion("0.7.155");
		 appPayload.iOSLaunchPath("wlstudio:\\"); 		 
		 appPayload.SavePayload();
		 }
	}
	@Test
	public void CreateAndroidAppPayload(){
		 for (int i=0;i<1;i++)
		 {
			 appPayload.clickNewPayload();
			 appPayload.sleep(5000);
			 appPayload.selePlatform(1);
			 appPayload.InputPayloadName("AndroidApp"+i);
			 appPayload.DeploymentMethod(1);
			 appPayload.sleep(2000);
			 appPayload.AndroidSoftwareHosting(0);
			 appPayload.AndroidChooseApp("https://play.google.com/store/apps/details?id=com.adobe.reader");
			 appPayload.SavePayload();
		 }
	}
	@Test
	public void CreateAndroidManifestPayload(){
		 for (int i=0;i<1;i++)
		 {
		 appPayload.clickNewPayload();
		 appPayload.sleep(5000);
		 appPayload.selePlatform(1);
		 appPayload.InputPayloadName("Androidmanifest"+i);
		 appPayload.DeploymentMethod(1);
		 appPayload.sleep(2000);
		 appPayload.AndroidSoftwareHosting(1);
		 appPayload.AndroidAppName("App"+i);
		 appPayload.AndroidBrowseAppIcon();
		 appPayload.AndroidPackageID("com.landesk.studio");
		 appPayload.AndrodManifestURL("http://mobilitytest.landesk.com/Studio/Studio.apk");
		 appPayload.AndroidBundleVersion("0.7.155");		  		 
		 appPayload.SavePayload();
		 }
	}
}
