package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 9/22/2022
 */
@LeetCode(
		id = 2413,
		name = "Smallest Even Multiple",
		url = "https://leetcode.com/problems/smallest-even-multiple/",
		difficulty = Difficulty.EASY
)
public class SmallestEvenMultiple
{
	public int smallestEvenMultiple(int n)
	{
		for (int i = 1; i < Integer.MAX_VALUE; i++)
		{
			if (i % 2 == 0 && i % n == 0)
			{
				return i;
			}
		}

		return -1;
	}
}
