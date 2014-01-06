package crackingTheCodingInterview2;

public class Ch1_RotateArray {

	/**
	 * Given an array and an integer k. Rotate the array around k in place.
	 * 
	 * e.g. 
	 * 
	 * 		{1, 2, 3, 4, 5}		k = 3
	 * 
	 * 		{4, 5, 1, 2, 3}
	 * 
	 * */
	
	public static void rotate(int [] vs, int k) {
		if (k <= 0 || vs == null || vs.length == 1) return;
		
		int start = k, temp = 0;
		while (start < vs.length) {
			temp = vs[start];
			rotateHelper(vs, start - k, start - 1);
			vs[start++ - k] = temp;
		}
	}
	//  4 1 2 3 5    (start = start - k, end = start - 1)
	private static void rotateHelper(int [] vs, int start, int end) {
		while (end >= start) {
			vs[end + 1] = vs[end];
			end--;
		}
	}
	
	public static void main(String [] args) {
		int [] vs = {1, 2, 3, 4, 5};
		int k = 3;
		rotate(vs, k);
		
		for (int v : vs) {
			System.out.printf("%3d", v);
		}
		System.out.println();
	}
}
