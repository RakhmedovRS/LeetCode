package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 03-Jul-20
 */
@LeetCode(id = 228, name = "Summary Ranges", url = "https://leetcode.com/problems/summary-ranges/")
public class SummaryRanges
{
	public List<String> summaryRanges(int[] nums)
	{
		List<String> answer = new ArrayList<>();
		if (nums == null || nums.length == 0)
		{
			return answer;
		}

		Deque<Integer> deque = new LinkedList<>();
		for (int num : nums)
		{
			if (!deque.isEmpty())
			{
				if (deque.getLast() + 1 != num)
				{
					if (deque.size() == 1)
					{
						answer.add(String.valueOf(deque.removeLast()));
					}
					else
					{
						answer.add(String.format("%d->%d", deque.removeFirst(), deque.removeLast()));
						deque.clear();
					}
				}
			}
			deque.addLast(num);
		}

		if (deque.size() == 1)
		{
			answer.add(String.valueOf(deque.removeLast()));
		}
		else
		{
			answer.add(String.format("%d->%d", deque.removeFirst(), deque.removeLast()));
		}

		return answer;
	}

	public static void main(String[] args)
	{
		System.out.println(new SummaryRanges().summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
		System.out.println(new SummaryRanges().summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
	}
}
