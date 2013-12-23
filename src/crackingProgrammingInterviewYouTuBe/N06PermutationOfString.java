package crackingProgrammingInterviewYouTuBe;

import java.util.ArrayList;
import java.util.List;

public class N06PermutationOfString {

	private static int called_times = 0;
	
	// Time: Sum( (n-1) * n! )  n = 1, 2, 3, ...
	public static List<String> printPermutationOfString(String s) {
		// Base case
		if (s.length() == 1) {
			List<String> list = new ArrayList<String>();
			list.add(new String(s));
			called_times++;
			return list;
		}

		// C -> B
		char last_char = s.toCharArray()[s.length() - 1];
		// ABC -> AB -> A
		List<String> list = printPermutationOfString(s.substring(0, s.length() - 1));
		List<String> n_list = new ArrayList<String>();
		
		for (String str : list) {
			char [] cc = str.toCharArray();
			for (int i = 0; i <= cc.length; i++) {
				n_list.add(combinate(cc, i, last_char));
			}
		}
		
		return n_list;
	}
	
	private static String combinate(char [] cc, int index, char last_char) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cc.length; i++) {
			called_times++;
			if (i == index) sb.append(last_char);
			sb.append(cc[i]);
		}
		if (index == cc.length) {
			sb.append(last_char);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "ABC";
		List<String> list = printPermutationOfString(str);
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println("==== permutation size: " + list.size() + " called_times: " + called_times + " ====");
	}
}
