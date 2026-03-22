package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-03-22
 */
@LeetCode(
        id = 3977,
        name = "Minimum Removals to Achieve Target XOR",
        url = "https://leetcode.com/problems/minimum-removals-to-achieve-target-xor/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumRemovalsToAchieveTargetXOR {
    public int minRemovals(int[] nums, int target) {
        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);

        Map<Long, Integer> leftXor = xorMap(left);
        Map<Long, Integer> rightXor = xorMap(right);

        int max = -1;
        for (long leftX : leftXor.keySet()) {
            long TARGET = leftX ^ target;
            if (rightXor.containsKey(TARGET)) {
                max = Math.max(max, leftXor.get(leftX) + rightXor.get(TARGET));
            }
        }

        return max == -1 ? max : nums.length - max;
    }

    private Map<Long, Integer> xorMap(int[] arr) {
        Map<Long, Integer> xorMap = new HashMap<>();
        for (long mask = 0; mask < (1L << arr.length); mask++) {
            long xor = 0;
            int size = 0;
            for (int i = 0; i < arr.length; i++) {
                if ((mask & (1L << i)) != 0) {
                    xor ^= arr[i];
                    size++;
                }
            }
            xorMap.put(xor, Math.max(xorMap.getOrDefault(xor, 0), size));
        }

        return xorMap;
    }
}