
public class MyString {
	
	public static void main(String args []) {
		Student [] students = Student.generateStudents(10);
		
		// O(n^2)
		String str = new String();
		for (Student s : students) {
			str += s.name + " ";
		}
		System.out.println(str);
		
		// O(n) - StringBuffer is synchronous which means thread safe.
		StringBuffer sb = new StringBuffer();
		for (Student s : students) {
			sb.append(s.name + " ");
		}
		System.out.println(sb.toString());
		
		// O(n) - StringBuilder is asynchronous which means faster than StringBuilder
		StringBuilder sbu = new StringBuilder();
		for (Student s : students) {
			sbu.append(s.name + " ");
		}
		System.out.println(sbu.toString());
	}
}
