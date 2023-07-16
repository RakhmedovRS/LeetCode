package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 15-Sep-20
 */
@LeetCode(
		id = 991,
		name = "Broken Calculator",
		url = "https://leetcode.com/problems/broken-calculator/",
		difficulty = Difficulty.MEDIUM
)
public class BrokenCalculator
{
	public int brokenCalc(int source, int target)
	{
		int operations = 0;
		while (target > source)
		{
			operations++;
			if (target % 2 != 0)
			{
				target++;
			}
			else
			{
				target /= 2;
			}
		}

		return operations + source - target;
	}
}
