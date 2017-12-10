package com.cucumberJunit.util;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebConnector {
	private static WebConnector web;
	private WebDriver driver=null;
	//private WebDriver fireFox=null;
	private WebDriver IE=null;
	private WebDriver chrome=null;
	private static Properties configProperties;
	private static Properties sqlProperties;
	private static final String  configFile=System.getProperty("user.dir")+"src//test//resources//Config.properties";
	private static String sqlFile=System.getProperty("user.dir")+"src//test//resources//SQL.properties";
	static{
		configProperties=new Properties();
		sqlProperties=new Properties();
		try{
			FileInputStream fisConfig=new FileInputStream(configFile);
			
			configProperties.load(fisConfig);
			FileInputStream fisSQL=new FileInputStream(sqlFile);
			sqlProperties.load(fisSQL);
			
		}catch(Exception e){
			
		}
	}
	private WebConnector(){
		
	}
	
	
	public static WebConnector getInstance(){
		if(web==null) {
			web= new WebConnector();
		}
		return web;	
	}

	public WebDriver getDriver(){
		if (driver==null){
			//if("firefox".equalsIgnoreCase(System.getProperty("Browser")) && fireFox==null){
				if("firefox".equalsIgnoreCase(System.getProperty("Browser"))){
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\geckodriver.exe");
		driver= new FirefoxDriver();
		}
		else if("IE".equalsIgnoreCase(System.getProperty("Browser")) && IE==null){
				System.out.println("i am inside IE");
				 System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\IEDriverServer_32.exe");
				driver= new InternetExplorerDriver();
			}
		else if("Chrome".equalsIgnoreCase(System.getProperty("Browser")) && chrome==null){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe");
					driver= new ChromeDriver();	
				}
			
	}
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/*public void setFireFox(WebDriver fireFox) {
		this.fireFox = fireFox;
	}*/

	public void setIE(WebDriver iE) {
		IE = iE;
	}

	public void setChrome(WebDriver chrome) {
		this.chrome = chrome;
	}



	
}
