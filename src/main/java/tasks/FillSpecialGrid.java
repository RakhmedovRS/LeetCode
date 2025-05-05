package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-05-04
 */
@LeetCode(
        id = 3537,
        name = "Fill a Special Grid",
        url = "https://leetcode.com/problems/fill-a-special-grid/description/",
        difficulty = Difficulty.MEDIUM
)
public class FillSpecialGrid {
    public int[][] specialGrid(int N) {
        int[] rows = new int[(int) Math.pow(2, N)];
        int[] columns = new int[(int) Math.pow(2, N)];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = i;
            columns[i] = i;
        }

        int[] curr = new int[]{0};
        int[][] grid = new int[rows.length][columns.length];
        fill(rows, columns, curr, grid);
        return grid;
    }

    private void fill(int[] rows, int[] columns, int[] curr, int[][] grid) {
        if (rows.length == 1 && columns.length == 1) {
            grid[rows[0]][columns[0]] = curr[0]++;
        } else {
            List<int[]> rowsSplit = split(rows);
            List<int[]> columnsSplit = split(columns);
            fill(rowsSplit.get(0), columnsSplit.get(1), curr, grid);
            fill(rowsSplit.get(1), columnsSplit.get(1), curr, grid);
            fill(rowsSplit.get(1), columnsSplit.get(0), curr, grid);
            fill(rowsSplit.get(0), columnsSplit.get(0), curr, grid);
        }
    }

    private List<int[]> split(int[] arr) {
        int[] left = new int[arr.length / 2];
        int[] right = new int[arr.length / 2];
        for (int i = 0, leftPos = 0, rightPos = 0; i < arr.length; i++) {
            if (i < arr.length / 2) {
                left[leftPos++] = arr[i];
            } else {
                right[rightPos++] = arr[i];
            }
        }

        return Arrays.asList(left, right);
    }
}