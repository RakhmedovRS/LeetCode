package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 11-Feb-21
 */
@LeetCode(
		id = 1756,
		name = "Design Most Recently Used Queue",
		url = "https://leetcode.com/problems/design-most-recently-used-queue/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class DesignMostRecentlyUsedQueue
{
	class MRUQueue
	{
		LinkedList<Integer> integers;

		public MRUQueue(int n)
		{
			integers = new LinkedList<>();
			for (int i = 1; i <= n; i++)
			{
				integers.addLast(i);
			}
		}

		public int fetch(int k)
		{
			int value = integers.remove(k - 1);
			integers.addLast(value);
			return value;
		}
	}
}
