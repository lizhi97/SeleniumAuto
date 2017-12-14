package com.landesk.avalanche.TestCases;



import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.landesk.AvalanchePageTestCasesBase;
import com.landesk.avalanche.PageObjects.EditProfileMobileDeviceObj;
import com.landesk.avalanche.PageObjects.MainPageAvalancheObj;
import com.landesk.avalanche.PageObjects.ProfilesPageObject;
import com.landesk.avalanche.PageObjects.ViewProfilePageObject;
import com.landesk.avalanche.Utils.*;

public class TestCaseMobileDeviceProfile extends AvalanchePageTestCasesBase{
	
	 private MainPageAvalancheObj mp; 
	 private ProfilesPageObject ppo;
	 private EditProfileMobileDeviceObj cpmd;
	 private ViewProfilePageObject vpp;
	 private Util util;
	 @Parameters({"url","username","password"})
	 @Test
	 public void test53890(String url,String username,String password){
		     LoginAvalanchePage(url,username,password);
		     mp = new  MainPageAvalancheObj(driver);
			 ppo = new ProfilesPageObject(driver);
			 cpmd = new EditProfileMobileDeviceObj(driver);
			 vpp = new ViewProfilePageObject(driver);
			 util = new Util();
			 mp.clickProfileButton();
			 ppo.clickNewProfile();
			 ppo.clickMDbutton();
			 cpmd.clearProfileNameText();
			 cpmd.clickSaveButton();
			 String expected = "Profile Name is required.";
			 String actual = cpmd.getWarninMessageWarning();
			 Util.validateWarningMessage(actual, expected);
			 cpmd.inputProFileName("0000MD34");
			 cpmd.clickSaveButton();
			 //vpp.clickClosedButton();
			 System.out.println("53890 finish running");
			 
			 
	}
	
	 @Test
	 public void test53892(){
		 mp.clickProfileButton();
		 ppo.clickNewProfile();
		 ppo.clickMDbutton();
		 cpmd.clearProfileNameText();
		 cpmd.inputProFileName("0000MD34");
		 cpmd.clickSaveButton();
		 String expected = "Profile names must be unique.";
		 String actual = cpmd.getWarninMessageWarning();
		 Util.validateWarningMessage(actual, expected);
		 System.out.println("53892 finish running");
	 }
	 
	 @Test
	 public void test53896(){
		    mp.clickProfileButton();
		    ppo.clickNewProfile();
		    ppo.clickMDbutton();
			cpmd.clearProfileNameText();
			cpmd.inputProFileName("?/sd<>\"");
			cpmd.clickSaveButton(); 
			String expected = "Profile names must start and end with a letter or number and can only contain letters, numbers, single spaces, dashes, periods and underscores.";
			String actual = cpmd.getWarninMessageWarning();
			Util.validateWarningMessage(actual, expected);
			System.out.println("53896 finish running");
		}
	 
	 @Test 
	 public void test53893(){
		 mp.clickProfileButton(); 
		 ppo.DeleteProfileInputByOrder(ppo.getPorfileNameOrder("0000MD34"));
		 System.out.println("53893 finish running");
	 }
	
	 @Test 
	 public void test54199(){
		
			mp.clickProfileButton();
			ppo.clickNewProfile();
			ppo.clickMDbutton();
			cpmd.clearProfileNameText();
			cpmd.inputProFileName("00autoMD");
			cpmd.checkEnableBox();
			util.validatecheckBoxStatus(cpmd.getCheckBoxValueStatus());
			cpmd.clickSaveButton();
			mp.clickProfileButton();
			ppo.clickProfile(ppo.getPorfileNameOrder("00autoMD"));
			vpp.clickEditButton();
			util.validateInputText(cpmd.getInputTextStatus());
			mp.clickProfileButton();
			ppo.DeleteProfileInputByOrder(ppo.getPorfileNameOrder("00autoMD"));
			System.out.println("54199 finish running");
	 }
	 
	
	 @Test 
		public void test54200(){
			mp.clickProfileButton();
			ppo.clickNewProfile();
			ppo.clickMDbutton();
			cpmd.clearProfileNameText();
			cpmd.inputProFileName("001MD2");
			cpmd.clickWizardButton();
			cpmd.clickOnWizardSelectList();	
			cpmd.selectColumnsItem();			
			cpmd.clickInsertButton();			
			cpmd.clickEqualButton();			
			cpmd.inputWizardField();		
			cpmd.clickWizardOKButton();
			cpmd.clickSaveButton();
			System.out.println("54200 finish running");
          
		}
	 
}
