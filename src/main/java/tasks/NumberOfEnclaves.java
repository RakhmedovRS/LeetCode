package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 04-Aug-20
 */
@LeetCode(id = 1020, name = "Number of Enclaves", url = "https://leetcode.com/problems/number-of-enclaves/")
public class NumberOfEnclaves
{
	public int numEnclaves(int[][] A)
	{
		int answer = 0;
		int rows = A.length;
		int columns = A[0].length;
		for (int row = 1; row < rows - 1; row++)
		{
			for (int column = 1; column < columns - 1; column++)
			{
				if (A[row][column] == 1)
				{
					int[] temp = new int[]{0};
					if (!canWalkOffBoundaries(A, row, column, rows, columns, temp))
					{
						answer += temp[0];
					}
				}
			}
		}

		return answer;
	}

	private boolean canWalkOffBoundaries(int[][] A, int row, int column, int rows, int columns, int[] count)
	{
		if (row < 0
			|| row == rows
			|| column < 0
			|| column == columns)
		{
			return true;
		}

		if (A[row][column] == 0)
		{
			return false;
		}

		A[row][column] = 0;
		count[0]++;

		boolean up = canWalkOffBoundaries(A, row - 1, column, rows, columns, count);
		boolean down = canWalkOffBoundaries(A, row + 1, column, rows, columns, count);
		boolean left = canWalkOffBoundaries(A, row, column - 1, rows, columns, count);
		boolean right = canWalkOffBoundaries(A, row, column + 1, rows, columns, count);

		return up || down || left || right;
	}
}
