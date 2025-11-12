package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-08-16
 */
@LeetCode(
        id = 3653,
        name = "XOR After Range Multiplication Queries I",
        url = "https://leetcode.com/problems/xor-after-range-multiplication-queries-i/description/",
        difficulty = Difficulty.MEDIUM
)
public class XORAfterRangeMultiplicationQueriesI {
    int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int ans = 0;
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int v = query[3];
            while (l <= r) {
                nums[l] = (int) (((long) nums[l] * v) % MOD);
                l += k;
            }
        }
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }
}