package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 11-Jul-20
 */
@LeetCode(id = 1508, name = "Range Sum of Sorted Subarray Sums", url = "https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/")
public class RangeSumOfSortedSubarraySums
{
	public int rangeSum(int[] nums, int n, int left, int right)
	{
		int pos = 0;
		int i = 0;
		int sum = 0;
		int step = 0;
		int[] arr = new int[n * (n + 1) / 2];
		while (pos < arr.length)
		{
			sum += nums[i++];
			arr[pos++] = sum;
			if (i == nums.length)
			{
				step++;
				i = step;
				sum = 0;
			}
		}

		Arrays.sort(arr);
		sum = 0;
		for (int idx = left - 1; idx < right; idx++)
		{
			sum += arr[idx];
		}

		return sum;
	}
}
