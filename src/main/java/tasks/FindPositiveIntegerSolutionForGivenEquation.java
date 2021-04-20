package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 07-Sep-20
 */
@LeetCode(id = 1237, name = "Find Positive Integer Solution for a Given Equation", url = "https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/")
public class FindPositiveIntegerSolutionForGivenEquation
{
	interface CustomFunction
	{
		// Returns f(x, y) for any given positive integers x and y.
		// Note that f(x, y) is increasing with respect to both x and y.
		// i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
		public int f(int x, int y);
	}

	public List<List<Integer>> findSolution(CustomFunction customfunction, int z)
	{
		List<List<Integer>> answer = new ArrayList<>();
		for (int x = 1; x <= z; x++)
		{
			for (int y = 1; y <= z; y++)
			{
				if (customfunction.f(x, y) == z)
				{
					answer.add(Arrays.asList(x, y));
				}
			}
		}

		return answer;
	}
}
