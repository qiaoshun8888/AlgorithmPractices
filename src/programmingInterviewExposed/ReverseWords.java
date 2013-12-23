package programmingInterviewExposed;

public class ReverseWords {

	private static int called_times = 0;
	public static String reverse(String str) {
		char [] cc = str.toCharArray();
		
		StringBuilder sb = new StringBuilder();
		
		/*
		 * Hello World - > World Hello
		 *      |    ^
		 *      |    |
		 *      ^    i, j
		 *      j     
		 */
		for (int i = cc.length - 1; i >= 0; i--) {
			int j = i;
			while (j > 0 && cc[j] != ' ') {
				j--;
			}
			boolean head = j == 0;
			
			j = head ? j : j + 1;
			
			int length = i - j + 1;
			
			for (; j <= i; j++) {
				called_times++;
				sb.append(cc[j]);
			}
			
			// If not the first word, then add a space.
			if (!head) {
				sb.append(' ');
			}
			
			i = i - length;
		}
		
		return sb.toString();
	}
	
	public static String reverse2(String str) {
		/*
		 * 		hello world
		 * ->  	dlrow olleh  (step 1)
		 * ->   world hello  (step 2)
		 * 
		 * */
		char [] cc = str.toCharArray();
		reverse(cc, 0, cc.length - 1);
		
		// step 2
		int j = 0;
		for (int i = 0; i < cc.length;) {
			j = i + 1;
			while (j < cc.length && cc[j] != ' ') {
				called_times++;
				j++;
			}
			reverse(cc, i, j - 1);
			i = j + 1;
		}
		
		return new String(cc);
	}
	private static void reverse(char [] cc, int start, int end) {
		while (start <= end) {
			called_times++;
			swap(cc, start++, end--);
		}
	}
	private static void swap(char [] cc, int a, int b) {
		char c = cc[a];
		cc[a] = cc[b];
		cc[b] = c;
	}
	
	public static void main(String [] args) {
		String str = "Stack Overflow is a question and answer site for professional and enthusiast programmers. It's 100% free, no registration required.";
		// String str = "Hello World";
		System.out.println("length N = " + str.length());
		System.out.println(str);
		String reverse_str1 = reverse(str); 
		System.out.println(reverse_str1);
		System.out.println("=== called_tiems: " + called_times);
		
		called_times = 0;
		
		System.out.println(str);
		String reverse_str2 = reverse2(str);
		System.out.println(reverse_str2);
		System.out.println("=== called_tiems: " + called_times);
		
		System.out.println("reverse_str2 == reverse_str1? " + reverse_str2.equals(reverse_str1));
	}
}
