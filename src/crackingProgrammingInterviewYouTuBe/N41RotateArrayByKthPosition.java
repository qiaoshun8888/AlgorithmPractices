package crackingProgrammingInterviewYouTuBe;

public class N41RotateArrayByKthPosition {

	/**
	 * Rotate an array by k position in place
	 * 
	 * e.g.
	 * 		{1, 2, 3, 4, 5, 6}
	 * k = 2
	 * 
	 * Output:
	 * 		{3, 4, 5, 6, 1, 2}
	 * 
	 * 
	 * */
	
	public static void rotate(int [] vs, int k) {
		int temp = 0;
		k--;
		for (int j = k; j >= 0; j--) {
			temp = vs[j];
			for (int i = j + 1; i < vs.length - (k - j); i++) {
				vs[i - 1] = vs[i];
			}
			vs[vs.length - 1 - (k - j)] = temp;
		}
	}
	
	public static void main(String [] args) {
		int [] vs = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int k = 3;
		rotate(vs, k);
		
		for (int i : vs) {
			System.out.print(i + " ");
		}
	}
}
