package SDBMS;

public class Student {
  private String id;
  private String name;
  private int age;
  private int marks;
  
  static int count=1;
  
 Student( String id,String name, int age, int marks) {
	
	this.id = "JSP"+count;
	this.name = name;
	this.age = age;
	this.marks = marks;
	count++;
}
  public String toString() {
	  return "Id:"+id+" Name:"+name+ " Age:"+age+ " Marks:"+marks;
  }
public String getId() {
	return id;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public int getMarks() {
	return marks;
}
public void setMarks(int marks) {
	this.marks = marks;
}
  
  
}
