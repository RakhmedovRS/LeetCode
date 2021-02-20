import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 2/20/2021
 */
@LeetCode(
	id = 1765,
	name = "Map of Highest Peak",
	url = "https://leetcode.com/problems/map-of-highest-peak/",
	difficulty = Difficulty.MEDIUM
)
public class MapOfHighestPeak
{
	public int[][] highestPeak(int[][] isWater)
	{
		int rows = isWater.length;
		int columns = isWater[0].length;

		Queue<int[]> queue = new LinkedList<>();
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				if (isWater[row][column] == 1)
				{
					queue.add(new int[]{row, column, 0});
				}
			}
		}

		int[][] answer = new int[rows][columns];
		for (int[] row : answer)
		{
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		int size;
		int[] current;
		int row;
		int column;
		int height;
		while (!queue.isEmpty())
		{
			size = queue.size();
			while (size-- > 0)
			{
				current = queue.remove();
				row = current[0];
				column = current[1];
				height = current[2];
				if (height >= answer[row][column])
				{
					continue;
				}

				answer[row][column] = height;
				if (row - 1 >= 0)
				{
					queue.add(new int[]{row - 1, column, height + 1});
				}

				if (row + 1 < rows)
				{
					queue.add(new int[]{row + 1, column, height + 1});
				}

				if (column - 1 >= 0)
				{
					queue.add(new int[]{row, column - 1, height + 1});
				}

				if (column + 1 < columns)
				{
					queue.add(new int[]{row, column + 1, height + 1});
				}
			}
		}

		return answer;
	}

	public static void main(String[] args)
	{
		MapOfHighestPeak clazz = new MapOfHighestPeak();
		int[][] array = new int[1000][];
		for (int i = 0; i < array.length; i++)
		{
			int[] sub = new int[1000];
			Arrays.fill(sub, 1);
			array[i] = sub;
		}

		int[][] result = clazz.highestPeak(array);
		for (int[] row : result)
		{
			System.out.println(Arrays.toString(row));
		}

		System.out.println(Arrays.deepToString(clazz.highestPeak(
			new int[][]
				{
					{0, 0, 0, 0, 0, 0, 1, 0},
					{0, 1, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 1, 0},
					{0, 0, 1, 0, 0, 0, 0, 0}
				}
		)));

		System.out.println(Arrays.deepToString(clazz.highestPeak(
			new int[][]
				{
					{1}
				}
		)));

		System.out.println(Arrays.deepToString(clazz.highestPeak(
			new int[][]
				{
					{0, 1},
					{0, 0}
				}
		)));

		System.out.println(Arrays.deepToString(clazz.highestPeak(
			new int[][]
				{
					{0, 0, 1},
					{1, 0, 0},
					{0, 0, 0}
				}
		)));
	}
}
