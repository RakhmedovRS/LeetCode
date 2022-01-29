package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 26-Feb-20
 */
@LeetCode(
	id = 85,
	name = "Maximal Rectangle",
	url = "https://leetcode.com/problems/maximal-rectangle/",
	difficulty = Difficulty.HARD
)
public class MaximalRectangle
{
	public int largestRectangleArea(int[] heights)
	{
		int n = heights.length;
		int pos = 0;
		int max = 0;

		Deque<Integer> stack = new LinkedList<>();

		while (pos < n)
		{
			while (!stack.isEmpty() && heights[pos] < heights[stack.peek()])
			{
				max = Math.max(max, heights[stack.pop()] * (pos - (stack.isEmpty() ? 0 : stack.peek() + 1)));
			}
			stack.push(pos++);
		}

		while (!stack.isEmpty())
		{
			max = Math.max(max, heights[stack.pop()] * (n - (stack.isEmpty() ? 0 : stack.peek() + 1)));
		}

		return max;
	}

	public int maximalRectangle(char[][] matrix)
	{
		int max = 0;
		if (matrix == null || matrix.length == 0)
		{
			return max;
		}

		int[] histogram = new int[matrix[0].length];
		for (int row = 0; row < matrix.length; row++)
		{
			for (int column = 0; column < matrix[row].length; column++)
			{
				if (row == 0)
				{
					histogram[column] = matrix[row][column] - '0';
				}
				else
				{
					int current = matrix[row][column] - '0';
					if (current == 0)
					{
						histogram[column] = 0;
					}
					else
					{
						histogram[column] += current;
					}
				}
			}
			max = Math.max(max, largestRectangleArea(histogram));
		}
		return max;
	}
}
