package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 8/22/2021
 */
@LeetCode(
		id = 1981,
		name = "Minimize the Difference Between Target and Chosen Elements",
		url = "https://leetcode.com/problems/minimize-the-difference-between-target-and-chosen-elements/",
		difficulty = Difficulty.MEDIUM
)
public class MinimizeTheDifferenceBetweenTargetAndChosenElements {
	public int minimizeTheDifference(int[][] mat, int target) {
		for (int[] row : mat) {
			Arrays.sort(row);
		}
		return dfs(0, mat, target, new Integer[mat.length + 1][10_000]);
	}

	private int dfs(int row, int[][] mat, int target, Integer[][] memo) {
		if (memo[row][target] != null) {
			return memo[row][target];
		}

		int min = Integer.MAX_VALUE;
		for (int column = 0; column < mat[row].length; column++) {
			int add = mat[row][column] > target ? mat[row][column] - target : 0;

			if (row == mat.length - 1) {
				min = Math.min(min, add > 0 ? add : target - mat[row][column]);
			}
			else {
				min = Math.min(min, add > 0 ? add + dfs(row + 1, mat, 0, memo) : dfs(row + 1, mat, target - mat[row][column], memo));
			}
		}

		memo[row][target] = min;

		return min;
	}
}
