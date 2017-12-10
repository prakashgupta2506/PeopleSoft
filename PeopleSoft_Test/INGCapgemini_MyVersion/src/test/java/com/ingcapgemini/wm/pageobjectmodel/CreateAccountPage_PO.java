package com.ingcapgemini.wm.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ingcapgemini.wm.common.GlobalStepDefinition;
import com.ingcapgemini.wm.util.SeleniumUtil;
import com.ingcapgemini.wm.util.Xls_Reader;

public class CreateAccountPage_PO {

	private static final Logger LOGGER = LogManager.getLogger(CreateAccountPage_PO.class);

    
	public static final String TITLE_RADIOBUTTON_ID = "id_gender";
	public static String TITLE_RADIOBUTTON_ID_Gender;
	public static final String FIRSTNAME_ID = "customer_firstname";
	public static final String LASTNAME_ID = "customer_lastname";

	public static final String PASSWORD_ID = "passwd";
	public static final String DOB_DAY_ID = "days";
	public static final String DOB_MONTH_ID = "months";
	public static final String DOB_YEAR_ID = "years";

	public static final String YOURADDRESS_FIRSTNAME_ID = "firstname";
	public static final String YOURADDRESS_LASTNAME_ID = "lastname";

	public static final String ADDRESS_ID = "address1";

	public static final String CITY_ID = "city";
	public static final String STATE_WEBLIST_ID = "id_state";

	public static final String ZIP_ID = "postcode";
	public static final String COUNTRY_WEBLIST_ID = "id_country";
	public static final String MOBILEPHONE_ID = "phone_mobile";

	public static final String EMAILALIAS_ID = "alias";

	public static final String SUBMIT_BUTTON_ID = "submitAccount";

	public static String FirstName;
	
	public static String LastName;
	
	public static String Password;

	public static void inputRegistrationDetails(String sheetName, int rowNum) {
		
		LOGGER.info("########## Inside inputRegistrationDetails  ##########");
		
		Xls_Reader xlread = GlobalStepDefinition.xlread;

		String Title = xlread.getCellData(sheetName, "Title", rowNum);

		if (Title.equals("Mr.")) {
			TITLE_RADIOBUTTON_ID_Gender = TITLE_RADIOBUTTON_ID + "1";
		} else if (Title.equals("Mrs.")) {
			TITLE_RADIOBUTTON_ID_Gender = TITLE_RADIOBUTTON_ID + "2";
		}

		FirstName = xlread.getCellData(sheetName, "FirstName", rowNum);
		LastName = xlread.getCellData(sheetName, "LastName", rowNum);
		Password = xlread.getCellData(sheetName, "Password", rowNum);
		String DOB = xlread.getCellData(sheetName, "DOB", rowNum);
		String DOB_day = DOB.split("-")[0];
		String DOB_month = DOB.split("-")[1];
		String DOB_year = DOB.split("-")[2];
		String YourAddress_FN = xlread.getCellData(sheetName, "YourAddress_FN", rowNum);
		String YourAddress_LN = xlread.getCellData(sheetName, "YourAddress_LN", rowNum);
		String Address = xlread.getCellData(sheetName, "Address", rowNum);
		String City = xlread.getCellData(sheetName, "City", rowNum);
		String State = xlread.getCellData(sheetName, "State", rowNum);
		String Zip = xlread.getCellData(sheetName, "Zip", rowNum);

		String Country = xlread.getCellData(sheetName, "Country", rowNum);
		String MobilePhone = xlread.getCellData(sheetName, "MobilePhone", rowNum);
		String Email_Alias = xlread.getCellData(sheetName, "Email_Alias", rowNum);

		SeleniumUtil.ValidateWebElementPresence(By.id(TITLE_RADIOBUTTON_ID_Gender));
		SeleniumUtil.getInstance().getDriver().findElement(By.id(TITLE_RADIOBUTTON_ID_Gender)).click();

		SeleniumUtil.setValue(By.id(FIRSTNAME_ID), FirstName);
		SeleniumUtil.setValue(By.id(LASTNAME_ID), LastName);
		SeleniumUtil.setValue(By.id(PASSWORD_ID), Password);

		SeleniumUtil.selectWebList(By.id(DOB_DAY_ID), DOB_day, "SelectByvalue");
		SeleniumUtil.selectWebList(By.id(DOB_MONTH_ID), DOB_month, "selectByVisibleText");
		SeleniumUtil.selectWebList(By.id(DOB_YEAR_ID), DOB_year, "SelectByvalue");
		SeleniumUtil.setValue(By.id(YOURADDRESS_FIRSTNAME_ID), YourAddress_FN);
		SeleniumUtil.setValue(By.id(YOURADDRESS_LASTNAME_ID), YourAddress_LN);
		SeleniumUtil.setValue(By.id(ADDRESS_ID), Address);
		SeleniumUtil.setValue(By.id(CITY_ID), City);
		SeleniumUtil.selectWebList(By.id(STATE_WEBLIST_ID), State, "selectByVisibleText");
		SeleniumUtil.setValue(By.id(ZIP_ID), Zip);
		SeleniumUtil.selectWebList(By.id(COUNTRY_WEBLIST_ID), Country, "selectByVisibleText");
		SeleniumUtil.setValue(By.id(MOBILEPHONE_ID), MobilePhone);
		SeleniumUtil.setValue(By.id(EMAILALIAS_ID), Email_Alias);
		SeleniumUtil.clickWebElement(By.id(SUBMIT_BUTTON_ID));

	}

}
