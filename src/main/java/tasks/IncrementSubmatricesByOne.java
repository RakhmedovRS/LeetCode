package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 1/16/2023
 */
@LeetCode(
		id = 2536,
		name = "Increment Submatrices by One",
		url = "https://leetcode.com/problems/increment-submatrices-by-one/",
		difficulty = Difficulty.MEDIUM
)
public class IncrementSubmatricesByOne
{
	public int[][] rangeAddQueries(int n, int[][] queries)
	{
		int[][] mat = new int[n][n];
		for (int[] q : queries)
		{
			int r1 = q[0];
			int c1 = q[1];
			int r2 = q[2];
			int c2 = q[3];

			for (int row = r1; row <= r2; row++)
			{
				for (int column = c1; column <= c2; column++)
				{
					mat[row][column]++;
				}
			}
		}

		return mat;
	}
}
