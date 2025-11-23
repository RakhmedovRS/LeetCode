package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-22
 */
@LeetCode(
        id = 3751,
        name = "Total Waviness of Numbers in Range I",
        url = "https://leetcode.com/problems/total-waviness-of-numbers-in-range-i/description/",
        difficulty = Difficulty.MEDIUM
)
public class TotalWavinessOfNumbersInRangeI {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;
        while (num1 <= num2) {
            ans += peaksAndValleys(num1);
            num1++;
        }
        return ans;
    }

    private int peaksAndValleys(int num) {
        char[] digits = ("" + num).toCharArray();
        if (digits.length < 3) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < digits.length - 1; i++) {
            int left = digits[i - 1] - '0';
            int mid = digits[i] - '0';
            int right = digits[i + 1] - '0';
            if (left < mid && mid > right) {
                res++;
            } else if (left > mid && mid < right) {
                res++;
            }
        }
        return res;
    }
}