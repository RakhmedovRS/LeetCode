package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 7/10/2021
 */
@LeetCode(
	id = 1925,
	name = "Count Square Sum Triples",
	url = "https://leetcode.com/problems/count-square-sum-triples/",
	difficulty = Difficulty.EASY
)
public class CountSquareSumTriples
{
	public int countTriples(int n)
	{
		int count = 0;
		for (int a = 1; a <= n; a++)
		{
			for (int b = 1; b <= n; b++)
			{
				int c = (int)Math.sqrt(a * a + b * b);
				if (a * a + b * b == c * c && c <= n)
				{
					count++;
				}
			}
		}
		return count;
	}
}
