package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 12/27/2020
 */
@LeetCode(
	id = 1706,
	name = "Where Will the Ball Fall",
	url = "https://leetcode.com/problems/where-will-the-ball-fall/",
	difficulty = Difficulty.MEDIUM
)
public class WhereWillTheBallFall
{
	public int[] findBall(int[][] grid)
	{
		int rows = grid.length;
		int columns = grid[0].length;
		int[] answer = new int[columns];
		Arrays.fill(answer, -1);
		boolean[][] newGrid = new boolean[rows * 4][columns * 4];
		int[][] a = new int[][]
			{
				{0, 0},
				{1, 1},
				{1, 1},
				{1, 1}
			};

		int[][] b = new int[][]
			{
				{0, 3},
				{1, -1},
				{1, -1},
				{1, -1}
			};

		int r;
		int c;
		int[][] steps;
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				r = row * 4;
				c = column * 4;
				// \
				if (grid[row][column] == 1)
				{
					steps = a;
				}
				// /
				else
				{
					steps = b;
				}

				for (int[] step : steps)
				{
					r += step[0];
					c += step[1];
					newGrid[r][c] = true;
				}
			}
		}

		for (int i = 0; i < columns; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				if (!newGrid[0][i * 4 + j])
				{
					int pos = findFallPos(0, i * 4 + j, rows * 4, columns * 4, newGrid, new boolean[rows * 4][columns * 4]);
					if (pos != Integer.MAX_VALUE)
					{
						answer[i] = pos / 4;
					}
					break;
				}
			}
		}

		return answer;
	}

	private int findFallPos(int row, int column, int rows, int columns, boolean[][] grid, boolean[][] visited)
	{
		if (row < 0 || row == rows || column < 0 || column == columns - 1 || visited[row][column] || grid[row][column])
		{
			return Integer.MAX_VALUE;
		}

		visited[row][column] = true;

		if (row == rows - 1)
		{
			return column;
		}

		int down = findFallPos(row + 1, column, rows, columns, grid, visited);
		int left = findFallPos(row, column - 1, rows, columns, grid, visited);
		int right = findFallPos(row, column + 1, rows, columns, grid, visited);

		return Math.min(down, Math.min(left, right));
	}

	public static void main(String[] args)
	{
		WhereWillTheBallFall clazz = new WhereWillTheBallFall();
		System.out.println(Arrays.toString(clazz.findBall(new int[][]
			{
				{1, -1, -1, 1, -1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1, -1, -1, 1, -1, 1, -1, 1, -1, -1, -1, -1, 1, -1, 1, 1, -1, -1, -1, -1, -1, 1},
				{-1, 1, 1, 1, -1, -1, -1, -1, 1, 1, 1, -1, -1, -1, 1, -1, -1, 1, 1, 1, 1, 1, 1, -1, 1, -1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, -1, 1, 1, -1, 1, 1},
				{1, -1, -1, -1, -1, 1, -1, 1, 1, 1, 1, 1, 1, 1, -1, 1, -1, -1, -1, 1, -1, -1, 1, -1, 1, -1, 1, -1, -1, 1, -1, 1, -1, 1, 1, -1, -1, 1, 1, -1, 1, -1}
			})));

		System.out.println(Arrays.toString(clazz.findBall(new int[][]
			{
				{1, 1, 1, -1, -1},
				{1, 1, 1, -1, -1},
				{-1, -1, -1, 1, 1},
				{1, 1, 1, 1, -1},
				{-1, -1, -1, -1, -1}
			})));
	}
}
