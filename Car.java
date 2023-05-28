package customException;

public class Car {
  String id;
  String name;
  
  static int count=101;
  
public Car( String name) {
	
	this.id = "JSP"+count;
	this.name = name;
	count++;
}
  public static void main(String[] args) {
	Car c1=new Car("suzuki");
	System.out.println(c1.id+" "+c1.name);
	
	Car c2=new Car("Honda");
	System.out.println(c2.id+" "+c2.name);
	
}
  
}
