import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 16-Sep-20
 */
@LeetCode(id = 164, name = "Maximum Gap", url = "https://leetcode.com/problems/maximum-gap/")
public class MaximumGap
{
	public int maximumGap(int[] nums)
	{
		if (nums.length < 2)
		{
			return 0;
		}

		Arrays.sort(nums);
		int gap = Integer.MIN_VALUE;
		for (int i = 1; i < nums.length; i++)
		{
			gap = Math.max(gap, nums[i] - nums[i - 1]);
		}
		return gap;
	}
}
