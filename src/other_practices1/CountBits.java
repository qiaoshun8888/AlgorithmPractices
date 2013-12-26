package other_practices1;

public class CountBits {

	/**
	 * Count all the bits in an int value
	 * 
	 * */
	
	public static int countBits(int v) {
		int i = 0;
		while (v > 0) {
			if ((v & 1) > 0) i++;
			v >>= 1;
		}
		return i;
	}
	
	public static void main(String [] args) {
		int v = 29;
		System.out.println(countBits(v));
		System.out.println(Integer.toBinaryString(v));
	}
}
