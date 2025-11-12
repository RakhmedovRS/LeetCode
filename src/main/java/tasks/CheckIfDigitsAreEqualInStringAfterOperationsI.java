package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-02-22
 */
@LeetCode(
        id = 3461,
        name = "Check If Digits Are Equal in String After Operations I",
        url = "https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/description/",
        difficulty = Difficulty.EASY
)
public class CheckIfDigitsAreEqualInStringAfterOperationsI {
    public boolean hasSameDigits(String s) {
        int[] digits = new int[s.length()];
        int pos = 0;
        for (char ch : s.toCharArray()) {
            digits[pos++] = ch - '0';
        }

        int end = digits.length;
        while (end != 2) {
            for (int i = 1; i < end; i++) {
                digits[i - 1] = (digits[i - 1] + digits[i]) % 10;
            }
            end--;
        }
        return digits[0] == digits[1];
    }
}