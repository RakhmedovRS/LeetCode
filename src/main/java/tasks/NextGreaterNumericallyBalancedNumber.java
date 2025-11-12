package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-10-23
 */
@LeetCode(
        id = 2048,
        name = "Next Greater Numerically Balanced Number",
        url = "https://leetcode.com/problems/next-greater-numerically-balanced-number/description/",
        difficulty = Difficulty.MEDIUM
)
public class NextGreaterNumericallyBalancedNumber {
    public int nextBeautifulNumber(int n) {
        int len = ("" + n).length();

        int[] min = new int[]{Integer.MAX_VALUE};
        dfs(new int[10], len, min, 0, n);
        dfs(new int[10], len + 1, min, 0, n);
        return min[0];
    }

    private void dfs(int[] used, int len, int[] min, int curr, int n) {
        if (len <= 0 && isValid(used) && curr > n) {
            min[0] = Math.min(min[0], curr);
            return;
        }

        for (int i = 1; i < 10; i++) {
            int nextLen;
            if (used[i] > 0) {
                nextLen = len;
            } else {
                nextLen = len - i;
            }

            if ((nextLen >= -2 && used[i] < i) || (used[i] < i && used[i] > 0)) {
                used[i]++;
                dfs(used, nextLen, min, curr * 10 + i, n);
                used[i]--;
            }
        }
    }

    private boolean isValid(int[] memo) {
        for (int i = 1; i < memo.length; i++) {
            if (memo[i] > 0 && i != memo[i]) {
                return false;
            }
        }
        return true;
    }
}