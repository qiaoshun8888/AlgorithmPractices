package other_practices2.array;

public class ValidSudoku {

	/*
	 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
	 * 
	 * The Sudoku board could be partially filled, where empty cells are filled
	 * with the character '.'.
	 * 
	 * Note: A valid Sudoku board (partially filled) is not necessarily
	 * solvable. Only the filled cells need to be validated.
	 */

	public boolean isValidSudoku(char[][] board) {
		boolean[] used = new boolean[9];
		for (int i = 0; i < 9; i++) {
			used = new boolean[9];
			// check rows
			for (int j = 0; j < 9; j++) {
				if (!check(board[i][j], used))
					return false;
			}
			used = new boolean[9];
			// check columns
			for (int j = 0; j < 9; j++) {
				if (!check(board[j][i], used))
					return false;
			}
		}
		
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				used = new boolean[9];
				// check small box
				for (int i = c * 3; i < (c + 1) * 3; i++) {
					for (int j = r * 3; j < (r + 1) * 3; j++) {
						if (!check(board[i][j], used))
							return false;
					}
				}
			}
		}

		return true;
	}

	private boolean check(char c, boolean[] used) {
		if (c == '.')
			return true;
		if (used[c - '1'])
			return false;
		used[c - '1'] = true;
		return true;
	}

}
