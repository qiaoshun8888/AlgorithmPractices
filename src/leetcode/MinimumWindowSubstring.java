package leetcode;

/**
 * MinimumWindowSubstring.java
 * 
 * Description: Given a string S and a string T, find the minimum window in S
 * which will contain all the characters in T in complexity O(n).
 * 
 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the emtpy string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 * 
 * Solution Reference:
 * http://leetcode.com/2010/11/finding-minimum-window-in-s-which.html
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 31, 2014
 */

public class MinimumWindowSubstring {

	public String minWindow(String S, String T) {
		if (S == null || S.length() == 0 || T == null || T.length() == 0
				|| T.length() > S.length())
			return new String();

		char[] cc = S.toCharArray();
		char[] tt = T.toCharArray();

		int[] needToFind = new int[256];
		for (int i = 0; i < tt.length; i++) {
			needToFind[(int) tt[i]]++;
		}

		int[] hasFound = new int[256];

		int count = 0, minWinLength = Integer.MAX_VALUE, minWinStart = -1, minWinEnd = -1;

		for (int winStart = 0, winEnd = 0; winEnd < cc.length; winEnd++) {
			// If cc[winEnd] is not the character need to find, continue
			int index = (int) cc[winEnd];
			if (needToFind[index] == 0)
				continue;
			hasFound[index]++;

			// Increment count by 1 after we found a character.
			if (hasFound[index] <= needToFind[index])
				count++;

			// If we found all the characters
			if (count == tt.length) {
				// Advance winStart as far as possible, until the window
				// constrain break
				while (needToFind[(int) cc[winStart]] == 0 || // skip the
																// character we
																// don't need to
																// find
						hasFound[(int) cc[winStart]] > needToFind[(int) cc[winStart]]) {
					hasFound[(int) cc[winStart]]--;
					winStart++;
				}

				// Update minnimum window
				int winLength = winEnd - winStart + 1;
				if (minWinLength > winLength) {
					minWinLength = winLength;
					minWinStart = winStart;
					minWinEnd = winEnd;
				}
			}
		}

		if (minWinStart == -1)
			return new String();
		return S.substring(minWinStart, minWinEnd + 1);
	}

	public static void main(String[] args) {
		MinimumWindowSubstring o = new MinimumWindowSubstring();
		String S = "a"; // "ADOBECODEBANC";
		String T = "b"; // "ABC";
		System.out.println(o.minWindow(S, T));
	}
}
