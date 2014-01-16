package crackingTheCodingInterview.chapter5;

public class BitTasks {

	/**
	 * 0 0 1 0 0 0 <--- 
	 * 5 4 3 2 1 0 <--- Index of bit (i)
	 * */
	
	
	
	/**
	 * 0 0 1 0 0 0
	 *     ^
	 *     |
	 *     |
	 *    get
	 * */
	static boolean getBit(int num, int i) {
		return (num & (1 << i)) != 0;
	}
	
	/**
	 * 1 1 1 0 0 0
	 *     ^
	 *     |
	 *     |
	 *    set
	 * */
	static int setBit(int num, int i) {
		return num | (1 << i);
	}
	
	/**
	 * 1 1 1 0 0 0
	 *     ^
	 *     |
	 *     |
	 *    clear -> 0
	 * */
	static int clearBit(int num, int i) {
		return num & ~(1 << i);
	}
	
	/**
	 * 0 0 1 1 1 1
	 *       ^
	 *       |
	 *       |
	 *      clear all the left bits of current bit (inclusive)
	 * */
	static int clearBitsMSBThroughI(int num, int i) {
		return num & ((1 << i) - 1);
	}
	
	/**
	 * 0 0 1 1 1 1
	 *       ^
	 *       |
	 *       |
	 *      clear all the right bits of current bit (inclusive)
	 * */
	static int clearBitsIThrough0(int num, int i) {
		return num & ~((1 << i + 1) - 1);
	}
	
	
	static int updateBit(int num, int i, int v) {
		/*
		int mask = ~(1 << i);
		return (num & mask) | (v << i);
		*/
		return clearBit(num, i) | (v << i);
	}
	
	public static void main(String [] args) {
		System.out.println(getBit(3, 1)); // true
		System.out.println(setBit(3, 2)); // 7
		System.out.println(clearBit(7, 1)); // 5
		System.out.println(clearBitsMSBThroughI(11, 2)); // 3
		System.out.println(clearBitsIThrough0(11,2)); // 8
		System.out.println(updateBit(5, 1, 1)); // 7
	}
}
