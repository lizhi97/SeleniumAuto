package com.landesk.avalanche.TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.landesk.AvalanchePageTestCasesBase;
import com.landesk.avalanche.PageObjects.CreateNewNetworkProfileObj;
import com.landesk.avalanche.PageObjects.EditNetworkProfileObj;
import com.landesk.avalanche.PageObjects.IpAddressPoolsObj;
import com.landesk.avalanche.PageObjects.MainPageAvalancheObj;
import com.landesk.avalanche.PageObjects.ProfilesPageObject;
import com.landesk.avalanche.PageObjects.ViewNetworkProfileObj;
import com.landesk.avalanche.Utils.Util;

public class TestCaseNetworkProfile extends AvalanchePageTestCasesBase{
	 
	 private MainPageAvalancheObj mp; 
	 private ProfilesPageObject ppo;
	 private CreateNewNetworkProfileObj np;
	 private ViewNetworkProfileObj vnp;
	 private EditNetworkProfileObj enp;
//	 private IpAddressPoolsObj ippl;
	
	 @Parameters({"url","username","password","profileName"})
	 @Test
	 public void test53136(String url,String username,String password,String profileName) throws InterruptedException{
		     LoginAvalanchePage(url,username,password);
			 mp = new  MainPageAvalancheObj(driver);
			 ppo = new ProfilesPageObject(driver);
			 np = new CreateNewNetworkProfileObj(driver);
			 vnp = new ViewNetworkProfileObj(driver);
			 enp = new EditNetworkProfileObj(driver);
			 mp.clickProfileButton();
	//		 mp.clickJasonfolder();
			 ppo.clickNewProfile();
			 ppo.clickNetworkSetting();
			 np.inputProFileName(profileName);
	//		 np.editMDIpAddressPools();
			 //ippl = new IpAddressPoolsObj(driver);
			 
	//		 np.inputIpAddressRange();
	//		 ippl.clickAddButton();
	//		 ippl.clickSaveButton();
			 np.checkEnableBox();
			 np.clickSaveButton();
			 System.out.println("1");
			 vnp.clickCloseButton();
			 System.out.println("2");

		}
	 @Parameters({"profileName"})	
	 @Test
	 public void test53142(String profileName) throws InterruptedException{
//		 mp.clickProfileButton();
//		 mp.clickJasonfolder();
		 ppo.clickProfileByName(profileName);
		 System.out.println("3");
		 np.clickCloneButton();
		 System.out.println("4");
		 enp.clickSaveButton();
		 System.out.println("5");
		 np.clickCloseButton();
		 //		 np.clickCloneButton();
//		 String expected = "none";
//	     String actual = np.getIpAddressPoolInfo();
//	     Util.validateWarningMessage(actual, expected);
//		 np.clickSaveButton();
//		 mp.clickProfileButton(); 
//		 mp.clickJasonfolder();
//		 ppo.DeleteProfileInputByOrder(ppo.getPorfileNameOrder("0JasonNetworkProfile"));
	 } 

@Parameters({"profileName"})
@Test
     public void test53169(String profileName) throws InterruptedException{
//	 mp.clickProfileButton();
//	 mp.clickJasonfolder();
	 ppo.clickProfileByName(profileName);
	 np.clickEditButton();
	 np.checkManageWWAN();
	 np.checkManageWWAN();
	 
}
@Parameters({"profileName"})
@Test
     public void test53176(String profileName) throws InterruptedException{
//	 mp.clickProfileButton();
	 System.out.println(profileName);
//	 mp.clickJasonfolder();
	 ppo.clickProfileByName(profileName);
	 System.out.println("3");
	 System.out.println("Edit 0JackNetworkProfile");
	 np.clickEditButton();
	 np.checkManageWLAN();
	 System.out.println("Enable WLAN");
	 
	 
	 
	 
	 np.SelectEncrySetting("WEP Key Rotation");
	 System.out.println("Select WEP Key Rotation");
	 np.clickSaveButton();
	 
//	 np.clickCloneButton();
	// System.out.println("4");
	// enp.clickSaveButton();
	// System.out.println("5");
	// np.clickCloseButton();
	 //		 np.clickCloneButton();
//	 String expected = "none";
//    String actual = np.getIpAddressPoolInfo();
//    Util.validateWarningMessage(actual, expected);
//	 np.clickSaveButton();
//	 mp.clickProfileButton(); 
//	 mp.clickJasonfolder();
//	 ppo.DeleteProfileInputByOrder(ppo.getPorfileNameOrder("0JasonNetworkProfile"));
} 
@Parameters({"profileName"})
@Test
     public void test53177(String profileName) throws InterruptedException{
//	 mp.clickProfileButton();
	 System.out.println(profileName);
//	 mp.clickJasonfolder();
	 ppo.clickProfileByName(profileName);
	 System.out.println("3");
	 System.out.println("Edit 0JackNetworkProfile");
	 np.clickEditButton();
	 np.checkManageWLAN();
	 System.out.println("Enable WLAN"); 
	 np.SelectEncrySetting("WPA (TKIP)");
	 System.out.println("Select WPA(TKIP)");
	 np.clickSaveButton();
	 

} 
@Parameters({"profileName"})
@Test
     public void test53178(String profileName) throws InterruptedException{
//	 mp.clickProfileButton();
	 System.out.println(profileName);
//	 mp.clickJasonfolder();
	 ppo.clickProfileByName(profileName);
	 System.out.println("3");
	 System.out.println("Edit 0JackNetworkProfile");
	 np.clickEditButton();
	 np.checkManageWLAN();
	 System.out.println("Enable WLAN"); 
	 np.SelectEncrySetting("WPA2 (AES)");
	 System.out.println("Select WPA2(AES)");
	 np.clickSaveButton();
	 

} 
@Parameters({"profileName"})
@Test
     public void test53179(String profileName) throws InterruptedException{
//	 mp.clickProfileButton();
	 System.out.println(profileName);
//	 mp.clickJasonfolder();
	 ppo.clickProfileByName(profileName);
	 System.out.println("3");
	 System.out.println("Edit 0JackNetworkProfile");
	 np.clickEditButton();
	 np.checkManageWLAN();
	 System.out.println("Enable WLAN"); 
	 np.SelectEncrySetting("WPA (TKIP) + WPA2 (AES)");
	 System.out.println("Select WPA(TKIP)+WPA2(AES)");
	 np.clickSaveButton();
	 

} 


@Parameters({"profileName"})
@Test
     public void test53187(String profileName) throws InterruptedException{
//	 mp.clickProfileButton();
	 System.out.println(profileName);
//	 mp.clickJasonfolder();
	 ppo.clickProfileByName(profileName);
	 System.out.println("3");
	 System.out.println("Edit 0JackNetworkProfile");
	 np.clickEditButton();
	 np.checkManageWLANIP();
	 System.out.println("Enable WLAN IP"); 
	// np.SelectEncrySetting("WPA (TKIP) + WPA2 (AES)");
	// System.out.println("Select WPA(TKIP)+WPA2(AES)");
	 np.clickSaveButton();
	 

} 


}

