package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 2/13/2022
 */
@LeetCode(
	id = 2164,
	name = "Sort Even and Odd Indices Independently",
	url = "https://leetcode.com/problems/sort-even-and-odd-indices-independently/",
	difficulty = Difficulty.EASY
)
public class SortEvenAndOddIndicesIndependently
{
	public int[] sortEvenOdd(int[] nums)
	{
		List<Integer> evens = new ArrayList<>();
		List<Integer> odds = new ArrayList<>();
		for (int i = 0; i < nums.length; i++)
		{
			if (i % 2 == 0)
			{
				evens.add(nums[i]);
			}
			else
			{
				odds.add(nums[i]);
			}
		}

		evens.sort(Comparator.naturalOrder());
		odds.sort(Comparator.reverseOrder());
		int evensPos = 0;
		int oddsPos = 0;
		for (int i = 0; i < nums.length; i++)
		{
			if (i % 2 == 0)
			{
				nums[i] = evens.get(evensPos++);
			}
			else
			{
				nums[i] = odds.get(oddsPos++);
			}
		}

		return nums;
	}
}
