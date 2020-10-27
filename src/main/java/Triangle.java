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
		List<Integer> level;
		for (int row = 1; row < triangle.size(); row++)
		{
			level = triangle.get(row);
			for (int column = 0; column < level.size(); column++)
			{
				level.set(column, getMin(triangle.get(row - 1), column) + level.get(column));
			}
		}

		int min = Integer.MAX_VALUE;
		for (int total : triangle.get(triangle.size() - 1))
		{
			min = Math.min(min, total);
		}

		return min;
	}

	private int getMin(List<Integer> level, int pos)
	{
		if (pos == 0)
		{
			return level.get(pos);
		}
		else if (pos == level.size())
		{
			return level.get(pos - 1);
		}

		return Math.min(level.get(pos - 1), level.get(pos));
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
