package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-09-05
 */
@LeetCode(
        id = 4040,
        name = "Minimum Operations to Form Subset Sum I",
        url = "https://leetcode.com/problems/minimum-operations-to-form-subset-sum-i/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumOperationsToFormSubsetSumI {
    public int minOperations(int[] nums, int sum) {
        int[] memo = new int[sum + 1];
        Arrays.fill(memo, Integer.MAX_VALUE / 2);
        memo[0] = 0;

        for (int num : nums) {
            Map<Integer, Integer> states = new HashMap<>();
            states.put(num, 0);

            long value = num;
            int ops = 0;
            while (value <= sum) {
                states.merge((int) value, ops, Math::min);

                value *= 2;
                ops++;

                if (value > sum && value > Integer.MAX_VALUE / 2) {
                    break;
                }
            }

            value = num;
            ops = 0;

            while (value > 0) {
                states.merge((int) value, ops, Math::min);
                value /= 2;
                ops++;
            }

            int[] next = memo.clone();
            for (Map.Entry<Integer, Integer> entry : states.entrySet()) {
                int v = entry.getKey();
                int cost = entry.getValue();

                if (v > sum) {
                    continue;
                }

                for (int s = 0; s + v <= sum; s++) {
                    if (memo[s] != Integer.MAX_VALUE / 2) {
                        next[s + v] = Math.min(
                                next[s + v],
                                memo[s] + cost
                        );
                    }
                }
            }

            memo = next;
        }

        return memo[sum] == Integer.MAX_VALUE / 2 ? -1 : memo[sum];
    }
}