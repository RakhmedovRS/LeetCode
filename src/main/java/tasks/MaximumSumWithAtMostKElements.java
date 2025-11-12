package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-02-22
 */
@LeetCode(
        id = 3462,
        name = "Maximum Sum With at Most K Elements",
        url = "https://leetcode.com/problems/maximum-sum-with-at-most-k-elements/description/",
        difficulty = Difficulty.MEDIUM
)
public class MaximumSumWithAtMostKElements {
    public long maxSum(int[][] grid, int[] limits, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> grid[b[0]][b[1]] - grid[a[0]][a[1]]);
        for (int row = 0; row < grid.length; row++) {
            Arrays.sort(grid[row]);
            pq.add(new int[]{row, grid[row].length - 1});
        }

        long sum = 0;
        while (k-- > 0) {
            int[] curr = pq.remove();
            int row = curr[0];
            int pos = curr[1];

            if (limits[row] > 0) {
                limits[row]--;
            } else {
                k++;
                continue;
            }

            sum += grid[row][pos--];

            if (pos >= 0) {
                pq.add(new int[]{row, pos});
            }
        }

        return sum;
    }
}