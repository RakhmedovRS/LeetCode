package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 2/13/2022
 */
@LeetCode(
	id = 2169,
	name = "Count Operations to Obtain Zero",
	url = "https://leetcode.com/problems/count-operations-to-obtain-zero/",
	difficulty = Difficulty.EASY
)
public class CountOperationsToObtainZero
{
	public int countOperations(int num1, int num2)
	{
		int count = 0;
		while (num1 != 0 && num2 != 0)
		{
			count++;
			if (num1 >= num2)
			{
				num1 -= num2;
			}
			else
			{
				num2 -= num1;
			}
		}

		return count;
	}
}
