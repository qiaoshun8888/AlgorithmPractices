package other_practices1;

public class CheckBitSet {

	/**
	 * Check the high-order bit is set in a byte.
	 * 
	 * */
	public static boolean check(byte b) {
		int i = 1 << 7;
		System.out.println(Integer.toBinaryString(i));
		return (b & i) > 0;
	}
	
	public static void main(String [] args) {
		int i = 127;
		byte b = (byte) i;
		System.out.println(b);
		System.out.println(Integer.toBinaryString(b));
		System.out.println("Is high-order bit set? " + (check(b) ? "YES" : "NO"));
	}
}
