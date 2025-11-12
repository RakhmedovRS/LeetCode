package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-09
 */
@LeetCode(
        id = 3741,
        name = "Minimum Distance Between Three Equal Elements II",
        url = "https://leetcode.com/problems/minimum-distance-between-three-equal-elements-ii/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumDistanceBetweenThreeEqualElementsII {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> memo = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int pos = 0; pos < nums.length; pos++) {
            List<Integer> indices = memo.computeIfAbsent(nums[pos], N -> new ArrayList<>());
            indices.add(pos);
            if (indices.size() > 2) {
                int i = indices.get(indices.size() - 3);
                int j = indices.get(indices.size() - 2);
                int k = indices.get(indices.size() - 1);
                min = Math.min(min, Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i));
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}