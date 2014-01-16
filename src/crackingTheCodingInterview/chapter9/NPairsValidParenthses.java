package crackingTheCodingInterview.chapter9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NPairsValidParenthses {

	private static int called_times = 0;
	public static List<String> generateParenthese(int n) {
		Set<String> set = new HashSet<String>();
		if (n == 1) {
			List<String> list = new ArrayList<String>();
			list.add("()");
			return list;
		}
		List<String> l = new ArrayList<String>();
		for (String s : generateParenthese(n - 1)) {
			char[] cc = s.toCharArray();

			for (int i = 0; i <= cc.length; i++) {
				String s_temp = insertAParenthsis(cc, i);
				if (!set.contains(s_temp)) {
					set.add(s_temp);
					l.add(s_temp);
				}
			}
		}
		
		return l;
	}
	
	private static String insertAParenthsis(char[] cc, int index) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cc.length; i++) {
			called_times++;
			if (index == i) {
				sb.append("()");
			}
			sb.append(cc[i]);
		}
		if (index == cc.length) {
			sb.append("()");
		}
		return sb.toString();
	}
	
	public static ArrayList<String> generateParentheseImprove(int count) {
		char[] cc = new char[count * 2];
		ArrayList<String> list = new ArrayList<String>();
		addParenthese(list, count, count, cc, 0);
		return list;
	}
	private static void addParenthese(ArrayList<String> list, int left_rem, int right_rem, char[] cc, int count) {
		called_times++;
		if (left_rem < 0 || right_rem < left_rem) return;
		if (left_rem == 0 && right_rem == 0) {
			String s = String.copyValueOf(cc);
			list.add(s);
		}
		else {
			if (left_rem > 0) {
				cc[count] = '(';
				addParenthese(list, left_rem - 1, right_rem, cc, count + 1);
			}
			if (right_rem > left_rem) {
				cc[count] = ')';
				addParenthese(list, left_rem, right_rem - 1, cc, count + 1);
			}
		}
	}
	
	public static void main(String[] args) {
		int N = 3;
		
		for (String s : generateParenthese(N)) {
			System.out.println(s);
		}
		System.out.println("=== called_times: " + called_times);
		called_times = 0;
		System.out.println();
		
		for (String s : generateParentheseImprove(N)) {
			System.out.println(s);
		}
		System.out.println("=== called_times: " + called_times);
	}
}
