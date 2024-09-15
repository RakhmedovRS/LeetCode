package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-09-14
 */
@LeetCode(
        id = 3289,
        name = "The Two Sneaky Numbers of Digitville",
        url = "https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/",
        difficulty = Difficulty.EASY
)
public class TheTwoSneakyNumbersOfDigitville {
    public int[] getSneakyNumbers(int[] nums) {
        Arrays.sort(nums);
        int pos = 0;
        int[] ans = new int[2];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                ans[pos++] = nums[i];
            }
        }
        return ans;
    }
}