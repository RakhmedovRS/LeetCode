package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-04-25
 */
@LeetCode(
        id = 3908,
        name = "Valid Digit Number",
        url = "https://leetcode.com/problems/valid-digit-number/description/",
        difficulty = Difficulty.EASY
)
public class ValidDigitNumber {
    public boolean validDigit(int n, int x) {
        String num = "" + n;
        return !num.startsWith("" + x) && num.contains("" + x);
    }
}