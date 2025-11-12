package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-07-19
 */
@LeetCode(
        id = 3619,
        name = "Count Islands With Total Value Divisible by K",
        url = "https://leetcode.com/problems/count-islands-with-total-value-divisible-by-k/description/",
        difficulty = Difficulty.MEDIUM
)
public class CountIslandsWithTotalValueDivisibleByK {
    public int countIslands(int[][] grid, int k) {
        int rows = grid.length;
        int columns = grid[0].length;
        int result = 0;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (grid[row][column] > 0) {
                    int sum = erase(grid, row, column);
                    if (sum % k == 0) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    private int erase(int[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[row].length || grid[row][column] == 0) {
            return 0;
        }

        int val = grid[row][column];
        grid[row][column] = 0;
        return val + erase(grid, row + 1, column)
                + erase(grid, row - 1, column)
                + erase(grid, row, column + 1)
                + erase(grid, row, column - 1);
    }
}