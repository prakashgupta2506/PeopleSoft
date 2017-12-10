package com.capgemini.java.firstpackage;

public class JustLikeThat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	
	
		
		
		
				
		Employee e1=new Employee();
		e1.insert("Prakash", 1000);
		
		Employee e2=new Employee();
		e2.insert("Anjali", 2000);
		
		e1.display();
		e2.display();
		 		 
		 //Constructor
		 EmployeeConstructor e=new EmployeeConstructor("prakash",333);
		 e.display();
		 //Constructor
		 System.exit(0);
		for(int i=0;i<=3;i++){
			System.out.println(i);
		}

	}

}






class Employee{
	String name;
	int salary;
	void insert(String n,int s){
		name=n;
		salary=s;
			
	}
	
	void display(){
		System.out.println("name-" + name + ",salary-"+salary);
	}
	
}

class EmployeeConstructor{
	String name;
	int salary;
	EmployeeConstructor(String n,int s){
		name=n;
		salary=s;				
		
	}
	
	void display(){
		System.out.println("name-" + name + ",salary-"+salary);
	}
	
	
		
}



class tt{
	
	
	
	static{
		
		System.out.println("static called");
	}
	
	
	static void nn(){
		
		System.out.println("inside nn");
	}
	
}
	
