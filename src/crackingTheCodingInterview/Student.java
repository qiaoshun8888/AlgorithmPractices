package crackingTheCodingInterview;
public class Student {
	int id;
	String name;

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Student(int sid, String sname) {
		id = sid;
		name = sname;
	}

	public static Student [] generateStudents(int capacity) {
		Student [] students = new Student[capacity];
		for (int i=0; i<capacity; i++) {
			students[i] = new Student(i, "Student " + i);
		}
		return students;
	}

	public String toString() {
		return "S[" + id + "] - " + name;
	}
}
