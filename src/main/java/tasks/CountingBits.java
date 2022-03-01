package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 28-May-20
 */
@LeetCode(
	id = 338,
	name = "Counting Bits",
	url = "https://leetcode.com/problems/counting-bits/",
	difficulty = Difficulty.EASY
)
public class CountingBits
{
	public int[] countBits(int n)
	{
		int[] answer = new int[n + 1];
		for (int i = 1; i <= n; i++)
		{
			for (int j = 0; j < 30; j++)
			{
				answer[i] += (i & (1 << j)) > 0 ? 1 : 0;
			}
		}

		return answer;
	}
}
