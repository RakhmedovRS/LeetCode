package tasks;

import common.LeetCode;

import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 04-Mar-20
 */
@LeetCode(id = 1046, name = "Last Stone Weight", url = "https://leetcode.com/problems/last-stone-weight/")
public class LastStoneWeight
{
	public int lastStoneWeight(int[] stones)
	{
		PriorityQueue<Integer> values = new PriorityQueue<>((val1, val2) -> Integer.compare(val2, val1));
		for (Integer value : stones)
		{
			values.add(value);
		}

		while (values.size() > 1)
		{
			int result = values.remove() - values.remove();
			if (result != 0)
			{
				values.add(result);
			}
		}

		return values.isEmpty() ? 0 : values.remove();
	}
}
