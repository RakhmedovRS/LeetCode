package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 9/9/2022
 * @$
 * @$
 */
@LeetCode(
        id = 2400,
        name = "Number of Ways to Reach a Position After Exactly k Steps",
        url = "https://leetcode.com/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/",
        difficulty = Difficulty.MEDIUM
)
public class NumberOfWaysToReachPositionAfterExactlyKSteps
{
    int MOD = 1_000_000_007;

    public int numberOfWays(int startPos, int endPos, int k)
    {
        Map<Integer, Map<Integer, Long>> memo = new HashMap<>();
        dfs(startPos, endPos, k, memo);
        return (int)(memo.get(startPos).get(k) % MOD);
    }

    private long dfs(int pos, int endPos, int k, Map<Integer, Map<Integer, Long>> memo)
    {
        if (k < 0)
        {
            return 0;
        }

        if (k == 0)
        {
            return pos == endPos ? 1 : 0;
        }

        memo.putIfAbsent(pos, new HashMap<>());
        if (memo.get(pos).containsKey(k))
        {
            return memo.get(pos).get(k);
        }


        long count = 0;

        count += dfs(pos - 1, endPos, k - 1, memo);
        count %= MOD;

        count += dfs(pos + 1, endPos, k - 1, memo);
        count %= MOD;

        memo.get(pos).put(k, count);

        return count;
    }
}
