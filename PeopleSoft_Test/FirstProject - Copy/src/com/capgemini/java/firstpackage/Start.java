package src.com.capgemini.java.firstpackage;

class Vehicle {
int speed;
int color;
int wheels;
int cost;
void attributes(int wheels){	
	System.out.println("no. of wheels "+wheels);
}

}


class TwoWheeler extends Vehicle{
void attributestwowheeler(){
	System.out.println("inside two wheeler");
}
	
}

class FourWheeler extends Start{
}

public class Start{
public static void main(String arg[]){
	TwoWheeler bike=new TwoWheeler();
	bike.attributes(4);
	bike.attributestwowheeler();
}
}