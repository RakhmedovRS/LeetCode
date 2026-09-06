package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-09-05
 */
@LeetCode(
        id = 4038,
        name = "Count Integers Appearing in a Single Block",
        url = "https://leetcode.com/problems/count-integers-appearing-in-a-single-block/description/",
        difficulty = Difficulty.EASY
)
public class CountIntegersAppearingInSingleBlock {
    public int countSpecialIntegers(int[] nums) {
        int[] memo = new int[101];
        for (int num : nums) {
            memo[num]++;
        }

        int ans = 0;
        outer:
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[i] != nums[j]) {
                    if (memo[nums[i]] == count) {
                        ans++;
                    }
                    continue outer;
                }
                count++;
            }
            if (memo[nums[i]] == count) {
                ans++;
            }
        }

        return ans;
    }
}