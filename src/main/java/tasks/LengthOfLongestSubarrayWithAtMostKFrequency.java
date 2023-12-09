package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 12/9/2023
 */
@LeetCode(
		id = 2958,
		name = "Length of Longest Subarray With at Most K Frequency",
		url = "https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/",
		difficulty = Difficulty.MEDIUM
)
public class LengthOfLongestSubarrayWithAtMostKFrequency
{
	public int maxSubarrayLength(int[] nums, int k)
	{
		Map<Integer, Integer> freq = new HashMap<>();
		int ans = 0;
		int left = 0;
		int right = 0;
		while (right < nums.length)
		{
			int num = nums[right++];
			freq.put(num, freq.getOrDefault(num, 0) + 1);
			while (freq.get(num) > k)
			{
				int leftNum = nums[left++];
				int count = freq.remove(leftNum);
				if (--count > 0)
				{
					freq.put(leftNum, count);
				}
			}

			ans = Math.max(ans, right - left);
		}

		return ans;
	}
}
