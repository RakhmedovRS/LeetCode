package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-07-18
 */
@LeetCode(
        id = 3989,
        name = "Maximum Consistent Columns in a Grid",
        url = "https://leetcode.com/problems/maximum-consistent-columns-in-a-grid/description/",
        difficulty = Difficulty.HARD
)
public class MaximumConsistentColumnsInGrid {
    public int maxConsistentColumns(int[][] grid, int limit) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[] memo = new int[columns];
        Arrays.fill(memo, 1);
        for (int c1 = 0; c1 < columns; c1++) {
            outer:
            for (int c2 = c1 + 1; c2 < columns; c2++) {
                for (int row = 0; row < rows; row++) {
                    if (Math.abs(grid[row][c1] - grid[row][c2]) > limit) {
                        continue outer;
                    }
                }
                memo[c2] = Math.max(memo[c2], memo[c1] + 1);
            }
        }

        int max = 0;
        for (int m : memo) {
            max = Math.max(max, m);
        }
        return max;
    }
}