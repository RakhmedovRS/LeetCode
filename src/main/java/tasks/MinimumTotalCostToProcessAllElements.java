package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-07-18
 */
@LeetCode(
        id = 3987,
        name = "Minimum Total Cost to Process All Elements",
        url = "https://leetcode.com/problems/minimum-total-cost-to-process-all-elements/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumTotalCostToProcessAllElements {
    int MOD = 1_000_000_007;
    long INV2 = 500000004L;

    public int minimumCost(int[] nums, int k) {
        long resources = k;
        long cost = 0;
        long curr = 1;
        for (long num : nums) {
            if (num <= resources) {
                resources -= num;
            } else {
                num -= resources;
                resources = 0;
                long full = (num + k - 1) / k;
                long start = curr;
                long end = curr + full - 1;
                long add = (full % MOD);
                add = add * ((start + end) % MOD) % MOD;
                add = add * INV2 % MOD;
                cost = (cost + add) % MOD;
                resources = full * (long) k - num;
                curr = end + 1;
            }
        }
        return (int) cost;
    }
}