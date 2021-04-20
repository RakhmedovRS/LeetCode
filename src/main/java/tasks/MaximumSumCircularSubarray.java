package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 15-May-20
 */
@LeetCode(id = 918, name = "Maximum Sum Circular Subarray", url = "https://leetcode.com/problems/maximum-sum-circular-subarray/")
public class MaximumSumCircularSubarray
{
	public int maxSubarraySumCircular(int[] A)
	{
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int currentMin = 0;
		int currentMax = 0;
		int total = 0;
		for (int num : A)
		{
			currentMax = Math.max(currentMax + num, num);
			currentMin = Math.min(currentMin + num, num);
			max = Math.max(max, currentMax);
			min = Math.min(min, currentMin);
			total += num;
		}

		return max > 0 ? Math.max(max, total - min) : max;
	}
}
