package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-08-02
 */
@LeetCode(
        id = 3634,
        name = "Minimum Removals to Balance Array",
        url = "https://leetcode.com/problems/minimum-removals-to-balance-array/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumRemovalsToBalanceArray {
    public int minRemoval(int[] nums, int k) {
        if (nums.length == 1) {
            return 0;
        }

        Arrays.sort(nums);
        TreeMap<Long, LinkedList<Integer>> positions = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            positions.computeIfAbsent((long) nums[i], n -> new LinkedList<>());
            positions.get((long) nums[i]).add(i);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            Map.Entry<Long, LinkedList<Integer>> entry = positions.floorEntry((long) nums[i] * k);
            if (entry != null) {
                int j = entry.getValue().getLast();

                int len = 1 + j - i;
                ans = Math.min(ans, nums.length - len);
            }
        }

        return ans;
    }
}