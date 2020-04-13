import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 13-Apr-20
 */
@LeetCode(id = 239, name = "Sliding Window Maximum", url = "https://leetcode.com/problems/sliding-window-maximum/")
public class SlidingWindowMaximum
{
	public int[] maxSlidingWindow(int[] nums, int k)
	{
		if (nums == null || nums.length == 0 || nums.length < k)
		{
			return new int[0];
		}

		int[] result = new int[nums.length - k + 1];
		int pos = 0;
		Deque<Integer> integers = new LinkedList<>();
		for (int i = 0; i < nums.length; i++)
		{
			if (i >= k)
			{
				if (integers.getFirst() == nums[i - k])
				{
					integers.removeFirst();
				}
			}

			while (!integers.isEmpty() && integers.getLast() < nums[i])
			{
				integers.removeLast();
			}

			integers.addLast(nums[i]);

			if (i >= k - 1)
			{
				result[pos++] = integers.getFirst();
			}
		}

		return result;
	}
}
