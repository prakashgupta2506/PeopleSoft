package com.cucumberJunit.action;

public class TestString {
public static String Email="Email";
public static final  String SUBMENU_XPATH_INDEX="(//a[contains(@inner,'text')])[index]";
public static final  String SUBMENU_XPATH="//a[contains(@inner,'text')]";



	public static void main(String[] args) {
		String innerText="prakash";
				String index="2";
		// TODO Auto-generated method stub
		System.out.println(SUBMENU_XPATH_INDEX.replace("text", innerText).replace("index", index));		
       System.out.println("print modified"+SUBMENU_XPATH.replace("text", "Gmail"));
	}

}
