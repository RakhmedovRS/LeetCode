package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-04-15
 */
@LeetCode(
        id = 3488,
        name = "Closest Equal Element Queries",
        url = "https://leetcode.com/problems/closest-equal-element-queries/description/",
        difficulty = Difficulty.MEDIUM
)
public class ClosestEqualElementQueries {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int[] distances = new int[nums.length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Map<Integer, LinkedList<Integer>> memo = new HashMap<>();
        for (int i = 0; i < nums.length * 2; i++) {
            int index = i % nums.length;
            int val = nums[index];
            if (memo.containsKey(val) && (i < nums.length || memo.get(val).size() > 1)) {
                distances[index] = i - memo.get(val).getLast();
            }

            if ((i < nums.length || memo.get(val).size() > 1)) {
                memo.computeIfAbsent(val, L -> new LinkedList<>()).addLast(i);
            }
        }

        memo.clear();
        for (int i = nums.length * 2 - 1; i >= 0; i--) {
            int index = i % nums.length;
            int val = nums[index];
            if (memo.containsKey(val) && (i >= nums.length || memo.get(val).size() > 1)) {
                distances[index] = Math.min(distances[index], memo.get(val).getLast() - i);
            }

            if ((i >= nums.length || memo.get(val).size() > 1)) {
                memo.computeIfAbsent(val, L -> new LinkedList<>()).addLast(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int query : queries) {
            if (distances[query] == Integer.MAX_VALUE) {
                ans.add(-1);
            } else {
                ans.add(distances[query]);
            }
        }

        return ans;
    }
}