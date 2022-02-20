package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 2/20/2022
 */
@LeetCode(
	id = 2180,
	name = "Count Integers With Even Digit Sum",
	url = "https://leetcode.com/problems/count-integers-with-even-digit-sum/",
	difficulty = Difficulty.EASY
)
public class CountIntegersWithEvenDigitSum
{
	public int countEven(int num)
	{
		int count = 0;
		outer:
		for (int i = 1; i <= num; i++)
		{
			int sum = 0;
			for (char ch : String.valueOf(i).toCharArray())
			{
				sum += (ch - '0');
			}

			if (sum % 2 == 0)
			{
				count++;
			}
		}

		return count;
	}
}
