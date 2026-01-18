package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-01-17
 */
@LeetCode(
        id = 1895,
        name = "Largest Magic Square",
        url = "https://leetcode.com/problems/largest-magic-square/description/",
        difficulty = Difficulty.MEDIUM
)
public class LargestMagicSquare {
    public int largestMagicSquare(int[][] grid) {
        int max = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        if (rows == 1 && columns == 1) {
            return 1;
        }

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                for (int m = max + 1; m <= rows; m++) {
                    if (magic(grid, row, column, rows, columns, m)) {
                        max = m;
                    }
                }
            }
        }
        return max;
    }

    private boolean magic(int[][] grid, int row, int column, int rows, int columns, int len) {
        if (row + len > rows || column + len > columns) {
            return false;
        }

        int rowSum = 0;
        for (int c = column; c < column + len; c++) {
            rowSum += grid[row][c];
        }

        int columnSum = 0;
        for (int r = row; r < row + len; r++) {
            columnSum += grid[r][column];
        }

        if (rowSum != columnSum) {
            return false;
        }

        for (int r = row; r < row + len; r++) {
            if (!validRow(r, column, len, grid, rowSum)) {
                return false;
            }
        }

        for (int c = column; c < column + len; c++) {
            if (!validColumn(row, c, len, grid, rowSum)) {
                return false;
            }
        }

        int diagonalSum = 0;
        int r = row;
        int c = column;
        for (int i = 0; i < len; i++) {
            diagonalSum += grid[r][c];
            r++;
            c++;
        }

        if (diagonalSum != rowSum) {
            return false;
        }

        diagonalSum = 0;
        r = row + len - 1;
        c = column;
        for (int i = 0; i < len; i++) {
            diagonalSum += grid[r][c];
            r--;
            c++;
        }

        return diagonalSum == rowSum;
    }

    private boolean validRow(int row, int column, int len, int[][] grid, int targetSum) {
        int sum = 0;
        for (int c = column; c < column + len; c++) {
            sum += grid[row][c];
        }

        return sum == targetSum;
    }

    private boolean validColumn(int row, int column, int len, int[][] grid, int targetSum) {
        int sum = 0;
        for (int r = row; r < row + len; r++) {
            sum += grid[r][column];
        }

        return sum == targetSum;
    }
}