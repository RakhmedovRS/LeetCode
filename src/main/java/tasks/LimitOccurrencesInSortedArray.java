package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-05-25
 */
@LeetCode(
        id = 3940,
        name = "Limit Occurrences in Sorted Array",
        url = "https://leetcode.com/problems/limit-occurrences-in-sorted-array/description/",
        difficulty = Difficulty.EASY
)
public class LimitOccurrencesInSortedArray {
    public int[] limitOccurrences(int[] nums, int k) {
        int[] seen = new int[101];
        List<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            if (++seen[num] <= k) {
                temp.add(num);
            }
        }

        int[] ans = new int[temp.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = temp.get(i);
        }
        return ans;
    }
}