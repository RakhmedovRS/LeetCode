package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 09-Feb-20
 */
@LeetCode(
		id = 1342,
		name = "Number of Steps to Reduce a Number to Zero",
		url = "https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/",
		difficulty = Difficulty.EASY
)
public class NumberOfStepsToReduceNumberToZero
{
	public int numberOfSteps(int num)
	{
		int steps = 0;
		while (num != 0)
		{
			if (num % 2 == 0)
			{
				num /= 2;
			}
			else
			{
				num--;
			}

			steps++;
		}

		return steps;
	}
}
