package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-03-01
 */
@LeetCode(
        id = 3857,
        name = "Minimum Cost to Split into Ones",
        url = "https://leetcode.com/problems/minimum-cost-to-split-into-ones/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumCostToSplitIntoOnes {
    public int minCost(int n) {
        int cost = 0;
        TreeMap<Integer, Integer> memo = new TreeMap<>();
        memo.put(n, 1);
        while (!memo.isEmpty()) {
            int curr = memo.lastKey();
            int count = memo.remove(curr);
            if (curr == 1) {
                continue;
            }
            if (curr % 2 == 0) {
                cost += (curr / 2) * (curr / 2) * count;
                memo.put(curr / 2, memo.getOrDefault(curr / 2, 0) + count * 2);
            } else {
                cost += ((curr + 1) / 2) * (curr / 2) * count;
                memo.put((curr + 1) / 2, memo.getOrDefault((curr + 1) / 2, 0) + count);
                memo.put(curr / 2, memo.getOrDefault(curr / 2, 0) + count);
            }
        }
        return cost;
    }
}