package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-01
 */
@LeetCode(
        id = 3731,
        name = "Find Missing Elements",
        url = "https://leetcode.com/problems/find-missing-elements/description/",
        difficulty = Difficulty.EASY
)
public class FindMissingElements {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean[] memo = new boolean[101];
        for (int num : nums) {
            memo[num] = true;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        List<Integer> ans = new ArrayList<>();
        while (min <= max) {
            if (!memo[min]) {
                ans.add(min);
            }
            min++;
        }
        return ans;
    }
}