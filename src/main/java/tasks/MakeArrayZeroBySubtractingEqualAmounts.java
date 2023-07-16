package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.TreeSet;

/**
 * @author Ruslan Rakhmedov
 * @created 7/31/2022
 * @Ruslan Rakhmedov$
 * @1.0$
 */
@LeetCode(
		id = 2357,
		name = "Make Array Zero by Subtracting Equal Amounts",
		url = "https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/",
		difficulty = Difficulty.EASY
)
public class MakeArrayZeroBySubtractingEqualAmounts
{
	public int minimumOperations(int[] nums)
	{
		TreeSet<Integer> treeSet = new TreeSet<>();
		for (int num : nums)
		{
			treeSet.add(num);
		}


		int count = 0;
		int sum = 0;
		while (!treeSet.isEmpty())
		{
			int current = treeSet.first();
			treeSet.remove(current);
			int reminder = current - sum;
			if (reminder > 0)
			{
				count++;
				sum += reminder;
			}
		}

		return count;
	}
}
