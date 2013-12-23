package other_practices1;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

	private static int called_times;
	
	/**
	 * power set {1, 2} -> {}, {1}, {2}, {1, 2}
	 * 
	 * The number of the power set is N^2 (N is the # of the elements in the original set)
	 * 
	 * 0 0 -> {}
	 * 0 1 -> {2}
	 * 1 0 -> {1}
	 * 1 1 -> {1, 2}
	 * 
	 * */
	
	// Time: N * N^2
	public static List<String> powerSet(int n) {
		// Generate number array
		int [] vs = new int[n];
		for (int i = 0; i < n; i++) {
			vs[i] = i + 1; // {1, 2, 3}
		}
		
		n = (1 << n) - 1;  // calculate 2^n - 1  (e.g. n = 2  ->  100 - 1  -> 11
		List<String> list = new ArrayList<String>();
		while (n >= 0) {
			StringBuilder sb = new StringBuilder();
			int temp = n, index = vs.length - 1;
			// traverse every bit of temp, then decide if element in the original set show up.
			while (index >= 0) {
				called_times++;
				if ((temp & 1) > 0) sb.append(vs[index]);
				temp >>= 1; // shift right
				index--;
			}
			list.add(sb.toString());
			n--;
		}
		return list;
	}
	
	public static void main(String [] args) {
		List<String> list = powerSet(2);
		System.out.println("==== list size: " + list.size() + " ====");
		System.out.println("==== called_times: " + called_times + " ====");
		for (String s : list) {
			System.out.print("- {");
			char [] cc = s.toCharArray();
			for (int i = 0; i < cc.length; i++) {
				if (i != cc.length - 1) System.out.print(cc[i] + ", ");
				else System.out.print(cc[i]);
			}
			System.out.println("}");
		}
	}
}
