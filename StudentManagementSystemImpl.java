package SDBMS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customException.InavlidChoiceException;
import customException.StudentNotFoundException;

public class StudentManagementSystemImpl implements StudentManagementSystem {

	Scanner scan=new Scanner(System.in);
	Map<String,Student>db=new LinkedHashMap<String, Student>();
	
	@Override
	public void addStudent() {
		System.out.println("Enter student Id :");
		String id=scan.next();
		System.out.println("Enter student Name :");
		String name=scan.next();
		System.out.println("Enter student Age :");
		int age=scan.nextInt();
		System.out.println("Enter student Marks :");
		int marks=scan.nextInt();
		Student std=new Student(id, name, age, marks);
		db.put(std.getId(), std);
		System.out.println("Student record inserted successfully");
		System.out.println("Student Id is :"+std.getId());
		
	}

	
	@Override
	public void displayStudent() {
		System.out.println("Enter student Id");
		String id = scan.next();
		id = id.toUpperCase();

		if (db.containsKey(id)) {
			Student std = db.get(id);
			System.out.println("Id :" + std.getId());
			System.out.println("Name :" + std.getName());
			System.out.println("Age :" + std.getAge());
			System.out.println("Marks :" + std.getMarks());

		} else {
			try {
				String message = "Student with " + id + " Id is not found!";
				throw new StudentNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void displayAllStudents() {
		
		if(db.size()!=0) {
			System.out.println("Student deatiles are followes..");
			Set <String>keys=db.keySet();
			for(String key:keys) {
				System.out.println(db.get(key));
		}
	}
			else {
				try {
					String message="Student DataBase is Empty nothing to Display!";
					throw new StudentNotFoundException(message);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
	}

	@Override
	public void removeSudent() {
		System.out.println("Enter student Id:");
		String id=scan.next();
	     id=id.toUpperCase();
	     if(db.containsKey(id)) {
	    	 System.out.println("Student record found!");
	    	 System.out.println(db.get(id));
	    	 db.remove(id);
	    	 System.out.println("Student record Deleted successfully..");
	     }else {
	    	 try {
					String message = "Student with " + id + " Id is not found!";
					throw new StudentNotFoundException(message);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					
				}	
	    	 }
		
	}

	@Override
	public void removeAllStudents() {
		System.out.println("Student records avialable : "+db.size());
		if(db.size()!=0) {
			db.clear();
			System.out.println("All students records deleted sucessfully!");
			System.out.println("Student records avialable : "+db.size());
		}else {
			try {
				String message="Student DataBase is Empty - nothing to Delete!";
				throw new StudentNotFoundException(message);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	@Override
	public void updateStudent() {
		System.out.println("Eneter student Id:");
		String id=scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id)) {
			Student std=db.get(id);
			System.out.println("1:Update Age\n2:Update Name\n3:Update Marks");
			System.out.println("Enter ur Choice");
			int choice=scan.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Age");
				int age=scan.nextInt();
				std.setAge(age);
				break;
				
			case 2:
				System.out.println("Enter Name");
				String name=scan.next();
				std.setName(name);
				break;
				
			case 3:
				System.out.println("Enter Marks");
				int marks=scan.nextInt();
				std.setMarks(marks);
				break;
				default:
					try {
						String message="invalid choice,kindly enter valid choice";
						throw new InavlidChoiceException(message);
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
			}
		}
		
	}

	@Override
	public void countStudents() {
		System.out.println("No of student records :"+db.size());
		
	}

	@Override
	public void sortStudents() {
		Set<String>keys=db.keySet();
		List<Student>list=new ArrayList<Student>();
		for(String key:keys) {
			list.add(db.get(key));
		}
		System.out.println("1:Sort By Id\n2:Sort By Name\n3:Sort By Age\n4:Sort By Marks");
		System.out.println("Enter ur choice");
		int choice =scan.nextInt();
		switch(choice) {
		case 1:
			Collections.sort(list,new customSorting.SortStudentById());
			display(list);
			break;
			
		case 2:
			Collections.sort(list,new customSorting.SortStudentByName());
			display(list);
			break;
			
		case 3:
			Collections.sort(list,new customSorting.SortStudentByAge());
			display(list);
			break;
			
		case 4:
			Collections.sort(list,new customSorting.SortStudentByMarks());
			display(list);
			break;
			default:
				try {
					String message="invalid choice,kindly enter valid choice";
					throw new InavlidChoiceException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			
		}
		
	}
	private static void display(List<Student>list) {
		for(Student s:list) {
			System.out.println(s);
		}
	}

	@Override
	public void getStudentWithHighestMarks() {
		if(db.size()>=2) {
		Set<String>keys=db.keySet();
		List<Student>list=new ArrayList<Student>();
		for(String key:keys) {
			list.add(db.get(key));
		}
		Collections.sort(list, new customSorting.SortStudentByMarks());
		System.out.println(list.get(list.size()-1));
	
		
	}
	}


	@Override
	public void getStudentWithLowestMarks() {
		if(db.size()>=2) {
		Set<String>keys=db.keySet();
		List<Student>list=new ArrayList<Student>();
		for(String key:keys) {
			list.add(db.get(key));
		}
		Collections.sort(list, new customSorting.SortStudentByMarks());
		System.out.println(list.get(0));
	
		}
	}

}
