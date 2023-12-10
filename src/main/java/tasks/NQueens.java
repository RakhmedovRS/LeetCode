package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 5/22/2021
 */
@LeetCode(
		id = 51,
		name = "N-Queens",
		url = "https://leetcode.com/problems/n-queens/",
		difficulty = Difficulty.HARD
)
public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> answer = new ArrayList<>();
		boolean[][] table = new boolean[n][n];
		dfs(0, table, answer);
		return answer;
	}

	private void dfs(int row, boolean[][] table, List<List<String>> answer) {
		if (row == table.length) {
			List<String> state = new ArrayList<>();
			for (boolean[] r : table) {
				StringBuilder sb = new StringBuilder();
				for (boolean b : r) {
					sb.append(b ? 'Q' : '.');
				}
				state.add(sb.toString());
			}

			answer.add(state);

			return;
		}

		for (int column = 0; column < table[row].length; column++) {
			if (canPlaceQueen(row, column, table)) {
				table[row][column] = true;
				dfs(row + 1, table, answer);
				table[row][column] = false;
			}
		}
	}

	private boolean canPlaceQueen(int row, int column, boolean[][] table) {
		//horizontal line
		for (int c = 0; c < table[row].length; c++) {
			if (table[row][c]) {
				return false;
			}
		}

		//vertical line
		for (int r = 0; r < table.length; r++) {
			if (table[r][column]) {
				return false;
			}
		}

		//slash line
		for (int r = row, c = column; r < table.length && c >= 0; r++, c--) {
			if (table[r][c]) {
				return false;
			}
		}
		for (int r = row, c = column; r >= 0 && c < table[row].length; r--, c++) {
			if (table[r][c]) {
				return false;
			}
		}

		//backslash line
		for (int r = row, c = column; r >= 0 && c >= 0; r--, c--) {
			if (table[r][c]) {
				return false;
			}
		}
		for (int r = row, c = column; r < table.length && c < table[row].length; r++, c++) {
			if (table[r][c]) {
				return false;
			}
		}

		return true;
	}
}
