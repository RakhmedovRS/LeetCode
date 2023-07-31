package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 7/30/2023
 */
@LeetCode(
		id = 2798,
		name = "Number of Employees Who Met the Target",
		url = "https://leetcode.com/problems/number-of-employees-who-met-the-target/description/",
		difficulty = Difficulty.EASY
)
public class NumberOfEmployeesWhoMetTheTarget
{
	public int numberOfEmployeesWhoMetTarget(int[] hours, int target)
	{
		int c = 0;
		for (int h : hours)
		{
			if (h >= target)
			{
				c++;
			}
		}
		return c;
	}
}
