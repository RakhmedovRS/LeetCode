package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-11
 */
@LeetCode(
        id = 2654,
        name = "Minimum Number of Operations to Make All Array Elements Equal to 1",
        url = "https://leetcode.com/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumNumberOfOperationsToMakeAllArrayElementsEqualTo1 {
    public int minOperations(int[] nums) {
        int seenOnes = 0;
        for (int num : nums) {
            if (num == 1) {
                seenOnes++;
            }
        }

        if (seenOnes > 0) {
            return nums.length - seenOnes;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                curr = GCD(curr, nums[j]);
                if (curr == 1) {
                    min = Math.min(min, 1 + j - i);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : nums.length - 1 + min - 1;
    }

    private int GCD(int a, int b) {
        return a == 0 ? b : GCD(b % a, a);
    }
}