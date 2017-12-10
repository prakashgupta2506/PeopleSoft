package src.com.capgemini.java.firstpackage;

class Shape{
		void CalculateArea(){
			
		}
		
}


class Circle extends Shape{
	void CalculateArea(int radius){
		System.out.println("Area of Circle "+3.14*radius*radius);
	}
}

class Rectangle extends Shape{
	void CalculateArea(int length,int breadth){
		System.out.println("Area of Rectangle "+length*breadth);
	}
}

class Square extends Shape{
	void CalculateArea(int length){
		System.out.println("Area of Square "+length*length);
	}
}

public class Test1 {

	public static void main(String[] args) {
		Circle c=new Circle();
		c.CalculateArea(23);
		
		Rectangle r=new Rectangle();
		r.CalculateArea(12, 11);
		
		Square s=new Square();
		s.CalculateArea(90);
		
				

	}

}
