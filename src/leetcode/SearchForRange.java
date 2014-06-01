package leetcode;

public class SearchForRange {

	/**
	 * Given a sorted array of integers, find the starting and ending position
	 * of a given target value. Your algorithm's runtime complexity must be in
	 * the order of O(log n). 
	 * 
	 * If the target is not found in the array, return [-1, -1]. 
	 * 
	 * For example, 
	 * Given [5, 7, 7, 8, 8, 10] and target value 8,
	 * return [3, 4].
	 * 
	 **/
	
	public int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0) return new int[]{-1, -1};
        int[] result = new int[2];
        binarySearchForRange(A, 0, A.length - 1, target, false, result);
        return result;
    }
    
	/**
	 * @param flag flag = false: search for start, flag = true: search for end
	 */
    private void binarySearchForRange(int[] vs, int left, int right, int target, boolean flag, int[] result) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (vs[mid] == target) {
            	if (!flag) {
            		if (mid != 0 && vs[mid - 1] != target || mid == 0) {
                    	result[0] = mid;
                    	binarySearchForRange(vs, 0, vs.length - 1, target, true, result);
                    }
            		else if (mid == right - 1) 
            			result[1] = vs[right] == target ? right : mid;
            		else
            			binarySearchForRange(vs, left, mid, target, flag, result);
            	}
            	else {
            		if (mid != vs.length - 1 && vs[mid + 1] != target || mid == vs.length - 1) {
                    	result[1] = mid;
                    	return;
                    }
            		else if (mid == right - 1) 
            			result[1] = vs[right] == target ? right : mid;
            		else 
            			binarySearchForRange(vs, mid, right, target, flag, result);
            	}
            }
            else if (vs[mid] < target) binarySearchForRange(vs, mid + 1, right, target, flag, result);
            else binarySearchForRange(vs, left, mid - 1, target, flag, result);
        }
        return;
    }
    
    public static void main(String[] args) {
    	int[] vs = {5, 5, 5, 7, 7, 8, 8, 10, 10, 10};
    	int target = 7;
    	
    	SearchForRange o = new SearchForRange();
    	int[] result = o.searchRange(vs, target);
    	System.out.println(result[0] + " " + result[1]);
	}
}
