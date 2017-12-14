package com.landesk;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;


/**
 * Page Object base class.  It provides the base structure 
 * and properties for a page object to extend.  
 * 
 * @author Joe Li
 */
public class PageBase {
	/** Default URL */
	protected String URL;	

	/** This page's WebDriver */ 
	protected WebDriver driver; 
	
	protected boolean debug= false;


	/** Expected Page Title.  This will be used in isPageLoad() 
	 * to check if page is loaded. */
	protected String pageTitle; 




	public PageBase(WebDriver driver, String pageTitle) {
		this.driver = driver; 
		this.pageTitle = pageTitle; 
	}
	
	public PageBase(WebDriver driver){
		this.driver = driver;
		//waitForPageLoaded(driver);
	}
	
	/** Constructor */
	public PageBase(){
	
	}
	
	 public void waitForPageLoaded(WebDriver driver) {

	     ExpectedCondition<Boolean> expectation = new
	    		 ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver) {
	          return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	        }
	      };

	     Wait<WebDriver> wait = new WebDriverWait(driver,60);
	      try {
	              wait.until(expectation);
	      } catch(Throwable error) {
	              //assertFalse("Timeout waiting for Page Load Request to complete.",true);
	    	  System.out.println("Timeout waiting for Page Load Request to complete.");
	      		}
	      }
	 
	
	/**
	 *  Switch Window to original driver by handle
	 *  
	 *  @param WindowHandle This is a handle that need to switch to handle.
	 *  
	*/
	public void setDriverByHandle(String WindowHandle){
		driver.switchTo().window(WindowHandle);
		waitForPageLoaded(driver);
	}
	
	public void setDriver(WebDriver driver){
		this.driver = driver;
		waitForPageLoaded(driver);
	}
	/** 
	 * Check if page is loaded by comparing 
	 * the expected page-title with an actual page-title. 
	 */ 
	public boolean isPageLoad(){
		return (driver.getTitle().contains(pageTitle)); 
	}

	/** Open the default page */ 
	public void open(){
		driver.get(URL); 
	}
	
	/** Close the default page */ 
	public void close(){
		driver.close();
	}

	/** Returns the page title */ 
	public String getTitle() {
		return pageTitle; 
	}

	/** Returns the default URL */ 
	public String getURL() {
		return URL;
	}

	/** 
	 * Send text keys to the element that finds by cssSelector.  
	 * It shortens "driver.findElement(By.cssSelector()).sendKeys()". 
	 * @param cssSelector
	 * @param text
	 */
	protected void sendText(String cssSelector, String text) {
		driver.findElement(By.cssSelector(cssSelector)).sendKeys(text);
	}

	/** Is the text present in page. */ 
	public boolean isTextPresent(String text){
		return driver.getPageSource().contains(text); 
	}

	/** Is the Element in page. */
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);//if it does not find the element throw NoSuchElementException, thus returns false. 
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/** 
	 * Is the Element present in the DOM. 
	 * 
	 * @param _cssSelector 		element locater
	 * @return					WebElement
	 */
	public boolean isElementPresent(String _cssSelector){
		try {
			driver.findElement(By.cssSelector(_cssSelector));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Checks if the element is in the DOM and displayed. 
	 * 
	 * @param by - selector to find the element
	 * @return true or false
	 */
	public boolean isElementPresentAndDisplay(By by) {
		try {			
			return driver.findElement(by).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/** 
	 * Returns the first WebElement using the given method.  	   
	 * It shortens "driver.findElement(By)". 
	 * @param by 		element locater. 
	 * @return 		the first WebElement
	 */
	public WebElement getWebElement(By by){
		return driver.findElement(by); 			
	}
	
	/**
	 * waiting for the element to be Clickable and click it.
	 * @param driver this is WebDriver.
	 * @param by    locator for example By.id("btnClose"),By.xpath("//input[@id='btnStartScan']")
	 * @param secs  timeout seconds.
	 */
	protected void waitAndClickElement(WebDriver driver, By by,int secs) {
		
		new WebDriverWait(driver,secs).until(
				ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
		highlightElement(driver.findElement(by));
	}
	public void highlightElement(WebElement element) {
		for (int i = 0; i <2; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: yellow; border: 2px solid yellow;");
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		}
	}
	protected List<WebElement> waitAndGetElements(WebDriver driver,By by,int secs) {
		new WebDriverWait(driver,secs).until(
				ExpectedConditions.elementToBeClickable(by));
		return driver.findElements(by);
	}
	/**
	 * 
	 * @param driver
	 * @param by
	 * @param secs
	 * @return
	 */
	protected WebElement waitAndGetElement(WebDriver driver, By by,int secs) {
		new WebDriverWait(driver,secs).until(
				ExpectedConditions.presenceOfElementLocated(by));
		highlightElement(driver.findElement(by));
		return driver.findElement(by);
		
	}

	
	/**
	 * 
	 * @param driver
	 * @param by
	 * @param secs
	 */
	protected void waitAndRightClickElement(WebDriver driver, By by,int secs){
		new WebDriverWait(driver,secs).until(
				ExpectedConditions.presenceOfElementLocated(by));
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(by));
	    action.perform();	
	}
	/**
	 * 
	 * @param driver
	 * @param frameName
	 * @param sec
	 */
	protected void waitAndSwitchToFrame(WebDriver driver, String frameName, int sec){
		new WebDriverWait(driver,sec).until(
				ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
			}
/**
 * Take a screenshot and save it into a directory	
 * @param fileMeaning File meaning which will be a part of the saved file name.
 * @param destDirectory Destination directory to save the screenshot file.
 */
	public void takeScreenshotAndSave(String fileMeaning,String destDirectory){

		SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd-HHmmss");
		String time=sdf.format(new Date());
		File screenshotRealtime=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
		try{
			if (destDirectory.trim().length()==0){
				FileUtils.copyFile(screenshotRealtime, new File(fileMeaning+time+".png"));				
			}
			else{ 
				if (!(new File(destDirectory).isDirectory())){
				new File(destDirectory).mkdir();	
				}			
			FileUtils.copyFile(screenshotRealtime, new File(destDirectory+File.separator+fileMeaning+time+".png"));
			}
								
		} catch(IOException e){
			e.printStackTrace();
		}
		
	}
}



