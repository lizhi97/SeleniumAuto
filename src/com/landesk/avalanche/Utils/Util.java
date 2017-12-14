package com.landesk.avalanche.Utils;

import org.testng.AssertJUnit;



public class Util {

	public static void validateWarningMessage(String actual,String expected){
		
		AssertJUnit.assertEquals("Warning Message" + ": is not exist on the page", expected, actual);
	}
	
	public void validatecheckBoxStatus(boolean flag){
		if(flag == false){
			AssertJUnit.fail("enable checkbox is not been checked");
		}
	}
	public void validateInputText(boolean flag){
		if(flag == false){
			AssertJUnit.fail("profile can not been edit");
		}
	}
	public void validateDelete(boolean flag){
		if(flag == false){
			AssertJUnit.fail("delete profile failed");
			
		} 
	}
	
}
