package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-15
 */
@LeetCode(
        id = 3747,
        name = "Count Distinct Integers After Removing Zeros",
        url = "https://leetcode.com/problems/count-distinct-integers-after-removing-zeros/description/",
        difficulty = Difficulty.MEDIUM
)
public class CountDistinctIntegersAfterRemovingZeros {
    public long countDistinct(long n) {
        String N = ("" + n);
        long len = N.length();
        long smaller = 0;
        for (int i = 1; i < len; i++) {
            smaller += (long) Math.pow(9, i);
        }

        long additional = 0;
        boolean seenZero = false;
        for (int i = 0; i < N.length(); i++) {
            char ch = N.charAt(i);
            long d = ch - '0';
            if (d == 0) {
                seenZero = true;
                break;
            }

            long variants = d - 1;
            long positions = N.length() - i - 1;
            additional += variants * ((long) Math.pow(9, positions));
        }

        if (!seenZero) {
            additional++;
        }

        return additional + smaller;
    }
}