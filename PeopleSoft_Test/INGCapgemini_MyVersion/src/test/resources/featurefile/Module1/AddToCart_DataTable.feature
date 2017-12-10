@Checkout_Scenarios_byreading_DataTable
Feature: FR01 
#Checkout related scenarios like add to cart,remove,payment etc.

@JustRun
Scenario: JustRun
Given Just Run



@JustRun-Login
Scenario: JustRun-Login
Given user "Admin" login into the application with correct credentials DataTable
And verify that User successfully log out of the application



@AddToCart_FR01_SCR001
Scenario: SCR001 
#Add a single item into cart and then remove it

Given user "Admin" login into the application with correct credentials DataTable
When user searches for an item DataTable
And user Add To Cart and Proceed to checkout DataTable
Then summary section shows the added item DataTable
When user delete the item DataTable
Then added item should be removed DataTable
And verify that User successfully log out of the application



@AddToCart_ForDifferentUser_FR01_SCR002
Scenario: SCR002
#Add a single item into cart and then remove it

Given user "Admin1" login into the application with correct credentials DataTable
When user searches for an item DataTable
And user Add To Cart and Proceed to checkout DataTable
Then summary section shows the added item DataTable
When user delete the item DataTable
Then added item should be removed DataTable
And verify that User successfully log out of the application



@AddToCart_NewUser_FR01_SCR003
Scenario: SCR003
#New user register and add to cart
When user navigates to create account page
And enters all the required details and register
Then new user should be created and should be able to login successfully
When user searches for an item DataTable
And user Add To Cart and Proceed to checkout DataTable
Then summary section shows the added item DataTable
When user delete the item DataTable
Then added item should be removed DataTable
And verify that User successfully log out of the application
