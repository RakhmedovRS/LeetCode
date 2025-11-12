package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-03-26
 */
@LeetCode(
        id = 2033,
        name = "Minimum Operations to Make a Uni-Value Grid",
        url = "https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/description",
        difficulty = Difficulty.MEDIUM
)
public class MinimumOperationsToMakeUniValueGrid {
    public int minOperations(int[][] grid, int x) {
        int[] arr = new int[grid.length * grid[0].length];
        Integer reminder = null;
        int pos = 0;
        for (int[] row : grid) {
            for (int val : row) {
                if (reminder == null) {
                    reminder = val % x;
                } else if (reminder != val % x) {
                    return -1;
                }
                arr[pos++] = val;
            }
        }
        Arrays.sort(arr);

        int ans = 0;
        int left;
        int right;
        int target;
        if (arr.length % 2 == 0) {
            left = arr.length / 2 - 1;
            right = arr.length / 2;
            target = arr[right++];
        } else {
            left = arr.length / 2 - 1;
            right = arr.length / 2 + 1;
            target = arr[arr.length / 2];
        }

        while (left >= 0) {
            ans += (target - arr[left--]) / x;
        }
        while (right < arr.length) {
            ans += (arr[right++] - target) / x;
        }
        return ans;
    }
}