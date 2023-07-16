package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 9/11/2022
 */
@LeetCode(
		id = 2404,
		name = "Most Frequent Even Element",
		url = "https://leetcode.com/problems/most-frequent-even-element/",
		difficulty = Difficulty.EASY
)
public class MostFrequentEvenElement
{
	public int mostFrequentEven(int[] nums)
	{
		int[] memo = new int[(int) Math.pow(10, 5) + 1];
		for (int num : nums)
		{
			memo[num]++;
		}

		int maxIndex = -1;
		for (int i = 0; i < memo.length; i += 2)
		{
			if (memo[i] > 0)
			{
				if (maxIndex == -1 || memo[i] > memo[maxIndex])
				{
					maxIndex = i;
				}
			}
		}

		return maxIndex;
	}
}
