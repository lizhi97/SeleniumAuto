package com.landesk.ldms.webconsole.PageObjectsForIE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import com.landesk.PageBaseForIE;

public class SelectQueryCondition extends PageBaseForIE {
	
	public SelectQueryCondition(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void selectDeviceName() throws Exception{
		
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver, "tree" , 50);
		waitAndClickElement(driver, By.xpath(".//*[@id='9item']"), 50);
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver, "config" , 50);
		waitAndSwitchToFrame(driver, "dialog" , 50);
		new Select(driver.findElement(By.id("_val"))).selectByIndex(4);
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("boolOp"))).selectByIndex(1);
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		waitAndSwitchToFrame(driver, "config" , 50);
		waitAndSwitchToFrame(driver, "selected" , 50);
		waitAndClickElement(driver, By.xpath(".//*[@id='btnAdd']"), 50);
		waitAndClickElement(driver, By.xpath(".//*[@id='selData']/table/tbody/tr[3]/td/input[1]"), 50);
		
	}
}
