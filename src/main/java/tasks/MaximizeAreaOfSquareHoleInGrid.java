package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 11/25/2023
 */
@LeetCode(
		id = 2943,
		name = "Maximize Area of Square Hole in Grid",
		url = "https://leetcode.com/problems/maximize-area-of-square-hole-in-grid/",
		difficulty = Difficulty.MEDIUM
)
public class MaximizeAreaOfSquareHoleInGrid
{
	public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars)
	{
		Arrays.sort(hBars);
		Arrays.sort(vBars);
		int hMax = maxConsecutive(hBars);
		int vMax = maxConsecutive(vBars);

		int res = Math.min(hMax, vMax) + 1;

		return res * res;
	}

	private int maxConsecutive(int[] vals)
	{
		int max = 0;
		int prev = vals[0];
		int curr = 1;
		for (int val : vals)
		{
			if (val == prev + 1)
			{
				curr++;
			}
			else
			{
				curr = 1;
			}

			prev = val;

			max = Math.max(max, curr);
		}

		return max;
	}
}
