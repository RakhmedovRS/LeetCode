package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-10-13
 */
@LeetCode(
        id = 3349,
        name = "Adjacent Increasing Subarrays Detection I",
        url = "https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i/description/",
        difficulty = Difficulty.EASY
)
public class AdjacentIncreasingSubarraysDetectionI {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int length = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) >= nums.get(i)) {
                length = 1;
            } else {
                length++;
            }
            if (length >= k && increasing(nums, k - 1, 1 + i + k)) {
                return true;
            }
        }
        return false;
    }

    private boolean increasing(List<Integer> nums, int k, int start) {
        while (k > 0 && start < nums.size() - 1) {
            if (nums.get(start) >= nums.get(start + 1)) {
                return false;
            }
            k--;
            start++;
        }

        return k <= 0;
    }
}