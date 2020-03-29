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
	public int largestRectangleArea(int[] h)
	{
		int n = h.length;
		int i = 0;
		int max = 0;

		Deque<Integer> s = new LinkedList<>();

		while (i < n)
		{
			while (!s.isEmpty() && h[i] < h[s.peek()])
			{
				max = Math.max(max, h[s.pop()] * (i - (s.isEmpty() ? 0 : s.peek() + 1)));
			}
			s.push(i++);
		}

		while (!s.isEmpty())
		{
			max = Math.max(max, h[s.pop()] * (n - (s.isEmpty() ? 0 : s.peek() + 1)));
		}

		return max;
	}
}
