package com.pathway.scripts;
import org.openqa.selenium.By;

import com.pathway.selenium.factory.SeleniumFunctions;
import com.pathway.util.Excel;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignIn extends SeleniumFunctions{
	
	// Locators :-	
		By banking_tab = By.xpath("//*[@id='banking']/span"); 
		By banks_creditcards_page_label = By.xpath("//*[@id='uniqName_100_0']/div[1]/div[1]/div[1]/span[1]");
		By connect_link = By.xpath("//*[@id='dtx-zero-state']/div[1]/div/div[4]/button"); 
		By connect_an_account_page_lable = By.xpath("//*[contains(text(),'Connect an account')]");
		By enter_bank_name_search_box= By.xpath("//*[@id='fdx-provider-search-input']");
		By bank_name_link=By.xpath("//*[@id='fdx-provider-search-result-0']/div[1]/div/div/img");
		By username_label=By.xpath("//*[contains(text(),'Username')]");
		By pwd_label=By.xpath("//*[contains(text(),'Password')]");
		
		
	// Data :-
		String excel_file = "files//LoginDetails.xlsx";
		String sheet_name = "Bankdetails";
		String bank_name = Excel.readFromExcel(excel_file, sheet_name, 1, 1); 
		

	// Methods :-	
		/**
		 * This method will be used for navigating to Banking tab.
		 *  
		 */
	@Given("^navigates to Banking tab$")
	public void navigates_to_Banking_tab() throws Throwable {
	    click(banking_tab);
	    wait(10);
	    verifyValues("Banks and Credit cards is not visible.", true, isElementVisible(banks_creditcards_page_label));
		System.out.println("User is on the Banks and Credit cards page");
	}
	/**
	 * This method will be used  to Click on Connect link.
	 *  
	 */
	@When("^user clicks on Connect link$")
	public void user_clicks_on_Connect_link() throws Throwable {
	    click(connect_link);
	    wait(10);
		verifyValues("Connect an account page is not visible.", true, isElementVisible(connect_an_account_page_lable));
		System.out.println("User is on the Connect an account page");
	}

	/**
	 * This method will be used validate the Connect an account page.
	 *  
	 */
	@Then("^validates the Connect an account page\\.$")
	public void validates_the_Connect_an_account_page() throws Throwable {
		verifyValues("Connect an account page is not visible.", true, isElementVisible(connect_an_account_page_lable));
		System.out.println("User is on the Connect an account page");
	}

	/**
	 * This method will be used to enter the bank name in search text box.
	 *  
	 */
	@When("^user enters bank name in search box$")
	public void user_enters_bank_name_in_search_box() throws Throwable {
	   enter(enter_bank_name_search_box,bank_name);
	}
 
	/**
	 * This method will be used to clicks on corresponding bank link.
	 *  
	 */
	@When("^user clicks on corresponding bank link$")
	public void user_clicks_on_corresponding_bank_link() throws Throwable {
	   click(bank_name_link);
	   wait(10);
	}

	/**
	 * This method will be used to validate the Sign in Bank details page.
	 *  
	 */
	@When("^Sign In bank details are displayed$")
	public void sign_In_bank_details_are_displayed() throws Throwable {
		verifyValues("Username is not visible.", true, isElementVisible(username_label));
		System.out.println("Username field is displayed");
		verifyValues("Password filed is displayed", true, isElementVisible(pwd_label));
		System.out.println("Password filed is displayed");
	}

	@Then("^validate the Thirdparty banking sign in page\\.$")
	public void validate_the_Thirdparty_banking_sign_in_page() throws Throwable {
		verifyValues("Connect an account page is not visible.", true, isElementVisible(connect_an_account_page_lable));
		System.out.println("User is on the Connect an account page");
	}


}
