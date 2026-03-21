package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-03-20
 */
@LeetCode(
        id = 3643,
        name = "Flip Square Submatrix Vertically",
        url = "https://leetcode.com/problems/flip-square-submatrix-vertically/description/",
        difficulty = Difficulty.EASY
)
public class FlipSquareSubmatrixVertically {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int topRow = x;
        int bottomRow = topRow + k - 1;
        while (topRow < bottomRow) {
            for (int column = y; column < y + k; column++) {
                int temp = grid[topRow][column];
                grid[topRow][column] = grid[bottomRow][column];
                grid[bottomRow][column] = temp;
            }
            topRow++;
            bottomRow--;
        }
        return grid;
    }
}