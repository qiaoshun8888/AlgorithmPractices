package crackingTheCodingInterview;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class MyArrayList {
	
	public static void main(String args[]) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(1);
		list.add(7);
		list.add(7);
		list.add(5);
		
		Set<Integer> set = new LinkedHashSet<Integer>(list);
		list.clear();
		list.addAll(set);
		
		for (Integer i : list) {
			System.out.println(i);
		}
	}
}
