package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-09-27
 */
@LeetCode(
        id = 3693,
        name = "Climbing Stairs II",
        url = "https://leetcode.com/problems/climbing-stairs-ii/description/",
        difficulty = Difficulty.MEDIUM
)
public class ClimbingStairsII {
    public int climbStairs(int n, int[] costs) {
        int[] arr = new int[costs.length + 1];
        System.arraycopy(costs, 0, arr, 1, costs.length);
        return climbStairS(n, arr);
    }

    public int climbStairS(int n, int[] costs) {
        int[] memo = new int[costs.length];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        for (int i = 0; i < costs.length; i++) {
            for (int j = i + 1; j < costs.length && j <= i + 3; j++) {
                memo[j] = Math.min(memo[j], memo[i] + costs[j] + (j - i) * (j - i));
            }
        }
        return memo[n];
    }
}