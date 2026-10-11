package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-10-11
 */
@LeetCode(
        id = 4071,
        name = "Minimum Rotations to Dial a Number II",
        url = "https://leetcode.com/problems/minimum-rotations-to-dial-a-number-ii/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumRotationsToDialNumberII {
    public int minRotations(int n, String s) {
        int pos = 0;
        int ans = 0;
        for (char ch : s.toCharArray()) {
            ans += distance(pos, ch - '0');
            pos = ch - '0';
        }

        char[] chars = s.toCharArray();
        int total = ans;
        for (int k = 0; k < n; k++) {
            int current = total;
            if (k == 0) {
                current -= distance(0, chars[0] - '0');
                current += distance(0, chars[n - 1] - '0');
            } else {
                current -= distance(chars[k - 1] - '0', chars[k] - '0');
                current += distance(chars[k - 1] - '0', chars[n - 1] - '0');
            }
            ans = Math.min(ans, current);
        }

        return ans;
    }

    private int distance(int a, int b) {
        int distance = Math.abs(a - b);
        return Math.min(distance, 10 - distance);
    }
}