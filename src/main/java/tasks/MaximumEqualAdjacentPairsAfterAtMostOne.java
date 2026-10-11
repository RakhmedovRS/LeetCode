package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-10-11
 */
@LeetCode(
        id = 4066,
        name = "Maximum Equal Adjacent Pairs After at Most One",
        url = "https://leetcode.com/problems/maximum-equal-adjacent-pairs-after-at-most-one-replacement/description/",
        difficulty = Difficulty.MEDIUM
)
public class MaximumEqualAdjacentPairsAfterAtMostOne {
    public int maxEqualAdjacentPairs(int[] nums) {
        Map<Integer, Map<Integer, Integer>> neighbors = new HashMap<>();
        int base = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int a = nums[i];
            int b = nums[i + 1];

            if (a == b) {
                base++;
                continue;
            }
            neighbors.computeIfAbsent(a, k -> new HashMap<>()).merge(b, 1, Integer::sum);
            neighbors.computeIfAbsent(b, k -> new HashMap<>()).merge(a, 1, Integer::sum);
        }

        int best = 0;
        for (Map<Integer, Integer> map : neighbors.values()) {
            for (int gain : map.values()) {
                best = Math.max(best, gain);
            }
        }

        return base + best;
    }
}