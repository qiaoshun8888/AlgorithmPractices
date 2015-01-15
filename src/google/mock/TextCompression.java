package google.mock;

public class TextCompression {

	public String compress(String text) {
		if (text == null || text.length() == 0) return "";
		StringBuilder sb = new StringBuilder();
		char c = 0;
		int start = 0, end = 0;
		while (end < text.length()) {
			c = text.charAt(start);
			end = start + 1;
			while (end < text.length() && text.charAt(end) == c) {
				end++;
			}
			int count = end - start;
			if (count > 2) {
				sb.append(count + "x" + c);
			} else {
				sb.append(text.substring(start, end));
			}
			start = end;
		}
		return sb.toString();
	}

	// Solve decompression ambiguity
	public String compressImproved(String text) {
		if (text == null || text.length() == 0) return "";
		StringBuilder sb = new StringBuilder();
		char c = 0;
		int start = 0, end = 0;
		while (end < text.length()) {
			c = text.charAt(start);
			end = start + 1;
			while (end < text.length() && text.charAt(end) == c) {
				end++;
			}
			int count = end - start;
			if (count > 2) {
				sb.append(count + "x" + c + ",");  // use comma to separate the strings
			} else {
				sb.append(text.substring(start, end) + ",");  // use comma to separate the strings
			}
			start = end;
		}
		String result = sb.toString();
		return result.substring(0, result.length() - 1);  // get rid of the last useless comma
	}

	public static void main(String[] args) {
		String[] testCases = {
				null,
				"",
				"aaabbbbaaccc",
				"aaaaaaaaaa",
				"aabbccdd",
				"444xbbb,,,!!!",
		};
		String[] expectedResults = {
				"",
				"",
				"3xa4xbaa3xc",
				"10xa",
				"aabbccdd",
				"3x4x3xb3x,3x!",
		};
		String[] expectedResultsForImprovedAlgo = {
				"",
				"",
				"3xa,4xb,aa,3xc",
				"10xa",
				"aa,bb,cc,dd",
				"3x4,x,3xb,3x,,3x!",
		};
		TextCompression o = new TextCompression();
		for (int i = 0; i < testCases.length; i++) {
			String result = o.compress(testCases[i]);
			if (result.equals(expectedResults[i])) {
				System.out.println("True");
			} else {
				System.out.println("False! Got result: " + result + ", but expect: " + expectedResults[i]);
			}
		}	

		System.out.println("\nTest for the improved algorithm:");

		for (int i = 0; i < testCases.length; i++) {
			String result = o.compressImproved(testCases[i]);
			if (result.equals(expectedResultsForImprovedAlgo[i])) {
				System.out.println("True");
			} else {
				System.out.println("False! Got result: " + result + ", but expect: " + expectedResults[i]);
			}
		}	
	}
}
