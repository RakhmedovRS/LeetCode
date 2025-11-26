package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-25
 */
@LeetCode(
        id = 2229,
        name = "Check if an Array Is Consecutive",
        url = "https://leetcode.com/problems/check-if-an-array-is-consecutive/description/",
        difficulty = Difficulty.EASY,
        premium = true
)
public class CheckIfAnArrayIsConsecutive {
    public boolean isConsecutive(int[] nums) {
        boolean[] memo = new boolean[100001];
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            memo[num] = true;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!memo[min++]){
                return false;
            }
        }
        return true;
    }
}