package com.landesk.ldms.webconsole.PageObjectsForIE;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import com.landesk.PageBaseForIE;
import com.landesk.ldms.Utils.util;

public class DistributionPackagePageObject extends PageBaseForIE{
	private util u = new util();
	
	public DistributionPackagePageObject(WebDriver d) {
		super(d);
		this.driver = d;
	}
	/**
	 * New Package Window
	 * @author Winsy
	 */

	public void NewPackageWindow(){
		//waitAndClickElement(driver,By.id(".//*[@id='_newPackage']"),50);
		//waitAndGetElement(driver,By.xpath("//table/tbody/tr/td[2]"),60);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		//waitAndGetElement(driver,By.xpath("//table/tbody/tr/td[2]"),60);
		((JavascriptExecutor) driver).executeScript("javascript:parent.frames[1].NewPackage(true);");
		//switchPackageToolframe();
	//	waitAndClickElement(driver,By.xpath("//table/tbody/tr/td[2]"),60);
		//System.out.println("execute java script,click New package");
	    String newhandle= u.switchWindow(driver);
	    driver.switchTo().window(newhandle);
	    this.setDriver(driver);
	    //System.out.println("New Package Window"+ driver.getTitle());
	}
	public void OpenPackageWindow(){

	    String newhandle= u.switchWindow(driver);
	    driver.switchTo().window(newhandle);
	    this.setDriver(driver);
	   // System.out.println("New Package Window"+ driver.getTitle());
	}
	
	
	/**
	 * input package name
	 * @author Winsy
	 * @param name
	 */
	
	public void inputText(String name){
		waitAndGetElement(driver,By.xpath(".//*[@id='_packageNameTextBox']"),60).clear();
		waitAndGetElement(driver,By.xpath(".//*[@id='_packageNameTextBox']"),60).sendKeys(name);
	}
	/**
	 * input primary file path
	 * @author Winsy
	 * @param file
	 */
	public void inputPrimaryFile(String file){
		waitAndGetElement(driver,By.id("_primaryFileTextBox"),60).clear();
		waitAndGetElement(driver,By.id("_primaryFileTextBox"),60).sendKeys(file);
	}
	/**
	 * input Description
	 * @author Winsy
	 * @param d
	 */
	public void inputDescription(String d){
		waitAndGetElement(driver,By.id("_descriptionTextBox"),60).clear();
		waitAndGetElement(driver,By.id("_descriptionTextBox"),60).sendKeys(d);
	}
	
	public void ClickAccoutPage(){
		waitAndClickElement(driver,By.id("accounts_navLink"),60);
		waitAndClickElement(driver,By.id("_radioButtonCurrentUser"),60);

	}
	
	public void clickOk(){
		waitAndClickElement(driver,By.id("_saveButton"),50);
	}
	
	public void selectPackage(String name){
		new Select(driver.findElement(By.id("DropDownListPkgType"))).selectByVisibleText(name);
	    //driver.findElement(By.cssSelector("option[value=\""+id+"\"]")).click();	
	}
	
	
}
