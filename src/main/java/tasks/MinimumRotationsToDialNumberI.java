package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-10-11
 */
@LeetCode(
        id = 4070,
        name = "Minimum Rotations to Dial a Number I",
        url = "https://leetcode.com/problems/minimum-rotations-to-dial-a-number-i/description/",
        difficulty = Difficulty.EASY
)
public class MinimumRotationsToDialNumberI {
    public int minRotations(String s) {
        int pos = 0;
        int ans = 0;
        for (char ch : s.toCharArray()) {
            ans += distance(pos, ch - '0');
            pos = ch - '0';
        }
        return ans;
    }

    private int distance(int a, int b) {
        int distance = Math.abs(a - b);
        return Math.min(distance, 10 - distance);
    }
}