package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 1/16/2023
 */
@LeetCode(
		id = 2536,
		name = "Increment Submatrices by One",
		url = "https://leetcode.com/problems/increment-submatrices-by-one/",
		difficulty = Difficulty.MEDIUM
)
public class IncrementSubmatricesByOne {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] grid = new int[n][n];
        for (int[] query : queries) {
            for (int row = query[0]; row <= query[2]; row++) {
                grid[row][query[1]] += 1;
                if (query[3] + 1 < n) {
                    grid[row][query[3] + 1] -= 1;
                }
            }
        }
        for (int row = 0; row < n; row++) {
            for (int column = 1; column < n; column++) {
                grid[row][column] += grid[row][column - 1];
            }
        }

        return grid;
    }
}
