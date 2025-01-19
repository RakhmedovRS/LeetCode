package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-01-18
 */
@LeetCode(
        id = 3423,
        name = "Maximum Difference Between Adjacent Elements in a Circular Array",
        url = "https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/description/",
        difficulty = Difficulty.EASY
)
public class MaximumDifferenceBetweenAdjacentElementsInCircularArray {
    public int maxAdjacentDistance(int[] nums) {
        int max = 0;
        for (int i = 1; i < nums.length * 2; i++) {
            max = Math.max(max, Math.abs(nums[(i - 1) % nums.length] - nums[(i) % nums.length]));
        }

        return max;
    }
}