package com.capgemini.java.firstpackage;

import java.util.ArrayList;

public class TestAnything {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList arrayList1 = new ArrayList(); 
		
		arrayList1.add("dd");
		arrayList1.add("jjj");
		
		
		for(int i=0;i<arrayList1.size();i++){
			System.out.println(arrayList1.get(i));
		}
		 System.out.println(arrayList1);
				
				System.exit(0);
		
		/*String a="zf";
		
		char c1=a.charAt(0);
		char c2=a.charAt(1);
		if(c1>c2)
			System.out.println(c1);
		else
			System.out.println(c2);
		System.exit(0);;
			*/
		
		Student st3=new Student(12); 
		st3.showThisVariable();

	}

}


