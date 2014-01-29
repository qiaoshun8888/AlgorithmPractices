package leetcode;

import java.util.*;

import myUtils.datastructure.TreeNode;

/**
 * SumRootToLeafNumbers.java
 * 
 * Description: Given a binary tree containing digits from 0-9 only, each
 * root-to-leaf path could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 * 		1 
 *     / \ 
 *    2   3 
 * 
 * The root-to-leaf path 1->2 represents the number 12. 
 * The root-to-leaf path 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 29, 2014
 */

public class SumRootToLeafNumbers {
	
	public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(root.val);
        return traversal(root, stack, 0);
    }
    private int traversal(TreeNode node, Stack<Integer> stack, int sum) {
        if (node.left == null && node.right == null) {
            List<Integer> list = new ArrayList<Integer>(stack);
            StringBuilder sb = new StringBuilder();
            for (int v : list) {
                sb.append(v);
            }
            int v = Integer.parseInt(sb.toString());
            return sum + v;
        }
        
        if (node.left != null) {
            stack.push(node.left.val);
            sum = traversal(node.left, stack, sum);
            stack.pop();
        }
        
        if (node.right != null) {
            stack.push(node.right.val);
            sum = traversal(node.right, stack, sum);
            stack.pop();
        }
        
        return sum;
    }
}
