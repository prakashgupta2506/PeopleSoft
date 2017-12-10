package com.cucumberJunit.story;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test {

	@Given("^the abc appliction up and runing$")
	public void the_abc_appliction_up_and_runing() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("the abc appliction up and runing");
	}

	@When("^user provide username and password$")
	public void user_provide_username_and_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("user provide username and password");
	}

	@Then("^user should login$")
	public void user_should_login() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("user should login");
	}
}
