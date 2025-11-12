package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-06-01
 */
@LeetCode(
        id = 3567,
        name = "Minimum Absolute Difference in Sliding Submatrix",
        url = "https://leetcode.com/problems/minimum-absolute-difference-in-sliding-submatrix/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumAbsoluteDifferenceInSlidingSubmatrix {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] ans = new int[1 + rows - k][1 + columns - k];
        for (int row = 0; row <= rows - k; row++) {
            for (int column = 0; column <= columns - k; column++) {
                ans[row][column] = calculate(row, column, rows, columns, grid, k);
            }
        }
        return ans;
    }

    private int calculate(int row, int column, int rows, int columns, int[][] grid, int k) {
        TreeSet<Integer> memo = new TreeSet<>();
        int min = Integer.MAX_VALUE;
        for (int r = row; r < row + k; r++) {
            for (int c = column; c < column + k; c++) {
                if (!memo.isEmpty()) {
                    Integer lower = memo.lower(grid[r][c]);
                    Integer higher = memo.higher(grid[r][c]);
                    if (lower != null) {
                        min = Math.min(min, Math.abs(grid[r][c] - lower));
                    }

                    if (higher != null) {
                        min = Math.min(min, Math.abs(grid[r][c] - higher));
                    }
                }

                memo.add(grid[r][c]);
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}