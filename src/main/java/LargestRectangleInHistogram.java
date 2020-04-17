import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 26-Feb-20
 */
@LeetCode(id = 82, name = "Largest Rectangle in Histogram", url = "https://leetcode.com/problems/largest-rectangle-in-histogram/")
public class LargestRectangleInHistogram
{
	public int largestRectangleArea(int[] heights)
	{
		int maxArea = 0;
		if (heights == null || heights.length == 0)
		{
			return maxArea;
		}

		Deque<Integer> stack = new LinkedList<>();
		for (int i = 0; i <= heights.length; i++)
		{
			if (i == heights.length || (!stack.isEmpty() && heights[stack.peek()] > heights[i]))
			{
				while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] > heights[i]))
				{
					int curr = heights[stack.pop()] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
					if (curr > maxArea)
					{
						maxArea = curr;
					}
				}
			}
			stack.push(i);
		}

		return maxArea;
	}
}
