package com.landesk.avalanche.TestCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.landesk.AvalanchePageTestCasesBase;
import com.landesk.avalanche.PageObjects.CreateNewAlertProfileObj;
import com.landesk.avalanche.PageObjects.MainPageAvalancheObj;
import com.landesk.avalanche.PageObjects.ProfilesPageObject;

public class TestCaseAlertProfile extends AvalanchePageTestCasesBase{
	
	 private MainPageAvalancheObj mp; 
	 private ProfilesPageObject ppo;
	 private CreateNewAlertProfileObj ap;
	 
	 @Parameters({"url","username","password"})
	 
	 @Test
	 //By Tracy
	 //Alert profile can be selected and de-selected//
	 public void test53069(String url,String username,String password){
	 		     LoginAvalanchePage(url,username,password);
	 			 mp = new  MainPageAvalancheObj(driver);
	 			 ppo = new ProfilesPageObject(driver);
	 			 ap = new CreateNewAlertProfileObj(driver);
	 			 mp.clickProfileButton();
	 			 mp.clickTracyfolder();
	 			 ap.selectAlertProfile();
	 			 ap.sleep(3000);
	 			 ap.clickApplyButton();
	 			 ap.sleep(1000);
	 			 ap.clickCheckboxOfAlertProfile(1);
	 			 ap.sleep(1000);
	 			 ppo.clickCheckboxOfProfile(1);    
	 			System.out.println("53069 finish running");
	 			
	 	}
	 
	 @Test
	 //Alert profile can be created and deleted//
	 public void test53070(){
		 ap.sleep(1000);
		 mp.clickProfileButton();
		 mp.clickTracyfolder();
		 ppo.clickNewProfile();
		 ppo.clickAlert();
		 ap.inputAlertProfileName(ap.inputAlertProfileName(7));
		 ap.clickAlertProfileSaveButton();
		 ap.clickAlertProfileCloseButton();
		 ap.selectAlertProfile();
		 ap.sleep(3000);
		 ap.clickApplyButton();
		 ap.sleep(1000);
		 ap.clickCheckboxOfAlertProfile(1);
		 ap.sleep(1000);
		 ap.deleteAlertProfile();  
		 System.out.println("53070 finish running");
	}    
			 
	
	 @Test
	 //Alert profile can be renamed//
	 public void test53071(){
		     ap.sleep(1000);
			 ap.clickAlertProfileName();
			 ap.clickEditButton();
			 ap.inputAlertProfileName(ap.inputAlertProfileName(7));
			 ap.clickAlertProfileSaveButton();
			 ap.clickAlertProfileCloseButton();
		     System.out.println("53071 finish running");
	 }
	 
	 @Test
	 //The same Alert profile name is not allowed//
	 public void test53072(){
		     ap.sleep(1000);  
		     ppo.clickNewProfile();
			 ppo.clickAlert();
			 ap.inputAlertProfileName("samenameAlertProfile");
			 ap.clickAlertProfileSaveButton();
			 ap.clickAlertProfileCloseButton();
			 ppo.clickNewProfile();
			 ppo.clickAlert();
			 ap.inputAlertProfileName("samenameAlertProfile");
			 ap.clickAlertProfileSaveButton();
		     ap.clickAlertProfileCancleButton();  
		     System.out.println("53072 finish running");
	}
	 
	 @Test 
	 //The clone cannot have the same name as an existing profile//
	 public void test53094(){
		 ap.sleep(1000);
		 ap.clickAlertProfileName();
		 ap.clickAlertProfileCloneButton();;
		 ap.inputAlertProfileName("samenameAlertProfile");
		 ap.clickAlertProfileSaveButton();
		 ap.clickAlertProfileCancleButton();
		 System.out.println("53094 finish running");
	 }
	
	 @Test 
	 //Alert profile permission - view only(user and group)//
	 public void test53106(){
		
		 System.out.println("53106 finish running");	
	 }
	 
	
	 @Test 
	 //Alert profile permission - view\edit(user and group)//
	public void test53109(){
			
		 System.out.println("53109 finish running");
		}
	 
	 @Test 
	 //make sure the applied alerts can be trigger and appear under alert tab//
	 public void test54033(){
		     ap.sleep(1000);
			 ap.clickCheckboxOfAlertProfile(1);
			 ap.clickApplyButton();
			 ap.clickScheduleDeployButton();
			 ap.clickApplyProfileButton();
			 mp.clickProfileButton();
			 mp.clickToolButton();
			 mp.clickAlertsButton();
		 System.out.println("54033 finish running");
		}
}
