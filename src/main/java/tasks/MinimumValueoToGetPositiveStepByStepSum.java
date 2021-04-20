package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 24-Jun-20
 */
@LeetCode(id = 1413, name = "Minimum Value to Get Positive Step by Step Sum", url = "https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/")
public class MinimumValueoToGetPositiveStepByStepSum
{
	public int minStartValue(int[] nums)
	{
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int num : nums)
		{
			sum += num;
			min = Math.min(min, sum);
		}

		return min > 0 ? 1 : min * -1 + 1;
	}
}
