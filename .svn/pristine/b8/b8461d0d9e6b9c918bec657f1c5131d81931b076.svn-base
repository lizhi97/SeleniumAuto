package com.landesk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

    public static WebDriver buildDriver(DriverType type) {

        WebDriver webDriver;
        String currentDir = System.getProperty("user.dir");

        switch (type) {
            case Firefox:
                webDriver = new FirefoxDriver();
                break;
            case IE:
            	DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            	System.setProperty(
            			"webdriver.ie.driver", 
            			currentDir + "\\LoginExe\\IEDriverServerx64.exe");
                webDriver = new InternetExplorerDriver(capabilities);
                break;
            case Chrome:
                webDriver = new ChromeDriver();
                break;
            default:
                webDriver = new ChromeDriver();
        }

        return webDriver;
    }

}
