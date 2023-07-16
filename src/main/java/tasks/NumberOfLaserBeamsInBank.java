package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/2/2022
 */
@LeetCode(
		id = 2125,
		name = "Number of Laser Beams in a Bank",
		url = "https://leetcode.com/problems/number-of-laser-beams-in-a-bank/",
		difficulty = Difficulty.MEDIUM
)
public class NumberOfLaserBeamsInBank
{
	public int numberOfBeams(String[] bank)
	{
		int total = 0;
		int prev = 0;
		int current = 0;
		for (String row : bank)
		{
			current = 0;
			for (char ch : row.toCharArray())
			{
				if (ch == '1')
				{
					current++;
				}
			}

			if (current != 0)
			{
				total += prev * current;
				prev = current;
			}
		}

		return total;
	}
}
