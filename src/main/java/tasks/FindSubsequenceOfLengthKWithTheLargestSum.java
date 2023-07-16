package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 12/11/2021
 */
@LeetCode(
		id = 2099,
		name = "Find Subsequence of Length K With the Largest Sum",
		url = "https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/",
		difficulty = Difficulty.EASY
)
public class FindSubsequenceOfLengthKWithTheLargestSum
{
	public int[] maxSubsequence(int[] nums, int k)
	{
		int[] copy = Arrays.copyOf(nums, nums.length);
		Arrays.sort(copy);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length - k; i++)
		{
			map.put(copy[i], map.getOrDefault(copy[i], 0) + 1);
		}

		int pos = 0;
		int[] answer = new int[k];
		for (int i = 0; i < nums.length; i++)
		{
			if (!map.containsKey(nums[i]))
			{
				answer[pos++] = nums[i];
			}
			else
			{
				int count = map.remove(nums[i]);
				if (--count > 0)
				{
					map.put(nums[i], count);
				}
			}

		}

		return answer;
	}
}
