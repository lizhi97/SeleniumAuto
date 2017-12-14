   package com.landesk.avalanche.TestCases;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.landesk.AvalanchePageTestCasesBase;
import com.landesk.avalanche.PageObjects.CreateNewAlertProfileObj;
import com.landesk.avalanche.PageObjects.MainPageAvalancheObj;
import com.landesk.avalanche.PageObjects.ProfilesPageObject;


@Test
public class TestCase53070 extends AvalanchePageTestCasesBase{
	
	 private MainPageAvalancheObj mp; 
	 private ProfilesPageObject ppo;
	 private CreateNewAlertProfileObj ap;
	 
	
	@Parameters({"url","username","password"})	
	@Test
	public void test(String url,String username,String password){
		     LoginAvalanchePage(url,username,password);
			 mp = new  MainPageAvalancheObj(driver);
			 ppo = new ProfilesPageObject(driver);
			 ap = new CreateNewAlertProfileObj(driver);
			 System.out.println("53070 finish running");
			 mp.clickProfileButton();
 			 mp.clickTracyfolder();
 			 ap.selectAlertProfile(); 
 			 ap.sleep(3000);
 			 ap.clickApplyButton();
 			 ap.sleep(1000);
 			 ap.clickCheckboxOfAlertProfile(1);
 			 ap.clickApplyButton();
 			 System.out.println("53070 finish running");
 			 ap.clickScheduleDeployButton();
 			 ap.clickApplyProfileButton();
 			 mp.clickProfileButton();
 			 mp.clickToolButton();
 			 mp.clickAlertsButton();
 			 System.out.println("53070 finish running"); 
			 
			 
}

	
}