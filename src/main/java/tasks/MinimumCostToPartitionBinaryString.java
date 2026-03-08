package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-03-07
 */
@LeetCode(
        id = 3864,
        name = "Minimum Cost to Partition a Binary String",
        url = "https://leetcode.com/problems/minimum-cost-to-partition-a-binary-string/description/",
        difficulty = Difficulty.HARD
)
public class MinimumCostToPartitionBinaryString {
    public long minCost(String s, int encCost, int flatCost) {
        int[] memo = new int[s.length()];
        for (int i = 0; i < memo.length; i++) {
            memo[i] += s.charAt(i) - '0';
            if (i > 0) {
                memo[i] += memo[i - 1];
            }
        }

        int sum = getSum(memo, 0, s.length() - 1);
        if (sum == 0) {
            return flatCost;
        }

        return minCost(memo, 0, s.length() - 1, encCost, flatCost, new HashMap<>());
    }

    public long minCost(int[] memo, int left, int right, int encCost, int flatCost, Map<Integer, Map<Integer, Long>> MEMO) {
        int sum = getSum(memo, left, right);
        if (sum == 0) {
            return flatCost;
        }

        if (MEMO.containsKey(left) && MEMO.get(left).containsKey(right)) {
            return MEMO.get(left).get(right);
        }

        MEMO.putIfAbsent(left, new HashMap<>());

        int len = (1 + right - left);
        long curr = (long) sum * len * encCost;
        if (len % 2 != 0) {
            return curr;
        }

        int mid = left + len / 2;

        long leftSplit = minCost(memo, left, mid - 1, encCost, flatCost, MEMO);
        long rightSplit = minCost(memo, mid, right, encCost, flatCost, MEMO);

        MEMO.get(left).put(right, Math.min(curr, leftSplit + rightSplit));
        return MEMO.get(left).get(right);
    }

    private int getSum(int[] memo, int left, int right) {
        return memo[right] - (left == 0 ? 0 : memo[left - 1]);
    }
}