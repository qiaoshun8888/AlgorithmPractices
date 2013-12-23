package crackingProgrammingInterviewYouTuBe;

public class N24FindBalancePoint {

	
	/**
	 * Find the balance point in the array
	 * 
	 * */
	
	public static void find(int [] vs) {
		if (vs.length < 3) {
			System.out.println("Error: Array at least length 3");
			return;
		}
		int sum_left = vs[0], sum_right = 0, index = 1;
		// calculate total sum (sum_right)
		for (int i : vs) {
			sum_right += i;
		}
		sum_right -= vs[0]; sum_right -= vs[1];
		// find balance point
		while(sum_left != sum_right && index < vs.length - 1) {
			sum_left += vs[index];
			sum_right -= vs[index + 1];
			index++;
		}
		
		if (sum_left != sum_right) {
			System.out.println("There is no balance point in this array!");
		}
		else {
			System.out.println("Balance point: [" + index + "] sum: " + sum_left);
		}
	}
	
	public static void main(String [] args) {
		int [] vs = {4, 7, 1, -2, -5, 9, 4, -1, 5};
		find(vs);
	}
}
