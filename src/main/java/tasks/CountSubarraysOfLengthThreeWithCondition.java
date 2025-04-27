package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-04-27
 */
@LeetCode(
        id = 3392,
        name = "Count Subarrays of Length Three With a Condition",
        url = "https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition/description/",
        difficulty = Difficulty.EASY
)
public class CountSubarraysOfLengthThreeWithCondition {
    public int countSubarrays(int[] nums) {
        int ans = 0;
        for (int i = 2; i < nums.length; i++) {
            if ((nums[i - 2] + nums[i]) * 2 == nums[i - 1]) {
                ans++;
            }
        }
        return ans;
    }
}