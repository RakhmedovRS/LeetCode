import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 9/28/2020
 */
@LeetCode(id = 713, name = "Subarray Product Less Than K", url = "https://leetcode.com/problems/subarray-product-less-than-k/")
public class SubarrayProductLessThanK
{
	public int numSubarrayProductLessThanK(int[] nums, int k)
	{
		if (k <= 1)
		{
			return 0;
		}

		int count = 0;
		long product = 1;
		int left = 0;
		for (int right = 0; right < nums.length; right++)
		{
			product *= nums[right];
			while (product >= k)
			{
				product /= nums[left++];
			}
			count += 1 + right - left;
		}

		return count;
	}
}
