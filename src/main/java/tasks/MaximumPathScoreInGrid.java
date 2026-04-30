package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-04-29
 */
@LeetCode(
        id = 3742,
        name = "Maximum Path Score in a Grid",
        url = "https://leetcode.com/problems/maximum-path-score-in-a-grid/description/",
        difficulty = Difficulty.MEDIUM
)
public class MaximumPathScoreInGrid {
    public int maxPathScore(int[][] grid, int k) {
        int rows = grid.length;
        int columns = grid[0].length;
        Integer[][][] memo = new Integer[rows][columns][k + 1];

        memo[0][0][Math.min(1, grid[0][0])] = grid[0][0];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (row - 1 >= 0) {
                    for (int i = 0; i <= k; i++) {
                        if (memo[row - 1][column][i] != null) {
                            int nextK = i + Math.min(1, grid[row][column]);
                            if (nextK <= k) {
                                if (memo[row][column][nextK] == null) {
                                    memo[row][column][nextK] = memo[row - 1][column][i] + grid[row][column];
                                } else {
                                    memo[row][column][nextK] = Math.max(memo[row][column][nextK], memo[row - 1][column][i] + grid[row][column]);
                                }
                            }
                        }
                    }
                }

                if (column - 1 >= 0) {
                    for (int i = 0; i <= k; i++) {
                        if (memo[row][column - 1][i] != null) {
                            int nextK = i + Math.min(1, grid[row][column]);
                            if (nextK <= k) {
                                if (memo[row][column][nextK] == null) {
                                    memo[row][column][nextK] = memo[row][column - 1][i] + grid[row][column];
                                } else {
                                    memo[row][column][nextK] = Math.max(memo[row][column][nextK], memo[row][column - 1][i] + grid[row][column]);
                                }
                            }
                        }
                    }
                }
            }
        }

        int max = -1;
        for (int i = 0; i <= k; i++) {
            if (memo[rows - 1][columns - 1][i] != null) {
                max = Math.max(max, memo[rows - 1][columns - 1][i]);
            }
        }

        return max;
    }
}