package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/16/2020
 */
@LeetCode(
	id = 251,
	name = "Flatten 2D Vector",
	url = "https://leetcode.com/problems/flatten-2d-vector/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class Flatten2DVector
{
	class Vector2D
	{

		int row;
		int column;
		int[][] matrix;
		int elements;

		public Vector2D(int[][] v)
		{
			matrix = v;
			for (int[] row : v)
			{
				elements += row.length;
			}
		}

		public int next()
		{
			if (column >= matrix[row].length)
			{
				row++;
				column = 0;
				return next();
			}

			int val = matrix[row][column++];

			if (column == matrix[row].length)
			{
				row++;
				column = 0;
			}

			elements--;
			return val;
		}

		public boolean hasNext()
		{
			return elements > 0;
		}
	}
}
