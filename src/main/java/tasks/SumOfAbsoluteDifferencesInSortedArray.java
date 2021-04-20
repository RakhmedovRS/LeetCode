package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 12/12/2020
 */
@LeetCode(
	id = 1685,
	name = "Sum of Absolute Differences in a Sorted Array",
	url = "https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/",
	difficulty = Difficulty.MEDIUM
)
public class SumOfAbsoluteDifferencesInSortedArray
{
	public int[] getSumAbsoluteDifferences(int[] nums)
	{
		int[] prefix = new int[nums.length];
		int[] suffix = new int[nums.length];

		for (int i = 0; i < nums.length; i++)
		{
			prefix[i] = nums[i];
			if (i != 0)
			{
				prefix[i] += prefix[i - 1];
			}
		}

		for (int i = nums.length - 1; i >= 0; i--)
		{
			suffix[i] = nums[i];
			if (i != nums.length - 1)
			{
				suffix[i] += suffix[i + 1];
			}
		}

		int[] answer = new int[nums.length];
		int left;
		int right;
		for (int i = 0; i < nums.length; i++)
		{
			left = nums[i] * i;
			right = nums[i] * (nums.length - 1 - i);
			answer[i] = left - prefix[i] + suffix[i] - right;
		}

		return answer;
	}

	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(new SumOfAbsoluteDifferencesInSortedArray().getSumAbsoluteDifferences(new int[]{2, 3, 5})));
	}
}
