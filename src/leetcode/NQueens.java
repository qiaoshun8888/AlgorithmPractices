package leetcode;

import java.util.*;

/**
 * NQueens.java
 * 
 * Description: The n-queens puzzle is the problem of placing n queens on an n×n
 * chessboard such that no two queens attack each other. Given an integer n,
 * return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * For example, There exist two distinct solutions to the 4-queens puzzle:
 * 
   [
	 [".Q..",  // Solution 1
	  "...Q",
	  "Q...",
	  "..Q."],
	
	 ["..Q.",  // Solution 2
	  "Q...",
	  "...Q",
	  ".Q.."]
   ]
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 30, 2014
 */

public class NQueens {

	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> result = new ArrayList<String[]>();
		if (n <= 0) return result;
		
		char [][] board = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		
		DFS(board, 0, 0, 0, result);
		
		return result;
    }
	
	private void DFS(char[][] board, int row, int col, int count, ArrayList<String[]> result) {
		if (row > board.length || col > board.length) return;
		// Base case
		if (count == board.length) {
			result.add(generateSolution(board));
			return;
		}
		
		// Recursion - put queens row by row
		for (int i = 0; i < board.length; i++) {
			if (isValid(board, i, col)) {
				board[i][col] = 'Q';
				DFS(board, i, col + 1, count + 1, result);
				board[i][col] = '.';
			}
		}
	}
	
	private String[] generateSolution(char[][] board) {
		String [] solution = new String[board.length];
		for (int i = 0; i < board.length; i++) {
			solution[i] = new String(board[i]);
		}
		return solution;
	}
	
	private boolean isValid(char[][] board, int row, int col) {
		for (int i = 0; i < board.length; i++)
			if (board[row][i] == 'Q' || board[i][col] == 'Q') return false;
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 'Q') return false;
		for (int i = row, j = col; i < board.length && j >= 0; i++, j--)
			if (board[i][j] == 'Q') return false;
		return true;
	}
	
	public static void main(String[] args) {
		NQueens o = new NQueens();
		ArrayList<String[]> result = o.solveNQueens(4);
		System.out.println(result.size());
		
		for (String [] ss : result) {
			for (String s : ss) {
				System.out.println(s);
			}
			System.out.println();
		}
	}
}
