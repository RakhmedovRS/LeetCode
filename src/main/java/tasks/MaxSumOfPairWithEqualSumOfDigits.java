package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 7/18/2022
 */
@LeetCode(
	id = 2342,
	name = "Max Sum of a Pair With Equal Sum of Digits",
	url = "https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/",
	difficulty = Difficulty.MEDIUM
)
public class MaxSumOfPairWithEqualSumOfDigits
{
	public int maximumSum(int[] nums)
	{
		int[] copy = Arrays.copyOf(nums,  nums.length);
		Map<Integer, List<Integer>> sumToIndex = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
		{
			int sum = 0;
			while (copy[i] > 0)
			{
				sum += copy[i] % 10;
				copy[i] /= 10;
			}

			sumToIndex.putIfAbsent(sum, new ArrayList<>());
			sumToIndex.get(sum).add(i);
		}

		int max = -1;
		for (Map.Entry<Integer, List<Integer>> entry : sumToIndex.entrySet())
		{
			if (entry.getValue().size() > 1)
			{
				List<Integer> list = entry.getValue();
				list.sort((a, b) -> nums[b] - nums[a]);

				max = Math.max(max, nums[list.get(0)] + nums[list.get(1)]);
			}
		}

		return max;
	}
}
