package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 4/17/2021
 */
@LeetCode(
		id = 1074,
		name = "Number of Submatrices That Sum to Target",
		url = "https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/",
		difficulty = Difficulty.HARD
)
public class NumberOfSubmatricesThatSumToTarget {
	public int numSubmatrixSumTarget(int[][] matrix, int target) {
		int rows = matrix.length;
		if (rows == 0) {
			return 0;
		}
		int columns = matrix[0].length;

		int[][] memo = new int[rows + 1][columns + 1];
		for (int row = 1; row <= rows; row++) {
			for (int column = 1; column <= columns; column++) {
				memo[row][column] = memo[row - 1][column] + memo[row][column - 1] - memo[row - 1][column - 1] + matrix[row - 1][column - 1];
			}
		}

		int count = 0;
		int currentSum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int row1 = 1; row1 <= rows; row1++) {
			for (int row2 = row1; row2 <= rows; row2++) {
				map.clear();
				map.put(0, 1);
				for (int column = 1; column <= columns; column++) {
					currentSum = memo[row2][column] - memo[row1 - 1][column];

					count += map.getOrDefault(currentSum - target, 0);

					map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
				}
			}
		}

		return count;
	}
}
