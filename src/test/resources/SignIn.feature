
Feature: SignIn Intuit application


Scenario: Login in to Intuit portal
Given user is logged in with valid credentials
	And navigates to Banking tab
	When user clicks on Connect link
  Then validates the Connect an account page.
  When user enters bank name in search box
  And user clicks on corresponding bank link
  And Sign In bank details are displayed
  Then validate the Thirdparty banking sign in page.
	
	
