package com.pathway.util;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.pathway.scripts.ScriptRunner;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

import cucumber.runtime.CucumberException;
import cucumber.runtime.io.URLOutputStream;
import gherkin.formatter.Formatter;
import gherkin.formatter.Reporter;
import gherkin.formatter.model.Background;
import gherkin.formatter.model.Examples;
import gherkin.formatter.model.Feature;
import gherkin.formatter.model.Match;
import gherkin.formatter.model.Result;
import gherkin.formatter.model.Scenario;
import gherkin.formatter.model.ScenarioOutline;
import gherkin.formatter.model.Step;
import gherkin.formatter.model.Tag;

public class ExtentCucumberFormatter implements Reporter, Formatter {
	private static ExtentReports extent;
	private ExtentTest featureTest;
	private ExtentTest scenarioTest;
	private LinkedList<Step> testSteps = new LinkedList();
	private static File htmlReportDir;
	private static Map systemInfo;
	private boolean scenarioOutlineTest;
	private static final Map<String, String> MIME_TYPES_EXTENSIONS = new HashMap() {
	};
	private static WebDriver webDriver;
	
	public void setWebDriver(WebDriver webDriver){
		this.webDriver = webDriver;
	}
	public ExtentCucumberFormatter(File filePath) {
		if (!(filePath.getPath().equals(""))) {
			String reportPath = filePath.getPath();
			htmlReportDir = new File(reportPath);
			extent = new ExtentReports(reportPath);
		} else {
			String reportDir = "output/Run_" + System.currentTimeMillis();
			htmlReportDir = new File(reportDir);
			extent = new ExtentReports(reportDir + "/report.html");
		}
	}

	public ExtentCucumberFormatter() {
	}

	public static void initiateExtentCucumberFormatter(File filePath, Boolean replaceExisting,
			DisplayOrder displayOrder, NetworkMode networkMode, Locale locale) {
		htmlReportDir = filePath;
		extent = new ExtentReports(filePath.getAbsolutePath(), replaceExisting, displayOrder, networkMode, locale);
	}

	public static void initiateExtentCucumberFormatter(File filePath, Boolean replaceExisting,
			DisplayOrder displayOrder, NetworkMode networkMode) {
		initiateExtentCucumberFormatter(filePath, replaceExisting, displayOrder, networkMode, null);
	}

	public static void initiateExtentCucumberFormatter(File filePath, Boolean replaceExisting,
			DisplayOrder displayOrder, Locale locale) {
		initiateExtentCucumberFormatter(filePath, replaceExisting, displayOrder, null, locale);
	}

	public static void initiateExtentCucumberFormatter(File filePath, Boolean replaceExisting,
			DisplayOrder displayOrder) {
		initiateExtentCucumberFormatter(filePath, replaceExisting, displayOrder, null, null);
	}

	public static void initiateExtentCucumberFormatter(File filePath, Boolean replaceExisting, NetworkMode networkMode,
			Locale locale) {
		initiateExtentCucumberFormatter(filePath, replaceExisting, null, networkMode, locale);
	}

	public static void initiateExtentCucumberFormatter(File filePath, Boolean replaceExisting,
			NetworkMode networkMode) {
		initiateExtentCucumberFormatter(filePath, replaceExisting, null, networkMode, null);
	}

	public static void initiateExtentCucumberFormatter(File filePath, NetworkMode networkMode) {
		initiateExtentCucumberFormatter(filePath, null, null, networkMode, null);
	}

	public static void initiateExtentCucumberFormatter(File filePath, Boolean replaceExisting, Locale locale) {
		initiateExtentCucumberFormatter(filePath, replaceExisting, null, null, locale);
	}

	public static void initiateExtentCucumberFormatter(File filePath, Boolean replaceExisting) {
		initiateExtentCucumberFormatter(filePath, replaceExisting, null, null, null);
	}

	public static void initiateExtentCucumberFormatter(File filePath, Locale locale) {
		initiateExtentCucumberFormatter(filePath, null, null, null, locale);
	}

	public static void initiateExtentCucumberFormatter(File filePath) {
		initiateExtentCucumberFormatter(filePath, null, null, null, null);
	}

	public static void initiateExtentCucumberFormatter() {
		String reportFilePath = "output" + File.separator + "Run_" + System.currentTimeMillis() + File.separator
				+ "report.html";

		initiateExtentCucumberFormatter(new File(reportFilePath));
	}

	public static void setTestRunnerOutput(String s) {
		extent.setTestRunnerOutput(s);
	}

	public static void loadConfig(File configFile) {
		extent.loadConfig(configFile);
	}

	public static void addSystemInfo(String param, String value) {
		if (systemInfo == null) {
			systemInfo = new HashMap();
		}
		systemInfo.put(param, value);
	}

	public static void addSystemInfo(Map<String, String> info) {
		if (systemInfo == null) {
			systemInfo = new HashMap();
		}
		systemInfo.putAll(info);
	}

	public void before(Match match, Result result) {
	}

	public void result(Result result) {
		if (!(this.scenarioOutlineTest)) {
			Step step = (Step) this.testSteps.poll();
			if ("passed".equals(result.getStatus()))
				this.scenarioTest.log(LogStatus.PASS, step.getKeyword() + step.getName(), "PASSED");
			else if ("failed".equals(result.getStatus())){
				if(webDriver != null){
					try{
						TakesScreenshot ts = (TakesScreenshot) webDriver;
						File source = ts.getScreenshotAs(OutputType.FILE);
						String fileName = "screenshot-" + System.currentTimeMillis() +".png";
						String dest = ScriptRunner.reportFolderPath+"//" +  fileName;
						File destination = new File(dest);
						FileUtils.copyFile(source, destination);
						this.scenarioTest.log(LogStatus.FAIL, step.getKeyword() + step.getName(),this.scenarioTest.addScreenCapture(fileName));
					}catch(Exception ex){}
				}
			}
			else if ("skipped".equals(result.getStatus()))
				this.scenarioTest.log(LogStatus.SKIP, step.getKeyword() + step.getName(), "SKIPPED");
			else if ("undefined".equals(result.getStatus()))
				this.scenarioTest.log(LogStatus.UNKNOWN, step.getKeyword() + step.getName(), "UNDEFINED");
		}
	}

	public void after(Match match, Result result) {
	}

	public void match(Match match) {
	}

	public void embedding(String s, byte[] bytes) {
		if (!(this.scenarioOutlineTest)) {
			String extension = (String) MIME_TYPES_EXTENSIONS.get(s);
			String fileName = "screenshot-" + System.currentTimeMillis() + "." + extension;
			writeBytesAndClose(bytes, reportFileOutputStream(fileName));
			this.scenarioTest.log(LogStatus.INFO, this.scenarioTest.addScreenCapture(fileName));
		}
	}

	public void write(String s) {
		if (!(this.scenarioOutlineTest))
			this.scenarioTest.log(LogStatus.INFO, s);
	}

	public void syntaxError(String s, String s1, List<String> list, String s2, Integer integer) {
	}

	public void uri(String s) {
	}

	public void feature(Feature feature) {
		this.featureTest = extent.startTest("Feature: " + feature.getName());

		for (Tag tag : feature.getTags())
			this.featureTest.assignCategory(new String[] { tag.getName() });
	}

	public void scenarioOutline(ScenarioOutline scenarioOutline) {
		this.scenarioOutlineTest = true;
	}

	public void examples(Examples examples) {
	}

	public void startOfScenarioLifeCycle(Scenario scenario) {
		this.scenarioTest = extent.startTest("Scenario: " + scenario.getName());

		for (Tag tag : scenario.getTags()) {
			this.scenarioTest.assignCategory(new String[] { tag.getName() });
		}
		this.scenarioOutlineTest = false;
	}

	public void background(Background background) {
	}

	public void scenario(Scenario scenario) {
	}

	public void step(Step step) {
		if (!(this.scenarioOutlineTest))
			this.testSteps.add(step);
	}

	public void endOfScenarioLifeCycle(Scenario scenario) {
		if (!(this.scenarioOutlineTest)) {
			extent.endTest(this.scenarioTest);
			this.featureTest.appendChild(this.scenarioTest);
		}
	}

	public void done() {
	}

	public void close() {
		extent.addSystemInfo(systemInfo);
		extent.close();
	}

	public void eof() {
		extent.endTest(this.featureTest);
		extent.flush();
	}

	private OutputStream reportFileOutputStream(String fileName) {
		try {
			return new URLOutputStream(new URL(htmlReportDir.toURI().toURL(), fileName));
		} catch (IOException var3) {
			throw new CucumberException(var3);
		}
	}

	private void writeBytesAndClose(byte[] buf, OutputStream out) {
		try {
			out.write(buf);
		} catch (IOException var4) {
			throw new CucumberException("Unable to write to report file item: ", var4);
		}
	}
}
