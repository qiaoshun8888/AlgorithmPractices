package leetcode;

/**
 * WordSearch.java
 * 
 * Description: Given a 2D board and a word, find if the word exists in the
 * grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * For example, Given board =
 * 
 * 	[
	  ["ABCE"],
	  ["SFCS"],
	  ["ADEE"]
	]
 * 
 * word = "ABCCED", -> returns true,
 * 
 * word = "SEE", -> returns true,
 * 
 * word = "ABCB", -> returns false.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Feb 1, 2014
 */

public class WordSearch {

	public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) return false;
        
        char[] cc = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == cc[0]) {
					// System.out.println(i + " " + j);
					boolean[][] visited = new boolean[board.length][board[0].length];
					if (existHelper(board, visited, i, j, cc, 0)) {
						return true;
					}
				}
			}
		}
        
        return false;
    }
	private boolean existHelper(char[][] board, boolean[][] visited, int x, int y, char[] cc, int index) {
		if (index == cc.length) return true;
		
		if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited[x][y]) {
			return false;
		}
		
		// System.out.printf("(%d, %d)\n", x, y);
		
		if (board[x][y] == cc[index]) {
			index++;
		}
		else return false;
		
		visited[x][y] = true;
		boolean b = existHelper(board, visited, x - 1, y, cc, index) || 
				existHelper(board, visited, x + 1, y, cc, index) ||
				existHelper(board, visited, x, y - 1, cc, index) ||
				existHelper(board, visited, x, y + 1, cc, index);
		visited[x][y] = false;
		
		return b;
	}
	
	public static void main(String[] args) {
		char[][] board = {
				{'A', 'B', 'C', 'E'},
				{'S', 'F', 'E', 'S'},
				{'A', 'D', 'E', 'E'}
		};
		char[][] board2 = {
				{'C', 'A', 'A'},
				{'A', 'A', 'A'},
				{'B', 'C', 'D'}
		};
		String[] words = {"ABCESEEEFS"};//, "AA", "ABCCED", "SEE", "ABCB"};
		WordSearch o = new WordSearch();
		
		for (String word : words) {
			System.out.println(o.exist(board, word));
		}
	}
}
