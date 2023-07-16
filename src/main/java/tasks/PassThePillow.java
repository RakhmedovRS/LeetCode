package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 3/7/2023
 */
@LeetCode(
		id = 2582,
		name = "Pass the Pillow",
		url = "https://leetcode.com/problems/pass-the-pillow/",
		difficulty = Difficulty.EASY
)
public class PassThePillow
{
	public int passThePillow(int n, int time)
	{
		//time %= n * 2;

		int pos = 1;
		boolean forward = true;
		while (time-- > 0)
		{
			if (pos == n)
			{
				forward = !forward;
			}

			if (!forward && pos == 1)
			{
				forward = true;
			}

			if (forward)
			{
				pos++;
			}
			else
			{
				pos--;
			}
		}

		return pos;
	}
}
