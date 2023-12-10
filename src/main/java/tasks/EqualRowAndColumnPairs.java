package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 7/27/2022
 * @Ruslan Rakhmedov$
 * @1.0$
 */
@LeetCode(
		id = 2352,
		name = "Equal Row and Column Pairs",
		url = "https://leetcode.com/problems/equal-row-and-column-pairs/",
		difficulty = Difficulty.MEDIUM
)
public class EqualRowAndColumnPairs {
	public int equalPairs(int[][] grid) {
		int answer = 0;

		List<List<Integer>> rows = new ArrayList<>();

		for (int[] row : grid) {
			List<Integer> r = new ArrayList<>();
			for (int val : row) {
				r.add(val);
			}

			rows.add(r);
		}

		List<List<Integer>> columns = new ArrayList<>();
		for (int column = 0; column < grid[0].length; column++) {
			List<Integer> c = new ArrayList<>();
			for (int row = 0; row < grid.length; row++) {
				c.add(grid[row][column]);
			}

			columns.add(c);
		}

		for (List<Integer> row : rows) {
			inner:
			for (List<Integer> column : columns) {
				for (int i = 0; i < row.size(); i++) {
					if (!row.get(i).equals(column.get(i))) {
						continue inner;
					}
				}

				answer++;
			}
		}

		return answer;
	}
}
