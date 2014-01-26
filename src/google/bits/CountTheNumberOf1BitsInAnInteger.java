package google.bits;

/**
 * CountTheNumberOf1BitsInAnInteger.java
 * 
 * Description: How would you figure out the number of 1 bits in an integer?
 * 
 * Follow up: If this were a repeated operation, how could you optimize this?
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 25, 2014
 */

public class CountTheNumberOf1BitsInAnInteger {

	public static int count(int n) {
		int count = 0;
		while (n > 0) {
			if ((n & 1) > 0) count++;
			n >>= 1;
		}
		return count;
	}
	
	public static boolean verifyAnswer(int n, int count) {
		String s = Integer.toBinaryString(n);
		for (char c : s.toCharArray()) {
			if (c == '1') count--;
		}
		return count == 0;
	}
	
	public static void main(String[] args) {
		int [] vs = {1, 2, 11, 9283, 2774, 1, 0, 239473872};
		for (int v : vs) {
			System.out.println("Verify: " + verifyAnswer(v, count(v)));
		}
	}
}
