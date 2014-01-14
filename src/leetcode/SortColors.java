package leetcode;

public class SortColors {

	/**
	 * Given an array with n objects colored red, white or blue, sort them so
	 * that objects of the same color are adjacent, with the colors in the order
	 * red, white and blue.
	 * 
	 * Here, we will use the integers 0, 1, and 2 to represent the color red,
	 * white, and blue respectively.
	 * 
	 * Note: You are not suppose to use the library's sort function for this
	 * problem.
	 * 
	 * 
	 * Follow up: A rather straight forward solution is a two-pass algorithm
	 * using counting sort. First, iterate the array counting number of 0's,
	 * 1's, and 2's, then overwrite array with total number of 0's, then 1's and
	 * followed by 2's.
	 * 
	 * Could you come up with an one-pass algorithm using only constant space?
	 * 
	 * */
	
	/*
     * 0 - red
     * 1 - white
     * 2 - blue
     *
     *  red | white | blue
     *
     * e.g.
     *      1 0 2 1 0 2 0
     *      0 0 2 1 0 2 1
     *      0 0 1 1 0 2 2      
     *      0 0 0 1 1 2 2
     *      
     */
	
    public static void sortColors(int[] A) {
        int start = 0, end = A.length -1;
        while (start < end) {
        	// System.out.println("start: " + start + "  end: " + end);
        	
            while (start < end && A[start] == 0) start++;
            // 1 switch with 0
            if (A[start] == 1) {
            	int temp_end = end;
            	while (start < temp_end && A[temp_end] != 0) temp_end--;
            	if (start >= temp_end) start++;
            	else {
            		swap(A, start, temp_end);
            		start++;
            	}
            }
            // 2 switch with 0 or 1
            else {
            	int temp_end = end;
            	while (start < temp_end && A[temp_end] == 2) temp_end--;
            	if (start >= temp_end) break; // This means all the numbers after start are two
            	else {
            		swap(A, start, temp_end);
            		end--; // Skip the blue color at the end of the array we already knew.
            		if (A[start] == 0) start++; // If 2 switch with 0, then we advance start
            		// If 2 switch with 1, then we do nothing
            	}
            }
        }
    }
    private static void swap(int [] vs, int i, int j) {
        if (i != j) {
            vs[i] ^= vs[j];
            vs[j] ^= vs[i];
            vs[i] ^= vs[j];
        }
    }
    
    public static void main(String [] args) {
    	int [] vs = {1, 0, 2, 1, 0, 2, 0};
    	// Special cases
    	// int [] vs = {1, 1, 2, 1, 1, 2, 1};
    	// int [] vs = {0, 0, 2, 0, 0, 2, 0};
    	// int [] vs = {0, 0, 1, 0, 0, 1, 1};
    	// int [] vs = {1, 1};
    	// int [] vs = {0, 0};
    	// int [] vs = {2, 2};
    	sortColors(vs);
    	
    	for (int v : vs) {
    		System.out.print(v + " ");
    	}
    }
}
