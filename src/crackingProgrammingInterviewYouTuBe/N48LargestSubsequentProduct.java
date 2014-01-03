package crackingProgrammingInterviewYouTuBe;

public class N48LargestSubsequentProduct {

	/**
	 * Compute Largest Subsequent Product (LSP) in Linear Time
	 * 
	 * e.g.
	 * 
	 * {0.5, -2.5, 3.0, -6},
	 * 
	 * LSP = (-2.5) * 3.0 * (-6) = 45
	 * 
	 * */
	
	public static double LSP(double [] vs) {
		double gMax = 0, cMin = 1, cMax = 1, temp = 0;
		for (int i = 0; i < vs.length; i++) {
			if (vs[i] > 0) {
				cMax *= vs[i];
				if (cMin != 1) {
					cMin *= vs[i];
				}
			}
			else if (vs[i] < 0) {
				if (cMin == 1) {
					cMin = cMax * vs[i];
					cMax = 1;
				}
				else {
					temp = cMax * vs[i];
					cMax = cMin * vs[i];
					cMin = temp;
				}
			}
			else {
				cMax = 1;
				cMin = 1;
			}
			
			gMax = Math.max(gMax, cMax);
		}
		
		 return gMax;
	}
	
	static double MaxSubsequentProduct(double[] nums) {
		//as we discussed in slides, we need four support variables
		double globalMaxPos = 0;
		double globalMaxNeg = 0;
		double currPos = 1;
		double currNeg = 1;
		//now we start processing the values in the array
		for(int i=0; i<nums.length; i++) {
			//we process the K (nums[i]) based on its sign (pos/neg/zero)
			if(nums[i]>0) {
				currPos *= nums[i];
				if(currNeg != 1)//only update it when it is set before
					currNeg *= nums[i];
			} else if(nums[i]<0) {
				//firstly check if the currNeg has been set or not
				if(currNeg == 1) {
					//The positive value can be computed by using Neg*nums[i]
					currNeg = currPos * nums[i];
					//we need set neg value first otherwise we lost the postive so far
					//in case of neg value not set, the current pos product can be reset!
					currPos = 1;
				}
				else {
					//as we discussed we need set neg=pos*current value and vice versa
					double tempNeg = currNeg;
					currNeg = currPos * nums[i];
					currPos = tempNeg * nums[i];
				}
			} else { //it is 0
				currPos = 1;
				currNeg = 1;//reset both products
			}
			
			//now check if any current product can be set to global max pos/neg values
			if(currPos > globalMaxPos)
				globalMaxPos = currPos;
			if(currNeg < globalMaxNeg)
				globalMaxNeg = currNeg;//actually we do not need this global neg value, but for reference
			
			//last step, we need discard the current product if it is less than 1!
			if(currPos < 1)
				currPos = 1;
		}
		//do not forget to return the value
		return globalMaxPos;
	}
	
	
	public static void main(String [] args) {
		double [] vs = {1, -0.5, 3.0, -6, -1};
		// double [] vs = {0, 5, -0.5};
		System.out.println(LSP(vs));
		System.out.println(MaxSubsequentProduct(vs));
		
	}
}
