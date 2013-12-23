package crackingProgrammingInterviewYouTuBe;

public class N33ReverseWordsInAPhrase {

	/**
	 * Reverse words in a phrase without additional memory.
	 * 
	 * e.g. "Hello World" to "World Hello"
	 * 
	 * */
	
	public static String reverse(String str) {
		char [] cc = str.toCharArray();
		// reverse the who phrase
		swap(cc, 0, cc.length - 1);
		// reverse every word
		int start = 0;
		for (int i = 0; i < cc.length; i++) {
			if (cc[i] == ' ') {
				swap(cc, start, i - 1);
				start = i + 1;
			}
			if (i == cc.length - 1) {
				swap(cc, start, i);
			}
		}
		return new String(cc);
	}
	private static void swap(char [] cc, int start, int end) {
		while(start < end) {
			char c = cc[start];
			cc[start] = cc[end];
			cc[end] = c;
			start++;
			end--;
		}
	}
	
	public static void main(String [] args) {
		String str = " Hello  deee  good gggbbb  World ";
		System.out.println(reverse(str));
	}
}
