package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 06-Feb-20
 */
@LeetCode(
		id = 215,
		name = "Kth Largest Element in an Array",
		url = "https://leetcode.com/problems/kth-largest-element-in-an-array/",
		difficulty = Difficulty.EASY
)
public class KthLargestElementInAnArray
{
	public int findKthLargest(int[] nums, int k)
	{
		Arrays.sort(nums);
		return nums[nums.length - k];
	}
}
