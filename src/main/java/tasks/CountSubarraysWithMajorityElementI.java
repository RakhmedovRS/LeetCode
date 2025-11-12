package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-08
 */
@LeetCode(
        id = 3737,
        name = "Count Subarrays With Majority Element I",
        url = "https://leetcode.com/problems/count-subarrays-with-majority-element-i/description/",
        difficulty = Difficulty.MEDIUM
)
public class CountSubarraysWithMajorityElementI {
    public int countMajoritySubarrays(int[] nums, int target) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> memo = new HashMap<>();
            for (int j = i; j < nums.length; j++) {
                int total = 1 + j - i;
                memo.put(nums[j], memo.getOrDefault(nums[j], 0) + 1);
                int targetCount = memo.getOrDefault(target, 0);
                if (targetCount != 0 && targetCount > (total - targetCount)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}