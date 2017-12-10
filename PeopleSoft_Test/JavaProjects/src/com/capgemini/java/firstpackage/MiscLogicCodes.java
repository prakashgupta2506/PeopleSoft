package com.capgemini.java.firstpackage;


import java.lang.*;

public class MiscLogicCodes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Codes codes = new Codes();
		// codes.fibonacci();
		codes.fibonacciWithRecursion(10);
		int n = 31;
		// codes.prime(n);
		codes.factorial(5);
		codes.factorialWithRecursion(6);

	}

}

 class Codes {
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
