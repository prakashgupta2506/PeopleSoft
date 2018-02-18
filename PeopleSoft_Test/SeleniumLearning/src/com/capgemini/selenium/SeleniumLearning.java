package com.capgemini.selenium;

import com.sun.jna.platform.win32.WinDef.BYTE;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.http.util.Asserts;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.swing.JOptionPane;

public class SeleniumLearning {

	class MsgBox {

		public void msgbox() {
			JOptionPane.showMessageDialog(null, "HELLLO", "InfoBox: " + "TITLE", JOptionPane.INFORMATION_MESSAGE);
		}

	}
	
		public static void main(String args[]) throws InterruptedException {

			System.out.println(System.getProperty("user.dir"));
			System.exit(0);
			//###################################### MISC ############################################
			/*System.setProperty("abc", "chrome");
			System.out.println(System.getProperty("abc"));
			
			System.exit(0);

			System.out.println(System.getProperty("user.dir"));*/
			//###################################### MISC ############################################
		
			//**************  Firefox Driver *****************
			
			//System.setProperty("webdriver.firefox.marionette",
			System.setProperty("webdriver.gecko.driver",
					"D:\\Selenium_31May2017\\SeleniumInstallations\\BrowserDrivers\\chromedriver.exe");
			
			
			//WebDriver driver = new FirefoxDriver();
			
			//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			 //System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"false");
			WebDriver driver = new FirefoxDriver();
			
			
			/* FirefoxProfile profile = new FirefoxProfile();
			 profile.setPreference("network.proxytype", 1);
			 profile.setPreference("network.proxy.http", "127.0.0.1");
			 profile.setPreference("network.proxy.http.port","4444");*/
			
			/*DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", false);*/
			 
		        
		        
			 //WebDriver driver = new FirefoxDriver(capabilities);
			
		
						
			//**************  IE Driver *****************
			// System.setProperty("webdriver.ie.driver", "D:\\Selenium_31May2017\\SeleniumInstallations\\Browser Drivers\\IEDriverServer.exe");
			 //WebDriver driver=new InternetExplorerDriver();
			
			//**************  Chrome Driver *****************
			//System.setProperty("webdriver.chrome.driver","D:\\Selenium_31May2017\\SeleniumInstallations\\Browser Drivers\\chromedriver.exe");
			 //WebDriver driver = new ChromeDriver();
				
			 
			 
			 
			 
			 
			driver.get("http://only-testing-blog.blogspot.in/");
			driver.manage().window().maximize();
			
			System.exit(0);
			
			
		
			
			driver.get("http://only-testing-blog.blogspot.in/");
			driver.manage().window().maximize();
			System.out.println("PARENT TITLE:::::"+driver.getTitle());
			driver.switchTo().frame("frame1");
			
			//getwindow handle of the parent handle before launching the new window-
			String  parentWindowHandle = driver.getWindowHandle();
					
					
			driver.findElement(By.xpath("//a[text()='BLOG']")).click();
			//Selenium WebDriver assigns an alphanumeric id to each window as soon as the WebDriver object
			//is instantiated.This unique alphanumeric id is called window handle. 
			
			
			
			
			
			
			//Return a set of window handle 
			Set<String> handles = driver.getWindowHandles();
			String childWindowId=null;
			
			//or directly use...instead of below lines...
			//String childWindow=handles.iterator().next();
			
			Iterator<String> it=handles.iterator();
			
			
			
			
			
			while (it.hasNext()) {
				String windowid = it.next();
				if (!parentWindowHandle.equals(windowid)) {
					childWindowId = windowid;
					break;
				}

			}
			
			
			driver.switchTo().window(childWindowId);
			System.out.println("CHILD TITLE:::::"+driver.getTitle());
			
		
		
			driver.switchTo().defaultContent();
			System.out.println("PARENT TITLE:::::"+driver.getTitle());
			
			
			System.exit(0);
			//String Parent_Window = driver.getWindowHandle(); 
			//handles.
			
			
			//###################### select a link from group of links #################################################
			/*driver.get("http://only-testing-blog.blogspot.in/");
			driver.manage().window().maximize();		
			List<WebElement> objLinks=driver.findElements(By.tagName("a"));			
			for(int i=0;i<objLinks.size()-1;i++){
				if (objLinks.get(i).getAttribute("text").contains("Face")&&objLinks.get(i).getAttribute("text").equals("Facebook")){
					objLinks.get(i).click();
					break;
				}
			}*/
			
		
			//###################### select a link from group of links #################################################
			
			System.exit(0);
			
		
			
			
			
			
			//#####################################  FRAME and SELECT OBJECT #########################################################
			/*WebDriver driver = new FirefoxDriver();
			driver.get("http://only-testing-blog.blogspot.in/");
			driver.manage().window().maximize();
			WebDriverWait explicitWait = new WebDriverWait(driver, 10);
			try {
				explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frame2"));//OR  driver.switchTo().frame("frame2")
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				System.out.println("Error ############" + e.getMessage());
			}				
			try {
				explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select[id='Carlist']")));
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				System.out.println("Error ############" + e.getMessage());
				
				Assert.assertEquals("Failed object not found",true,false);//delibaretely created assertions to report...but execution won't continue..
			}
			WebElement objWebList=driver.findElement(By.cssSelector("select[id='Carlist']"));		
			Select sel=new Select(objWebList);		
			System.out.println("Default selected value----"+sel.getFirstSelectedOption().getText());
			String selectValue="Opel Car";
			sel.selectByValue(selectValue);
			System.out.println("Select By Value--"+selectValue);
			sel.selectByVisibleText("Opel");
			List<WebElement> allItems=sel.getOptions();
			boolean valFound=false;
			for(int i=0;i<allItems.size();i++){
				if(allItems.get(i).getText().equals("Toyota")){
					valFound=true;
					sel.selectByIndex(i);
					break;
				}			
			}		
			if(valFound==true)
				System.out.println("Value found in the list box");
			else
				System.out.println("Value NOT found in the list box");
			driver.switchTo().defaultContent();
			driver.close();
			System.exit(0);*/
			//#####################################  FRAME and SELECT OBJECT #########################################################
			
			
			
			

			// ################################################## Profiling ##################################################
			/*FIREFOX
			FirefoxProfile profile = new FirefoxProfile();
			profile.setAcceptUntrustedCertificates(true);
			profile.setAssumeUntrustedCertificateIssuer(false);
			WebDriver driver=new FirefoxDriver(profile);
 			or DesiredCapabilities capabilities = DesiredCapabilities.firefox();  but test it....
 			
 			
 			
			IE
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			WebDriver driver = new InternetExplorerDriver(capabilities);

			CHROME
			DesiredCapabilities capabilities = DesiredCapabilities.chrome()       
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true)
			WebDriver driver = new ChromeDriver(capabilities);
	*/
			
			
			//launch default page
			/*FirefoxProfile fireFoxProfile = new FirefoxProfile();
			fireFoxProfile.setPreference("browser.startup.homepage", "http://www.google.com");
			WebDriver driver = new FirefoxDriver(fireFoxProfile);*/
			 
			// ################################################## profiling  ##################################################
			

			// Assert.assertEquals("dd","dd");

			/*
			 * System.out.println("FIRST##############"+driver==null);
			 * driver.close();
			 */
			driver.get("http://only-testing-blog.blogspot.in/");
			driver.quit();
			System.out.println("SECOND##############" + driver == null);
			System.exit(0);

			
			
			//###################### Synchronization #################################################
			
					//isEnabled() ,isDisplayed(),isSelected() -in conditional and looping operations 
							

			WebElement objEditBox = driver.findElement(By.id("text1"));
			if (objEditBox.isEnabled()) {
				System.out.println("Text box is enabled");
			} else {
				System.out.println("Text box is disabled");
			}
					
					
			//The ExpectedConditions class offers a wider set of conditions that you can use in conjunction with WebDriverWait's until() method.
			// explicitWait.until(ExpectedConditions.alertIsPresent());
			// explicitWait.until(ExpectedConditions.elementToBeClickable(By.id("Submit")));
			// explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iddd"));
					
					
		//###################### Synchronization #################################################

					
					
			// ############## try catch for isDisplayed ############################
			
			/*driver.get("http://only-testing-blog.blogspot.in/");
			WebDriverWait explicitWait = new WebDriverWait(driver, 3);

			try {
				if (driver.findElement(By.xpath("//a[text()='Facebook1212']")).isDisplayed() == true)
					System.out.println("FOUND");
			} catch (NoSuchElementException e1) { // TODO Auto-generated catch block
				System.out.println("Error ############" + e1.getMessage());
			}*/
			
		
			
			  
			 
			// ############## try catch for isDisplayed ############################

			
			
			
			// ############## try catch for explicit waits ############################
		/*	driver.get("http://only-testing-blog.blogspot.in/");
			WebDriverWait explicitWait = new WebDriverWait(driver, 3);
			try {
				explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Faceboaaaok']")));
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				System.out.println("Error ############" + e.getMessage());
			}
			 */
			
			
			// ############## try catch for explicit waits ############################

			// ############## print all cell values from a webtable(this is worked on W3School webtable ############################
			
		/*	WebElement objWebTable = driver.findElement(By.xpath("//div[@id='post-body-3107268830657760720']/div[1]/table"));
			List<WebElement> objRows = objWebTable.findElements(By.tagName("tr"));
			for (int r = 0; r < objRows.size(); r++) {
				List<WebElement> objCols = objRows.get(r).findElements(By.tagName("td"));
				for (int c = 0; c < objCols.size(); c++) {
					String val = objCols.get(c).getText();
					System.out.println("r--" + r + ",c--" + c + "....val--" + val);

				}

			}*/

			// ############## print all cell values from a webtable(this is worked on W3School webtable ############################

			// ############## Find row where-“Centro commercial…” and “Francisco Change” is present and return value present in 3rd column. ############################

	/*		driver.get("https://www.w3schools.com/html/html_tables.asp");

			WebElement objWebTable = driver.findElement(By.xpath("//table[@id='customers']"));

			List<WebElement> objRows = objWebTable.findElements(By.tagName("tr"));

			for (int r = 1; r < objRows.size(); r++) {
				List<WebElement> objCols = objRows.get(r).findElements(By.tagName("td"));

				for (int c = 0; c < objCols.size(); c++) {
					String val = objCols.get(c).getText();
					if (val.equals("Centro comercial Moctezuma")) {
						String val1 = objCols.get(c + 1).getText();
						if (val1.equals("Francisco Chang")) {
							System.out.println(objCols.get(c + 2).getText());
							break;
						}

					}

				}

			} 
			 */
			// ############## Find row where-“Centro commercial…” and “Francisco Change” is present and return value present in 3rd column. ############################

			// ############## GetRoProperty type ######################################
			// System.out.println(objWebTable.getAttribute("border"));
			// ############## GetRoProperty type  ######################################

			// ############## using Action class to hover the mouse ######################################
			
			/* Actions act = new Actions(driver); 
			 driver.switchTo().frame("I20_1497247838705"); WebElement
			 moveToElement = driver.findElement(By.xpath("//a[text()='Hover over me']"));
			 act.moveToElement(moveToElement).perform(); Thread.sleep(2000);*/
			 

			// ############## using Action class to hover the mouse ######################################

	}

}
