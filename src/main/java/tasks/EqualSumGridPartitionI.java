package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-03-25
 */
@LeetCode(
        id = 3546,
        name = "Equal Sum Grid Partition I",
        url = "https://leetcode.com/problems/equal-sum-grid-partition-i/description/",
        difficulty = Difficulty.MEDIUM
)
public class EqualSumGridPartitionI {
    public boolean canPartitionGrid(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        long totalSum = 0;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                totalSum += grid[row][column];
            }
        }

        long rowSum = 0;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                rowSum += grid[row][column];
            }

            if (totalSum - rowSum == rowSum) {
                return true;
            }
        }


        long columnSum = 0;
        for (int column = 0; column < columns; column++) {
            for (int row = 0; row < rows; row++) {
                columnSum += grid[row][column];
            }

            if (totalSum - columnSum == columnSum) {
                return true;
            }
        }

        return false;
    }
}