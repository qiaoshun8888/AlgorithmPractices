package programcreek;

import java.util.*;

public class ComparableExample {

	static class Friend implements Comparable<Friend> {
		int age;

		public Friend(int age) {
			this.age = age;
		}

		@Override
		public int compareTo(Friend o) {
			if (age > o.age)
				return 1;
			else if (age < o.age)
				return -1;
			else
				return 0;
		}
		
		@Override
		public String toString() {
			return "Friend age(" + age + ")";
		}
	}

	public static void main(String[] args) {
		Friend f1 = new Friend(20);
		Friend f2 = new Friend(15);
		Friend f3 = new Friend(14);

		if (f1.compareTo(f2) > 0)
			System.out.println("Friend 1 is older.\n");
		else
			System.out.println("Friend 2 is older.\n");
		
		List<Friend> list = new ArrayList<Friend>();
		list.add(f1);
		list.add(f2);
		list.add(f3);
		
		Collections.sort(list);
		
		for (Friend f : list) {
			System.out.println(f);
		}
	}
}
