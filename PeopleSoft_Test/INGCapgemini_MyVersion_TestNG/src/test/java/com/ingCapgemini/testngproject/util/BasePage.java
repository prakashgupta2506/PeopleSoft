package com.ingCapgemini.testngproject.util;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public static Properties prop = null;
	public  WebDriver driver;
	static{
		System.out.println("inside base page");
	}
	public BasePage() {
		
		if (prop == null) {
			try {
				prop = new Properties();
				FileInputStream fis = new FileInputStream(
						System.getProperty("user.dir")
								+ "\\src\\test\\resources\\config.properties");
				prop.load(fis);
			} catch (Exception e) {
				System.out.println(e.getStackTrace() + e.getMessage());

			}
		}
		
		
	}

	public String getPropertiesValue(String key) {
          
		return prop.getProperty(key);
	}

	public  void launchBrowser() {
		
		if (driver == null) {
			if (prop.getProperty("Browser").equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();

			} else if (prop.getProperty("Browser").equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.IE.driver",
						"\\Resource\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();

			} else if (prop.getProperty("Browser").equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"\\Resource\\chromedriver.exe");
				driver = new ChromeDriver();

			}
			
		}
		
	}
	
	public  void openUrl(String url) {

		//launchBrowser();
		driver.get(url);

	}

	public WebDriver getdriver(){
		return driver;
		
	}
	

}
