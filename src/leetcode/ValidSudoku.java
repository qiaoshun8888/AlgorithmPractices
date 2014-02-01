package leetcode;

/**
 *	ValidSudoku.java
 *
 *	Description: Determine if a Sudoku is valid.
 *
 *	@author John Qiao <qiaoshun8888@gmail.com>
 *	Date: Jan 31, 2014
 */

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) return false;
        
        // small blocks
        for (int row = 0; row < board.length; row += 3) {
            for (int col = 0; col < board[0].length; col += 3) {
                boolean [] check = new boolean[9];
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        char c = board[i][j];
                        if (!checkValid(check, c)) {
                            return false;
                        }
                    }
                }
            }
        }
        
        // big blocks - rows
        for (int i = 0; i < board.length; i++) {
            boolean [] check = new boolean[9];
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (!checkValid(check, c)) {
                    return false;
                }
            }
        }
        
        // big block - columns
        for (int i = 0; i < board[0].length; i++) {
            boolean [] check = new boolean[9];
            for (int j = 0; j < board.length; j++) {
                char c = board[j][i];
                if (!checkValid(check, c)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean checkValid(boolean [] check, char c) {
        if (c == '.') return true;
        else if (!check[(int)c - 49]) {
            check[(int)c - 49] = true;
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
    	char [][] board = {
    			{'.','8','7','6','5','4','3','2','1'},
    			{'2','.','.','.','.','.','.','.','.'},
    			{'3','.','.','.','.','.','.','.','.'},
    			{'4','.','.','.','.','.','.','.','.'},
    			{'5','.','.','.','.','.','.','.','.'},
    			{'6','.','.','.','.','.','.','.','.'},
    			{'7','.','.','.','.','.','.','.','.'},
    			{'8','.','.','.','.','.','.','.','.'},
    			{'9','.','.','.','.','.','.','.','.'},
    	};
    	ValidSudoku o = new ValidSudoku();
    	System.out.println(o.isValidSudoku(board));
	}
}
