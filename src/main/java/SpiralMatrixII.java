import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 01-Mar-20
 */
@LeetCode(
	id = 59,
	name = "Spiral Matrix II",
	url = "https://leetcode.com/problems/spiral-matrix-ii/",
	difficulty = Difficulty.MEDIUM
)
public class SpiralMatrixII
{
	public int[][] generateMatrix(int n)
	{
		int[][] matrix = new int[n][n];

		int upperBound = 0;
		int lowerBound = n - 1;
		int leftBound = 0;
		int rightBound = n - 1;

		int value = 1;
		n *= n;
		while (value <= n)
		{
			for (int row = upperBound, column = leftBound; column <= rightBound && value <= n; column++)
			{
				matrix[row][column] = value++;
			}
			upperBound++;

			for (int row = upperBound, column = rightBound; row <= lowerBound && value <= n; row++)
			{
				matrix[row][column] = value++;
			}
			rightBound--;

			for (int row = lowerBound, column = rightBound; column >= leftBound && value <= n; column--)
			{
				matrix[row][column] = value++;
			}
			lowerBound--;

			for (int row = lowerBound, column = leftBound; row >= upperBound && value <= n; row--)
			{
				matrix[row][column] = value++;
			}
			leftBound++;
		}

		return matrix;
	}

	public static void main(String[] args)
	{
		System.out.println(Arrays.deepToString(new SpiralMatrixII().generateMatrix(4)));
	}
}
