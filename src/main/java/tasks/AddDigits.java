package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10-Jun-20
 */
@LeetCode(
	id = 258,
	name = "Add Digits",
	url = "https://leetcode.com/problems/add-digits/",
	difficulty = Difficulty.EASY
)
public class AddDigits
{
	public int addDigits(int num)
	{
		if (num == 0)
		{
			return 0;
		}

		if (num % 9 == 0)
		{
			return 9;
		}

		return num % 9;
	}
}
