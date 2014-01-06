package crackingTheCodingInterview2;

public class Ch1_LargestSubsequenceSum {

	/**
	 * Compute Largest Subsequent Sum (LSS) in Linear Time
	 * 
	 * e.g.
	 * 
	 * {1, -5, 5, 3, -6, 1, 5, 3, -1, 7}
	 * 
	 * LSS:  1 + 5 + 3 = 9
	 * 
	 * */
	
	public static int LSS(int [] vs) {
		int gMax = 0, gStart = 0, gLength = 0, cMax = 0, cStart = -1, cLength = 0;
		
		for (int i = 0; i < vs.length; i++) {
			if (vs[i] < 0) {
				cMax = 0;
				cStart = -1;
				cLength = 0;
			}
			else {
				if (cStart == -1) cStart = i;
				cLength++;
				cMax += vs[i];
			}
			
			if (gMax < cMax) {
				gStart = cStart;
				gLength = cLength;
				gMax = cMax;
			}
		}
		
		while (gLength > 0) {
			System.out.print(vs[gStart++] + " ");
			gLength--;
		}
		System.out.println();
		return gMax;
	}
	
	public static void main(String [] args) {
		int [] vs = {1, -5, 5, 3, -6, 1, 5, 3, -1, 7};
		System.out.println(LSS(vs));
	}
}
