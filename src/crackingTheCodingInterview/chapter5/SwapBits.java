package crackingTheCodingInterview.chapter5;

public class SwapBits {

	/**
	 * !! wrong!
	 * */
	public static int swapEvenOdd(int a) {
		int b = a;
		int bits_length = 0;
		while (b != 0) {
			b >>= 1;
			bits_length++;
		}
		
		// a = 1010
		//       ^^
		//     ^^
		
		//    if different then flip each bit
		
		for (int i = 0, odd = 0, even = 0; i < bits_length; i+=2) { // i = 3
			even = i;  		// 0, 2
			odd = i + 1;    // 1, 3 
			
			// same, ignore
			// different, flip 
			if ((a >> odd & 1) != (a >> even & 1)) {
				// if odd is 0, then flip to 1 and flip even to 0
				if ((a >> odd & 1) == 0) {
					a |= 1 << odd;
					a &= ~(1 << even); 
				}
				else {
					a &= ~(1 << odd);
					a |= 1 << even;
				}
			} else {
				
			}
			// ...
		}
		
		return a;
	}
	
	public static int swap(int n) {
		return ( (n & 0xaaaaaaaa) >> 1 | (n & 0x55555555) << 1);
	}
	
	
	public static void main(String [] args) {
		System.out.println(SwapBits.swapEvenOdd(10));
		System.out.println(SwapBits.swap(10));
		System.out.println();
		
		System.out.println(SwapBits.swapEvenOdd(20));
		System.out.println(SwapBits.swap(20));
		System.out.println();
		
		System.out.println(SwapBits.swapEvenOdd(32));
		System.out.println(SwapBits.swap(32));
	}
}
