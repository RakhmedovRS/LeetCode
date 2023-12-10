package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 6/27/2021
 */
@LeetCode(
		id = 1913,
		name = "Maximum Product Difference Between Two Pairs",
		url = "https://leetcode.com/problems/maximum-product-difference-between-two-pairs/",
		difficulty = Difficulty.EASY
)
public class MaximumProductDifferenceBetweenTwoPairs {
	public int maxProductDifference(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length - 1] * nums[nums.length - 2] - nums[0] * nums[1];
	}
}
