/**********
*  Created By: Persistent Automation Team
*  Created On: 11/30/2016
*  Modified On: 12/07/2016
**********/

package com.pathway.scripts;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pathway.selenium.factory.SeleniumFunctions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class Common_Utility_Page extends SeleniumFunctions{

	By show_more_link =  By.linkText("Show More"); 
	By back_to_related_link = By.xpath("//a[text()='<< Back to Related list']");
	static By spinner = By.xpath("//*[@class='spinner']");
	
	@And("^user clicks on Show More link$")
	public void user_clicks_on_Show_More_link() {
		click(show_more_link);
		waitForElementtoBeVisible(back_to_related_link);
		System.out.println("user clicks on Show More link");		
	}
	
	@Then("^more records are displayed successfully$")
	public void more_records_are_displayed_successfully() {
		int size = getElementList(back_to_related_link).size();
		verifyValues("Back to related link is not present twice", 2, size);
		System.out.println("All the records are getting displayed");
	}
	
	/*CREATED BY: PERSISTENT TEAM
	**CRETAED ON: 07/12/2016
	**DESC: This method is used verify the values selected in multi combo list*/
	public void validate_multicombo_selected_values(By locator, String options, String multiCombo_name) {
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
			verifyValues(val + " not present in Multiselect Combo: " + multiCombo_name, true, status);
		}
		System.out.println("All the selected values are present in "+ multiCombo_name);
	}
}
