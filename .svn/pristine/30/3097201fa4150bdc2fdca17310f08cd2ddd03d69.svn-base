package com.landesk.avalanche.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.landesk.PageBase;


public class LoginPageObject extends PageBase{
	    
	
		public LoginPageObject(WebDriver driver){
			super(driver); 
			this.driver = driver;

		}
	    
	 	public void inputUsername(String username){
			waitAndGetElement(driver,By.id("loginField"),50).sendKeys(username);
		}
		public void inputPassword(String password){
			waitAndGetElement(driver,By.id("passwordField"),50).sendKeys(password);
		}
		public void clickLoginButton(){
			waitAndClickElement(driver,By.id("loginTableButton"),50); 
		}
}	
