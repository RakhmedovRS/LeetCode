import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 05-May-20
 */
@LeetCode(id = 209, name = "Minimum Size Subarray Sum", url = "https://leetcode.com/problems/minimum-size-subarray-sum/")
public class MinimumSizeSubarraySum
{
	public int minSubArrayLen(int s, int[] nums)
	{
		if (nums == null || nums.length == 0)
		{
			return 0;
		}

		int left = 0;
		int totalSum = 0;
		int minSize = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++)
		{
			totalSum += nums[i];
			while (totalSum >= s)
			{
				minSize = Math.min(minSize, 1 + i - left);
				totalSum -= nums[left++];
			}
		}

		return minSize == Integer.MAX_VALUE ? 0 : minSize;
	}

	public static void main(String[] args)
	{
		System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
		System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(213, new int[]{12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12}));
	}
}
