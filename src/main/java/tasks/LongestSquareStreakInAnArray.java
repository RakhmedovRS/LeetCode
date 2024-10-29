package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-10-27
 */
@LeetCode(
        id = 2501,
        name = "Longest Square Streak in an Array",
        url = "https://leetcode.com/problems/longest-square-streak-in-an-array/description/",
        difficulty = Difficulty.MEDIUM
)
public class LongestSquareStreakInAnArray {
    public int longestSquareStreak(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        Arrays.sort(nums);
        int longest = -1;
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            int res = dfs(num, set, seen);
            if (res > 1) {
                longest = Math.max(longest, res);
            }
        }

        return longest;
    }

    private int dfs(int num, Set<Integer> set, Set<Integer> seen) {
        if (seen.contains(num)) {
            return 0;
        }

        if (set.contains(num)) {
            seen.add(num);
            return 1 + dfs(num * num, set, seen);
        }
        return 0;
    }
}