package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/22/2022
 */
@LeetCode(
		id = 2145,
		name = "Count the Hidden Sequences",
		url = "https://leetcode.com/problems/count-the-hidden-sequences/",
		difficulty = Difficulty.MEDIUM
)
public class CountTheHiddenSequences
{
	public int numberOfArrays(int[] differences, int lower, int upper)
	{
		int[] prefixSum = new int[differences.length];
		prefixSum[0] = differences[0];
		for (int i = 1; i < prefixSum.length; i++)
		{
			prefixSum[i] += differences[i] + prefixSum[i - 1];
		}

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int p : prefixSum)
		{
			min = Math.min(min, p);
			max = Math.max(max, p);
		}

		long left = lower;
		long right = upper;
		long mid;

		Long l = null;

		while (left <= right)
		{
			mid = (left + right) / 2;
			if (mid + min >= lower && mid + max <= upper)
			{
				right = mid - 1;
				l = mid;
			}
			else if (mid + min < lower)
			{
				left = mid + 1;
			}
			else
			{
				right = mid - 1;
			}
		}

		left = lower;
		right = upper;

		Long r = null;

		while (left <= right)
		{
			mid = (left + right) / 2;
			if (mid + min >= lower && mid + max <= upper)
			{
				left = mid + 1;
				r = mid;
			}
			else if (mid + min < lower)
			{
				left = mid + 1;
			}
			else
			{
				right = mid - 1;
			}
		}

		if (l == null && r == null)
		{
			return 0;
		}
		else if (l == null || r == null)
		{
			return 1;
		}
		return (int) (1 + r - l);
	}
}
