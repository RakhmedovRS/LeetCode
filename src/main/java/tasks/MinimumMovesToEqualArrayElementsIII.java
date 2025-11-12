package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-08
 */
@LeetCode(
        id = 3736,
        name = "Minimum Moves to Equal Array Elements III",
        url = "https://leetcode.com/problems/minimum-moves-to-equal-array-elements-iii/description/",
        difficulty = Difficulty.EASY
)
public class MinimumMovesToEqualArrayElementsIII {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            ans += nums[nums.length - 1] - nums[i];
        }
        return ans;
    }
}