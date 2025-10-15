package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-10-14
 */
@LeetCode(
        id = 3350,
        name = "Adjacent Increasing Subarrays Detection II",
        url = "https://leetcode.com/problems/adjacent-increasing-subarrays-detection-ii/description/",
        difficulty = Difficulty.MEDIUM
)
public class AdjacentIncreasingSubarraysDetectionII {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int[] leftToRight = new int[nums.size()];
        Arrays.fill(leftToRight, 1);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) < nums.get(i)) {
                leftToRight[i] += leftToRight[i - 1];
            }
        }

        int[] rightToLeft = new int[nums.size()];
        Arrays.fill(rightToLeft, 1);
        for (int i = rightToLeft.length - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) {
                rightToLeft[i] += rightToLeft[i + 1];
            }
        }

        int max = 1;
        for (int i = 1; i < leftToRight.length - 2; i++) {
            max = Math.max(max, Math.min(leftToRight[i], rightToLeft[i + 1]));
        }

        return max;
    }
}