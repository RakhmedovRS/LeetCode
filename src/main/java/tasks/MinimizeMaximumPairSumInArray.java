package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 5/29/2021
 */
@LeetCode(
		id = 1877,
		name = "Minimize Maximum Pair Sum in Array",
		url = "https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/",
		difficulty = Difficulty.MEDIUM
)
public class MinimizeMaximumPairSumInArray
{
	public int minPairSum(int[] nums)
	{
		int max = 0;
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		while (left < right)
		{
			max = Math.max(max, nums[left++] + nums[right--]);
		}

		return max;
	}
}
