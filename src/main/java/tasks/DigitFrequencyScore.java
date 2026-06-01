package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-05-31
 */
@LeetCode(
        id = 3945,
        name = "Digit Frequency Score",
        url = "https://leetcode.com/problems/digit-frequency-score/description/",
        difficulty = Difficulty.EASY
)
public class DigitFrequencyScore {
    public int digitFrequencyScore(int n) {
        int[] memo = new int[10];
        while (n > 0) {
            memo[n % 10]++;
            n /= 10;
        }

        int ans = 0;
        for (int i = 1; i < 10; i++) {
            ans += i * memo[i];
        }
        return ans;
    }
}