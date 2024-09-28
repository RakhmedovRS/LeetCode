package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-09-28
 */
@LeetCode(
        id = 3300,
        name = "Minimum Element After Replacement With Digit Sum",
        url = "https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/description/",
        difficulty = Difficulty.EASY
)
public class MinimumElementAfterReplacementWithDigitSum {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            min = Math.min(min, sum);
        }
        return min;
    }
}