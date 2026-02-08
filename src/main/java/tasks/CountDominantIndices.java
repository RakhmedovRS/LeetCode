package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-02-07
 */
@LeetCode(
        id = 3833,
        name = "Count Dominant Indices",
        url = "https://leetcode.com/problems/count-dominant-indices/description/",
        difficulty = Difficulty.EASY
)
public class CountDominantIndices {
    public int dominantIndices(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int ans = 0;
        int total = nums.length;
        for (int i = 0; i < nums.length - 1; i++) {
            sum -= nums[i];
            total--;
            if (nums[i] > sum / total) {
                ans++;
            }
        }
        return ans;
    }
}