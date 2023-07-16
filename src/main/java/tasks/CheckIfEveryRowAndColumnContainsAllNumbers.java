package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/20/2022
 */
@LeetCode(
		id = 2133,
		name = "Check if Every Row and Column Contains All Numbers",
		url = "https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/",
		difficulty = Difficulty.EASY
)
public class CheckIfEveryRowAndColumnContainsAllNumbers
{
	public boolean checkValid(int[][] matrix)
	{
		for (int[] row : matrix)
		{
			boolean[] seen = new boolean[matrix.length + 1];
			for (int val : row)
			{
				if (val >= seen.length || seen[val])
				{
					return false;
				}

				seen[val] = true;
			}
		}

		for (int column = 0; column < matrix.length; column++)
		{
			boolean[] seen = new boolean[matrix.length + 1];
			for (int[] ints : matrix)
			{
				if (ints[column] >= seen.length || seen[ints[column]])
				{
					return false;
				}
				seen[ints[column]] = true;
			}
		}

		return true;
	}
}
