package tasks;

import common.LeetCode;

import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 05-May-20
 */
@LeetCode(id = 119, name = "Pascal's tasks.Triangle II", url = "https://leetcode.com/problems/pascals-triangle-ii/")
public class PascalTriangleII
{
	public List<Integer> getRow(int rowIndex)
	{
		Integer[] row = new Integer[rowIndex + 1];
		Arrays.fill(row, 0);
		row[0] = 1;

		for (int i = 1; i <= rowIndex; i++)
		{
			for (int j = i; j > 0; j--)
			{
				row[j] += row[j - 1];
			}
		}

		return Arrays.asList(row);
	}

	public static void main(String[] args)
	{
		System.out.println(new PascalTriangleII().getRow(3));
	}
}
