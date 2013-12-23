package chapter7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrimeFactors {

	public static int getKthNumber(int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> buffer_list = new ArrayList<Integer>();
		list.add(1);
		buffer_list.add(1);
		int new_added = 0;
		while (list.size() - 1 < k) {
			 // There exists unnecessary access
			// e.g. always from the top of the list, actually we don't need do that
			// we can access from [1+count*3]
			int temp = new_added;
			new_added = 0;
			for (int v : list.subList(list.size() - temp - 1, list.size())) {
				for (int i = 3; i <= 7; i+=2) {
					if (!list.contains(v*i)) {
						buffer_list.add(v*i);
						new_added++;
					}
				}				
			}
			list = new ArrayList<Integer>(buffer_list);
		}
		return list.get(k);
	}
	
	public static int getKthMagicNumber(int k) {
		if (k < 0) return 0;
		
		int val = 0;
		Queue<Integer> queue3 = new LinkedList<Integer>();
		Queue<Integer> queue5 = new LinkedList<Integer>();
		Queue<Integer> queue7 = new LinkedList<Integer>();
		
		queue3.add(1);
		
		for (int i = 0; i <= k; i++) {
			int v3 = queue3.size() > 0 ? queue3.peek() : Integer.MAX_VALUE;
			int v5 = queue5.size() > 0 ? queue5.peek() : Integer.MAX_VALUE;
			int v7 = queue7.size() > 0 ? queue7.peek() : Integer.MAX_VALUE;
			val = Math.min(v3, Math.min(v5, v7));
			if (val == v3) {
				queue3.remove();
				queue3.add(3 * val);
				queue5.add(5 * val);
			}
			else if (val == v5) {
				queue5.remove();
				queue5.add(5 * val);
			}
			else if (val == v7) {
				queue7.remove();
			}
			queue7.add(7 * val);
		}
		
		return val;
	}
	
	
	
	public static void main(String [] args) {
		System.out.println(getKthNumber(5));
		System.out.println(getKthMagicNumber(5));
	}
}
