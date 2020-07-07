import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 07-Jul-20
 */
@LeetCode(id = 456, name = "132 Pattern", url = "https://leetcode.com/problems/132-pattern/")
public class OneTwoThreePattern
{
	public boolean find132pattern(int[] nums)
	{
		if (nums == null || nums.length < 3)
		{
			return false;
		}

		int[] min = new int[nums.length];
		min[0] = nums[0];
		for (int i = 1; i < nums.length; i++)
		{
			min[i] = Math.min(min[i - 1], nums[i]);
		}

		Deque<Integer> stack = new LinkedList<>();
		for (int i = nums.length - 1; i >= 0; i--)
		{
			if (nums[i] > min[i])
			{
				while (!stack.isEmpty() && stack.peek() <= min[i])
				{
					stack.pop();
				}

				if (!stack.isEmpty() && stack.peek() < nums[i])
				{
					return true;
				}

				stack.push(nums[i]);
			}
		}

		return false;
	}
}
