package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-08-09
 */
@LeetCode(
        id = 4016,
        name = "Maximum Area of Two Non-Overlapping Square Submatrices",
        url = "https://leetcode.com/problems/maximum-area-of-two-non-overlapping-square-submatrices/description/",
        difficulty = Difficulty.MEDIUM
)
public class MaximumAreaOfTwoNonOverlappingSquareSubmatrices {
    public int maxArea(int[][] mat) {
        int rows = mat.length;
        int columns = mat[0].length;

        int[][] top = new int[rows][columns];
        int[][] bottom = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (mat[row][column] == 1) {
                    top[row][column] = 1;
                    if (row > 0 && column > 0) {
                        top[row][column] += Math.min(top[row - 1][column - 1], Math.min(top[row - 1][column], top[row][column - 1]));
                    }
                }
            }
        }

        for (int row = rows - 1; row >= 0; row--) {
            for (int column = columns - 1; column >= 0; column--) {
                if (mat[row][column] == 1) {
                    bottom[row][column] = 1;
                    if (row < rows - 1 && column < columns - 1) {
                        bottom[row][column] += Math.min(bottom[row + 1][column + 1], Math.min(bottom[row + 1][column], bottom[row][column + 1]));
                    }
                }
            }
        }

        int ans = 0;

        int[] TOP = new int[rows];
        int[] BOTTOM = new int[rows];
        for (int row = 0; row < rows; row++) {
            int optimal = 0;

            for (int column = 0; column < columns; column++) {
                optimal = Math.max(optimal, top[row][column]);
            }

            TOP[row] = optimal;
            if (row > 0) {
                TOP[row] = Math.max(TOP[row], TOP[row - 1]);
            }
        }

        for (int row = rows - 1; row >= 0; row--) {
            int optimal = 0;

            for (int column = 0; column < columns; column++) {
                optimal = Math.max(optimal, bottom[row][column]);
            }

            BOTTOM[row] = optimal;
            if (row + 1 < rows) {
                BOTTOM[row] = Math.max(BOTTOM[row], BOTTOM[row + 1]);
            }
        }

        for (int row = 0; row + 1 < rows; row++) {
            int min = Math.min(TOP[row], BOTTOM[row + 1]);
            ans = Math.max(ans, min);
        }

        int[] LEFT = new int[columns];
        int[] RIGHT = new int[columns];
        for (int column = 0; column < columns; column++) {
            int optimal = 0;
            for (int row = 0; row < rows; row++) {
                optimal = Math.max(optimal, top[row][column]);
            }

            LEFT[column] = optimal;
            if (column > 0) {
                LEFT[column] = Math.max(LEFT[column], LEFT[column - 1]);
            }
        }

        for (int column = columns - 1; column >= 0; column--) {
            int optimal = 0;
            for (int row = 0; row < rows; row++) {
                optimal = Math.max(optimal, bottom[row][column]);
            }

            RIGHT[column] = optimal;
            if (column + 1 < columns) {
                RIGHT[column] = Math.max(RIGHT[column], RIGHT[column + 1]);
            }
        }

        for (int column = 0; column + 1 < columns; column++) {
            int min = Math.min(LEFT[column], RIGHT[column + 1]);
            ans = Math.max(ans, min);
        }

        return ans * ans;
    }
}