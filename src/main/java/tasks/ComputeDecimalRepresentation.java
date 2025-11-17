package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-16
 */
@LeetCode(
        id = 3697,
        name = "Compute Decimal Representation",
        url = "https://leetcode.com/problems/compute-decimal-representation/description/",
        difficulty = Difficulty.EASY
)
public class ComputeDecimalRepresentation {
    public int[] decimalRepresentation(int n) {
        char[] digits = ("" + n).toCharArray();
        int nonZero = 0;
        long seed = 1;
        for (char ch : digits) {
            if (ch - '0' > 0) {
                nonZero++;
            }
            seed *= 10;
        }

        int pos = 0;
        int[] ans = new int[nonZero];

        for (char digit : digits) {
            seed /= 10;
            if (digit - '0' > 0) {
                ans[pos++] = (int) ((digit - '0') * seed);
            }
        }

        return ans;
    }
}