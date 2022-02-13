package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 2/13/2022
 */
@LeetCode(
	id = 2170,
	name = "Minimum Operations to Make the Array Alternating",
	url = "https://leetcode.com/problems/minimum-operations-to-make-the-array-alternating/",
	difficulty = Difficulty.MEDIUM
)
public class MinimumOperationsToMakeTheArrayAlternating
{
	public int minimumOperations(int[] nums)
	{
		if (nums.length <= 1)
		{
			return 0;
		}
		int[] evens = new int[100_001];
		int[] odds = new int[100_001];

		int e = 0;
		int o = 0;
		for (int i = 0; i < nums.length; i++)
		{
			if (i % 2 == 0)
			{
				evens[nums[i]]++;
				e++;
			}
			else
			{
				odds[nums[i]]++;
				o++;
			}
		}

		List<Integer> ids = new ArrayList<>();
		for (int i = 0; i < odds.length; i++)
		{
			if (odds[i] != 0)
			{
				ids.add(i);
			}
		}

		ids.sort((a, b) -> odds[a] - odds[b]);

		int min = nums.length;
		for (int i = 0; i < evens.length; i++)
		{
			int x = 0;
			if (ids.get(ids.size() - 1) == i)
			{
				if (ids.size() == 1)
				{
					x = 0;
				}
				else
				{
					x = odds[ids.get(ids.size() - 2)];
				}
			}
			else
			{
				x = odds[ids.get(ids.size() - 1)];
			}
			min = Math.min(min, o - x + e - evens[i]);
		}

		return min;
	}
}
