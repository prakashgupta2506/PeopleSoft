@UserRegistration
Feature: FR02
#User Registration related scenarios



@UserRegistration_FR02_SCR001
Scenario: SCR001
#User Registration
When user navigates to create account page
And enters all the required details and register
Then new user should be created and should be able to login successfully



@UserRegistration_FR02_SCR002 
Scenario: SCR002
#User Registration normal data governed through feature file or value being provided directly...this is not good(better to create new scenario here)....bad particlularly when multilpe users are working..
When user ab navigates to create account page with datarow as 3
And enters all the required details and register
Then new user should be created and should be able to login successfully



@UserRegistration_FR02_SCR003
Scenario: SCR003
#User Registration for multiple users..problem is if first user regisration fails the for loop won't continue for other users..reporting will not look good
When User registration for multiple users with data from rows 4 to 5


@UserRegistration_FR02_SCR004
Scenario Outline: SCR004
#User Registration for multiple users..to avoid above problem..
When User registration for multiple users with data from rows "<Row>"
Examples:
|Row|
|6|
|7|



@UserRegistration_FR02_SCR005
Scenario: SCR005
#for execution on basis of y/n in excel..
When User launches the application
Then Welcome page should be displayed








