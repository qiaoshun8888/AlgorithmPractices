package leetcode;

import java.util.*;

import myUtils.TreeUtils;
import myUtils.datastructure.TreeNode;

/**
 *	PathSumII.java
 *
 *	Description: Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

	For example:
	Given the below binary tree and sum = 22,
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \    / \
	        7    2  5   1
	return
	[
	   [5,4,11,2],
	   [5,8,4,5]
	]
	
 *
 *	@author John Qiao <qiaoshun8888@gmail.com>
 *	Date: Jan 30, 2014
 */

public class PathSumII {
	
	private static int stackSum = 0;

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) return result;
        
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(root.val);
        stackSum += root.val;
        
        pathSumHelper(root, stack, sum, result);
        
        return result;
    }
    private void pathSumHelper(TreeNode root, Stack<Integer> stack, int target, ArrayList<ArrayList<Integer>> result) {
        if (isLeaf(root) && stackSum == target) {
            ArrayList<Integer> list = new ArrayList<Integer>(stack);
            result.add(list);
            return;
        }
        
        if (root.left != null) {
            stack.push(root.left.val);
            stackSum += root.left.val;
            pathSumHelper(root.left, stack, target, result);
            stackSum -= root.left.val;
            stack.pop();
        }
        
        if (root.right != null) {
            stack.push(root.right.val);
            stackSum += root.right.val;
            pathSumHelper(root.right, stack, target, result);
            stackSum -= root.right.val;
            stack.pop();
        }
    }
    
    private boolean isLeaf(TreeNode node) {
    	return node.left == null && node.right == null;
    }
    
    public static void main(String[] args) {
//    	int [] vs = {-1, 5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, -1, -1, 5, 1};
    	int [] vs = {-1, 1, 2, -1};
    	TreeNode root = TreeUtils.generateBinaryTree(vs);
    	TreeUtils.print(root);
    	int sum = 3;
    	
    	PathSumII o = new PathSumII();
    	ArrayList<ArrayList<Integer>> result = o.pathSum(root, sum);

    	for (ArrayList<Integer> list : result) {
    		System.out.println(list);
    	}
	}
}
