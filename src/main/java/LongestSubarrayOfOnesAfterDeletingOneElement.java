import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 27-Jun-20
 */
@LeetCode(id = 1493, name = "Longest Subarray of 1's After Deleting One Element", url = "https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/")
public class LongestSubarrayOfOnesAfterDeletingOneElement
{
	public int longestSubarray(int[] nums)
	{
		int ones = 0;
		int zeroes = 0;
		int left = 0;
		int right = 0;
		int max = 0;

		boolean containsZero = false;
		for (int num : nums)
		{
			if (num == 0)
			{
				containsZero = true;
				break;
			}
		}

		while (left < nums.length && right < nums.length)
		{
			while (right < nums.length && zeroes <= 1)
			{
				ones += nums[right];
				if (nums[right] == 0)
				{
					zeroes++;
				}
				right++;
			}

			max = Math.max(max, ones);

			while (left < nums.length && zeroes > 1)
			{
				ones -= nums[left];
				if (nums[left] == 0)
				{
					zeroes--;
				}
				left++;
			}
			max = Math.max(max, ones);
		}

		return containsZero ? max : max - 1;
	}
}
