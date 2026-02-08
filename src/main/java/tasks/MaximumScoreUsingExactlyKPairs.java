package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-02-07
 */
@LeetCode(
        id = 3836,
        name = "Maximum Score Using Exactly K Pairs",
        url = "https://leetcode.com/problems/maximum-score-using-exactly-k-pairs/description/",
        difficulty = Difficulty.HARD
)
public class MaximumScoreUsingExactlyKPairs {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        Long[][][] memo = new Long[nums1.length + 1][nums2.length + 1][k + 1];
        dfs(0, 0, nums1, nums2, k, memo);
        return memo[0][0][k];
    }

    private long dfs(int i, int j, int[] nums1, int[] nums2, int k, Long[][][] memo) {
        if (k == 0) {
            return 0;
        }

        if (i >= nums1.length || j >= nums2.length) {
            return Long.MIN_VALUE / 10;
        }

        if (memo[i][j][k] != null) {
            return memo[i][j][k];
        }

        long I = dfs(i + 1, j, nums1, nums2, k, memo);
        long J = dfs(i, j + 1, nums1, nums2, k, memo);
        long USE = (long) nums1[i] * nums2[j] + dfs(i + 1, j + 1, nums1, nums2, k - 1, memo);

        memo[i][j][k] = Math.max(I, Math.max(J, USE));
        return memo[i][j][k];
    }
}