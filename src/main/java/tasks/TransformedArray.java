package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-12-07
 */
@LeetCode(
        id = 3379,
        name = "Transformed Array",
        url = "https://leetcode.com/problems/transformed-array/",
        difficulty = Difficulty.EASY
)
public class TransformedArray {
    public int[] constructTransformedArray(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int index = (i + (nums[i] % nums.length) + nums.length) % nums.length;
                result[i] = nums[index];
            } else if (nums[i] > 0) {
                int index = (i + (nums[i] % nums.length) + nums.length) % nums.length;
                result[i] = nums[index];
            } else {
                result[i] = nums[i];
            }
        }
        return result;
    }
}