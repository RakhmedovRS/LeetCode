package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-05-09
 */
@LeetCode(
        id = 3925,
        name = "Concatenate Array With Reverse",
        url = "https://leetcode.com/problems/concatenate-array-with-reverse/description/",
        difficulty = Difficulty.EASY
)
public class ConcatenateArrayWithReverse {
    public int[] concatWithReverse(int[] nums) {
        int[] ans = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
        }

        int pos = nums.length - 1;
        for (int i = nums.length; i < ans.length; i++) {
            ans[i] = nums[pos--];
        }
        return ans;
    }
}