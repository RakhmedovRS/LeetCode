package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-08
 */
@LeetCode(
        id = 3738,
        name = "Longest Non-Decreasing Subarray After Replacing at Most One Element",
        url = "https://leetcode.com/problems/longest-non-decreasing-subarray-after-replacing-at-most-one-element/description/",
        difficulty = Difficulty.MEDIUM
)
public class LongestNonDecreasingSubarrayAfterReplacingAtMostOneElement {
    public int longestSubarray(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] += 1_000_000_000;
        }

        int[] leftToRight = new int[nums.length];
        int[] rightToLeft = new int[nums.length];

        int ans = 0;
        LinkedList<Integer> storage = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (storage.isEmpty() || storage.getLast() <= num) {
                storage.addLast(num);
            } else {
                storage.clear();
                storage.addLast(num);
            }
            leftToRight[i] = storage.size();
            ans = Math.max(ans, storage.size());
        }

        storage = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            if (storage.isEmpty() || storage.getLast() >= num) {
                storage.addLast(num);
            } else {
                storage.clear();
                storage.addLast(num);
            }
            rightToLeft[i] = storage.size();
            ans = Math.max(ans, storage.size());
        }

        for (int i = 0; i < leftToRight.length - 1; i++) {
            if (i + 2 < nums.length && nums[i] > nums[i + 1] && nums[i] <= nums[i + 2]) {
                ans = Math.max(ans, leftToRight[i] + rightToLeft[i + 1]);
            }
            ans = Math.max(ans, leftToRight[i] + 1);
        }

        for (int i = nums.length - 1; i > 0; i--) {
            if (i - 2 >= 0 && nums[i] < nums[i - 1] && nums[i] >= nums[i - 2]) {
                ans = Math.max(ans, rightToLeft[i] + leftToRight[i - 1]);
            }
            ans = Math.max(ans, rightToLeft[i] + 1);
        }

        return ans;
    }
}