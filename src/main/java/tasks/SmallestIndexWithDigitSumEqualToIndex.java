package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-05-18
 */
@LeetCode(
        id = 3550,
        name = "Smallest Index With Digit Sum Equal to Index",
        url = "https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/description/",
        difficulty = Difficulty.EASY
)
public class SmallestIndexWithDigitSumEqualToIndex {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            while (nums[i] > 0) {
                sum += nums[i] % 10;
                nums[i] /= 10;
            }

            if (sum == i) {
                return i;
            }
        }
        return -1;
    }
}