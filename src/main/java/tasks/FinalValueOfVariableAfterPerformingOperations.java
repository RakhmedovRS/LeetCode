package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 9/19/2021
 */
@LeetCode(
	id = 2011,
	name = "Final Value of Variable After Performing Operations",
	url = "https://leetcode.com/problems/final-value-of-variable-after-performing-operations/",
	difficulty = Difficulty.EASY
)
public class FinalValueOfVariableAfterPerformingOperations
{
	public int finalValueAfterOperations(String[] operations)
	{
		int value = 0;
		for (String operation : operations)
		{
			if (operation.startsWith("+") || operation.endsWith("+"))
			{
				value++;
			}
			else
			{
				value--;
			}
		}

		return value;
	}
}
