package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 11/13/2022
 */
@LeetCode(
        id = 2466,
        name = "Count Ways To Build Good Strings",
        url = "https://leetcode.com/problems/count-ways-to-build-good-strings/",
        difficulty = Difficulty.MEDIUM
)
public class CountWaysToBuildGoodStrings
{
    int MOD = 1_000_000_007;

    public int countGoodStrings(int low, int high, int zero, int one)
    {
        long[] memo = new long[high + 1];
        memo[0] = 1;
        for (int i = 0; i <= high; i++)
        {
            if (i + zero < memo.length)
            {
                memo[i + zero] = (memo[i] + memo[i + zero]) % MOD;
            }

            if (i + one < memo.length)
            {
                memo[i + one] = (memo[i] + memo[i + one]) % MOD;
            }
        }

        long result = 0L;
        while (low <= high)
        {
            result = (result + memo[low++]) % MOD;
        }

        return (int) result;
    }
}
