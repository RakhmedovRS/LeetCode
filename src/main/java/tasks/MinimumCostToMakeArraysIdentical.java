package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-01-18
 */
@LeetCode(
        id = 3424,
        name = "Minimum Cost to Make Arrays Identical",
        url = "https://leetcode.com/problems/minimum-cost-to-make-arrays-identical/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumCostToMakeArraysIdentical {
    public long minCost(int[] arr, int[] brr, long k) {
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans += Math.abs(arr[i] - brr[i]);
        }

        Arrays.sort(arr);
        Arrays.sort(brr);

        long diff = 0;
        for (int i = 0; i < arr.length; i++) {
            diff += Math.abs(arr[i] - brr[i]);
        }

        return Math.min(ans, diff + k);
    }
}