package crackingProgrammingInterviewYouTuBe;

public class N07FindNumber {

	/**
	 * Find the 1st index of a given number in a sorted array allowing duplicates
	 * 
	 * */
	public static int find(int [] vs, int x) {
		return binarySearch(vs, x, 0, vs.length - 1);
	}
	private static int binarySearch(int [] vs, int x, int low, int high) {
		if (low > high) return -1;
		int mid = (low + high) / 2;
		if (vs[mid] == x) {
			/*
			 e.g. {2, 2, 2, 2, 2, 2, 2}
			 	   |  |  |  ^
			 	   |  |  | [3]
			 	   |  |  ^
			 	   |  | [2]
			 	   |  ^
			 	   | [1]
			 	   ^
			 	  [0]
			*/          
			
			// worst case: n/2
			/*
			while (mid >= 0 && vs[mid] == x) {
				mid--;
			}
			return mid + 1;
			*/
			
			/*
			 e.g. {2, 2, 2, 2, 2, 2, 2}
			 	   |  |     ^
			 	   |  |    [3]
			 	   |  ^
			 	   | [1]
			 	   ^
			 	  [0]
			*/          
			
			// worst case: log(n)
			int i = binarySearch(vs, x, low, mid - 1);
			return i != -1 ? i : mid;
		}
		else if (vs[mid] > x) return binarySearch(vs, x, low, mid - 1);
		else return binarySearch(vs, x, mid + 1, high);
	}
	
	public static void main(String [] args) {
		int [] vs = {0, 2, 2, 2, 3, 3, 4, 4, 4, 5, 6, 7, 9, 9, 12, 15, 19};
		System.out.println(find(vs, 4));
	}
}
