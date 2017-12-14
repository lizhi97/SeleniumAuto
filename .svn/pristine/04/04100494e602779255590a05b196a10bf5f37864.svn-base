package com.landesk.ldms.webconsole.TestCasesForIE;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.landesk.TestCaseBaseForIE;
import com.landesk.ldms.Utils.util;
import com.landesk.ldms.webconsole.PageObjects.MainPageObject;


public class PageSettings  extends TestCaseBaseForIE{
	
	
	/**
	 * <b>62494: Default setting persist and are applied to all users</b><br>
	 * 1.Open the Web Console <br>
	 * 2.Navigate to Administration > Preferences > Page Settings<br>
	 * 3.Change the value for Items/page to anything other than the default one. For example to 50 <br>
	 * 4.Click Update <br>
	 * 5.Close the Web Console (or wait for 20 or so minutes for the session to expire), re-open the Web Console<br>
	 * 6.Check the value for Items/page.<br>
	 * author vivian
	 * @param url web console address
	 * @param loginexe AutoIT executable file to log in the web console
	 * @param context
	 * @throws Exception
	 */
	

	@Parameters({"url","loginexe"})
	@Test
	public void pageSettings(String url, String loginexe,ITestContext context) throws Exception{
		WebDriver driver = new FirefoxDriver();
		util uu= new util();
		driver.manage().window().maximize();

		MainPageObject mPage = new  MainPageObject(driver);
		Runtime.getRuntime().exec(loginexe);
		driver.get(url);
		mPage.letMainPageLoad();

		mPage.clickAdminGroupElement();
		mPage.clickperfGroupElement();
		mPage.clickPageSettingElement();

		mPage.inputItemsPage();
		mPage.clickUpdateItemsPage();

		uu.isAlertPresent(driver);
		System.out.println("click OK");
		System.out.println("Values should be updated");
		driver.close();
		Thread.sleep(1000*10);

		driver = new FirefoxDriver();
		mPage = new MainPageObject(driver);
		Runtime.getRuntime().exec(loginexe);
		driver.get(url);
		mPage.clickAdminGroupElement();
		mPage.clickperfGroupElement();
		mPage.clickPageSettingElement();
		String pageValue = mPage.getItemsPageValue();
		System.out.println("pageValue"+  pageValue);
		Assert.assertEquals(pageValue, "50");
	}


}
