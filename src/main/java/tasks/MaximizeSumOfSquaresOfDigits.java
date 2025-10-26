package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-10-25
 */
@LeetCode(
        id = 3723,
        name = "Maximize Sum of Squares of Digits",
        url = "https://leetcode.com/problems/maximize-sum-of-squares-of-digits/description/",
        difficulty = Difficulty.MEDIUM
)
public class MaximizeSumOfSquaresOfDigits {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder();
        while (sum > 0 && num > 0) {
            for (int digit = 9; digit > 0 && num > 0; digit--) {
                int res = sum / digit;
                while (res-- > 0) {
                    sb.append(digit);
                    num--;
                }
                sum -= (sum / digit) * digit;
            }
        }

        if (num <= 0 && sum > 0) {
            return "";
        }

        while (num-- > 0) {
            sb.append("0");
        }
        return sb.toString();
    }
}