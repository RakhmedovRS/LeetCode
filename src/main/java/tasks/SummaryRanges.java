package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 03-Jul-20
 */
@LeetCode(
	id = 228,
	name = "Summary Ranges",
	url = "https://leetcode.com/problems/summary-ranges/",
	difficulty = Difficulty.EASY
)
public class SummaryRanges
{
	public List<String> summaryRanges(int[] nums)
	{
		List<String> list = new ArrayList<>();
		LinkedList<Integer> stack = new LinkedList<>();
		for (int num : nums)
		{
			if (!stack.isEmpty())
			{
				if (stack.getLast() + 1 != num)
				{
					if (stack.size() == 1)
					{
						list.add("" + stack.removeLast());
					}
					else
					{
						list.add("" + stack.removeFirst() + "->" + stack.removeLast());
					}
					stack.clear();
				}
			}

			stack.addLast(num);
		}

		if (!stack.isEmpty())
		{
			if (stack.size() == 1)
			{
				list.add("" + stack.removeLast());
			}
			else
			{
				list.add("" + stack.removeFirst() + "->" + stack.removeLast());
			}
		}
		return list;
	}

	public static void main(String[] args)
	{
		System.out.println(new SummaryRanges().summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
		System.out.println(new SummaryRanges().summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
	}
}
