package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-22
 */
@LeetCode(
        id = 3754,
        name = "Concatenate Non-Zero Digits and Multiply by Sum I",
        url = "https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/description/",
        difficulty = Difficulty.EASY
)
public class ConcatenateNonZeroDigitsAndMultiplyBySumI {
    public long sumAndMultiply(int n) {
        String num = "" + n;
        long sum = 0;
        long number = 0;
        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            if (digit > 0) {
                number *= 10;
                number += digit;
                sum += digit;
            }
        }
        return sum * number;
    }
}