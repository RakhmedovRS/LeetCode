package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 2/16/2022
 */
@LeetCode(
	id = 2161,
	name = "Partition Array According to Given Pivot",
	url = "https://leetcode.com/problems/partition-array-according-to-given-pivot/",
	difficulty = Difficulty.MEDIUM
)
public class PartitionArrayAccordingToGivenPivot
{
	public int[] pivotArray(int[] nums, int pivot)
	{
		List<Integer> less = new ArrayList<>();
		List<Integer> equal = new ArrayList<>();
		List<Integer> greater = new ArrayList<>();

		for (int num : nums)
		{
			if (num < pivot)
			{
				less.add(num);
			}
			else if (num == pivot)
			{
				equal.add(num);
			}
			else
			{
				greater.add(num);
			}
		}

		int pos = 0;
		for (int num : less)
		{
			nums[pos++] = num;
		}

		for (int num : equal)
		{
			nums[pos++] = num;
		}

		for (int num : greater)
		{
			nums[pos++] = num;
		}

		return nums;
	}
}
