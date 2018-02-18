package com.capgemini.java.firstpackage;


import java.lang.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MiscLogicCodes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		RegularExpression r=new RegularExpression();
		r.findStrings();
		System.exit(0);
		Codes codes = new Codes();
		codes.stringCompare();
		System.exit(0);
		codes.stringSortBasedOnFirstChar();
		System.exit(0);
		codes.bubbleSort();
		System.exit(0);
		codes.binarySearch();
		
		
		
		
		
		
		System.exit(0);
		
		Codes f=new Codes();
		f.fibo();
		System.exit(0);		
		//reverse string
		String str="Prakash Gupta";
		String rev="";
		for(int i=str.length()-1;i>=0;i--){
			rev=rev+str.charAt(i);
		}
		System.out.println(rev);
		System.exit(0);
		
		
		// codes.fibonacci();
		codes.fibonacciWithRecursion(10);
		int n = 31;
		// codes.prime(n);
		codes.factorial(5);
		codes.factorialWithRecursion(6);
		
		
		
		

	}

}

 class Codes {
	 
	 
	 void stringCompare(){

		 
		 String a[] = { "abc", "hfhf", "bdf", "dff" };

			boolean swap;
			int cnt = 1;

			do {
				swap = false;
				for (int j = 0; j <= a.length - 1 - cnt; j++)

					if (a[j].compareTo(a[j+1])>0) {
						String temp = a[j];
						a[j] = a[j + 1];
						a[j + 1] = temp;
						swap = true;
					}

				cnt++;

			} while (swap == true);

			for (int i = 0; i <= a.length-1; i++)
				System.out.print(a[i] + ",");

		 
	 
	 }
	 
	 void stringSortBasedOnFirstChar(){
		 
		 String a[] = { "abc", "hfhf", "bdf", "dff" };

			boolean swap;
			int cnt = 1;

			do {
				swap = false;
				for (int j = 0; j <= a.length - 1 - cnt; j++)

					if (a[j].charAt(0) > a[j + 1].charAt(0)) {
						String temp = a[j];
						a[j] = a[j + 1];
						a[j + 1] = temp;
						swap = true;
					}

				cnt++;

			} while (swap == true);

			for (int i = 0; i <= a.length-1; i++)
				System.out.print(a[i] + ",");

		 
	 }
	 void bubbleSort(){
		int a[] = { 2, 5, 10, 8, 12 };
		boolean swap;
		int cnt = 1;

		do {
			swap = false;
			for (int j = 0; j <= a.length - 1 - cnt; j++)

				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					swap = true;

				}

			cnt++;

		} while (swap == true);
		
		for(int i=0;i<=a.length-1;i++)
			System.out.print(a[i]+",");
		 
		 
	 }
	 
	 
	 void binarySearch(){
		 int a[]={2,5,10,8,12};
		 Arrays.sort(a);
		 int toSearch=10;
		 int lb=0; 
		 int ub=a.length-1;
		 int  mid;
		 
		 while(lb<=ub){
			mid=(lb+ub)/2;
			
			if(a[mid]==toSearch){
				System.out.println("element found at "+mid);
				return;
			}
			 
			if(a[mid]>toSearch)
				ub=mid-1;
			else
				lb=mid+1;
				
				
			
			
		 }
		 
		 
		 
		 
		 
		 
	 }
	void fibonacci() {
		int n1 = 0, n2 = 1, sum, count = 10;
		System.out.print(n1 + "," + n2);
		for (int i = 2; i < count; i++) {
			sum = n1 + n2;
			System.out.print("," + sum);
			n1 = n2;
			n2 = sum;
		}
		System.out.println();

	}
void fibo(){
	
	int n1 = 0, n2 = 1, sum, count = 10;
	String s=n1+","+n2;
	
//	System.out.print(n1 + "," + n2);
	for (int i = 2; i < count; i++) {
		sum = n1 + n2;
		s=s+","+sum;
		//System.out.print("," + sum);
		n1 = n2;
		n2 = sum;
	}
	System.out.println(s);
	
	
}
	
	
	
	static int n1 = 0, n2 = 1, sum, printOnce = 0;
	void fibonacciWithRecursion(int counter) {
		if (counter > 2) {
			if (printOnce == 0) {
				System.out.print(n1 + "," + n2);
				printOnce = printOnce + 1;
			}
			sum = n1 + n2;
			System.out.print("," + sum);
			n1 = n2;
			n2 = sum;
			fibonacciWithRecursion(counter - 1);
		}
		else {
			System.out.println();
			return;
		}
		
	}
	

	void prime(int n) {
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (n % i == 0) {
				System.out.println("Following no. is not prime - " + n);
				return;
			}

		}
		System.out.println("Following no. is prime - " + n);

	}
	
	void factorial(int n){
		int factorialOutput=1;
		for(int i=n;i>=1;i--){
			factorialOutput=factorialOutput*i;			
		}
		System.out.println(factorialOutput);
		
	}
	
	
	static int factorialOutput=1;
	void factorialWithRecursion(int n){
		if(n>0)
			factorialOutput=factorialOutput*n;	
		else {System.out.println(factorialOutput);	
		   	return;
		}
		
		factorialWithRecursion(n-1);
	}

}

 
 //Java StringBuffer class is used to create mutable (modifiable) string. 
 //The StringBuffer class in java is same as String class except it is mutable i.e. 
 //it can be changed. 
 
 class StringBuff{  
	 void stringBuff(){  
	 StringBuffer sb=new StringBuffer("Hello ");  
	 sb.append("Java");//now original string is changed  
	 System.out.println(sb);//prints Hello Java  
	 sb.insert(1, "Java");
	 System.out.println(sb);//prints HJavaello  
	 sb.replace(1,3,"Java");  
	 System.out.println(sb);//prints HJavalo 
	 sb.delete(1,3);  
	 System.out.println(sb);//prints Hlo  
	 sb.reverse();  
	 System.out.println(sb);//prints olleH  
	 
	 
	 
	 
	 
	 
	 }  
	 }  
 
 
 class RegularExpression{
		
		
		void findStrings() {

			//length must be 3 characters starting with ca
			String REGEX = "[c][a][a-zA-Z0-9]{1}";
			String INPUT = "cat cat cat dog cattie cat cat";
			Pattern p = Pattern.compile(REGEX);	
			
			Matcher m = p.matcher(INPUT); 	
			int count = 0;

			while (m.find()) {
				count++;
				System.out.println("Match number " + count);
				System.out.println("start(): " + m.start());
				System.out.println("end(): " + m.end());
				System.out.println(INPUT.substring(m.start(), m.end()));
			}
		}
		
		
		void countWord() {

			String REGEX = "\\bcat\\b";

			String INPUT = "cat cat cat dog cattie cat cat";
			// compiles the given regex and return the Pattern object.
			Pattern p = Pattern.compile(REGEX);
			// A Matcher object is the engine that interprets the pattern and
			// performs match operations against an input string
			Matcher m = p.matcher(INPUT); // get a matcher object//creates a matcher
											// that matches the given input with
											// pattern.
			int count = 0;

			while (m.find()) {
				count++;
				System.out.println("Match number " + count);
				System.out.println("start(): " + m.start());
				System.out.println("end(): " + m.end());

			}
		}
			   
		
		
		void regularExpressionJavaTpoint(){ 
	      
	        String strPattern="[]"; 
	        Pattern pattern = Pattern.compile(strPattern);    
	        String strText="tttt";  
	        Matcher matcher = pattern.matcher(strText);    
	        boolean found = false;    
	        while (matcher.find()) {    
	            System.out.println("I found the text "+matcher.group()+" starting at index "+    
	             matcher.start()+" and ending at index "+matcher.end());    
	            found = true;    
	        }    
	        if(!found){    
	            System.out.println("No match found.");    
	        
	    }    
	}    
		
		
	}