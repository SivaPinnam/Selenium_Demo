package com.pathway.selenium.factory;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.pathway.util.SFLoginUtil;

public class SeleniumChromeFactory implements SeleniumFactory {

//	@Override
	public WebDriver getWebDriver() {

		try {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"//driver//chromedriver-win.exe");
			WebDriver driver = new ChromeDriver();
			return driver;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(-999);
		}
		return null;
	}
	
	//@Override
	public WebDriver getRemoteWebDriver() {

		try{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"//driver//chromedriver.exe");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			WebDriver driver = new RemoteWebDriver(new URL(SFLoginUtil.getSeleniumURL()), cap);
			//WebDriver driver = new FirefoxDriver();
			return driver;
		}catch(Exception ex){
			ex.printStackTrace();
			System.exit(-999);
		}
		return null;
	}

}
