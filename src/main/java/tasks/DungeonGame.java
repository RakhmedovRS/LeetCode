package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 21-Jun-20
 */
@LeetCode(
		id = 174,
		name = "Dungeon Game",
		url = "https://leetcode.com/problems/dungeon-game/",
		difficulty = Difficulty.HARD
)
public class DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
		int rows = dungeon.length;
		int columns = dungeon[0].length;
		Integer[][] memo = new Integer[rows][columns];
		int min = dfs(0, 0, rows, columns, memo, dungeon);

		return min < 0 ? Math.abs(min) + 1 : 1;
	}

	private Integer dfs(int row, int column, int rows, int columns, Integer[][] memo, int[][] dungeon) {
		if (row < 0 || row == rows || column < 0 || column == columns) {
			return null;
		}

		if (row == rows - 1 && column == columns - 1) {
			return dungeon[row][column];
		}
		if (memo[row][column] == null) {
			Integer down = dfs(row + 1, column, rows, columns, memo, dungeon);
			Integer right = dfs(row, column + 1, rows, columns, memo, dungeon);

			int best;
			if (down == null) {
				best = right;
			}
			else if (right == null) {
				best = down;
			}
			else {
				best = Math.max(right, down);
			}

			memo[row][column] = Math.min(dungeon[row][column], best + dungeon[row][column]);
		}

		return memo[row][column];
	}
}
