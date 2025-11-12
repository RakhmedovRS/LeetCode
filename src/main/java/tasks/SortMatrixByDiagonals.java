package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-08-27
 */
@LeetCode(
        id = 3446,
        name = "Sort Matrix by Diagonals",
        url = "https://leetcode.com/problems/sort-matrix-by-diagonals/description/",
        difficulty = Difficulty.MEDIUM
)
public class SortMatrixByDiagonals {
    public int[][] sortMatrix(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int row = rows - 1;
        int column = 0;

        while (column < columns) {
            List<Integer> numbers = getDiagonalNumber(row, column, grid);
            if (column > 0) {
                numbers.sort(Comparator.naturalOrder());
            } else {
                numbers.sort(Comparator.reverseOrder());
            }
            updateGrid(row, column, grid, numbers);
            if (row == 0) {
                column++;
            } else {
                row--;
            }
        }
        return grid;
    }

    private List<Integer> getDiagonalNumber(int row, int column, int[][] grid) {
        List<Integer> numbers = new ArrayList<>();
        while (row < grid.length && column < grid[row].length) {
            numbers.add(grid[row++][column++]);
        }
        return numbers;
    }

    private void updateGrid(int row, int column, int[][] grid, List<Integer> numbers) {
        for (int number : numbers) {
            grid[row++][column++] = number;
        }
    }
}