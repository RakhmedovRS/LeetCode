package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 19-Aug-20
 */
@LeetCode(
	id = 454,
	name = "4Sum II",
	url = "https://leetcode.com/problems/4sum-ii/",
	difficulty = Difficulty.MEDIUM
)
public class FourSumII
{
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D)
	{
		int count = 0;
		Map<Integer, Integer> ab = new HashMap<>();
		int sum;
		for (int a : A)
		{
			for (int b : B)
			{
				sum = a + b;
				ab.put(sum, ab.getOrDefault(sum, 0) + 1);
			}
		}

		for (int c : C)
		{
			for (int d : D)
			{
				sum = c + d;
				count += ab.getOrDefault(-sum, 0);
			}
		}

		return count;
	}
}
