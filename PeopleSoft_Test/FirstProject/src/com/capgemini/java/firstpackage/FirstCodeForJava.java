package src.com.capgemini.java.firstpackage;
import  com.capgemini.java.secondpackage.*;
public class FirstCodeForJava {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		
		
		
		String we="SCR01_TC001;SCRO1_TC001_2";
		System.out.println(we.split(";")[1]);
		
	
		
		System.exit(0);
		//automatically constructor of Test is called when it is extended by ExtendTest		
		ExtendTest c=new ExtendTest();
				
		
		
		
	//scope of variable	

		ExtendScopeOfVariable TestScope=new ExtendScopeOfVariable();
		TestScope.showvariablevalues();
		System.out.println(TestScope.kk);//accessible via extended class
		
		ScopeOfVariable TestScope1 =new ScopeOfVariable();
		//System.out.println(TestScope1.i);//compile error since i is private
		System.out.println(TestScope1.j);//accessible since j is public
		//System.out.println(TestScope1.k);//compile error since k is protected
		//System.out.println(TestScope1.h);//compile error since h is default scope
		
		
		
		//aray
		int arr[];
		arr=new int[3];
		for(int i=0;i<arr.length;i++){
			arr[i]=i;
		}
		
		for(int j=0;j<arr.length;j++){
			System.out.print(arr[j]);
		}
		
		String names[]=new String[10];
		
		String names1[]={"A","B","C"};
		System.out.println(names1.length);
		System.out.println(names1[0]);
		for(String strValues:names1){  
	        System.out.println(strValues);  
	    } 
		
		
		
		String names2[]=new String[]{"A","B","C"};		
		System.out.println(names2[0]);
		
		
	
		//switch
		int a=5;
		
		switch(a){
			case 1:
				 System.out.println("case 1");
				 break;
			case 5://or 2+3
				System.out.println("case 5");
				 break;
				 
			default:
				System.out.println("default");
		
		}
		
		// if-else
		int marks = 65;
		if (marks < 50) {
			System.out.println("fail");
		} else if (marks >= 50 && marks < 60) {
			System.out.println("D grade");
		} else {
			System.out.println("Invalid!");
		}


//Java Labeled For Loop
		aa: for (int i = 1; i <= 3; i++) {
			bb: for (int j = 1; j <= 3; j++) {
				if (i == 2 && j == 2) {
					break aa;
				}
				System.out.println(i + " " + j);
			}
		}
	

		
//For-each loop
		int arrr[]={12,23,44,56,78};  
	    for(int i:arrr){  
	        System.out.println(i);  
	    }  
		
	    
	    
	 //infinite for loop
	   /* for(;;){  
	        System.out.println("infinitive loop");  
	    }  */
	
	    
	    
	    
	 //while
	    int i2=1;  
	    while(i2<=10){  
	        System.out.println(i2);  
	    i2++;  
	    }  
	    
	    //infinite
	    /*while(true){  
	        System.out.println("infinitive while loop");  
	    }  */
	    
	
		// do-while
		int i1 = 1;
		do {
			System.out.println(i1);
			i1++;
		} while (i1 <= 10);

		// infinite-
		/*do {
			System.out.println("infinitive do while loop");
		} while (true);*/

		
	    
	    
	   // continue
		for (int i11 = 1; i11 <= 10; i11++) {
			if (i11 == 5) {
				continue;
			}
			System.out.println(i11);
		}
	    
	    
	    
	   // documentation-
	    /** The Calculator class provides methods to get addition and subtraction of given 2 numbers.*/  
		class Calculator {
			/** The add() method returns addition of given numbers. */
			public int add(int a, int b) {
				return a + b;
			}

			/** The sub() method returns subtraction of given numbers. */
			public int sub(int a, int b) {
				return a - b;
			}
		} 
		
		// Compile it by javac tool: javac Calculator.java
		// Create Documentation API by javadoc tool: javadoc Calculator.java
		// Now, there will be HTML files created for your Calculator class in
		// the current directory. Open the HTML files and see the explanation of
		// Calculator class provided through documentation comment.

	
		
		
		
		//ternary operator
		 String g;
		 g=3<4?"no":"yes";
		 System.out.println(g);
		//
		 
		 
		
		
		AddClass Add=new AddClass();
		Add.add(3, 6);
		System.out.println("Added Vaulue is "+Add.returnaddedvalue(2, 2));
		Add.add(3, 5, 34);
		
		Calculation calc=new Calculation();
		calc.Addition(5, 6);
		calc.Subtraction(5, 2);
		
//		-------------------------------------
		Prakash p =new Prakash();
		p.sleeping();
		p.walking();
		

//		------------------------------
		
		Student st1=new Student(45,"Prakash");
		st1.show();
		
		//acccessing variable of Student class
		
		Student st2=new Student(12,"Gupta");
		st2.rollNo=43;
		st2.showRollNo();
		
		
		Student st3=new Student(12); 
		st3.showThisVariable();
		

	
		//
		
		
		
	}

}	



abstract class Person{
	
	abstract void sleeping();
	 abstract void walking();
}

class Prakash extends Person{
	
	void sleeping(){
		System.out.println("Prakash is sleeping");
		
		
		
	}
	
	void walking(){		
		System.out.println("Prakash is walking");
		
		
	}
	
}





class Student{
	int id;
	String name;
	int rollNo;
	int thiss;
	 Student(int stid,String stname){
		id=stid;
		name=stname;
		
	}
	 
	 Student(int thiss){
		this.thiss=thiss;
		
	 }
	 
	 
	 void showThisVariable(){
		 System.out.println(this.thiss);
	 }
	
	void show(){
		System.out.println("New student id is-" +id +" and name is-"+name);
	}
	
	
	void showRollNo(){
		System.out.println("Roll No "+rollNo);
	}
	
}


class ExtendScopeOfVariable extends ScopeOfVariable{
	int kk=k;
	void showvariablevalues(){
		System.out.println(k);//k is accesible since k is protected and can be accesed by extending the class
		//System.out.println(h); gives error since h has default scope,only accessible in it package
	}
}



class Test{
	
	Test(){
		System.out.println("Automaticallly called upon extending");
	}
	
}

class ExtendTest extends Test{
	
}
