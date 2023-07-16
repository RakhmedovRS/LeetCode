package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 1/22/2023
 */
@LeetCode(
		id = 2544,
		name = "Alternating Digit Sum",
		url = "https://leetcode.com/problems/alternating-digit-sum/",
		difficulty = Difficulty.EASY
)
public class AlternatingDigitSum
{
	public int alternateDigitSum(int n)
	{
		int sum = 0;
		boolean pos = true;
		String s = "" + n;
		for (char ch : s.toCharArray())
		{
			if (pos)
			{
				sum += ch - '0';
			}
			else
			{
				sum -= ch - '0';
			}

			pos = !pos;
		}

		return sum;
	}
}
