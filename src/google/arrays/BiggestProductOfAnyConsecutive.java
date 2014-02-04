package google.arrays;

/**
 * BiggestProductOfAnyConsecutive.java
 * 
 * Description: Find the biggest product of any consecutive subset of array of
 * numbers. Example: 1, 5, -10, 3, 7, 0, 100, 2, -3. In this case the product of
 * subset [100 X 2] = 200 is the biggest. I am interested in your algorithm, you
 * don’t need to implement your solution.
 * 
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Feb 4, 2014
 */

public class BiggestProductOfAnyConsecutive {

	public static int cul(int [] vs) {
		int mPos = 0;
		// 1, 5, -10, 3, 7 , -1 , 0
		int pos = 1, neg = 1;
		for (int i = 0; i < vs.length; i++) {
			System.out.println("v: " + vs[i] + "  pos: " + pos + "  neg: " + neg);
			if (vs[i] < 0) {
				if (pos > mPos) mPos = pos;
				if (neg < 0) {
					pos = neg * vs[i];
					neg = 1;
				}
				else {
					pos *= vs[i];
					neg = pos;
					pos = 1;
				}
			}
			else if (vs[i] > 0) {
				pos *= vs[i];
				neg *= vs[i];
			}
			else {
				if (pos > mPos) mPos = pos;
				pos = 1;
				neg = 1;
			}
		}
		
		if (pos > mPos) mPos = pos;
		
		return mPos;
	}
	
	public static void main(String[] args) {
//		int [] vs = {1, 5, -10, 3, 7 , -1 , 0};  // 1050
//		int [] vs = {1, 5, -10, -2, 0, 2, 2}; // 100
//		int [] vs = {1, 5, -1, 2, -1, 4}; // 40
		int [] vs = {1, 5, -10, 20, 40}; // 800
		System.out.println(cul(vs));
	}
}
