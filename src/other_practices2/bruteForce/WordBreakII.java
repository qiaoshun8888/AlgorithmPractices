package other_practices2.bruteForce;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {

	public int callTimes = 0;

	public List<String> wordBreak(String s, Set<String> dict) {
		List<String> list = new ArrayList<String>();
		// Input checking.
		if (s == null || s.length() == 0 ||
				dict == null || dict.size() == 0) return list;
		int len = s.length();
		// memo[i] is recording,
		// whether we cut at index "i", can get one of the result.
		boolean memo[] = new boolean[len];
		for (int i = 0; i < len; i ++) memo[i] = true;
		StringBuilder tmpStrBuilder = new StringBuilder();
		helper(s, 0, tmpStrBuilder, dict, list, memo);
		return list;
	}

	private void helper(String s, int start, StringBuilder tmpStrBuilder,
			Set<String> dict, List<String> list, boolean[] memo) {
		//Base case.
		if (start >= s.length()) {
			list.add(tmpStrBuilder.toString().trim());
			return;
		}
		int listSizeBeforeRecursion = 0;
		for (int i = start; i < s.length(); i ++) {
			callTimes++;
			//if (memo[i] == false) continue;
			String curr = s.substring(start, i + 1);
			if (!dict.contains(curr)) continue;
			// Have a try.
			tmpStrBuilder.append(curr);
			tmpStrBuilder.append(" ");
			// Do recursion.
			listSizeBeforeRecursion = list.size();
			helper(s, i + 1, tmpStrBuilder, dict, list, memo);
			//if (list.size() == listSizeBeforeRecursion) memo[i] = false;
			// Roll back.
			tmpStrBuilder.setLength(tmpStrBuilder.length() -
					curr.length() - 1);
		}
	}

	public static void main(String[] args) {
		// String s = "catsanddog";
		String s = "aaaaaaaaaaaaaaaaaaaa";
		Set<String> dict = new HashSet<String>();
		// String[] words = {"cat", "cats", "and", "sand", "dog"};
		String[] words = {"a", "aa"};
		for (String word : words) {
			dict.add(word);
		}
		WordBreakII o = new WordBreakII();
		List<String> results = o.wordBreak(s, dict);
		for (String str : results) {
			System.out.println(str);
		}
		System.out.println("callTimes: " + o.callTimes);

		s = "";
	}
}
