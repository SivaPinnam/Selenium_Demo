package com.pathway.selenium.factory;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.pathway.util.SFLoginUtil;

public class SeleniumIEFactory implements SeleniumFactory {

	//@Override
	public WebDriver getWebDriver() {

		try {
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") +"//Driver//IEDriverServer.exe");
			DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
            cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
            cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			WebDriver driver = new InternetExplorerDriver(cap);
			return driver;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(-999);
		}
		return null;
	}

	//@Override
	public WebDriver getRemoteWebDriver() {
		try {
			   System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") +"//Driver//IEDriverServer.exe");
				DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
				cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				WebDriver driver = new RemoteWebDriver(new URL(SFLoginUtil.getSeleniumURL()), cap);
				return driver;
			}catch(Exception ex){
				ex.printStackTrace();
				System.exit(-999);
			}
		return null;
	}

		
}
