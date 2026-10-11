package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-10-11
 */
@LeetCode(
        id = 4065,
        name = "Rearrange Array by Removing Distinct Values",
        url = "https://leetcode.com/problems/rearrange-array-by-removing-distinct-values/description/",
        difficulty = Difficulty.EASY
)
public class RearrangeArrayByRemovingDistinctValues {
    public int[] rearrangeArray(int[] nums) {
        int[] memo = new int[101];
        for (int num : nums) {
            memo[num]++;
        }

        List<Integer> ans = new ArrayList<>();
        boolean seen = true;
        while (seen) {
            seen = false;
            for (int i = 0; i < memo.length; i++) {
                if (memo[i] > 0) {
                    seen = true;
                    ans.addLast(i);
                    memo[i]--;
                }
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}