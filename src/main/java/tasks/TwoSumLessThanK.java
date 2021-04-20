package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 11/29/2020
 */
@LeetCode(
	id = 1099,
	name = "Two Sum Less Than K",
	url = "https://leetcode.com/problems/two-sum-less-than-k/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class TwoSumLessThanK
{
	public int twoSumLessThanK(int[] nums, int k)
	{
		int sum = -1;
		Arrays.sort(nums);
		int j;
		for (int i = 0; i < nums.length && nums[i] < k; i++)
		{
			j = binarySearch(nums, i + 1, nums.length - 1, k - nums[i]);
			if (j != -1)
			{
				sum = Math.max(sum, nums[i] + nums[j]);
			}
		}

		return sum;
	}

	private int binarySearch(int[] nums, int left, int right, int target)
	{
		int middle;
		int i = -1;
		while (left <= right)
		{
			middle = (left + right) / 2;
			if (nums[middle] >= target)
			{
				right = middle - 1;
			}
			else
			{
				i = middle;
				left = middle + 1;
			}
		}

		return i;
	}

	public static void main(String[] args)
	{
		System.out.println(new TwoSumLessThanK().twoSumLessThanK(new int[]{10, 20, 30}, 15));
		System.out.println(new TwoSumLessThanK().twoSumLessThanK(new int[]{34, 23, 1, 24, 75, 33, 54, 8}, 60));
	}
}
