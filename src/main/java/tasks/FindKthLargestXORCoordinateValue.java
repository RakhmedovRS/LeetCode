package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 2/16/2021
 */
@LeetCode(
		id = 1738,
		name = "Find Kth Largest XOR Coordinate Value",
		url = "https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/",
		difficulty = Difficulty.MEDIUM
)
public class FindKthLargestXORCoordinateValue
{
	public int kthLargestValue(int[][] matrix, int k)
	{
		int rows = matrix.length;
		int columns = matrix[0].length;
		List<Integer> list = new ArrayList<>();
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				int val = matrix[row][column];
				if (row - 1 >= 0)
				{
					val ^= matrix[row - 1][column];
				}

				if (column - 1 >= 0)
				{
					val ^= matrix[row][column - 1];
				}

				if (row - 1 >= 0 && column - 1 >= 0)
				{
					val ^= matrix[row - 1][column - 1];
				}

				matrix[row][column] = val;

				list.add(val);
			}
		}

		list.sort(Comparator.reverseOrder());

		return list.get(k - 1);
	}
}
