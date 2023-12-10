package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 13-Jun-20
 */
@LeetCode(id = 419, name = "Battleships in a Board", url = "https://leetcode.com/problems/battleships-in-a-board/")
public class BattleshipsInBoard {
	public int countBattleships(char[][] board) {
		int res = 0;
		int rows = board.length;
		int columns = board[0].length;
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				if (board[row][column] == '.') {
					continue;
				}

				if (row > 0 && board[row - 1][column] == 'X') {
					continue;
				}

				if (column > 0 && board[row][column - 1] == 'X') {
					continue;
				}
				res++;
			}
		}

		return res;
	}
}
