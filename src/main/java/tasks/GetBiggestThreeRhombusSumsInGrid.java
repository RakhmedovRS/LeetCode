package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author RakhmedovRS
 * @created 5/29/2021
 */
@LeetCode(
		id = 1878,
		name = "Get Biggest Three Rhombus Sums in a Grid",
		url = "https://leetcode.com/problems/get-biggest-three-rhombus-sums-in-a-grid/",
		difficulty = Difficulty.MEDIUM
)
public class GetBiggestThreeRhombusSumsInGrid
{
	public int[] getBiggestThree(int[][] grid)
	{
		int rows = grid.length;
		int columns = grid[0].length;
		TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				set.add(grid[row][column]);
				addRhombus(row, column, rows, columns, grid, set);
			}
		}

		if (set.size() == 1)
		{
			return new int[]{set.pollFirst()};
		}
		else if (set.size() == 2)
		{
			return new int[]{set.pollFirst(), set.pollFirst()};
		}

		return new int[]{set.pollFirst(), set.pollFirst(), set.pollFirst()};
	}

	private void addRhombus(int row, int column, int rows, int columns, int[][] grid, TreeSet<Integer> set)
	{
		for (int step = 2; step <= columns; step += 2)
		{
			if (column + step < columns && (row - step / 2 >= 0) && (row + step / 2 < rows))
			{
				int[] leftV = new int[]{row, column};
				int[] rightV = new int[]{row, column + step};
				int[] topV = new int[]{row - step / 2, column + step / 2};
				int[] downV = new int[]{row + step / 2, column + step / 2};

				int sum = 0;
				int[] current = new int[]{row, column};
				while (current[0] != topV[0] && current[1] != topV[1])
				{
					sum += grid[current[0]--][current[1]++];
				}

				while (current[0] != rightV[0] && current[1] != rightV[1])
				{
					sum += grid[current[0]++][current[1]++];
				}

				while (current[0] != downV[0] && current[1] != downV[1])
				{
					sum += grid[current[0]++][current[1]--];
				}

				while (current[0] != leftV[0] && current[1] != leftV[1])
				{
					sum += grid[current[0]--][current[1]--];
				}

				set.add(sum);
			}
			else
			{
				break;
			}
		}
	}
}
