/**********
 *  Created By: Persistent Automation Team
 *  Created On: 11/30/2016
 *  Modified On: 12/22/2016
 **********/
package com.pathway.scripts;

import org.openqa.selenium.By;

import com.pathway.selenium.factory.SeleniumFunctions;
import com.pathway.util.Excel;

import cucumber.api.java.en.Given;

public class Login_Page extends SeleniumFunctions {
	
// Locators :-	
	By username_field = By.xpath("//*[@name='Email']"); 
	By password_field = By.xpath("//*[@name='Password']");
	By login_button = By.xpath("//*[@id='ius-sign-in-submit-btn-text']");
	By skip = By.xpath("//*[@id='ius-verified-user-update-btn-skip']");
	
// Data :-
	String excel_file = "files//LoginDetails.xlsx";
	String sheet_name = "LoginDetails";
	String url = Excel.readFromExcel(excel_file, sheet_name, 1, 1); 
	String username = Excel.readFromExcel(excel_file, sheet_name, 2, 1); 
	String password = Excel.readFromExcel(excel_file, sheet_name, 3, 1); 

// Methods :-	
	
    /**
	 * This method will enter user credentials and click on login button 
	 */
	@Given("^user is logged in with valid credentials$")
	public void user_is_logged_in_with_valid_credentails() {
			getUrl(url);
			if(! isElementExist(new Home_Page().homepage_lable)){
				enter(username_field, username);
				enter(password_field, password);
				click(login_button);
				click(skip);
				wait(5);
			}
			new Home_Page().verify_user_is_on_home_page();
	}
}
