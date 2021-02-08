import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 2/8/2021
 */
@LeetCode(
	id = 1749,
	name = "Maximum Absolute Sum of Any Subarray",
	url = "https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class MaximumAbsoluteSumOfAnySubarray
{
	public int maxAbsoluteSum(int[] nums)
	{
		int max = 0;
		int minSum = 0;
		int maxSum = 0;
		for (int num : nums)
		{
			maxSum += num;
			minSum += num;
			if (minSum > 0)
			{
				minSum = 0;
			}
			if (maxSum < 0)
			{
				maxSum = 0;
			}

			max = Math.max(max, Math.max(-minSum, maxSum));
		}

		return max;
	}
}
