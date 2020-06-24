import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 24-Jun-20
 */
@LeetCode(id = 457, name = "Circular Array Loop", url = "https://leetcode.com/problems/circular-array-loop/")
public class CircularArrayLoop
{
	public boolean circularArrayLoop(int[] nums)
	{
		if (nums == null || nums.length <= 1)
		{
			return false;
		}

		Set<Integer> visited = new HashSet<>();
		for (int i = 0; i < nums.length; i++)
		{
			if (traverse(nums, i + nums[i], nums[i] >= 0, visited, 0))
			{
				return true;
			}

			visited.clear();
		}

		return false;
	}

	private boolean traverse(int[] nums, int pos, boolean isMovingForward, Set<Integer> visited, int steps)
	{
		pos = getIndex(nums, pos);

		if (visited.contains(pos))
		{
			return steps > 1;
		}

		if (nums[pos] < 0 && isMovingForward)
		{
			return false;
		}

		if (nums[pos] > 0 && !isMovingForward)
		{
			return false;
		}

		visited.add(pos);

		if (pos == getIndex(nums, pos + nums[pos]))
		{
			return false;
		}

		return traverse(nums, pos + nums[pos], nums[pos] >= 0, visited, steps + 1);
	}

	private int getIndex(int[] nums, int pos)
	{
		pos %= nums.length;

		if (pos < 0)
		{
			pos = nums.length + pos;
		}

		if (pos >= nums.length)
		{
			pos = pos - nums.length;
		}

		return pos;
	}
}
