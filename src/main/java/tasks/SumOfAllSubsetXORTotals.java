package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 5/16/2021
 */
@LeetCode(
	id = 1863,
	name = "Sum of All Subset XOR Totals",
	url = "https://leetcode.com/problems/sum-of-all-subset-xor-totals/",
	difficulty = Difficulty.EASY
)
public class SumOfAllSubsetXORTotals
{
	public int subsetXORSum(int[] nums)
	{
		List<List<Integer>> powerSet = new ArrayList<>();
		powerSet.add(new ArrayList<>());
		for (int num : nums)
		{
			int size = powerSet.size();
			for (int i = 0; i < size; i++)
			{
				List<Integer> set = new ArrayList<>(powerSet.get(i));
				set.add(num);
				powerSet.add(set);
			}
		}

		int sum = 0;
		for (List<Integer> sub : powerSet)
		{
			int xor = 0;
			for (int val : sub)
			{
				xor ^= val;
			}

			sum += xor;
		}

		return sum;
	}
}
