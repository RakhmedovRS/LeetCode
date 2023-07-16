package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 24-Jul-20
 */
@LeetCode(
		id = 1162,
		name = "As Far from Land as Possible",
		url = "https://leetcode.com/problems/as-far-from-land-as-possible/",
		difficulty = Difficulty.MEDIUM
)
public class AsFarFromLandAsPossible
{
	public int maxDistance(int[][] grid)
	{
		Queue<int[]> queue = new LinkedList<>();
		int rows = grid.length;
		int columns = grid[0].length;
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (grid[row][column] == 1)
				{
					queue.add(new int[]{row, column, row, column});
				}
			}
		}

		if (queue.isEmpty() || queue.size() == rows * columns)
		{
			return -1;
		}

		int maxDistance = 0;
		int size;
		int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, -1}, {-1, 1}, {1, 1}, {-1, -1}};
		Integer[][] distances = new Integer[rows][columns];
		while (!queue.isEmpty())
		{
			size = queue.size();
			while (size-- > 0)
			{
				int[] pos = queue.remove();
				int row = pos[0];
				int column = pos[1];
				int sourceRow = pos[2];
				int sourceColumn = pos[3];
				int nextRow;
				int nextColumn;
				for (int[] direction : directions)
				{
					nextRow = row + direction[0];
					nextColumn = column + direction[1];
					if (nextRow < 0
							|| nextRow == rows
							|| nextColumn < 0
							|| nextColumn == columns
							|| grid[nextRow][nextColumn] == 1)
					{
						continue;
					}

					int manhattanDistance = getManhattanDistance(sourceRow, sourceColumn, nextRow, nextColumn);
					if (distances[nextRow][nextColumn] == null || manhattanDistance < distances[nextRow][nextColumn])
					{
						distances[nextRow][nextColumn] = manhattanDistance;
						queue.add(new int[]{nextRow, nextColumn, sourceRow, sourceColumn});
					}
				}
			}
		}

		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (distances[row][column] != null)
				{
					maxDistance = Math.max(maxDistance, distances[row][column]);
				}
			}
		}

		return maxDistance;
	}

	private int getManhattanDistance(int r1, int c1, int r2, int c2)
	{
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}

	public static void main(String[] args)
	{
		System.out.println(new AsFarFromLandAsPossible().maxDistance(new int[][]
				{
						{1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
						{1, 1, 0, 1, 1, 1, 0, 1, 1, 0},
						{0, 1, 1, 0, 1, 0, 0, 1, 0, 0},
						{1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
						{0, 1, 0, 0, 0, 1, 1, 0, 1, 1},
						{0, 0, 1, 0, 0, 1, 0, 1, 0, 1},
						{0, 0, 0, 1, 1, 1, 1, 0, 0, 1},
						{0, 1, 0, 0, 1, 0, 0, 1, 0, 0},
						{0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
						{1, 1, 0, 1, 1, 1, 1, 1, 0, 0},
				}));

		System.out.println(new AsFarFromLandAsPossible().maxDistance(new int[][]
				{
						{1, 0, 0},
						{0, 0, 0},
						{0, 0, 0}
				}));

		System.out.println(new AsFarFromLandAsPossible().maxDistance(new int[][]
				{
						{1, 0, 1},
						{0, 0, 0},
						{1, 0, 1}
				}));
	}
}
