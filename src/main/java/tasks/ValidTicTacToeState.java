package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 21-Jul-20
 */
@LeetCode(id = 794, name = "Valid Tic-Tac-Toe State", url = "https://leetcode.com/problems/valid-tic-tac-toe-state/")
public class ValidTicTacToeState {
	public boolean validTicTacToe(String[] board) {
		int turns = 0;
		boolean xWon = false;
		boolean oWon = false;
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				if (board[row].charAt(column) == 'X') {
					if (isWon(board, row, column)) {
						xWon = true;
					}
					turns++;
				}
				else if (board[row].charAt(column) == 'O') {
					if (isWon(board, row, column)) {
						oWon = true;
					}
					turns--;
				}
			}
		}

		return turns >= 0 && turns <= 1 && (turns != 0 || !xWon) && (turns != 1 || !oWon);
	}

	boolean isWon(String[] board, int row, int column) {

		char left = column > 0 ? board[row].charAt(column - 1) : 'D';
		char right = column < 2 ? board[row].charAt(column + 1) : 'D';
		if (left == right && right == board[row].charAt(column)) {
			return true;
		}

		char up = row > 0 ? board[row - 1].charAt(column) : 'D';
		char bottom = row < 2 ? board[row + 1].charAt(column) : 'D';
		if (up == bottom && bottom == board[row].charAt(column)) {
			return true;
		}

		char leftUpCorner = (row > 0 && column > 0) ? board[row - 1].charAt(column - 1) : 'D';
		char rightBottomCorner = (row < 2 && column < 2) ? board[row + 1].charAt(column + 1) : 'D';
		if (leftUpCorner == rightBottomCorner && rightBottomCorner == board[row].charAt(column)) {
			return true;
		}

		char leftBottomCorner = (row < 2 && column > 0) ? board[row + 1].charAt(column - 1) : 'D';
		char rightUpCorner = (row > 0 && column < 2) ? board[row - 1].charAt(column + 1) : 'D';
		return leftBottomCorner == rightUpCorner && rightUpCorner == board[row].charAt(column);
	}
}
