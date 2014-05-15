package leetcode;

public class InterleavingString {

	public boolean isInterleave(String s1, String s2, String s3) {
		if (((s1 == null || s2 == null) && s3 != null)
				|| ((s1 != null || s2 != null) && s3 == null)
				|| (s1.length() + s2.length() != s3.length()))
			return false;
		
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		char[] c3 = s3.toCharArray();

		boolean[][] matrix = new boolean[s1.length() + 1][s2.length() + 1];

		matrix[0][0] = true;

		for (int i1 = 1; i1 < s1.length(); i1++) {
			if (c3[i1 - 1] == c1[i1 - 1])
				matrix[i1][0] = true;
			else
				break;
		}

		for (int i2 = 1; i2 < s2.length(); i2++) {
			if (c3[i2 - 1] == c2[i2 - 1])
				matrix[0][i2] = true;
			else
				break;
		}

		for (int i = 1; i <= c1.length; i++) {
			for (int j = 1; j <= c2.length; j++) {
				if (c1[i - 1] == c3[i + j - 1])
					matrix[i][j] |= matrix[i - 1][j];
				if (c2[j - 1] == c3[i + j - 1])
					matrix[i][j] |= matrix[i][j - 1];
			}
		}

		return matrix[c1.length][c2.length];
	}

	public boolean isInterleave2(String s1, String s2, String s3) {
		if (((s1 == null || s2 == null) && s3 != null)
				|| ((s1 != null || s2 != null) && s3 == null)
				|| (s1.length() + s2.length() != s3.length()))
			return false;

		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		char[] c3 = s3.toCharArray();

		return isInterleaveHelper(c1, c2, c3, 0, 0, 0);
	}

	private boolean isInterleaveHelper(char[] c1, char[] c2, char[] c3, int i1,
			int i2, int i3) {

		while (i3 < c3.length) {
			// System.out.println(i1 + " " + i2 + " " + i3);
			if ((i1 < c1.length && c3[i3] == c1[i1])
					&& (i2 >= c2.length || c3[i3] != c2[i2])) {
				System.out.print(c1[i1] + " ");
				i3++;
				i1++;
			} else if ((i2 < c2.length && c3[i3] == c2[i2])
					&& (i1 >= c1.length || c3[i3] != c1[i1])) {
				System.out.print(c2[i2] + " ");
				i3++;
				i2++;
			} else if (i1 < c1.length && i2 < c2.length && c3[i3] == c1[i1]
					&& c3[i3] == c2[i2]) {
				i3++;
				return isInterleaveHelper(c1, c2, c3, i1 + 1, i2, i3)
						|| isInterleaveHelper(c1, c2, c3, i1, i2 + 1, i3);
			} else {
				System.out.println(i1 + " " + i2 + " " + i3);
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// String s1 = "aabcc";
		// String s2 = "dbbca";
		// String s3 = "aadbbcbcac";

		// String s1 = "abfgb";
		// String s2 = "bcdeg";
		// String s3 = "abbcdefggb";

		// String s1 = "cc";
		// String s2 = "aca";
		// String s3 = "acacc";

		// String s1 = "abc";
		// String s2 = "aacbb";
		// String s3 = "aabacbcb";

		String s1 = "a";
		String s2 = "b";
		String s3 = "ab";

		InterleavingString o = new InterleavingString();

		System.out.println(o.isInterleave(s1, s2, s3));
		// http://www.cnblogs.com/lichen782/p/leetcode_interleaving_string.html
	}
}
