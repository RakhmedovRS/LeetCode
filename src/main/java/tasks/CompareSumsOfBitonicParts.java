package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-04-25
 */
@LeetCode(
        id = 3909,
        name = "Compare Sums of Bitonic Parts",
        url = "https://leetcode.com/problems/compare-sums-of-bitonic-parts/description/",
        difficulty = Difficulty.MEDIUM
)
public class CompareSumsOfBitonicParts {
    public int compareBitonicSums(int[] nums) {
        long left = 0;
        long right = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        for (int i = 0; i < nums.length && max > nums[i]; i++) {
            left += nums[i];
        }

        for (int i = nums.length - 1; i >= 0 && max > nums[i]; i--) {
            right += nums[i];
        }

        if (left == right) {
            return -1;
        }

        return left < right ? 1 : 0;
    }
}