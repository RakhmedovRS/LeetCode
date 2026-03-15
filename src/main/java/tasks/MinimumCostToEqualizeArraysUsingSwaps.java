package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-03-14
 */
@LeetCode(
        id = 3868,
        name = "Minimum Cost to Equalize Arrays Using Swaps",
        url = "https://leetcode.com/problems/minimum-cost-to-equalize-arrays-using-swaps/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumCostToEqualizeArraysUsingSwaps {
    public int minCost(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if (identical(nums1, nums2)) {
            return 0;
        }

        if (!isPossibleToMatch(nums1, nums2)) {
            return -1;
        }

        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            memo.put(nums1[i], memo.getOrDefault(nums1[i], 0) + 1);
            memo.put(nums2[i], memo.getOrDefault(nums2[i], 0) - 1);
        }

        int swaps = 0;
        for (int qty : memo.values()) {
            swaps += Math.abs(qty) / 2;
        }

        return swaps / 2;
    }

    private boolean identical(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] != nums2[i]) {
                return false;
            }
        }

        return true;
    }

    private boolean isPossibleToMatch(int[] nums1, int[] nums2) {
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            memo.put(nums1[i], memo.getOrDefault(nums1[i], 0) + 1);
            memo.put(nums2[i], memo.getOrDefault(nums2[i], 0) + 1);
        }

        for (int qty : memo.values()) {
            if (qty % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}