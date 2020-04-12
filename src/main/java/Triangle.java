import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 12-Apr-20
 */
@LeetCode(id = 120, name = "Triangle", url = "https://leetcode.com/problems/triangle/")
public class Triangle
{
	public int minimumTotal(List<List<Integer>> triangle)
	{
		if (triangle == null || triangle.size() == 0)
		{
			return 0;
		}

		int[][] memo = new int[triangle.size()][];
		for (int row = 0; row < triangle.size(); row++)
		{
			memo[row] = new int[triangle.get(row).size()];
		}

		memo[0][0] = triangle.get(0).get(0);
		for (int row = 1; row < triangle.size(); row++)
		{
			for (int column = 0; column < triangle.get(row).size(); column++)
			{
				if (column == 0)
				{
					memo[row][column] = memo[row - 1][column];
				}
				else if (column == triangle.get(row).size() - 1)
				{
					memo[row][column] = memo[row - 1][column - 1];
				}
				else
				{
					memo[row][column] = Math.min(memo[row - 1][column - 1], memo[row - 1][column]);
				}

				memo[row][column] += triangle.get(row).get(column);
			}
		}

		int min = Integer.MAX_VALUE;
		for (int value : memo[memo.length - 1])
		{
			if (min > value)
			{
				min = value;
			}
		}

		return min;
	}

	public static void main(String[] args)
	{
		List<List<Integer>> triangle = new ArrayList<>();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3, 4));
		triangle.add(Arrays.asList(5, 6, 7));
		triangle.add(Arrays.asList(4, 1, 8, 3));

		System.out.println(new Triangle().minimumTotal(triangle));
	}
}
