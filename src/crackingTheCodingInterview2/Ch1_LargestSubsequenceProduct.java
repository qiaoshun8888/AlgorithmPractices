package crackingTheCodingInterview2;

public class Ch1_LargestSubsequenceProduct {

	/**
	 * Compute Largest Subsequent Product (LSP) in Linear Time
	 * 
	 * e.g.
	 * 
	 * {1, -0.5, -0.5, 3.0, -6, -1}
	 * 
	 * LSP = 3.0 * (-6) * (-1) = 18
	 * 
	 * */
	
	public static double LSP(double [] vs) {
		double gMax = 0, cMax = 1, cMin = 1;
		if (vs == null) return gMax;
		
		for (int i = 0; i < vs.length; i++) {
			if (vs[i] == 0) {
				cMax = 1;
				cMin = 1;
			}
			else if (vs[i] > 0) {
				cMax *= vs[i];
				if (cMin < 0)  cMin *= vs[i];
			}
			else if (vs[i] < 0) {
				if (cMin < 0) {
					double temp = cMax;
					cMax = cMin * vs[i];
					cMin = temp * vs[i];
				}
				else {
					cMax = 1;
					cMin = vs[i];
				}
			}
			
			gMax = Math.max(gMax, cMax);
			
			cMax = cMax < 1 ? 1 : cMax;
		}
		
		return gMax;
	}
	
	public static void main(String [] args) {
		double [] vs = {1, -0.5, -0.5, 3.0, -6, -1};
		// double [] vs = {0.5, -2.5, 3.0, -6};
		
		System.out.println(LSP(vs));
	}
}
