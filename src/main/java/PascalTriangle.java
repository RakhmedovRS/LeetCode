import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 26-Mar-20
 */
@LeetCode(id = 118, name = "Pascal's Triangle", url = "https://leetcode.com/problems/pascals-triangle/")
public class PascalTriangle
{
	public List<List<Integer>> generate(int numRows)
	{
		List<List<Integer>> result = new ArrayList<>();
		if (numRows == 0)
		{
			return result;
		}

		result.add(Arrays.asList(1));
		if (numRows == 1)
		{
			return result;
		}

		result.add(Arrays.asList(1, 1));
		if (numRows == 2)
		{
			return result;
		}

		result.add(Arrays.asList(1, 2, 1));
		if (numRows == 3)
		{
			return result;
		}

		for (int row = 3; row < numRows; row++)
		{
			List<Integer> newRow = new ArrayList<>(3 + 1);
			newRow.add(1);
			for (int position = 1; position < row; position++)
			{
				newRow.add(result.get(row - 1).get(position - 1) + result.get(row - 1).get(position));
			}
			newRow.add(1);
			result.add(newRow);
		}

		return result;
	}

	public static void main(String[] args)
	{
		new PascalTriangle().generate(5).forEach(System.out::println);
	}
}
