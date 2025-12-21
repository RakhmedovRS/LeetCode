package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-12-20
 */
@LeetCode(
        id = 3784,
        name = "Minimum Deletion Cost to Make All Characters Equal",
        url = "https://leetcode.com/problems/minimum-deletion-cost-to-make-all-characters-equal/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumDeletionCostToMakeAllCharactersEqual {
    public long minCost(String s, int[] cost) {
        long min = Long.MAX_VALUE;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            long sum = 0L;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ch) {
                    sum += cost[i];
                }
            }
            min = Math.min(min, sum);
        }

        return min;
    }
}