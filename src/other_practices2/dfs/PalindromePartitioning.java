package other_practices2.dfs;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	/**
	 * Given a string s, partition s such that every substring of the partition is a palindrome.

		Return all possible palindrome partitioning of s.

		For example, given s = "aab",
		Return

		  [
		    ["aa","b"],
		    ["a","a","b"]
		  ]
	 */

	public List<List<String>> partition(String s) {
		List<List<String>> results = new ArrayList<List<String>>();
		if (s == null || s.length() == 0) return results;
		List<String> list = new ArrayList<String>();
		dfs(s, list, results);
		return results;
	}

	private void dfs(String s, List<String> list, List<List<String>> results) {
		if (s.length() == 0) {
			results.add(new ArrayList<String>(list));
			return;
		}

		for (int i = 0; i < s.length(); i++) {
			String subStr = s.substring(0, i + 1);
			if (isPalindrome(subStr)) {
				list.add(subStr);
				dfs(s.substring(i + 1), list, results);
				list.remove(list.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String s) {
		int start = 0, end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--)) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "aab";
		PalindromePartitioning o = new PalindromePartitioning();
		List<List<String>> results = o.partition(s);
		for (List<String> list : results) {
			System.out.println(list);
		}
	}
}
