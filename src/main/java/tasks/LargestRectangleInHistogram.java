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
	id = 84,
	name = "Largest Rectangle in Histogram",
	url = "https://leetcode.com/problems/largest-rectangle-in-histogram/",
	difficulty = Difficulty.HARD
)
public class LargestRectangleInHistogram
{
	public int largestRectangleArea(int[] heights)
	{
		int n = heights.length;
		int maxArea = 0;
		Deque<Integer> deque = new LinkedList<>();
		deque.addLast(-1);
		int height;
		int width;
		for (int i = 0; i < n; i++)
		{
			while (deque.getLast() != -1 && heights[deque.getLast()] >= heights[i])
			{
				height = heights[deque.removeLast()];
				width = i - deque.getLast() - 1;
				maxArea = Math.max(maxArea, height * width);
			}

			deque.addLast(i);
		}

		while (deque.getLast() != -1)
		{
			height = heights[deque.removeLast()];
			width = n - deque.getLast() - 1;
			maxArea = Math.max(maxArea, height * width);
		}

		return maxArea;
	}
}
