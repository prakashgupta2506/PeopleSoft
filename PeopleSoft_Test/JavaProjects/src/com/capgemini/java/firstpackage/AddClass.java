package com.capgemini.java.firstpackage;



 public class AddClass {

	void add(int i, int j) {
	
		int s = i + j;
		System.out.println("Summation is:" + s);
	}

	void add(int i, int j, int k) {
		int s = i + j + k;
		System.out.println("Summation is:" + s);
	}

	int returnaddedvalue(int i, int j) {
		return i + j;
	}

}

 class Calculation {
	int outPut;

	void Addition(int x, int y) {
		outPut = x + y;
		System.out.println("Addition of " + x + " and " + y + " is " + outPut);

	}

	void Subtraction(int x, int y) {
		outPut = x - y;
		System.out.println("Substraction of " + x + " and " + y + " is "
				+ outPut);
	}

}
