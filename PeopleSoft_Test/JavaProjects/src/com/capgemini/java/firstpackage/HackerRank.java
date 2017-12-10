package com.capgemini.java.firstpackage;
import java.util.Scanner;

/*//Java Method Overriding
class Sports {
	String getName() {
		return "Generic Sports";
	}

	void getNumberOfTeamMembers() {
		System.out.println("Each team has n players in " + getName());
	}
}

class Soccer extends Sports {
	@Override
	String getName() {
		return "Soccer Class";
	}

	void getNumberOfTeamMembers() {
		System.out.println("Each team has 11 players in " + getName());
	}

}*/





/*//Java Interface
//Divisors of 6 are 1,2,3 and 6. 1+2+3+6=12.
interface AdvancedArithmetic {
	int divisor_sum(int n);
}

class MyCalculator implements AdvancedArithmetic {

	int s;

	public int divisor_sum(int n) {
		s = n;
		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0) {
				s = s + i;	
			}

		}
		return s;
	}
	
}
*/


/*//abstract class
abstract class Book {
	String title;

	abstract void setTitle(String s);

	String getTitle() {
		return title;
	}
}

class MyBook extends Book {
	void setTitle(String s) {
		title = s;
	}

}*/
		





/*//Java Inheritance
class Animal {
	void walk() {
		System.out.println("I am walking");
	}
}

class Bird extends Animal {
	void fly() {
		System.out.println("I am flying");
	}

	void sing() {
		System.out.println("I am singing");
	}
}*/


public class HackerRank {

	public static void main(String[] args) {


		/*//Java Method Overriding
		Sports c1 = new Sports();
        Soccer c2 = new Soccer();
        System.out.println(c1.getName());
        c1.getNumberOfTeamMembers();
        System.out.println(c2.getName());
        c2.getNumberOfTeamMembers();
        */
        
        
        
		
		/*//Interface
		MyCalculator my_calculator = new MyCalculator();
		System.out.print(my_calculator.divisor_sum(6) + "\n");*/
		
		
		/*//abstract class				
		Scanner sc=new Scanner(System.in);
		String title=sc.nextLine();
		MyBook new_novel=new MyBook();
		new_novel.setTitle(title);
		System.out.println("The title is: "+new_novel.getTitle());
      	sc.close();*/
		
		
		
		
		
		/*//Java Inheritance
		Bird bird = new Bird();
		System.out.println("My superclass is: " + bird.getClass().getSuperclass().getName());	
	      bird.walk();
	      bird.fly();
	      bird.sing();*/
	      
	      
		
		
		
		
		
		/*	 //create sequence like   
		(a+2^0.b),(a+2^0.b+2^1.b) . .
		Sample Input
		2
		0 2 10
		5 3 5
		
		Sample Output
		2 6 14 30 62 126 254 510 1022 2046
		8 14 26 50 98
		
		int k;
		int v = 0;
		String s = "";
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int ii = 0; ii < t; ii++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();
			
			for (int i1 = 0; i1 < n; i1++) {

				v = 0;
				
				
				for (int j1 = 0; j1 <= i1; j1++) {

					v = v + ((int) Math.pow(2, j1)) * b;

				}

				v = a + v;
				
				s =  s+" "+v;
				
			}

			System.out.println(s.trim()); 
            s="";
		}
      
        in.close(); 
*/
    
	
		
		
        
       /* //mulitplacation table
		Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        
        for(int i=1;i<=10;i++){
        	
        System.out.println(N+"X"+i+"="+N*i);
        }
             
        System.exit(0);*/
        
	
	
	
	
		
		/*//If-Else
		
		 * If n is odd, print Weird If n is even and in the inclusive range of 2
		 * to 5 , print Not Weird If n is even and in the inclusive range of 6
		 * to 20, print Weird If n is even and greater than 20, print Not Weird
		 

		
		
		
		Scanner sc1 = new Scanner(System.in);
		int n = sc1.nextInt();
		String ans = "";
		if (n % 2 == 1 || (n % 2 == 0 && n >= 6 && n <= 20)) {
			ans = "Weird";
		} else {

			if ((n % 2 == 0 && n >= 2 && n <= 5) || (n % 2 == 0 && n > 20))
				ans = "Not Weird";

		}

		System.out.println(ans);
*/
		System.exit(0);
	}
	

}
