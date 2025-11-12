package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-09
 */
@LeetCode(
        id = 3740,
        name = "Minimum Distance Between Three Equal Elements I",
        url = "https://leetcode.com/problems/minimum-distance-between-three-equal-elements-i/description/",
        difficulty = Difficulty.EASY
)
public class MinimumDistanceBetweenThreeEqualElementsI {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> memo = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            memo.computeIfAbsent(nums[i], N -> new ArrayList<>()).add(i);
        }

        int min = Integer.MAX_VALUE;
        for (List<Integer> indices : memo.values()) {
            if (indices.size() > 2) {
                for (int pos = 2; pos < indices.size(); pos++) {
                    int i = indices.get(pos - 2);
                    int j = indices.get(pos - 1);
                    int k = indices.get(pos);
                    min = Math.min(min, Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i));
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}