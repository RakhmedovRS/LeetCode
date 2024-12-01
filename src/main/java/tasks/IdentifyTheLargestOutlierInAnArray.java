package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-11-30
 */
@LeetCode(
        id = 3371,
        name = "Identify the Largest Outlier in an Array",
        url = "https://leetcode.com/problems/identify-the-largest-outlier-in-an-array/",
        difficulty = Difficulty.MEDIUM
)
public class IdentifyTheLargestOutlierInAnArray {
    public int getLargestOutlier(int[] nums) {
        int totalSum = 0;
        int max = Integer.MIN_VALUE;
        Arrays.sort(nums);
        Map<Integer, Integer> memo = new HashMap<>();
        for (int num : nums) {
            totalSum += num;
            memo.put(num, memo.getOrDefault(num, 0) + 1);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            totalSum -= num;
            int count = memo.remove(num);
            if (--count > 0) {
                memo.put(num, count);
            }
            if (totalSum % 2 == 0 && memo.containsKey(totalSum / 2)) {
                max = Math.max(max, num);
            }
            totalSum += num;
            memo.put(num, memo.getOrDefault(num, 0) + 1);
        }
        return max;
    }
}