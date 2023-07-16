package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 3/27/2022
 */
@LeetCode(
		id = 2216,
		name = "Minimum Deletions to Make Array Beautiful",
		url = "https://leetcode.com/problems/minimum-deletions-to-make-array-beautiful/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumDeletionsToMakeArrayBeautiful
{
	public int minDeletion(int[] nums)
	{
		int deletions = 0;
		LinkedList<Integer> list = new LinkedList<>();
		for (int num : nums)
		{
			list.addLast(num);
		}

		boolean even = true;
		int prev = -1;
		int counter = 0;
		while (!list.isEmpty())
		{
			if (even)
			{
				prev = list.removeFirst();
				counter++;
			}
			else
			{
				while (!list.isEmpty() && prev == list.getFirst())
				{
					list.removeFirst();
					deletions++;
				}

				if (!list.isEmpty())
				{
					list.removeFirst();
					counter++;
				}
			}

			even = !even;
		}

		if (counter % 2 != 0)
		{
			deletions++;
		}

		return deletions;
	}
}
