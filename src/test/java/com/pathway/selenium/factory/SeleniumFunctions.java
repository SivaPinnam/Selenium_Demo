
package com.pathway.selenium.factory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.pathway.scripts.ScriptRunner;

public class SeleniumFunctions extends ScriptRunner {

	// C :-

	public void click(By locator) {
		waitForElementtoBeVisible(locator);
		waitForElementtoBeClickable(locator);
		driver.findElement(locator).click();
	}

	public void closeCurrentTab() {
		driver.close();
	}

	public void closeSingleinstance() {
		driver.close();
		driver = null;
		wait = null;
	}

	public void closeAllinstances() {
		driver.quit();
		driver = null;
		wait = null;
	}

	// E :-

	public void enter(By locator, String txt) {
		waitForElementtoBeVisible(locator);
		if (!isElementEnable(locator)) {
			wait(5);
		}
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(txt);
	}

	// F :-

	public WebElement findElement(By locator) {
		waitForElementtoBeVisible(locator);
		return driver.findElement(locator);
	}

	public List<WebElement> findElements(By locator) {
		waitForElementtoBeVisible(locator);
		return driver.findElements(locator);
	}

	// G :-

	public void getUrl(String url) {
		if (wait == null) {
			ScriptRunner.setWait();
		}

		driver.manage().window().maximize();
		driver.get(url);
		System.out.println("User have entered URL successfully");
	}

	public String getText(By locator) {
		waitForElementtoBePresent(locator);
		return driver.findElement(locator).getText();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public int getBrowserinstanceSize() {
		return driver.getWindowHandles().size();
	}

	public int getElementSize(By locator) {
		return driver.findElements(locator).size();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	/**
	 * This method will be used to get all the windows.
	 * 
	 * @return
	 */
	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	public void getWindowHandle1() {
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(0));
		driver.close();
		driver.switchTo().window(tabs2.get(1));
	}

	public void swithtoWindowHandle() {
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
	}

	public void swithToOiriginalndowHandle() {
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(0));
	}

	/**
	 * This method will used to switch to a window using window handle
	 * 
	 * @param windowHandle
	 */
	public void switchToWindow(String windowHandle) {
		driver.switchTo().window(windowHandle);
	}

	/**
	 *  This method will get
	 * the list of all the options from dropdown/multiselect picklist
	 * 
	 * @param locator
	 * @return
	 */
	public List<WebElement> getAllOptions(By locator) {
		waitForElementtoBeVisible(locator);
		WebElement dropdown = driver.findElement(locator);
		Select select = new Select(dropdown);
		return select.getOptions();
	}

	/**
	 * This method will get the list of selected elements.
	 * 
	 * @param locator
	 * @return
	 */
	public List<WebElement> getAllSelectedOptions(By locator) {
		waitForElementtoBeVisible(locator);
		WebElement dropdown = driver.findElement(locator);
		Select select = new Select(dropdown);
		return select.getAllSelectedOptions();
	}

	public List<WebElement> getElementList(By locator) {
		waitForElementtoBeVisible(locator);
		return driver.findElements(locator);
	}

	// I :-

	public boolean isElementVisible(By locator) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;

		} catch (TimeoutException e) {
			System.out.println("Element is not visible : " + locator);
			return false;
		}
	}

	public boolean isElementExist(By locator) {
		try {
			driver.findElement(locator);
			return true;

		} catch (NoSuchElementException e) {			
			return false;
		}
	}

	/**
	 * This method will verify if targeted select box is multiple select box or
	 * not means we can select multiple options from that select box or not
	 * 
	 * @return
	 */
	public boolean isMultiselect(By locator) {
		waitForElementtoBeVisible(locator);
		WebElement dropdown = driver.findElement(locator);
		Select listbox = new Select(dropdown);
		return listbox.isMultiple();
	}

	public boolean isElementEnable(By locator) {
		waitForElementtoBeVisible(locator);
		return driver.findElement(locator).isEnabled();
	}

	public boolean isElementSelected(By locator) {
		waitForElementtoBeVisible(locator);
		return driver.findElement(locator).isSelected();
	}

	// M :-

	/**
	 * This method will used for mouse hover elements to hover the element
	 * 
	 * @param locator
	 */
	public void moveToElement(By locator) {
		Actions actions = new Actions(driver);
		waitForElementtoBeVisible(locator);
		WebElement move = driver.findElement(locator);
		actions.moveToElement(move).perform();
		;
	}

	/**
	 * This method will used for mouse hover elements. It will mouse hover the
	 * element and then click on the specific locator
	 * 
	 * @param locator
	 *            :- mouse hover element
	 * @param click
	 *            :- click on element from the mouse hover list
	 */
	public void moveToElementAndClick(By locator, By click) {
		Actions actions = new Actions(driver);
		waitForElementtoBeVisible(locator);
		WebElement move = driver.findElement(locator);
		WebElement click_locator = driver.findElement(click);
		actions.moveToElement(move).click(click_locator).build().perform();
		;
	}

	// N :-

	public void navigateBack() {
		driver.navigate().back();
	}

	public void navigateForward() {
		driver.navigate().forward();
	}

	public void navigateToUrl(String url) {
		driver.navigate().to(url);
	}

	// R :-

	public void refreshPage() {
		driver.navigate().refresh();
	}

	// S :-

	/**
	 * This method will select option from dropdown by using visible text
	 * 
	 * @param locator
	 * @param value
	 */
	public void selectByVisibleText(By locator, String value) {
		waitForElementtoBeVisible(locator);
		WebElement dropdown = driver.findElement(locator);
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
	}

	/**
	 * This method will select option from dropdown by using visible text
	 * 
	 * @param element
	 *            : provide web element
	 * @param value
	 */
	public void selectByVisibleText(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	/**
	 * This method will select option from dropdown by using value
	 * 
	 * @param locator
	 * @param value
	 */
	public void selectByValue(By locator, String value) {
		waitForElementtoBeVisible(locator);
		WebElement dropdown = driver.findElement(locator);
		Select select = new Select(dropdown);
		select.selectByValue(value);
	}

	/**
	 * This method will select option from dropdown by using index
	 * 
	 * @param locator
	 * @param index
	 */
	public void selectByIndex(By locator, int index) {
		waitForElementtoBeVisible(locator);
		WebElement dropdown = driver.findElement(locator);
		Select select = new Select(dropdown);
		select.selectByIndex(index);
	}

	public String getFirstSelectedOption(By locator) {
		WebElement dropdown = findElement(locator);
		Select select = new Select(dropdown);
		WebElement first_selected_element = select.getFirstSelectedOption();
		return first_selected_element.getText();
	}

	/**
	 * This method will select the check box
	 * 
	 * @param locator
	 */
	public void selectCheckBox(By locator) {
		waitForElementtoBeVisible(locator);
		if (!driver.findElement(locator).isSelected()) {
			driver.findElement(locator).click();
		}
	}

	/**
	 * This method will de-select the check box
	 * 
	 * @param locator
	 */
	public void deselectCheckBox(By locator) {
		waitForElementtoBeVisible(locator);
		if (driver.findElement(locator).isSelected()) {
			driver.findElement(locator).click();
		}
	}

	/**
	 * This method will switch to frame using frame id
	 * 
	 * @param frameId
	 */
	public void switchToFrame(String frameId) {
		driver.switchTo().frame(frameId);
	}

	/**
	 * This method will used to switch back to the default page
	 */
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method will switch to the alert and accept it
	 */
	public void switchToAlertAndAccept() {
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

	/**
	 * This method will switch to the alert and dismiss it
	 */
	public void switchToAlertAndDismiss() {
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method will switch to the alert and get the text present in the
	 * alert
	 */
	public String switchToAlertAndGetText() {
		wait.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert().getText();
	}

	/**
	 * This method will switch to the alert and it will enter text in the alert
	 * text field
	 */
	public void switchToAlertAndEnterText(String text) {
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().sendKeys(text);
		;
	}
	// V :-

	public void verifyValues(String msg, boolean expected, boolean actuals) {
		Assert.assertEquals(msg, expected, actuals);
	}

	public void verifyValues(String msg, String expected, String actuals) {
		Assert.assertEquals(msg, expected, actuals);
	}

	public void verifyValues(String msg, int expected, int actuals) {
		Assert.assertEquals(msg, expected, actuals);
	}

	public void verifyelementText(String msg, By locator, String expectedTxt) {
		verifyValues(msg, expectedTxt, getText(locator));
	}

	public void verifyElementAttributeValue(String msg, By locator, String attribute, String expected) {
		waitForElementtoBePresent(locator);
		String value = driver.findElement(locator).getAttribute(attribute);
		verifyValues(msg, expected, value);
	}

	public void verifyElementExists(String msg, By locator) {
		verifyValues(msg, true, isElementExist(locator));
	}

	public void verifyValuesNotEquals(String msg, String expected, String actual) {
		Assert.assertNotEquals(msg, expected, actual);
	}

	public void verifyValuesNotEquals(String msg, int expected, int actual) {
		Assert.assertNotEquals(msg, expected, actual);
	}

	public void verifyValuesNotEquals(String msg, boolean expected, boolean actual) {
		Assert.assertNotEquals(msg, expected, actual);
	}
	
	//This function is to verify the values present in Dropdown
	public void verifyDropdownValues(String options, By locator, String dropdown_Name){
		List<WebElement> selected_options = getAllOptions(locator);
		boolean status;
		for (String val : options.split(";")) {
			status = false;
			for (WebElement option : selected_options) {
				if (val.trim().equalsIgnoreCase(option.getText().trim())) {
					status = true;
					break;
				}
			}
			verifyValues(val + " is not present in dropdown: " + dropdown_Name, true, status);
		}
		
	}
	// W :-

	public void waitForElementtoBeClickable(By locator) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(locator));

		} catch (TimeoutException e) {
			Assert.fail("Element is not clickable : " + locator);
		}
	}

	public void waitForElementtoBeVisible(By locator) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		} catch (TimeoutException e) {
			Assert.fail("Element is not visible : " + locator);
		}
	}

	public void waitForElementtoBePresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		} catch (TimeoutException e) {
			Assert.fail("Element is not present : " + locator);
		}
	}

	public void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			System.out.println("Failed to wait for :" + seconds + " seconds");
		}
	}

	public void waitForElementToDisappear(By locator) {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
		}
	}

	// Created By: Optum Automation Team
	// Desc: Return Current Date
	public String getDate(int period, String format) {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		currentDate.add(Calendar.DAY_OF_MONTH, period);
		String date = formatter.format(currentDate.getTime());
		return date;
	}

	// Created By: Optum Automation Team
	// Desc: Return Tomorrow's Date
	public String TomorrowDate(String[] args) {

		Calendar calendar = Calendar.getInstance();
		Date today = calendar.getTime();

		calendar.add(Calendar.DAY_OF_YEAR, 1);

		Date tomorrow = calendar.getTime();
		// Use SimpleDateFormat to format the Date as a String:

		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

		String todayAsString = dateFormat.format(today);
		String tomorrowAsString = dateFormat.format(tomorrow);

		System.out.println(todayAsString);
		System.out.println(tomorrowAsString);
		return tomorrowAsString;

	}

	// Created By: Optum Automation Team
	// Desc: Return Yesterday's date
	public String getYesterdayDate(int period, String format) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		System.out.println("Yesterday's date = " + cal.getTime());

		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		cal.add(Calendar.DATE, -1);
		return dateFormat.format(cal.getTime());
	}

	public static Date getYesterday() {
		GregorianCalendar yesterday = new GregorianCalendar();
		yesterday.add(Calendar.DATE, -1);
		return yesterday.getTime();
	}

	
	@SuppressWarnings("unused")
	private static boolean validatePhoneNumber(String phoneNo) {
		// validate phone numbers of format "1234567890"
		if (phoneNo.matches("\\d{10}"))
			return true;
		// validating phone number with -, . or spaces
		else if (phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))
			return true;
		// validating phone number with extension length from 3 to 5
		else if (phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}"))
			return true;
		// validating phone number where area code is in braces ()
		else if (phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}"))
			return true;
		// return false if nothing matches the input
		else
			return false;

	}

	
	// Desc: Check if email id is valid
	public boolean isValidEmailAddress(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}
	
	
	public boolean isGetText(By locator) {
		boolean value = false;
		waitForElementtoBePresent(locator);
		if (driver.findElement(locator).getText() != "" || driver.findElement(locator).getText() != null)
			value = true;
		else
			value = false;
		return value;

	}

	/*** 
	 * Get the selected value from combo box
	 * 
	 * 
	 */
	public String getSelectedVisibleText(By locator) {
		WebElement dropdown = driver.findElement(locator);
		Select select = new Select(dropdown);
		return select.getFirstSelectedOption().getText();
	}
	
	// Created By: Optum Automation Team
	public void verifyRequiredFields(String msg, By locator) {
		verifyValues(msg, true, isRequired(locator));
	}
	
	// Created By: Optum Automation Team
	public boolean popupHandler(String popupMsg, String value) {
		boolean returnvalue = false;
		try {
			Alert alert = driver.switchTo().alert();
			String alertMessage = driver.switchTo().alert().getText();

			if (popupMsg.equalsIgnoreCase(alertMessage) && value.equalsIgnoreCase("accept")) {
				alert.accept();
				returnvalue = true;
			} else {
				alert.dismiss();
				returnvalue = false;
			}

		} catch (TimeoutException e) {
		}
		return returnvalue;
	}

	
	public boolean verifyPopupHandler(String popupMsg) {
		boolean returnvalue = false;
		try {
			String alertMessage = driver.switchTo().alert().getText();

			if (popupMsg.equalsIgnoreCase(alertMessage)) {
				returnvalue = true;
			} else {
				returnvalue = false;
			}

		} catch (TimeoutException e) {
		}
		return returnvalue;
	}

	
	public boolean isRequired(By locator) {
		boolean returnValue = false;

		if (driver.findElement(locator).getAttribute("data-rule-required").equalsIgnoreCase("true")) {
			returnValue = true;
		} else {
			returnValue = false;
		}

		return returnValue;

	}

	
	public void lookUpHandler(By locator, String SearchString) throws Exception	{

		String currentWindow = null;
		ArrayList<String> currentWindows = new ArrayList<String>(driver.getWindowHandles());
		int windowIndex = 0;
		click(locator);
		wait(5);
		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("**********************" + windowHandles.size());
		for (int i = 0; i < windowHandles.size(); i++) {
			for (int j = 0; j < currentWindows.size();j++) {
				if (currentWindows.get(j).equalsIgnoreCase(windowHandles.get(i)))
				{
					break;
				} 
				else {
					currentWindow = windowHandles.get(i);
					windowIndex = i;
				}				
			}
		}
		if (currentWindow != null) {
			driver.switchTo().window(currentWindow);
			System.out.println(driver.switchTo().window(currentWindow).getTitle());
		}
		wait(10);

		By lookupLocator = By.xpath("html/body/form/div/div[2]/input[1]");
		By goLocator = By.name("go");
		By searchResultLink = By.linkText(SearchString);
		switchToFrame("searchFrame");
		wait(5);
		enter(lookupLocator, SearchString);
		click(goLocator);
		wait(2);
		driver.switchTo().defaultContent();
		switchToFrame("resultsFrame");
		if (searchResultLink != null) {
			click(searchResultLink);
		}
		switchToWindow(windowHandles.get(windowIndex - 1));
		windowHandles = null;
	}

	public void calendar() {
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='calendarTable_']//td"));
		for (WebElement ele : allDates) {
			String date = ele.getText();
			if (date.equalsIgnoreCase("15")) {
				ele.click();
				break;
			}

		}
	}

	/**
	 * This method will select option from dropdown by using visible text
	 * 
	 * @param locator
	 * @param value
	 *            is list of drown down values to be verified.
	 */
	public String isSelectValueExists(By locator, String[] values) {
		String returnValue = "Not Matched";
		waitForElementtoBeVisible(locator);
		WebElement dropdown = driver.findElement(locator);
		Select select = new Select(dropdown);
		List<WebElement> options = select.getOptions();
		int j = 0;
		for (WebElement option : options) {
			for (int i = 0; i < values.length; i++) {
				if (option.getText().equalsIgnoreCase(values[i])) {
					verifyValues("Values match", values[i], option.getText());
					j++;
				}
				/*
				 * }else{ verifyValues("Values match",values[i],
				 * option.getText()); }
				 */
			}

			System.out.println(option.getText()); // Prints "Option", followed
													// by "Not Option"
		}
		if (j == options.size()) {
			returnValue = "Matched";
		}
		return returnValue;
	}

	/**
	 * This method return the length of the text input field
	 * 
	 * @param locator
	 *            length
	 */

	public int verifyInputFieldLength(By locator) {
		String value = driver.findElement(locator).getAttribute("maxlength");
		return Integer.parseInt(value);
	}

	// Created By: Optum Automation Team
	public boolean verifyDateFormate(String date, String exceptedDateformat) {

		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(exceptedDateformat);
		Date dateFormat = null;
		boolean returnValue = false;
		try {
			dateFormat = DATE_FORMAT.parse(date);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		if (dateFormat.toString().equalsIgnoreCase(date)) {
			returnValue = true;
		}

		return returnValue;
	}

	// 
	public String getSelectedValueFromDropDown(By locator) {
		Select select = new Select(findElement(locator));
		return select.getFirstSelectedOption().getText();
	}

	/**
	 * Iterates table rows and columns for specific values and returns
	 * engagementlink xpath for the 1st matching record.
	 * 
	 * @param columnName
	 * @param columnValue
	 * @param tableLocator
	 * @param firstRowColumnLocator
	 */

	
	public String getColumn(String rowPath, int columnNumber, String columnValue, By firstRowColumnLocator,
			int specificColumn) {

		By tableLocator = By.xpath(rowPath);
		int Row_count = driver.findElements(tableLocator).size();
		int Col_count = driver.findElements(firstRowColumnLocator).size();
		String engagementColumPath = "";
		// div[1]/div[2]/table/tbody/tr/td[2]/div[3]/div[1]/div/div[2]/table/tbody/tr[3]/td[2]

		String s1 = rowPath + "[";
		String s2 = "]/td[";
		String s3 = "]";

		for (int i = 2; i <= Row_count; i++) {
			for (int j = 1; j <= Col_count; j++) {
				String final_xpath = s1 + i + s2 + j + s3;
				String value = driver.findElement(By.xpath(final_xpath)).getText();
				if (j == columnNumber && value.equalsIgnoreCase(columnValue)) {
					engagementColumPath = s1 + i;
					break;
				}
				// break;
			}
			// break;
		}
		return engagementColumPath;
	}

}
