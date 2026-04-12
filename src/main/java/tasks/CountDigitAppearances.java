package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-04-11
 */
@LeetCode(
        id = 3895,
        name = "Count Digit Appearances",
        url = "https://leetcode.com/problems/count-digit-appearances/description/",
        difficulty = Difficulty.MEDIUM
)
public class CountDigitAppearances {
    public int countDigitOccurrences(int[] nums, int digit) {
        int ans = 0;
        for (int num : nums) {
            while (num > 0) {
                if (num % 10 == digit) {
                    ans++;
                }
                num /= 10;
            }
        }
        return ans;
    }
}