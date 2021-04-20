package tasks;

import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 10/8/2020
 */
@LeetCode(id = 1403, name = "Minimum Subsequence in Non-Increasing Order", url = "https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/")
public class MinimumSubsequenceInNonIncreasingOrder
{
	public List<Integer> minSubsequence(int[] nums)
	{
		int sum = 0;
		for (int num : nums)
		{
			if (num > 0)
			{
				sum += num;
			}
		}

		Arrays.sort(nums);

		List<Integer> answer = new ArrayList<>();
		int currentSum = 0;
		for (int i = nums.length - 1; i >= 0; i--)
		{
			currentSum += nums[i];
			sum -= nums[i];
			answer.add(nums[i]);
			if (currentSum > sum)
			{
				break;
			}
		}

		return answer;
	}

	public static void main(String[] args)
	{
		System.out.println(new MinimumSubsequenceInNonIncreasingOrder().minSubsequence(new int[]{4, 3, 10, 9, 8}));
	}
}
