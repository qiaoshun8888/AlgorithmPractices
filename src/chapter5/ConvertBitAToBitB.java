package chapter5;

public class ConvertBitAToBitB {

	public static int getNum(int a, int b) {
		int c = Math.min(a, b), d = Math.max(a, b);
		// Only works when a is less or equal than b
		
		//      a = 3, b = 8;
		// 		   11	1000
		int num = 0; // # of bits need to change from a -> b
		while (d > 0) {
			if ((d & 1) != (c & 1) || (c == 0 && ((d & 1) == 1) ) ) {
				num++;
			}
			d >>= 1;
			c >>= 1;
		}
		
		return num;
	}
	
	public static int getNum2(int a, int b) {
		int num = 0;
		for (int c = a ^ b; c != 0; c = c >> 1) {
			num += c & 1;
		}
		return num;
	}
	
	public static int getNum3(int a, int b) {
		int num = 0;
		for (int c = a ^ b; c != 0; c &= (c - 1)) {
			num++;
		}
		return num;
	}
	
	public static void main(String [] args) {
		
		System.out.println(ConvertBitAToBitB.getNum(4, 19));
		System.out.println(ConvertBitAToBitB.getNum2(4, 19));
		System.out.println(ConvertBitAToBitB.getNum3(4, 19));
		
		System.out.println();
		
		System.out.println(ConvertBitAToBitB.getNum(8, 3));
		System.out.println(ConvertBitAToBitB.getNum2(8, 3));
		System.out.println(ConvertBitAToBitB.getNum3(8, 3));
	}
}
