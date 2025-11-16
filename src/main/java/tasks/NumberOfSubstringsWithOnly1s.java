package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12-Jul-20
 */
@LeetCode(id = 1513,
        name = "Number of Substrings With Only 1s",
        url = "https://leetcode.com/problems/number-of-substrings-with-only-1s/",
        difficulty = Difficulty.MEDIUM
)
public class NumberOfSubstringsWithOnly1s {
    int MOD = 1_000_000_007;

    public int numSub(String s) {
        long ans = 0;
        int ones = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                ans = (ans + ((long) ones * (ones + 1)) / 2) % MOD;
                ones = 0;
            } else {
                ones++;
            }
        }

        if (ones != 0) {
            ans = (ans + ((long) ones * (ones + 1)) / 2) % MOD;
        }

        return (int) ans;
    }
}
