package com.landesk.selendroid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidDriver;
import io.selendroid.device.DeviceTargetPlatform;

public class SelendroidTest {
	@Test
	public void test() throws Exception{
		//SelendroidCapabilities capa = new SelendroidCapabilities("io.selendroid.testapp:0.9.0");
		SelendroidCapabilities capa = new SelendroidCapabilities("com.Landesk.BridgeIT:1.0.1");
		capa.setPlatformVersion(DeviceTargetPlatform.ANDROID17);
		capa.setEmulator(true);
		WebDriver driver = new SelendroidDriver(capa);
		driver.switchTo().window("WEBVIEW");
		
		WebElement inputEmail = driver.findElement(By.id("email"));
		inputEmail.sendKeys("jack@qa.com");
		
		WebElement inputPw = driver.findElement(By.id("password"));
		inputPw.sendKeys("Landesk@1");
		
		WebElement SavePw = driver.findElement(By.xpath(".//*[@id='savePassword']/input"));
		SavePw.click();
		
        driver.findElement(By.id("showAdvancedOptions")).click();
		
        driver.findElement(By.id("server")).sendKeys("http://172.29.110.198/serviceDesk.selfService2");	 
		
        driver.findElement(By.id("domainName")).sendKeys("jackwin2012R2\\administrator");	
        driver.findElement(By.id("logon")).click();
         
         
		//WebElement inputField = driver.findElement(By.id("my_text_field"));
		//Assert.assertEquals("true", inputField.getAttribute("enabled"));
		//inputField.sendKeys("Selendroid");
		//Assert.assertEquals("Selendroid", inputField.getText());
		//driver.quit();
	}
}
