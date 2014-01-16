package programcreek;

import java.util.*;

public class ComparatorExample {

	static class Friend{
		int age;
		
		public Friend(int age) {
			this.age = age;
		}
		
		public String toString() {
			return "Friend (age " + age + ")";
		}
	}
	
	static class AgeComparator implements Comparator<Friend> {
		@Override
		public int compare(Friend o1, Friend o2) {
			if (o1.age > o2.age) return 1;
			else if (o1.age < o2.age) return -1;
			return 0;
		}
	}
	
	public static void main(String[] args) {
		Friend f1 = new Friend(33);
		Friend f2 = new Friend(17);
		Friend f3 = new Friend(25);
		Friend f4 = new Friend(99);
		
		List<Friend> list = new ArrayList<Friend>();
		list.add(f1);
		list.add(f2);
		list.add(f3);
		list.add(f4);
		
		// Ascending Order
		Collections.sort(list, new AgeComparator());
		
		for (Friend f : list) {
			System.out.println(f);
		}
		System.out.println();
		
		// Descending Order
		Collections.sort(list, Collections.reverseOrder(new AgeComparator()));
		
		for (Friend f : list) {
			System.out.println(f);
		}
	}
}



