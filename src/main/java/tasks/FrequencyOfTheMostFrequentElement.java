package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 4/25/2021
 */
@LeetCode(
		id = 1838,
		name = "Frequency of the Most Frequent Element",
		url = "https://leetcode.com/problems/frequency-of-the-most-frequent-element/",
		difficulty = Difficulty.MEDIUM
)
public class FrequencyOfTheMostFrequentElement
{
	public int maxFrequency(int[] nums, int k)
	{
		Arrays.sort(nums);

		int ans = 0;
		long sum = 0;

		for (int left = 0, right = 0; right < nums.length; right++)
		{
			sum += nums[right];

			while ((long) nums[right] * (right - left + 1) - sum > k)
			{
				sum -= nums[left];
				left++;
			}

			ans = Math.max(ans, right - left + 1);
		}

		return ans;
	}
}
