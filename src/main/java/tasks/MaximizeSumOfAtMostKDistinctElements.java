package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-16
 */
@LeetCode(
        id = 3684,
        name = "Maximize Sum of At Most K Distinct Elements",
        url = "https://leetcode.com/problems/maximize-sum-of-at-most-k-distinct-elements/description/",
        difficulty = Difficulty.EASY
)
public class MaximizeSumOfAtMostKDistinctElements {
    public int[] maxKDistinct(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int pos = 0;
        int[] ans = new int[Math.min(k, set.size())];
        while (pos < ans.length) {
            ans[pos++] = set.last();
            set.remove(set.last());
        }

        return ans;
    }
}