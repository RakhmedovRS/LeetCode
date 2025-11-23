package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-22
 */
@LeetCode(
        id = 3752,
        name = "Lexicographically Smallest Negated Permutation that Sums to Target",
        url = "https://leetcode.com/problems/lexicographically-smallest-negated-permutation-that-sums-to-target/description/",
        difficulty = Difficulty.MEDIUM
)
public class LexicographicallySmallestNegatedPermutationThatSumsToTarget {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        long sum = 0;
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            sum += i;
            nums[i - 1] = i;
        }

        if (sum < Math.abs(target)) {
            return new int[0];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            long currentDiff;
            long newDiff;
            if (target < 0) {
                currentDiff = sum - target;
                newDiff = (sum - nums[i] * 2L) - target;
            } else {
                currentDiff = sum - target;
                newDiff = (sum - nums[i] * 2L) - target;
            }

            if (newDiff < currentDiff && newDiff >= 0) {
                sum -= nums[i] * 2L;
                nums[i] *= -1;
            }
        }

        sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum != target) {
            return new int[0];
        }

        Arrays.sort(nums);
        return nums;
    }
}