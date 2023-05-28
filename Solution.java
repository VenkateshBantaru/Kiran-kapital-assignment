package SDBMS;

import java.util.Scanner;

import customException.InavlidChoiceException;

public class Solution {
public static void main(String[] args) {
	System.out.println("Welcome To Students DataBase Management System!!");
	System.out.println("-------------------------------------------------");
	Scanner scan=new Scanner(System.in);
	StudentManagementSystem sms=new StudentManagementSystemImpl();//upcasting
	while(true) {
		System.out.println("1:Add Student\n2:Display Student");
		System.out.println("3:Display All Students\n4:Remove student");
		System.out.println("5:Remove All Students\n6:Update student");
		System.out.println("7:Count Students\n8:Sort students");
		System.out.println("9:Get Student With Highest Marks\n10:Get Student With Lowest Marks\n11:EXIT");
	    System.out.println("Choose ur Choice:");
	    int choice=scan.nextInt();
	    
	    switch(choice) {
	    case 1:
	    	sms.addStudent();
	    	break;
	    	
	    case 2:
	    	sms.displayStudent();
	    	break;
	    	
	    case 3:
	    	sms.displayAllStudents();
	    	break;
	    	
	    case 4:
	    	sms.removeSudent();
	    	break;
	    	
	    case 5:
	    	sms.removeAllStudents();
	    	break;
	    	
	    case 6:
	    	sms.updateStudent();
	    	break;
	    	
	    case 7:
	    	sms.countStudents();
	    	break;
	    	
	    case 8:
	    	sms.sortStudents();
	    	break;
	    	
	    case 9:
	    	sms.getStudentWithHighestMarks();
	    	break;
	    	
	    case 10:
	    	sms.getStudentWithLowestMarks();
	    	break;
	    	
	    case 11:
	    	System.out.println("Thank You!!");
	    	System.exit(0);
	    	break;
	    	default:
	    		try {
	    			String msg="Inavlid Choice!! Plz select above given options ?";
	    			throw new InavlidChoiceException(msg);
	    		}
	    		catch(Exception e) {
	    			System.out.println(e.getMessage());
	    		}
	    		 scan.close();
	    		System.out.println("-----------------------------------------");
	    }
	   
	
}
	
}

}
