package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-03-01
 */
@LeetCode(
        id = 1536,
        name = "Minimum Swaps to Arrange a Binary Grid",
        url = "https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumSwapsToArrangeBinaryGrid {
    public int minSwaps(int[][] grid) {
        int rows = grid.length;
        int columns = grid.length;
        int[] zeros = new int[rows];
        for (int row = 0; row < rows; row++) {
            int seenZeroes = 0;
            for (int column = columns - 1; column >= 0; column--) {
                if (grid[row][column] != 0) {
                    break;
                }
                seenZeroes++;
            }
            zeros[row] = seenZeroes;
        }

        int ans = 0;
        for (int row = 0; row < rows; row++) {
            boolean found = false;
            int desiredZeros = grid.length - row - 1;
            for (int i = row; i < zeros.length; i++) {
                if (zeros[i] >= desiredZeros) {
                    while (i > row) {
                        int temp = zeros[i];
                        zeros[i] = zeros[i - 1];
                        zeros[i - 1] = temp;
                        ans++;
                        i--;
                    }

                    found = true;
                    break;
                }
            }

            if (!found) {
                return -1;
            }
        }
        return ans;
    }
}