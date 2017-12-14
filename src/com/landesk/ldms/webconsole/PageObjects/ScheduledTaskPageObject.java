package com.landesk.ldms.webconsole.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.landesk.PageBase;
import com.landesk.ldms.Utils.util;

public class ScheduledTaskPageObject extends PageBase{
	private util u;
	public ScheduledTaskPageObject(WebDriver d){		
		super(d); 
		this.driver = d;
		u = new util();;
		
	}
	
	public void clickAddQuerybutton(){
		waitAndClickElement(driver,By.xpath(".//*[@id='_addQueryButton']"),50);
	}
	
	
	
	public void selectQueryName(String queryName){
		
		new Select(waitAndGetElement(driver,By.xpath(".//*[@id='_addQueryDropdownlist']"),50)).selectByVisibleText(queryName);
	}
	
	public void selectMethod(String methName){
		
		new Select(waitAndGetElement(driver,By.name("_deliveryMethodDropDownList"),50)).selectByVisibleText(methName);
	}
	
	public void selectPolicyMethodType(){
		
		new Select(waitAndGetElement(driver,By.name("_deliveryMethodsTypeDropDownList"),50)).selectByVisibleText("Policy");
		
	}
	
	public void selectTeamOwner(){
		
		new Select(waitAndGetElement(driver,By.xpath("//select[@name=\"owner_dropdownlist\"]"),50)).selectByVisibleText("selenium team");
	
	}
	
	public void ScheduledTaskWindowNew(){
		if(debug) System.out.println("swithto Scheduled task window");
		String newhandle= u.switchWindow(driver);
		driver.switchTo().window(newhandle);//switch new window
		this.setDriver(driver);
		if(debug) System.out.println("Scheduled Task window:"+driver.getTitle());
		
	}
	
	public void ScheduledTaskWindow() throws InterruptedException{
		
		//waitAndGetElement(driver,By.xpath("//span[contains(text(),'Schedule')]"),50);
		//waitAndClickElement(driver,By.xpath("//span[contains(text(),'Schedule')]"),50);
		Thread.sleep(2000);
		
		((JavascriptExecutor) driver).executeScript("javascript:parent.frames[1].OpenNewScheduledTask(true);");
		if (debug) System.out.println("execute java script, click Scheduled Task");//execute java  
		String newhandle= u.switchWindow(driver);
		driver.switchTo().window(newhandle);//switch new window
		this.setDriver(driver);
		if (debug) System.out.println("Scheduled Task window:"+driver.getTitle());
	}
	
	public void OpenScheduledTaskWindow(){
		String newhandle= u.switchWindow(driver);
		driver.switchTo().window(newhandle);//switch new window
		this.setDriver(driver);
		if (debug) System.out.println("Scheduled Task window:"+driver.getTitle());
	}
	
	
	public void EditTaskwindow(){
		if(true) System.out.println("Redit the existing Task");//execute java  
		String newhandle= u.switchWindow(driver);
		driver.switchTo().window(newhandle);//switch new window
		this.setDriver(driver);
		if(true) System.out.println("the existing Task windo"+driver.getTitle());
	}
	
	public void selectTargetGroup(String Name){
		new Select(driver.findElement(By.id("_addGroupDropdownlist"))).selectByVisibleText(Name);
	    //driver.findElement(By.id("deliveryMethods_navLink")).click();
	}
	public void selectOwnerAdmin(){
		new Select(driver.findElement(By.id("owner_dropdownlist"))).selectByVisibleText("W2K8R2-SEL\\Administrator");
	    //driver.findElement(By.id("deliveryMethods_navLink")).click();
	}
	
	public void selectOwner(String ownerName){
		new Select(driver.findElement(By.id("owner_dropdownlist"))).selectByVisibleText(ownerName);
	    //driver.findElement(By.id("deliveryMethods_navLink")).click();
	}
	public void clickDeliveryMethodElement(){
		waitAndClickElement(driver,By.id("deliveryMethods_navLink"),50);
	}
	public void selectMethodType(String name,String d){
		new Select(driver.findElement(By.id("_deliveryMethodsTypeDropDownList"))).selectByVisibleText(name);
	    driver.findElement(By.cssSelector("#_deliveryMethodsTypeDropDownList > option[value=\""+d+"\"]")).click();
	}
	public void selectMethod(String name,String d){
    new Select(driver.findElement(By.id("_deliveryMethodDropDownList"))).selectByVisibleText(name);
    driver.findElement(By.cssSelector("#_deliveryMethodDropDownList > option[value=\""+d+"\"]")).click();
	}
	
    public void clickTargetDriver(){
    	waitAndClickElement(driver,By.id("targets_navLink"),50);
    }
    
    
    public void deleteTargerDriver(String queryName){
    	waitAndClickElement(driver,By.xpath("//td[contains(text(),'"+queryName+"')]"),50);
    	waitAndClickElement(driver,By.id("_removeButton"),50);
    	
    }
    
    
    
    /**
     * @author YHan
     */
    public void selectTargetedDevice(){
    	waitAndClickElement(driver,By.xpath(".//*[@id='targets_mainDiv']/table/tbody/tr[6]/td/div/table[1]/tbody/tr[2]/td/table/tbody/tr/td"),50);
    }
    
    /**
     * @author YHan
     */
    public void deleteTargetedDevice(){
    	waitAndClickElement(driver,By.xpath(".//*[@id='_removeButton']"),50);
    }
 
    
    public void clickSchedleTask(){
    	waitAndClickElement(driver,By.id("setSchedule_navLink"),50);
    	 	
    }
    
    public void ClickStartNowOption(){
    	
      	waitAndClickElement(driver,By.xpath("//input[@id='rSched1']"),50);
    	
    }
    
    public void SelectAllDevice(){
    
    	new Select(waitAndGetElement(driver,By.name("_scheduleComputersTypeDropDownList"),50)).selectByVisibleText("All");
    	
    	
    }
    
    public void clickAddGroup(){
    	waitAndGetElement(driver,By.id("_addGroupButton"),50);
    	waitAndClickElement(driver,By.id("_addGroupButton"),50);
    }
    
    public void clickAddTargetList(){
    	waitAndGetElement(driver,By.id("_addTargetKartButton"),50);
    	waitAndClickElement(driver,By.id("_addTargetKartButton"),50);
    }
    
    public void inputTaskName(String name){
		waitAndGetElement(driver,By.xpath(".//*[@id='_scheduledTaskNameTextBox']"),60).clear();
		waitAndGetElement(driver,By.xpath(".//*[@id='_scheduledTaskNameTextBox']"),60).sendKeys(name);
	}
    public void clickOkTask(){
    	waitAndClickElement(driver,By.id("_okButton"),50);
    }
}
