package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 19-Jun-20
 */
@LeetCode(id = 999, name = "Available Captures for Rook", url = "https://leetcode.com/problems/available-captures-for-rook/")
public class AvailableCapturesForRook {
	public int numRookCaptures(char[][] board) {
		int captures = 0;
		if (board == null || board.length == 0) {
			return captures;
		}

		int rows = board.length;
		int columns = board[0].length;
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				if (board[row][column] == 'R') {

					for (int r = row - 1; r >= 0; r--) {
						if (board[r][column] != '.') {
							captures += board[r][column] == 'p' ? 1 : 0;
							break;
						}
					}

					for (int r = row + 1; r < rows; r++) {
						if (board[r][column] != '.') {
							captures += board[r][column] == 'p' ? 1 : 0;
							break;
						}
					}

					for (int c = column - 1; c >= 0; c--) {
						if (board[row][c] != '.') {
							captures += board[row][c] == 'p' ? 1 : 0;
							break;
						}
					}

					for (int c = column + 1; c < columns; c++) {
						if (board[row][c] != '.') {
							captures += board[row][c] == 'p' ? 1 : 0;
							break;
						}
					}

					break;
				}
			}
		}

		return captures;
	}
}
