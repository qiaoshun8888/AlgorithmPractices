package crackingTheCodingInterview;
import java.util.HashMap;

public class MyHashTable {
	
	public static void main(String args[]) {
		Student [] students = Student.generateStudents(10);
		HashMap<Integer, Student> students_map = new HashMap<Integer, Student>();
		for (Student s : students) {
			students_map.put(s.id, s);
			System.out.println(s.id + "\t" + s.name);
		}
		
		System.out.println(students_map.size());
	}
}