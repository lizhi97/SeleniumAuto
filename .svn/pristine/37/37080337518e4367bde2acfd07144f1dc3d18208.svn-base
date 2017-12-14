package com.landesk.avalanche.TestCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.landesk.AvalanchePageTestCasesBase;
import com.landesk.avalanche.PageObjects.CreateSoftwareProfileObj;
import com.landesk.avalanche.PageObjects.MainPageAvalancheObj;
import com.landesk.avalanche.PageObjects.ProfilesPageObject;

public class TestCase88548SoftwareProfile extends AvalanchePageTestCasesBase{
	 @Parameters({"url","username","password"})
	 @Test
	 public void test(String url,String username,String password){
		     LoginAvalanchePage(url,username,password);
			 MainPageAvalancheObj mp = new  MainPageAvalancheObj(driver);
			 ProfilesPageObject ppo = new ProfilesPageObject(driver);
			 CreateSoftwareProfileObj newsoftwarepro = new CreateSoftwareProfileObj(driver);
			 mp.clickProfileButton();
			 ppo.clickNewProfile();
			 ppo.clickNewSoftware();;
			 newsoftwarepro.inputProFileName("00zxjcreatsoftwareprofile1");
			 newsoftwarepro.clickSaveButton();
			 newsoftwarepro.newSoftwarePackage();
			 newsoftwarepro.seleSoftpacktoAdd(0);
			 newsoftwarepro.inputPackageName("package1");
			 newsoftwarepro.clickNextButton();
			 newsoftwarepro.installStatus();
			 newsoftwarepro.clickFinishbutton(1);
		 
		 
	}
}
