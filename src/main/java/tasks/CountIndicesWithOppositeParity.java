package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-05-03
 */
@LeetCode(
        id = 3917,
        name = "Count Indices With Opposite Parity",
        url = "https://leetcode.com/problems/count-indices-with-opposite-parity/description/",
        difficulty = Difficulty.EASY
)
public class CountIndicesWithOppositeParity {
    public int[] countOppositeParity(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] % 2 != nums[j] % 2) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }
}