
package com.pathway.scripts;

import org.openqa.selenium.By;

import com.pathway.selenium.factory.SeleniumFunctions;


public class Home_Page extends SeleniumFunctions{
	
	By homepage_lable = By.xpath("//*[@id='homepage']/span");
	By banking_tab  = By.linkText("Banking");
	
	/**
	 * This method will be used for validating Home page.
	 *  
	 */
	public void verify_user_is_on_home_page() {
		verifyValues("Home Page is not visible. Login Page is not displayed.", true, isElementVisible(homepage_lable));
		System.out.println("User is on the Home Page");
	}
	

	
	/*@Given("^navigates to Banking tab$")
	public void navigates_to_Banking_tab() throws Throwable {
		click(banking_tab);
		System.out.println("User has navigated to Banking tab successfully");
	}*/
}
