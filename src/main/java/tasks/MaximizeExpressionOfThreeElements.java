package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-15
 */
@LeetCode(
        id = 3745,
        name = "Maximize Expression of Three Elements",
        url = "https://leetcode.com/problems/maximize-expression-of-three-elements/description/",
        difficulty = Difficulty.EASY
)
public class MaximizeExpressionOfThreeElements {
    public int maximizeExpressionOfThree(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1] + nums[nums.length - 2] - nums[0];
    }
}