package com.landesk.avalanche.TestCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.landesk.AvalanchePageTestCasesBase;
import com.landesk.avalanche.PageObjects.EditProfileMobileDeviceObj;
import com.landesk.avalanche.PageObjects.MainPageAvalancheObj;
import com.landesk.avalanche.PageObjects.ProfilesPageObject;
import com.landesk.avalanche.PageObjects.ViewProfilePageObject;
import com.landesk.avalanche.Utils.Util;

public class TestCase54207 extends AvalanchePageTestCasesBase{
	
	 private MainPageAvalancheObj mp; 
	 private ProfilesPageObject ppo;
	 private EditProfileMobileDeviceObj cpmd;
	 private ViewProfilePageObject vpp;
	 private Util util;
	 @Parameters({"url","username","password","mdproname"})
	 @Test
	 public void test1(String url,String username,String password,String mdproname){
		 LoginAvalanchePage(url,username,password);
		 mp = new  MainPageAvalancheObj(driver);
		 ppo = new ProfilesPageObject(driver);
		 cpmd = new EditProfileMobileDeviceObj(driver);
		 vpp = new ViewProfilePageObject(driver);
		 util = new Util();
		 mp.clickProfileButton();
		 ppo.clickNewProfile();
		 ppo.clickMDbutton();
		 //cpmd.clearProfileNameText();
		 cpmd.inputProFileName(mdproname);
		 cpmd.clickSaveButton();
		 //vpp.clickClosedButton();
		 System.out.println("54207 finish running");

}
}
