package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/4/2020
 */
@LeetCode(
	id = 883,
	name = "Projection Area of 3D Shapes",
	url = "https://leetcode.com/problems/projection-area-of-3d-shapes/",
	difficulty = Difficulty.EASY
)
public class ProjectionAreaOf3DShapes
{
	public int projectionArea(int[][] grid)
	{
		if (grid.length == 0)
		{
			return 0;
		}

		int rows = grid.length;
		int columns = grid[0].length;
		int area = 0;
		int[] rowMaxes = new int[rows];
		int[] columnMaxes = new int[columns];
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (grid[row][column] != 0)
				{
					rowMaxes[row] = Math.max(rowMaxes[row], grid[row][column]);
					columnMaxes[column] = Math.max(columnMaxes[column], grid[row][column]);
					area++;
				}
			}
		}

		for (int rowMax : rowMaxes)
		{
			area += rowMax;
		}

		for (int colMax : columnMaxes)
		{
			area += colMax;
		}

		return area;
	}

	public static void main(String[] args)
	{
		System.out.println(new ProjectionAreaOf3DShapes().projectionArea(new int[][]
			{
				{1, 0},
				{0, 2}
			}));

		System.out.println(new ProjectionAreaOf3DShapes().projectionArea(new int[][]
			{
				{1, 2},
				{3, 4}
			}));
	}
}
