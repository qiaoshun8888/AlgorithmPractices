package programcreek;

public class ComparableExample {

	public static void main(String[] args) {
		Friend f1 = new Friend(20);
		Friend f2 = new Friend(25);
		
		if (f1.compareTo(f2) > 0)
			System.out.println("Friend 1 is older.");
		else
			System.out.println("Friend 2 is older.");
	}
}

class Friend implements Comparable<Friend> {
	int age;
	
	public Friend(int age) {
		this.age = age;
	}
	
	@Override
	public int compareTo(Friend o) {
		if (age > o.age) return 1;
		else if (age < o.age) return -1;
		else return 0;
	}
}
