package com.landesk.ldms.webconsole.PageObjectsForIE;
import java.util.List;
import java.util.concurrent.TimeUnit;
import com.landesk.PageBaseForIE;
import com.landesk.ldms.Utils.util;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageObject extends PageBaseForIE{
	private util u;
	
	public MainPageObject(WebDriver d){		
		super(d); 
		this.driver = d;
		u = new util();;
		
	}
	
	public void letMainPageLoad(){
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);		
		try {
			switchLeftLeft();
		} catch(Exception e){
			if (debug) System.out.println("Left frame not loaded, refresh");
			driver.navigate().refresh();	
		}
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	private void switchtoScheduledTasksTree(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"split_bottom_old",60);
		waitAndSwitchToFrame(driver,"split_bottom",60);
		waitAndSwitchToFrame(driver,"body",60);
		waitAndSwitchToFrame(driver,"scheduledTasksTree",60);
	}
	
	
	public void goToQueryListFrame(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver, "main" , 50);
		waitAndSwitchToFrame(driver, "core" , 50);
		waitAndSwitchToFrame(driver, "body" , 50);	
		waitAndSwitchToFrame(driver, "i_bottom", 50);
		waitAndSwitchToFrame(driver, "queryList", 50);
		waitAndSwitchToFrame(driver, "swd_top" , 50);
	}
	public void clickDeleteQueryButton(){
		goToNewQueryFrame();
		waitAndGetElement(driver,By.xpath("//span[contains(text(),'Delete')]"),60);
		waitAndClickElement(driver,By.xpath("//span[contains(text(),'Delete')]"),60);
	}
	public void GotoClickDeleteQuery(){
		
		clickDeleteQueryButton();
		
	}
	
	public void deleteQuery(String queryName){
		goToQueryListFrame();
		String s = queryName;
		try{
			waitAndClickElement(driver,By.xpath("//td[contains(text(),'"+s+"')]"),50);
			Thread.sleep(4000);
			GotoClickDeleteQuery();
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}catch (Exception e){
			if(debug)e.printStackTrace();
		}
		
	}
	/**
	 * select user group
	 * @param queryGroup  
	 */
	public void checkToSelectTeam(String queryGroup)
	{
		
		boolean flag = true;
		String s = "//span[contains(text(),\""+queryGroup+"\")]";
		while(flag){
			switchQueryTreeFrame();
			String teamName = waitAndGetElement(driver, By.xpath(s), 80).getText();
			if(queryGroup.equals(teamName)){
				waitAndClickElement(driver, By.xpath(s), 80);
				flag =false;
			}
		}
	}
	/**
	 * Select user's task.<br>
	 * Author Trudy
	 * @param distributionPackageName
	 */
	public void selectDistrPackage(String distributionPackageName) {
		switchPackageListFrame(); 
		String s= distributionPackageName;
		waitAndGetElement(driver,By.xpath("//td[contains(text(),'"+s+"')]"),60);
		waitAndClickElement(driver,By.xpath("//td[contains(text(),'"+s+"')]"),60);
	}
	
	/**
	 * Click 'All tasks' node.<Br>
	 * Author Trudy
	 */
	public void selectAlltaskNode(){
		switchtoScheduledTasksTree();
		waitAndClickElement(driver,By.xpath("//span[contains(text(),'All tasks')]"),60);
	}
	
	public  void selectMytaskNode(){
		switchtoScheduledTasksTree();
		waitAndClickElement(driver,By.xpath("//span[contains(text(),'My tasks')]"),60);
		if(debug) System.out.println("Click My tasks node");
		
		
	}
	
	
	/**
	 * Select 'All distribution packages' Node.<br>
	 * Author Trudy
	 */
	public void selectDistrPackagenode() {
		switchDistributionPackagesTreeframe();
		waitAndClickElement(driver,By.xpath("//span[contains(text(),'All distribution packages')]"),60);
		if (debug) System.out.println("select All distribution packages Node");
		}
	
	/**
	 * Click the 'All delivery methods' node in Delivery methods tab.<Br>
	 * Author Trudy
	 */
	public void selectAllMethNode() {
		switchDeliveryMethodsTreeFrame();
		waitAndClickElement(driver,By.xpath("//span[contains(text(),'All delivery methods')]"),60);
		waitAndClickElement(driver,By.id("img4"),60);
		}
	
	/**
	 * Select the method type by the @param DistriMethType.<Br>
	 * Author Trudy
	 * @param DistriMethType
	 */
	public void selectMethType(String DistriMethType){
	if(DistriMethType.equals("Policy")){
			waitAndClickElement(driver,By.xpath("//table[@class=\"groupDiv1\"]/tbody/tr[3]/td/span"),60);
			if (debug) System.out.println("select " + DistriMethType +" Methodtype");
		} 
		else if(DistriMethType.equals("Push")){
			waitAndClickElement(driver,By.xpath(".//table[@class=\"groupDiv1\"]/tbody/tr[2]/td/span"),60);
			if (debug) System.out.println("select " + DistriMethType +" Methodtype");
		}
		else if(DistriMethType.equals("Policy-supported push")){
			waitAndClickElement(driver,By.xpath(".//table[@class=\"groupDiv1\"]/tbody/tr[1]/td/span"),60);
			if (debug) System.out.println("select " + DistriMethType +" Methodtype");
		}		
		else if(DistriMethType.equals("Multicast (cache only)")){
			waitAndClickElement(driver,By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[8]/td/table/tbody/tr[4]/td/span/span"),60);
			if (debug) System.out.println("select " + DistriMethType +" Methodtype");
		}
	}
	
	/**
	 * Select the user's delivery methods.<Br>
	 * Author Trudy
	 * @param DistriMethName
	 */
	public void selectMethName(String DistriMethName){
		switchDeliveryMethodslist();
		String s = DistriMethName;
		waitAndClickElement(driver,By.xpath("//td[contains(text(),'"+s+"')]"),60);
		if (debug) System.out.println("select" + DistriMethName +"MethodName");
		}
	
	/**
	 * Select the user's task.<Br>
	 * Author Trudy
	 * @param distriTaskName
	 */
	public void selectDistribuTaskName(String distriTaskName){
		switchTaskList1Frame();
		String s = distriTaskName;
		waitAndClickElement(driver,By.xpath("//td[contains(text(),'"+s+"')]"),60);
	}
	
	public void clickDeliveryTaskTeam(){
		switchtoScheduledTasksTree();
		waitAndClickElement(driver,By.xpath("//span[@class=\"textSpan\" and text()=\"'selenium team' tasks\"]"),50);
	}
	
	public void clickScheduledButton(){
		switchPackageToolframe();
		waitAndClickElement(driver, By.xpath("//table[@class=\"tbList\"]/tbody/tr/td[10]/a/span"), 50);
		
	}
	
	
	
	public void goToNewFrameCondition(){
		
		 driver.switchTo().defaultContent();
		 waitAndSwitchToFrame(driver, "main" , 50);
		 waitAndSwitchToFrame(driver, "core" , 50);
		 waitAndSwitchToFrame(driver, "body" , 50);
		 waitAndSwitchToFrame(driver, "i_bottom" , 50);
		 waitAndSwitchToFrame(driver, "queryList" , 50);
		 waitAndSwitchToFrame(driver, "i_bottom" , 50); 
	}
	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
		
	public void goToNewQueryFrame() {
		
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver, "main" , 50);
		waitAndSwitchToFrame(driver, "core" , 50);
		waitAndSwitchToFrame(driver, "body" , 50);	
		waitAndSwitchToFrame(driver, "i_bottom", 50);
		waitAndSwitchToFrame(driver, "queryList", 50);
		waitAndSwitchToFrame(driver, "findfrm", 50);
		
	}
	/**
	 * 1.Click 'Delete' button to delete task.<Br>
	 * 2.Click 'OK' button in the warning message.<Br>
	 * Author Trudy
	 */
	public void clickDeleteSWDtaskElement(){
		switchTaskToolFrame();
		((JavascriptExecutor) driver).executeScript("javascript:parent.frames[1].Delete();");
		if (debug) System.out.println("execute java script,click delete");
		Alert alert = driver.switchTo().alert();
		alert.accept();
		waitForPageLoaded(driver);	
	}
	/**
	 * Click 'Delete' button to delete a distribution package.<br>
	 * Click 'OK' button in the warning message.<br>
	 * Author Trudy
	 */
	public void clickDeleteSWDPackElement(){
		switchPackageToolframe();
		((JavascriptExecutor) driver).executeScript("javascript:parent.frames[1].Delete();");
		if (debug) System.out.println("execute java script,click delete");
		Alert alert = driver.switchTo().alert();
		alert.accept();
		waitForPageLoaded(driver);
		if (debug) System.out.println("click OK--Delete SWD package"); 
		}
	/**
	 * Click 'Delivery methods' to switch to Delivery methods tab.<Br>
	 * Author Trudy
	 */
	public void clicKDeliverymethodtab(){
		driver.switchTo().defaultContent();
		swithSWDtabs();
		waitAndClickElement(driver,By.xpath(".//*[@id='2tab']/a"),50);
	}
	
	/**
	 * 1. Click the 'Delete button' to delete the delivery method.<Br>
	 * 2. Click the 'OK' button in the warning message.<Br>
	 * Author Trudy
	 */
	public void clickDeleteSWDMethodElement(){
		switchDeliveryMethodsFrame();
		((JavascriptExecutor) driver).executeScript("javascript:parent.frames[1].Delete();");
		if (debug) System.out.println("execute java script,click delete");
		Alert alert = driver.switchTo().alert();
		alert.accept();
		waitForPageLoaded(driver);
		if (debug) System.out.println("click OK--Delete the SWD method"); 
		}
	
	public void clickQueryButton() {
		switchLeftLeft();
		waitAndGetElement(driver, By.xpath("//a[text()='Queries']"), 50);
		waitAndClickElement(driver, By.xpath("//a[text()='Queries']"), 50);
		
	}
	
	public void clickSaveQueryButton(){
		
		 //waitAndClickElement(driver, By.xpath(".//*[@id='_btnSave']/nobr"), 50);
		 waitAndGetElement(driver, By.xpath(".//*[@id='_btnSave']/nobr"), 50);
		//((JavascriptExecutor) driver).executeScript("javascript:saveDialog(false)");
		 waitAndClickElement(driver, By.xpath(".//*[@id='_btnSave']/nobr"), 50);
	}

	public void clickConditionEdit() {
		
		
	     waitAndGetElement(driver, By.xpath(".//*[@id='_btnWhereEdit']/nobr"), 50);
		((JavascriptExecutor) driver).executeScript("javascript:DisplayDialog('query_frm.aspx',800,620)");
		
	}

	public void clickSortButtonEdit() {
		// waitAndClickElement(driver, By.id("_btnSortEdit"), 50);
		 waitAndGetElement(driver, By.id("_btnSortEdit"), 50);
	    ((JavascriptExecutor) driver).executeScript("javascript:DisplayDialog('query_sort.aspx',800,420)");
		 
	}
	
	public void clickArrbuttonEdit() {
		waitAndGetElement(driver, By.id("_btnAttrEdit"), 50);
		//waitAndClickElement(driver, By.id("_btnAttrEdit"), 50);
		((JavascriptExecutor) driver).executeScript("javascript:DisplayDialog('query_columnsupdt.aspx?target=Computer&type=field',700,570)");
		
	}
	
	public void clickNewPackageButton() {
		switchPackageToolframe();
		waitAndGetElement(driver, By.id("span_newPackage"), 50);
		waitAndClickElement(driver, By.id("span_newPackage"), 60);
	}
	

	public void clickNewQueryButton() {
		waitAndGetElement(driver, By.xpath(".//*[@id='spanqry_add']"), 50);
		waitAndClickElement(driver, By.xpath(".//*[@id='spanqry_add']"), 50);
	
	}
	
	/**
	 * @author YHan
	 * Click my queries button
	 */
	public void clickMyQueriesButton() {
		switchQueryTreeFrame();
		waitAndClickElement(driver, By.xpath(".//*[@id='group1']/span"), 50);
		}
	
	/**
	 * @author YHan
	 * Click my queries list 
	 */
	public void clickMyQuerieslist() {
		swithSwd_topFrame();
		waitAndClickElement(driver, By.xpath(".//*[@id='0item']"), 50);
		}
	
	/**
	 * @author YHan
	 * Click my queries list Run Button
	 */
	public void clickMyQuerieslistRunbutton() {
		switch_FindFrmFrame1();
		waitAndClickElement(driver, By.xpath(".//*[@id='query_run']"), 50);
		}
	
	public void clickDeleteElement(){
		switchFindfrmFrame();
		((JavascriptExecutor) driver).executeScript("javascript:parent.frames[1].doWork('delete');");
		if(debug) System.out.println("execute java script,click delete");//execute java script,click delete
		Alert alert = driver.switchTo().alert();
		alert.accept();
		waitForPageLoaded(driver);
		if(debug) System.out.println("click OK--Delete");//= click OK--Delete  

	}
	private void switchLeftLeft(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"left",60);
		waitAndSwitchToFrame(driver,"left",60);
	}
	private void switchQueryTreeFrame(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver, "main" , 50);
		waitAndSwitchToFrame(driver, "core" , 50);
		waitAndSwitchToFrame(driver, "body" , 50);	
		waitAndSwitchToFrame(driver, "i_bottom", 50);
		waitAndSwitchToFrame(driver, "queryTree", 50);
		if(debug) System.out.println("switch to queiryTree frame");
	}
	
	public void clickAdminGroupElement(){
		switchLeftLeft();
		waitAndClickElement(driver,By.xpath(".//*[@id='group5img']"),50);
	
	}

	public void clickperfGroupElement(){
		driver.switchTo().defaultContent();
		switchLeftLeft();
		waitAndClickElement(driver,By.xpath(".//*[@id='aText11']/a"),50);

	}

	public void clickCustomSettingElement(){	
		switchTabsframe();		
		waitAndClickElement(driver,By.xpath(".//*[@id='1tab']/a"),50);
		
	}
	public void clickNewColumSet(){
		switchFindfrmFrame();
		
		waitAndClickElement(driver,By.xpath("html/body/table/tbody/tr/td[1]/a"),50);
		//((JavascriptExecutor) driver).executeScript("javascript:parent.frames[1].doWork('new');");
		//System.out.println("execute java script,click New");//execute java script,click New
	}
	public void clickEditColumSet(){
		switchFindfrmFrame();
		//waitAndClickElement(driver,By.xpath(".//*[@id='_edit']"),50);
		((JavascriptExecutor) driver).executeScript("javascript:parent.frames[1].doWork('edit_fields');");
		//System.out.println("execute java script, click Edit");//execute java 
	}
	public void clickPageSettingElement(){
		switchTabsframe();
		waitAndClickElement(driver,By.xpath(".//*[@id='2tab']/a"),50);

	}
	
	
	
	
	public String inputTeamScripTaskName(String scriptname){
		Alert alert = driver.switchTo().alert();
		String s = scriptname;
		alert.sendKeys(s);
		alert.accept();
		return s;
	}
	
	public String inputTeamQueryName(){
		util u = new util();
		String s="Team Query "+ u.randomStringGenerator();
		return s;
	}
	
	public void inputItemsPage(){
		switchBodyframe();
		waitAndGetElement(driver,By.id("perPage"),60).clear();
		switchBodyframe();
		waitAndGetElement(driver,By.id("perPage"),60).sendKeys("50");
	}
	public String getItemsPageValue(){
		switchBodyframe();
		String pageValue= driver.findElement(By.id("perPage")).getAttribute("value");
		if(debug) System.out.println("pageValue=" + pageValue);
		return pageValue;
	}
	
	public void clickUpdateItemsPage(){
		switchBodyframe();
		waitAndGetElement(driver,By.xpath(".//*[@id='Form1']/table/tbody/tr/td/table/tbody/tr[6]/td/input"),60).submit();
		
	}
	
	/**
	 * the frame for column sets tool
	 * author Winsy
	 */

	private void switchFindfrmFrame(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"body",60);
		waitAndSwitchToFrame(driver,"split_top",60);
		waitAndSwitchToFrame(driver,"findfrm",60);
		
	}
	
		
		
	
	private void switchBodyframe(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"body",60);
	}
	
	
	private void switchDeliveryMethodsFrame(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"split_bottom_old",60);
		waitAndSwitchToFrame(driver,"split_bottom",60);
		waitAndSwitchToFrame(driver,"body",60);
		waitAndSwitchToFrame(driver,"deliveryMethodsBody",60);
		waitAndSwitchToFrame(driver,"findfrm",60);//The name does not make "findfrm",It will be repeated.
		
	}
	public void updateOKAlert(){
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void clickcolumnElement(String column){
		switchCustomColumnsFrame();
		waitAndClickElement(driver,By.xpath("//td[contains(text(),'"+column+"')]"),50);
		
	}

	public void clickMyDevicesElement(){
		switchLeftLeft();
		waitAndClickElement(driver,By.xpath(".//*[@id='aText0']/a"),50);
		switchto_i_topframe();

	}

	public String getDeviceName(String DeviceId){
		String Devicename = waitAndGetElement(driver,By.id(DeviceId),60).getText();
		return Devicename;
		
	}
	
	/**
	 * Invoke the team report from the right report view.</br> 
	 * Author Trudy
	 * @param teamreportname
	 */
	public void clickTeamReport(String teamreportname){
		waitAndClickElement(driver,By.name(teamreportname),50);
    }
	
	public void compareDeviceName(String dname){
		switch_d_bottomframe();
		WebElement el =waitAndGetElement(driver, By.id("targetTable"),60);
		List <WebElement> els = el.findElements(By.tagName("tr"));
		for(WebElement s: els){
			if(s.getText().equals(dname)){
				if(debug) System.out.println("Target device successful");
				break;
			}  
		}
	}
	
	/**
	 * Click 'Reports' in Left panel.</br> 
	 * Author Trudy
	 */
	public void clickReportsElement(){
		switchLeftLeft();
		waitAndClickElement(driver,By.xpath("html/body/table/tbody/tr[8]/td/table/tbody/tr/td/table/tbody/tr[1]/td[2]/a"),50);
	}
	
	/**
	 * Expand team reports in right reports view.</br> 
	 * Author Trudy
	 */
	public void clickTeamreportsPlusElement(){
		switch_reoprt_d_bottomframe();
		waitAndClickElement(driver,By.id("img1"),50);
	}
	//Expand the plus in network view.
	public void clickDevicePlusElement() throws InterruptedException{
	
		switchServerList_leftframe();
		waitAndClickElement(driver,By.id("img1"),50);
		if (debug) System.out.println("tiaoshi2");
		if (debug) System.out.println("Click +");
		waitAndClickElement(driver,By.xpath("//span[@enctitle=\"All+devices\"]"),50);
		if (debug) System.out.println("Click My device in device view");

	}
    //Click all Devices in network view.
	public void clickAllDevicesElement(){	
		waitAndClickElement(driver,By.xpath("//span[@enctitle=\"All+devices\"]"),50);
		switchto_i_topframe();
		
	}
	
	//Switch the frame(i_top) of "all device list"
	private void switchto_i_topframe(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"split_top",60);
		waitAndSwitchToFrame(driver,"serverlist_right",60);
		waitAndSwitchToFrame(driver,"i_top",60);
	
    }
	
	//Switch the frame(tabs) of "Target Properties"-HelenHan
	private void switch_TabsFrame(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"split_bottom_old",60);
		waitAndSwitchToFrame(driver,"split_bottom",60);
		waitAndSwitchToFrame(driver,"footer",60);
		waitAndSwitchToFrame(driver,"tabs",60);
    }
	
	private void switchTabsframe(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"footer",60);
		waitAndSwitchToFrame(driver,"tabs",60);
    }
	
	/**
	 * @author YHan
	 * Switch the frame(findfrm) of "View inventory"
	 */
	private void switch_FindFrmFrame(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"split_bottom_old",60);
		waitAndSwitchToFrame(driver,"split_bottom",60);
		waitAndSwitchToFrame(driver,"body",60);
		waitAndSwitchToFrame(driver,"findfrm",60);
	    }
	
	/**
	 * @author YHan
	 * Switch the frame(findfrm) of "My Query list menu "
	 */
	private void switch_FindFrmFrame1(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"body",60);
		waitAndSwitchToFrame(driver,"i_bottom",60);
		waitAndSwitchToFrame(driver,"queryList",60);
		waitAndSwitchToFrame(driver,"findfrm",60);
	}
	
		private void switch_d_bottomframe(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"split_bottom_old",60);
		waitAndSwitchToFrame(driver,"split_bottom",60);
		waitAndSwitchToFrame(driver,"body",60);
		waitAndSwitchToFrame(driver,"d_bottom",60);

	}
	
	private void switch_reoprt_d_bottomframe(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"body",60);
		waitAndSwitchToFrame(driver,"d_bottom",60);

	}
	private void switchDistributionPackagesTreeframe(){
		
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"split_top",60);
		waitAndSwitchToFrame(driver,"distributionPackagesTree",60);
	}
	
	private void switchCustomColumnsFrame(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"body",60);
		waitAndSwitchToFrame(driver,"split_top",60);
		waitAndSwitchToFrame(driver,"",60);
		
		
	}
	
	private void switchServerList_leftframe(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"split_top",60);
		waitAndSwitchToFrame(driver,"serverlist_left",60);

	}
	
	public void clickNewTaskButton(){
		switchPackageToolframe();
		waitAndGetElement(driver,By.xpath("//span[contains(text(),'Schedule')]"),50);
		waitAndClickElement(driver,By.xpath("//span[contains(text(),'Schedule')]"),50);
	}
	
	private void switchPackageToolframe(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"split_top",60);
		waitAndSwitchToFrame(driver,"distributionPackagesBody",60);
		waitAndSwitchToFrame(driver,"findfrm",60);
	}
	
	private void switchFooterTabsframe(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"split_bottom_old",60);
		waitAndSwitchToFrame(driver,"split_bottom",60);
		waitAndSwitchToFrame(driver,"footer",60);
		waitAndSwitchToFrame(driver,"tabs",60);
	}
	
	private void switchDeliveryMethodsTreeFrame(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"split_bottom_old",60);
		waitAndSwitchToFrame(driver,"split_bottom",60);
		waitAndSwitchToFrame(driver,"body",60);
		waitAndSwitchToFrame(driver,"deliveryMethodsTree",60);
	}
	
	private void switchPackageListFrame(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"split_top",60);
		waitAndSwitchToFrame(driver,"distributionPackagesBody",60);
		waitAndSwitchToFrame(driver,"i_bottom",60);
		
	}
	
	private void switchTaskList2Frame(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"i_bottom",60);
		waitAndSwitchToFrame(driver,"scheduledTasksBody",60);
		waitAndSwitchToFrame(driver,"i_bottom",60);
	}
	
	private void switchTaskList1Frame(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"split_bottom_old",60);
		waitAndSwitchToFrame(driver,"split_bottom",60);
		waitAndSwitchToFrame(driver,"body",60);
		waitAndSwitchToFrame(driver,"scheduledTasksBody",60);
		waitAndSwitchToFrame(driver,"i_bottom",60);
		
	}
	
	private void switchTaskTool2Frame(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"i_bottom",60);
		waitAndSwitchToFrame(driver,"scheduledTasksBody",60);
		waitAndSwitchToFrame(driver,"findfrm",60);
	}
	
	private void switchTaskToolFrame(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"split_bottom_old",60);
		waitAndSwitchToFrame(driver,"split_bottom",60);
		waitAndSwitchToFrame(driver,"body",60);
		waitAndSwitchToFrame(driver,"scheduledTasksBody",60);
		waitAndSwitchToFrame(driver,"findfrm",60);
	}

	private void switchCustomScriptTasksFrame(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"split_bottom_old",60);
		waitAndSwitchToFrame(driver,"split_bottom",60);
		waitAndSwitchToFrame(driver,"body",60);
		waitAndSwitchToFrame(driver,"scheduledTasksTree",60);
	}
	
	private void switchtoMoveCopy(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"split_top",60);
		waitAndSwitchToFrame(driver,"serverlist_right",60);
		waitAndSwitchToFrame(driver,"findfrm",60);
	}
	
	private void switchDeliveryMethodslist(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"split_bottom_old",60);
		waitAndSwitchToFrame(driver,"split_bottom",60);
		waitAndSwitchToFrame(driver,"body",60);
		waitAndSwitchToFrame(driver,"deliveryMethodsBody",60);
		waitAndSwitchToFrame(driver,"i_bottom",60);
	}
	

	
	private void switchtoTeamScripts(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"split_top",60);
		waitAndSwitchToFrame(driver,"CsScriptTree",60);
	}
	/**
	 * switch to 'tabs' frame in SWD panel.
	 */
	private void swithSWDtabs(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"split_bottom_old",60);
		waitAndSwitchToFrame(driver,"split_bottom",60);
		waitAndSwitchToFrame(driver,"footer",60);
		waitAndSwitchToFrame(driver,"tabs",60);
	}
	
	

	
	/**
	 * @author YHan
	 * Switch to My queries list
	 */
	private void swithSwd_topFrame(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"body",60);
		waitAndSwitchToFrame(driver,"i_bottom",60);
		waitAndSwitchToFrame(driver,"queryList",60);
		waitAndSwitchToFrame(driver,"swd_top",60);
	}
	
	private void switchtoTeamScriptsFrm(){
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver,"main",60);
		waitAndSwitchToFrame(driver,"core",60);
		waitAndSwitchToFrame(driver,"split_top",60);
		waitAndSwitchToFrame(driver,"CsScriptList",60);
		waitAndSwitchToFrame(driver,"cs_bottom",60);
	}
	
	public void clickMyTasksUnderCustomScriptTasks() throws InterruptedException{
		switchCustomScriptTasksFrame();
		waitAndClickElement(driver,By.xpath(".//*[@id='group1']/span"),60);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};
	}
	
	public void clickTeamTasksUnderCustomScriptTasks() throws InterruptedException{
		switchCustomScriptTasksFrame();
		waitAndClickElement(driver,By.xpath(".//*[@id='groupp9']/span"),60);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};
	}
	
	public void clickFreshButtonforCustomScriptTasks(String taskName) throws InterruptedException{
		switchTaskToolFrame();
		waitAndClickElement(driver,By.xpath(".//*[@id='_refresh']"),60);
		String taskStatus= getTaskState(taskName);
		for(int i=0;i<=100;i++){
			if(taskStatus.equals("Waiting")){
				switchTaskToolFrame();
				waitAndClickElement(driver,By.xpath(".//*[@id='_refresh']"),60);
				Thread.sleep(5000);
				taskStatus= getTaskState(taskName);	
			}
			else if(taskStatus.equals("Working")){
				switchTaskToolFrame();
				waitAndClickElement(driver,By.xpath(".//*[@id='_refresh']"),60);
				Thread.sleep(5000);
				taskStatus= getTaskState(taskName);	
			}
			else break;
		}
	}
	
	public boolean clickFreshButtonforTasksState(String taskName) throws InterruptedException{
		switchTaskToolFrame();
		waitAndClickElement(driver,By.xpath(".//*[@id='_refresh']"),60);
		String taskStatus= getTaskState(taskName);
		for(int i=0;i<=100;i++){
			if(!taskStatus.equals("Available for Download")){
				switchTaskToolFrame();
				waitAndClickElement(driver,By.xpath(".//*[@id='_refresh']"),60);
				Thread.sleep(5000);
				taskStatus= getTaskState(taskName);	
			}
			else return true;
		}
		return false;
	}
	/**
	 * Get the task's Status 
	 * author Jack,cheng
	 * @param taskName
	 * @return TaskStatus
	 */
	
	
	public String getTaskState(String taskName){
		switchTaskList1Frame();
		//String TaskStatus = waitAndGetElement(driver,By.xpath("//td[contains(text(),'"+taskName+"')]"),60).getText();
		String TaskStatus = waitAndGetElement(driver,By.xpath("//tr[td[contains(text(),'"+taskName+"')]]/td[3]"),60).getText();
		if (debug) System.out.println("start get "+taskName+"  TaskStatus  "+TaskStatus);
		return TaskStatus;
	}
	
	
	
	public void ViewTaskStatus() throws InterruptedException{
		waitAndClickElement(driver,By.xpath(".//*[@id='menuTask']/tbody/tr/td/table/tbody/tr[1]/td/a"),60);
		
	
		//waitAndGetElement(driver, By.xpath(".//*[@id='myList']/tbody/tr[6]/td[1]"),60);
		if(debug) System.out.println("view the task status");
		Thread.sleep(2000);
		takeScreenshotAndSave("test1","C://test");
	}
	
	
	public String getScriptTaskStatus(){
		switchTaskList1Frame();
		String TaskStatus = waitAndGetElement(driver,By.xpath(".//*[@id='myList']/tbody/tr[2]/td[3]"),60).getText();
		return TaskStatus;
	}
	
	
	public void rightClickOneTask(String taskName){
		switchTaskList1Frame();
		
		waitAndRightClickElement(driver,By.xpath("//td[contains(text(),'"+taskName+"')]"),60);
		 if(debug) System.out.println("Right click the task    "+taskName);
	}
	
	
	public void clickViewTaskStatus() throws InterruptedException{
		waitAndClickElement(driver,By.xpath(".//*[@id='menuTask']/tbody/tr/td/table/tbody/tr[1]/td/a"),60);
		if(debug) System.out.println("view the task status");
		Thread.sleep(2000);
		takeScreenshotAndSave("test1","C://test");
	}
	
	public void clickEditMenu(){
		waitAndClickElement(driver,By.xpath(".//*[@id='menuTask']/tbody/tr/td/table/tbody/tr[2]/td/a"),60);
	}
	
	public void clickStartnowMenu(){
		waitAndClickElement(driver,By.xpath(".//*[@id='menuTask']/tbody/tr/td/table/tbody/tr[3]/td/a"),60);
	}
	
	public void  pressRefreshMenu(){
		waitAndClickElement(driver,By.xpath(".//*[@id='menuTask']/tbody/tr/td/table/tbody/tr[8]/td/a"),60);
		if(debug) System.out.println("Press refresh menu");
	}
	
	
		
	public void clickViewStatus() throws InterruptedException{
		waitAndClickElement(driver,By.xpath(".//*[@id='menuTask']/tbody/tr/td/table/tbody/tr[1]/td/a"),60);
		//waitAndGetElement(driver, By.xpath(".//*[@id='myList']/tbody/tr[6]/td[1]"),60);
		Thread.sleep(2000);
		takeScreenshotAndSave("test1","C://test");
	}
	
	public void clickDeleteMenu() throws InterruptedException{
		waitAndClickElement(driver,By.xpath(".//*[@id='menuTask']/tbody/tr/td/table/tbody/tr[4]/td/a"),60);
	}
	
	public void deleteScriptTask(){
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public void doubleClickAllDevices() throws InterruptedException{
		switchTaskList1Frame();
		Actions actionTask = new Actions(driver);
		actionTask.doubleClick(driver.findElement(By.xpath(".//*[@id='myList']/tbody/tr[2]/td[1]")));
		actionTask.perform();
		//waitAndGetElement(driver, By.xpath(".//*[@id='myList']/tbody/tr[1]/td[9]"),60);
		Thread.sleep(2000);
		takeScreenshotAndSave("test2","C://test");
	}
	
	public void exportTaskResult(){
			
		switchTaskList1Frame();
		String allDeviceNumber=waitAndGetElement(driver,By.xpath(".//*[@id='myList']/tbody/tr[2]/td[2]"),60).getText();
	    String ActiveDeviceNumber=waitAndGetElement(driver,By.xpath(".//*[@id='myList']/tbody/tr[3]/td[2]"),60).getText();
	    String PendingDeviceNumber=waitAndGetElement(driver,By.xpath(".//*[@id='myList']/tbody/tr[4]/td[2]"),60).getText();
	    String SuccessullDeviceNumber=waitAndGetElement(driver,By.xpath(".//*[@id='myList']/tbody/tr[5]/td[2]"),60).getText();
	    String FailDeviceNumber=waitAndGetElement(driver,By.xpath(".//*[@id='myList']/tbody/tr[6]/td[2]"),60).getText();
		if(debug)  System.out.println("begin to print the task  result");
	  System.out.println("allDeviceNumber           "+allDeviceNumber);
	  System.out.println("ActiveDeviceNumber        "+ActiveDeviceNumber);
	  System.out.println("PendingDeviceNumber       "+PendingDeviceNumber);
	  System.out.println("SuccessullDeviceNumber    "+SuccessullDeviceNumber);
	  System.out.println("FailDeviceNumber          "+FailDeviceNumber);
	  
	  
	    
	}
	
	public String getTeamScriptName(){
		switchtoTeamScriptsFrm();
		WebElement el = waitAndGetElement(driver,By.xpath(".//*[@id='myList']/tbody/tr[2]/td[1]"),60);
		String s = el.getText();
		return s;
	}
	
	public void rightClickOneTeamScript(String teamScriptName){
		switchtoTeamScriptsFrm();
        String s = teamScriptName;
		waitAndGetElement(driver,By.xpath("//td[contains(text(),'"+s+"')]"),60);
		waitAndRightClickElement(driver,By.xpath("//td[contains(text(),'"+s+"')]"),60); 
	}
	
		public void rightClickTargetElement() throws InterruptedException{
			switch_d_bottomframe();
	        waitAndRightClickElement(driver,By.className("itemNot"),50); 
		
		
	}
		/**
		 * 
		 * @throws InterruptedException
		 */
	
	public void checkDoubleclickmenu(String deviceName) throws InterruptedException{
		 Actions  action2 = new Actions(driver);
		 action2.doubleClick(driver.findElement(By.xpath("//td[text()='"+deviceName+"']"))).perform();
	      Thread.sleep(1000);
	   
	      int order = driver.getWindowHandles().size();
	      if(order==1){
	    	  if(debug) System.out.println("DoubleClick didn't initiate an inventory scan");
	    	  
	      }
		
		
	}
	
	/**
	 * Click the 'Refresh' button in task tool.</br> 
	 */
	
	public void clickFreshButtonforTasks(){
		switchTaskToolFrame();
		waitAndClickElement(driver,By.xpath(".//*[@id='span_refresh']"),60);
	}
	
	/**
	 * Check the task's status.</br> 
	 * Author Trudy
	 * @return
	 */
	public String getTaskStatus(){
		String TaskStatus = waitAndGetElement(driver,By.xpath(".//*[@id='myList']/tbody/tr[2]/td[3]"),60).getText();
		return TaskStatus;
	}
	public void clickNewDistributionPack(){
		switchPackageToolframe();
		//waitAndClickElement(driver,By.xpath("//table/tbody/tr/td[2]"),60);
		((JavascriptExecutor) driver).executeScript("javascript:parent.frames[1].NewPackage(true);");
		
	}
	
	
	public void clickMoveCopyButton(){
		switchtoMoveCopy();
		waitAndClickElement(driver,By.xpath(".//*[@id='_movetogroup']"),60);
	}
	
	public void clickStartNowElement(){
		switchTaskToolFrame();
		waitAndClickElement(driver,By.xpath(".//*[@id='_startNow']"),50);
	}
	
	public void ClickEditElement(){
		switchTaskToolFrame();
		waitAndClickElement(driver,By.xpath("//span[@id='span_edit' and text()='Edit']"),50);
	}
	
	public void doubleClickTask(String taskName){
		switchTaskList2Frame();
		//waitAndRightClickElement(driver,By.xpath("html/body/div[3]/table/tbody/tr[3]/td[1]"),50);
		Actions actionTask = new Actions(driver);
		actionTask.doubleClick(driver.findElement(By.xpath("//td[contains(text(),'"+taskName+"')]")));
		actionTask.perform();
	}
	
	public void clickMyTaskList1Element(){
		switchTaskList1Frame();
		waitAndClickElement(driver,By.xpath(".//*[@id='myList']/tbody/tr[2]/td[1]"),50);
	}
	
	public void clickMyTaskElement(){
		switchDeliveryMethodsTreeFrame();
		waitAndClickElement(driver,By.xpath(".//*[@id='group1']/span"),50);
	}
	
	public void clickPackgeElement(String packageName){
		switchPackageListFrame();
		waitAndClickElement(driver,By.xpath("//td[@itemname='"+packageName+"']"),50);
		switchPackageToolframe();
		
	}
	
	public void clickTeamPackageElement(){
		switchDistributionPackagesTreeframe();
		waitAndGetElement(driver,By.xpath("//span[contains(text(),'selenium')]"),50);
	    waitAndClickElement(driver,By.xpath("//span[contains(text(),'selenium')]"),50);
	    switchPackageToolframe();
	}
	

	
	public void clickDeliveryMethElement(){
		switchFooterTabsframe();
		waitAndClickElement(driver,By.xpath(".//*[@id='2tab']/a"),50);
		
	}
	
	public void clickDeliveryTaskElement(){
		switchFooterTabsframe();
		waitAndClickElement(driver,By.xpath("//table/tbody/tr[3]/td"),50);
	}
	
	public void clickTeamMethodsElement(){
		switchDeliveryMethodsTreeFrame();
		waitAndClickElement(driver,By.xpath(".//*[@id='img3']"),50);
		
	}
	
	/**
	 * Click 'Distribution tasks' to switch to Distribution tasks tab.</br> 
	 * Author Trudy
	 */
	public void clickDistributiontaskstab(){
		driver.switchTo().defaultContent();
		swithSWDtabs();
		waitAndClickElement(driver,By.xpath(".//*[@id='0tab']/a"),50);
	}
	public void clickPolicyMethElement(String teamName) {
		switchDeliveryMethodsTreeFrame(); 
		if(teamName.equals("'Selenium team' delivery method")) {
			clickTeamMethodsElement();
		}
		waitAndClickElement(driver,By.xpath("//table[@class=\"groupDiv1\"]/tbody/tr[3]/td/span"),50);
		switchDeliveryMethodsFrame();
	}
	
	public void clickPushMethElement(){
		switchDeliveryMethodsTreeFrame();
		waitAndClickElement(driver,By.xpath(".//*[@id='div3']/tbody/tr[2]/td"),50);
		//switchDeliveryMethodsFrame();
	}
	
	public void clickPolicyMethElement(){
		switchDeliveryMethodsTreeFrame();
		waitAndClickElement(driver,By.xpath("//table[@class=\"groupDiv1\"]/tbody/tr[3]/td/span"),50);
		
	
	}
	
	public void clickMulticastMethElement(){
		switchDeliveryMethodsTreeFrame();
		waitAndClickElement(driver,By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[6]/td/table/tbody/tr[4]/td/span/span"),50);
		switchDeliveryMethodsFrame();
	}
	
	/**
	 * Click 'Distribution' to expand the Distribution panel in left panel.</br> 
	 */
	public void clickDistribution(){
		switchLeftLeft();
		waitAndClickElement(driver,By.xpath("//td[@class='navHdrText' and text()='Distribution']"),50);
	}
	
	public void clickSciptsItem() throws InterruptedException{
		switchLeftLeft();
		waitAndClickElement(driver,By.xpath("//td[starts-with(@id,'aText')]/a[text()='Scripts']"),50);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		};
	}
	
	public void clickTeamSciptsItem() throws InterruptedException{
		switchtoTeamScripts();
		waitAndClickElement(driver,By.xpath(".//*[@id='group97']/span"),50);
	}
	
	public void clickScheduleMenu(){
		switchtoTeamScriptsFrm();
		waitAndClickElement(driver,By.xpath(".//*[@id='osd_menu_schedule']/a/span"),50);
	}

	
	public void clickTaskStartNow(){
		switchTaskTool2Frame();
		waitAndClickElement(driver,By.xpath("//a[@id='_startNow']"),50);
	}
	public void clickTaskElement(String taskName){
		switchTaskList2Frame();
		waitAndClickElement(driver,By.xpath("//td[contains(text(),'"+taskName+"')]"),50);
	}
	
	public void clickRefreshTask(){
		switchTaskTool2Frame();
		waitAndClickElement(driver,By.xpath("//a[@id='_refresh']"),50);
	}
	
	public void clickScheduledTask(){
		driver.switchTo().defaultContent();
		switchLeftLeft();
		waitAndClickElement(driver,By.xpath("//a[@class='btnText' and text()='Scheduled tasks']"),50);
	}
	
	/**
	 * Click the 'Distribution' button to show the Distribution page in right panel.</br> 
	 */
	public void clicKDistribution1(){
		driver.switchTo().defaultContent();
		switchLeftLeft();
		waitAndClickElement(driver,By.xpath("//a[@class='btnText' and text()='Distribution']"),50);
	}
	public void clickSubDistri() {
		driver.switchTo().defaultContent();
		switchLeftLeft();
		waitAndClickElement(driver,By.xpath(".//*[@id='aText1']/a"),50);
	}
	public int isContainScanmenu(){
		  int i=0;
		  List<WebElement> elementList=driver.findElements(By.xpath("//td[@style=\"background-image:url(img/menu_bg.gif)\"]"));
	      for(WebElement e:elementList){
	    	  if(e.getText().contains("Scan")){
	    		  i++;
	    		  if(debug) System.out.println("RightClick has initiated an inventory scan");
	    	  }
	    	  else{
	    		  if(debug) System.out.println("RightClick didn't initiated an inventory scan");
	    	  }
	      }
	      return i;
	  }
	
	public void clickOneDevice(String id){
		switchto_i_topframe();
		waitAndClickElement(driver,By.id(id),50);
	}
	
	
	public void rightClickOneDevice(String id){
		switchto_i_topframe();
		waitAndRightClickElement(driver,By.id(id),50);
	}
	
	
	/**
	 * @author JerryZhang
	 * @param name
	 */
	public void rightClickDeviceByName(String name){
		switchto_i_topframe();
		waitAndRightClickElement(driver,By.name(name),60);
	}
	
	/**
	 * @author JerryZhang
	 * @param packageName
	 */
	public void rightClickOnePackage(String packageName){
		switchPackageListFrame();
		waitAndRightClickElement(driver,By.cssSelector("td[itemname='"+packageName+"']"),60);
		if(debug) System.out.println(By.cssSelector("td[itemname='"+packageName+"']").toString());
	}
	
	public void ClickRightScanMenu(){
		waitAndClickElement(driver,By.xpath("//table[3]/tbody/tr/td/table/tbody/tr[5]/td/a"),50);
	}
	
	public void ClickRightTracertMenu(){
		waitAndClickElement(driver,By.xpath("//table[3]/tbody/tr/td/table/tbody/tr[4]/td/a"),50);
	}
	
	/**
	 * @author JerryZhang
	 */
	public void ClickRightScheduleMenu(){
		
		waitAndClickElement(driver,By.xpath(".//*[@id='menuPackage']/tbody/tr/td/table/tbody/tr[7]/td/a"),60);
		//waitAndClickElement(driver,By.xpath("//tr/td/a/span[@class='menuText' and text()='Schedule']"),60);
	}
	
	/**
	 *Right Click a device and select Ping in the Menu 
	 * @author HelenHan
	 */
	public void ClickRightPingMenu(){
		waitAndClickElement(driver,By.xpath("//table[3]/tbody/tr/td/table/tbody/tr[3]/td/a"),50);
	}
	public void ClickTargetMenu(){
		waitAndClickElement(driver,By.xpath("//table[3]/tbody/tr/td/table/tbody/tr[2]/td/a"),50);
	}
	
	/**
	 *Click the properties tab of the target client 
	 * @author HelenHan
	 */

	public void clickTargetProperties(){
		switch_TabsFrame();
		waitAndClickElement(driver,By.xpath(".//*[@id='1tab']/a"),50);
	}
	
	/**
	 *Click the button "Inventory info" under properties tab of the target client 
	 * @author HelenHan
	 */
	public void clickTargetViewInventory(){
		switch_FindFrmFrame();
		waitAndClickElement(driver,By.xpath(".//*[@id='_viewinventory2']"),50);
	}
	
	public void clickToolbarElement(){
		switchFindfrmFrame();
		waitAndClickElement(driver,By.xpath(".//*[@id='toolbar']/tbody/tr/td[5]/a"),50);
	}
	private List <WebElement> getColumElements(){

		List <WebElement> els = driver.findElements(By.className("tblHdrBtn"));
		return els;
	}
	public boolean getOrderIPAddress(){
		List <WebElement> els = getColumElements();
		int order = u.getOrderofName("IP Address",els);
		if (order == 3) return true;
		else return false;
		
	}
	/**
	 * @author JerryZhang
	 * @param taskDoneText
	 * @return
	 */
	public boolean waitTaskCompleted(final String taskDoneText){	
		
	     ExpectedCondition<Boolean> expectation = new
	    		 ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver) {
			   switchTaskToolFrame();
			   waitAndClickElement(driver,By.xpath(".//*[@id='_refresh']"),60);	
			   switchTaskList1Frame();
			   return   ExpectedConditions.textToBePresentInElement(By.xpath("//td[text()='59577_task']/following-sibling::td[2]"), taskDoneText).equals(false);
	        }
	      };

	     Wait<WebDriver> wait = new WebDriverWait(driver,180);
	     return wait.until(expectation);

//		
//		switchTaskList1Frame();
//		boolean waitResult=new WebDriverWait(driver,180).until(
//				ExpectedConditions.textToBePresentInElement(By.xpath("//*[@id='myList']/tbody/tr/td[text()='59577_task']/following-sibling::td[2]"), taskDoneText));
//		while(!waitResult){		
//		   switchTaskToolFrame();
//		   waitAndClickElement(driver,By.xpath(".//*[@id='_refresh']"),60);	
//		   switchTaskList1Frame();
//		   waitResult=new WebDriverWait(driver,5).until(
//					ExpectedConditions.textToBePresentInElement(By.xpath("//*[@id='myList']/tbody/tr/td[text()='59577_task']/following-sibling::td[2]"), taskDoneText));
//		} 
//		return waitResult;
	}
	/**
	 * check whether the SWD package is existing.
	 * @author JackCheng
	 * @param PackageName
	 * @return
	 * @throws InterruptedException
	 */
	
	public boolean isPackagePresent(String packageName) throws InterruptedException{
	    switchPackageListFrame(); 
		if(debug) System.out.println(packageName+" is present.");
		return isElementPresent(By.xpath("//td[@itemname='"+packageName+"']"));
			 
	}
	
	public void doubleClickDevice(String deviceName){
		WebElement myDevice=driver.findElement(By.name(deviceName));
		if(debug) System.out.println(myDevice.getText());
		Actions action=new Actions(driver);
		action.doubleClick(myDevice).perform();	}
	
	/**
	 * Judge the distribution method with special name exists or not
	 * Author JerryZhang
	 * @param methType Distribution method type
	 * @param methodName Distribution method name
	 * @return
	 */
	public boolean isMethodPresent(String methType,String methodName){
		switchDeliveryMethodsTreeFrame();
		waitAndClickElement(driver,By.xpath("//span[contains(text(),'All delivery methods')]"),60);
		waitAndClickElement(driver,By.id("img4"),60);
		selectMethType(methType);	
		switchDeliveryMethodslist();
		if (debug) System.out.println("//*[@id='myList']/tbody/tr/td[contains(text(),'"+methodName+"')]");
		return isElementPresent(By.xpath("//*[@id='myList']/tbody/tr/td[contains(text(),'"+methodName+"')]"));
	}
	
}


