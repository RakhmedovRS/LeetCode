package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 09-May-20
 */
@LeetCode(
		id = 367,
		name = "Valid Perfect Square",
		url = "https://leetcode.com/problems/valid-perfect-square/",
		difficulty = Difficulty.EASY
)
public class ValidPerfectSquare
{
	public boolean isPerfectSquare(int num)
	{
		if (num == 1)
		{
			return true;
		}
		else if (num == 2 || num == 3)
		{
			return false;
		}

		long left = 1;
		long right = num / 2;
		long middle;
		long square;
		while (left <= right)
		{
			middle = left + (right - left) / 2;
			square = middle * middle;
			if (square == num)
			{
				return true;
			}
			else if (square > num)
			{
				right = middle - 1;
			}
			else
			{
				left = middle + 1;
			}
		}

		return false;
	}
}
