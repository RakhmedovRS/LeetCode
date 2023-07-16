package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 30-May-20
 */
@LeetCode(
		id = 1260,
		name = "Shift 2D Grid",
		url = "https://leetcode.com/problems/shift-2d-grid/",
		difficulty = Difficulty.EASY
)
public class Shift2DGrid
{
	public List<List<Integer>> shiftGrid(int[][] grid, int k)
	{
		int rows = grid.length;
		int columns = grid[0].length;
		int maxShift = rows * columns;

		List<List<Integer>> shiftedGreed = new ArrayList<>();
		LinkedList<Integer> flattenedGreed = new LinkedList<>();
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				flattenedGreed.addLast(grid[row][column]);
			}
		}

		k %= maxShift;
		while (k != 0)
		{
			flattenedGreed.addFirst(flattenedGreed.removeLast());
			k--;
		}

		for (int row = 0; row < rows; row++)
		{
			List<Integer> line = new ArrayList<>();
			for (int column = 0; column < columns; column++)
			{
				line.add(flattenedGreed.removeFirst());
			}
			shiftedGreed.add(line);
		}

		return shiftedGreed;
	}
}
