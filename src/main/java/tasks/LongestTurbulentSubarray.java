package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 17-Aug-20
 */
@LeetCode(
	id = 978,
	name = "Longest Turbulent Subarray",
	url = "https://leetcode.com/problems/longest-turbulent-subarray/",
	difficulty = Difficulty.MEDIUM
)
public class LongestTurbulentSubarray
{
	public int maxTurbulenceSize(int[] A)
	{
		int increasing = 1;
		int decreasing = 1;
		int max = 1;
		for (int i = 1; i < A.length; i++)
		{
			if (A[i - 1] > A[i])
			{
				decreasing = increasing + 1;
				increasing = 1;
			}
			else if (A[i - 1] < A[i])
			{
				increasing = decreasing + 1;
				decreasing = 1;
			}
			else
			{
				increasing = 1;
				decreasing = 1;
			}

			max = Math.max(max, Math.max(increasing, decreasing));
		}

		return max;
	}
}
