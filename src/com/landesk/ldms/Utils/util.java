package com.landesk.ldms.Utils;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//This is a utilize class to use by other class.
public class util {
	public int getOrderofName(String name, List <WebElement> els){
		 int i = 0;
		 for (WebElement el : els ) {
			 i++;
			 if(el.getText().equals(name)) return i;
		 }
		 return -1;
		 	 	 
	 }
	 
	  
	public String switchWindow(WebDriver driver){
	    String currentHandle = driver.getWindowHandle();
	    Set <String> handles = driver.getWindowHandles();
	   // System.out.println("size"+handles.size());
	    for (String s : handles) {
	          if (!s.equals(currentHandle)){
	        	  //System.out.println("handle"+s);
	                 return s;
	                 //System.out.println("handle"+s);
	           	}
	           
	    	}
	    return "Window handler failed to get";
	}
	public String randomStringGenerator(){
        return  RandomStringUtils.randomAlphabetic(8);
    }
	 public boolean isElementPresent(WebDriver driver, By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }

     public boolean isAlertPresent(WebDriver driver) {
		    try {
		      Alert alert = driver.switchTo().alert();
		      alert.accept();
		      return true;
		    } catch (NoAlertPresentException e) {
		      return false;
		    }
		  }
     public String closeAlertAndGetItsText(WebDriver driver) {
    	boolean acceptNextAlert = true;
 	    try {
 	      Alert alert = driver.switchTo().alert();
 	      String alertText = alert.getText();
 	      if (acceptNextAlert) {
 	        alert.accept();
 	      } else {
 	        alert.dismiss();
 	      }
 	      return alertText;
 	    } finally {
 	      acceptNextAlert = true;
 	    }
 	  }
   
}
