package com.landesk.ldms.webconsole.PageObjectsForIE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import com.landesk.PageBaseForIE;
import com.landesk.ldms.Utils.util;

public class DeliveryMethodsPageObject extends PageBaseForIE{
	private util u = new util();
	public DeliveryMethodsPageObject(WebDriver d){
			super(d);
			this.driver = d;
	}
	
	/**
	 * new Delivery Methods Window
	 * @author Winsy
	 * @throws InterruptedException 
	 */
	public void newDeliveryMethWindow() throws InterruptedException{
		Thread.sleep(2000);
		switchDeliveryMethodsFrame();
		waitAndClickElement(driver,By.xpath("//td/a[@title='New']"),50);
		//((JavascriptExecutor) driver).executeScript("javascript:parent.frames[1].NewDeliveryMethod(true);");
		if (debug) System.out.println("execute java script, click New Delivery Methods");//execute java  
		String newhandle= u.switchWindow(driver);
		driver.switchTo().window(newhandle);//switch new window
		this.setDriver(driver);
		if (debug) System.out.println("New Method window:"+driver.getTitle());
		
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
	
	/**
	 * select Owner-Admin
	 * @author Winsy
	 * @param name
	 */
	public void selectOwner(String name){
		new Select(driver.findElement(By.id("_userDropDownList"))).selectByVisibleText(name);
	}
	
	public void selectTypeandfrequencypolicy(){
		waitAndClickElement(driver,By.id("_jobTypeHyperlink"),50);
		waitAndClickElement(driver,By.id("_jobTypeRadiobuttonlist_1"),50);
		
	}
	
	
	/**
	 * Display progress to user
	 * @author Winsy
	 * @param id
	 * @param name
	 */
	public void selectUI(String name){
		new Select(driver.findElement(By.id("_packageProgressDropDown"))).selectByVisibleText(name);
	    //driver.findElement(By.cssSelector("option[value=\""+id+"\"]")).click();
	}
	//public void selectOwnerAndUI(By by,int id,String name){
		//new Select(driver.findElement(by)).selectByVisibleText(name);
	    //driver.findElement(By.cssSelector("option[value=\""+id+"\"]")).click();	
	//}
	/**
	 * click FeeBack And Timing Element
	 * @author winsy
	 */
	public void clickFeeBackAndTimingElement(){
		waitAndClickElement(driver,By.id("_feedbackHyperlink"),50);
		//driver.findElement(By.id("_feedbackHyperlink")).click();
	}
	/**
	 * input Method Name
	 * @author Winsy
	 * @param name
	 */
	public void inputMethodName(String name){
		waitAndGetElement(driver,By.id("_deliveryMethodNameTextbox"),60).clear();
		//driver.findElement(By.id("_deliveryMethodNameTextbox")).clear();
		waitAndGetElement(driver,By.id("_deliveryMethodNameTextbox"),60).sendKeys(name);
	    //driver.findElement(By.id("_deliveryMethodNameTextbox")).sendKeys(name);
	}
	/**
	 * save method
	 * @author Winsy
	 */
	public void clickOkMethodsElement(){
		waitAndClickElement(driver,By.id("_saveButton"),50);
		//driver.findElement(By.id("_saveButton")).click();
	}
}
