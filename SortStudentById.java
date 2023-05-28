package customSorting;
import java.util.Comparator;
import SDBMS.Student;


	
   public class SortStudentById implements Comparator<Student>{
	  
	public int compare(Student x, Student y) {
		
		return x.getId().compareTo(y.getId());
	}
	  
   }
   

