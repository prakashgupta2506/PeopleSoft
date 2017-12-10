package com.cucumberJunit.story;

import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumberJunit.util.WebConnector;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class hello {
	private static final Logger logger=Logger.getLogger(hello.class);
	private static WebConnector web = WebConnector.getInstance();
	private String scenarioName=null;


		
		@Before("@HookingTag")
		public void beforetag() {
			logger.debug("inside beforetag test "+hello.class.getCanonicalName());
			System.out.println("Before the scenario @HookingTag");
		
	}
	
	@After("@HookingTag")
	public void Aftertag() throws Throwable{
		logger.debug("test logger");
		System.out.println("after the scenario @HookingTag");
	
    }
		
	

	
	@Then("^verify that$")
	public void Then(){
		System.out.println("verify that");
		//Assert.assertTrue("",false);
	}
}
