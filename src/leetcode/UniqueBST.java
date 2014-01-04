package leetcode;

public class UniqueBST {

	/**
	 * Given n, how many structurally unique BST's (binary search trees) that
	 * store values 1...n?
	 * 
	 * For example, Given n = 3, there are a total of 5 unique BST's.
	 * 
	 * 
	 *  1         3     3      2      1
    	 \       /     /      / \      \
     	  3     2     1      1   3      2
    	 /     /       \                 \
   		2     1         2                 3
	 * 
	 * */
	
	public int numTrees(int n) {
		return calculate(n);
    }
    
    private int calculate(int n) {
    	int N = n + 1;
        int [] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
        	for (int j = 0; j < i; j++) {
        		dp[i] += dp[j] * dp[i - 1 - j];
        	}
        }
        
        for (int v : dp) {
        	System.out.print(v + " ");
        }
        System.out.println();
        
        return dp[n];
    }
    
    public static void main(String [] args) {
    	UniqueBST uBST = new UniqueBST();
    	System.out.println(uBST.numTrees(3));
    }
}
