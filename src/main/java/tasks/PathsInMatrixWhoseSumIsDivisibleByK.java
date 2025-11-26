package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 10/12/2022
 */
@LeetCode(
		id = 2435,
		name = "Paths in Matrix Whose Sum Is Divisible by K",
		url = "https://leetcode.com/problems/paths-in-matrix-whose-sum-is-divisible-by-k/",
		difficulty = Difficulty.HARD
)
public class PathsInMatrixWhoseSumIsDivisibleByK {
    int MOD = 1_000_000_007;

    public int numberOfPaths(int[][] grid, int k) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][][] memo = new int[rows][columns][k + 1];
        memo[0][0][grid[0][0] % k] = 1;
        for (int row = 0; row < rows; row++) {
            for (int column = row == 0 ? 1 : 0; column < columns; column++) {
                for (int i = 0; i < memo[row][column].length; i++) {
                    if (row - 1 >= 0) {
                        memo[row][column][(i + grid[row][column]) % k] += memo[row - 1][column][i];
                        memo[row][column][(i + grid[row][column]) % k] %= MOD;
                    }

                    if (column - 1 >= 0) {
                        memo[row][column][(i + grid[row][column]) % k] += memo[row][column - 1][i];
                        memo[row][column][(i + grid[row][column]) % k] %= MOD;
                    }
                }

            }
        }
        return memo[rows - 1][columns - 1][0];
    }
}
