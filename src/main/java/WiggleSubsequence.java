import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10-Aug-20
 */
@LeetCode(id = 376, name = "Wiggle Subsequence", url = "https://leetcode.com/problems/wiggle-subsequence/")
public class WiggleSubsequence
{
	public int wiggleMaxLength(int[] nums)
	{
		if (nums.length < 2)
		{
			return nums.length;
		}
		int[] negative = new int[nums.length];
		int[] positive = new int[nums.length];
		for (int right = 1; right < nums.length; right++)
		{
			for (int left = 0; left < right; left++)
			{
				if (nums[right] > nums[left])
				{
					negative[right] = Math.max(negative[right], positive[left] + 1);
				}
				else if (nums[left] > nums[right])
				{
					positive[right] = Math.max(positive[right], negative[left] + 1);
				}
			}
		}

		return 1 + Math.max(negative[nums.length - 1], positive[nums.length - 1]);
	}
}
