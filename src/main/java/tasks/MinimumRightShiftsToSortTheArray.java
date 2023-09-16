package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 9/16/2023
 */
@LeetCode(
		id = 2855,
		name = "Minimum Right Shifts to Sort the Array",
		url = "https://leetcode.com/problems/minimum-right-shifts-to-sort-the-array/",
		difficulty = Difficulty.EASY
)
public class MinimumRightShiftsToSortTheArray
{
	public int minimumRightShifts(List<Integer> nums)
	{
		LinkedList<Integer> list = new LinkedList<>();
		LinkedList<Integer> sortedList = new LinkedList<>();
		for (int num : nums)
		{
			list.addLast(num);
			sortedList.addLast(num);
		}

		sortedList.sort(null);

		int shifts = 0;
		for (int i = 0; i < nums.size(); i++)
		{
			if (list.equals(sortedList))
			{
				return shifts;
			}

			shifts++;

			list.addFirst(list.removeLast());
		}

		return -1;
	}
}
