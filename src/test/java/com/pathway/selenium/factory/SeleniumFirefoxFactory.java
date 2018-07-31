package com.pathway.selenium.factory;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.pathway.util.SFLoginUtil;

public class SeleniumFirefoxFactory implements SeleniumFactory {

	//@Override
	public WebDriver getWebDriver() {

		try {
			WebDriver driver = new FirefoxDriver();
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
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setBrowserName("firefox");
			WebDriver driver = new RemoteWebDriver(new URL(SFLoginUtil.getSeleniumURL()), capabilities);
			return driver;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(-999);
		}
		return null;
	}

}
